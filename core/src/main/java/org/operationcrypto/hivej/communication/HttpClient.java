/*
 *     This file is part of HiveJ
 * 
 *     HiveJ is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     HiveJ is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *     along with HiveJ.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.operationcrypto.hivej.communication;

import java.io.IOException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.UUID;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;

import org.apache.http.client.ClientProtocolException;
import org.operationcrypto.hivej.jrpc.JsonRPCRequest;
import org.operationcrypto.hivej.jrpc.JsonRPCResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class handles the communication to a Hive Node using the HTTP protocol.
 * 
 * @author <a href="https://github.com/marvin-we">marvin-we</a>
 */
public class HttpClient extends AbstractClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClient.class);
    private final String CLIENT_ID;

    /**
     * This field stores the connection factory used for requests against the given
     * endpoint.
     */
    private HttpRequestFactory requestFactory;

    /**
     * Initialize a new Http Client.
     * 
     * @param endpointURL            The endpoint to connect to.
     * @param disableSSLVerification Configure if the SSL certificate validation
     *                               should be skipped.
     * @throws Exception In case the request factory could not be setup.
     */
    public HttpClient(URL endpointURL, boolean disableSSLVerification) throws Exception {
        this(new Endpoint(endpointURL, disableSSLVerification));
    }

    /**
     * Initialize a new Http Client.
     * 
     * @param endpoint The <code>Endpoint</code> this client connects to.
     * @throws Exception In case the request factory could not be setup.
     */
    public HttpClient(Endpoint endpoint) throws Exception {
        this.setEndpoint(endpoint);

        // Generate a unique client id for easier logging.
        CLIENT_ID = this.getEndpoint().getEndpointURL() + "-" + UUID.randomUUID();

        NetHttpTransport.Builder builder = new NetHttpTransport.Builder();
        requestFactory = builder.build().createRequestFactory(new HttpClientRequestInitializer());
        // Disable SSL verification if needed
        if (this.getEndpoint().getDisableSSLVerification()
                && this.getEndpoint().getEndpointURL().getProtocol().equals("https")) {
            try {
                builder.doNotValidateCertificate();
            } catch (GeneralSecurityException e) {
                throw new Exception("Could not initialize request builder.", e);
            }
        }
    }

    @Override
    public JsonRPCResponse invokeAndReadResponse(JsonRPCRequest requestObject) throws Exception {
        try {
            String requestPayload = requestObject.toJson();
            HttpRequest httpRequest = requestFactory.buildPostRequest(
                    new GenericUrl(this.getEndpoint().getEndpointURL()),
                    ByteArrayContent.fromString("application/json", requestPayload));

            LOGGER.debug("Client {} send {}.", CLIENT_ID, requestPayload);

            HttpResponse httpResponse = httpRequest.execute();
            try {
                int status = httpResponse.getStatusCode();
                String responsePayload = httpResponse.parseAsString();

                if (status >= 200 && status < 300 && responsePayload != null) {
                    JsonRPCResponse rawJsonResponse = new JsonRPCResponse(
                            CommunicationHandler.getObjectMapper().readTree(responsePayload));
                    LOGGER.debug("Client {} received {} ", CLIENT_ID, rawJsonResponse);
                    return rawJsonResponse;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            } finally {
                // Close the response if no longer needed.
                httpResponse.disconnect();
            }

        } catch (IOException e) {
            throw new Exception("A problem occured while processing the request.", e);
        }
    }

    @Override
    public void closeConnection() {
        // A connection is used for exactly one request and closed afterwards.
        // Due to that there is no need to close it here.
    }
}
