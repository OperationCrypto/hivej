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
import java.net.URI;
import java.security.InvalidParameterException;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.operationcrypto.hivej.config.HiveJConfig;
import org.operationcrypto.hivej.jrpc.JsonRPCRequest;
import org.operationcrypto.hivej.jrpc.JsonRPCResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * This class handles the communication to the HiveJ web socket API.
 * 
 * @author
 */
public class CommunicationHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommunicationHandler.class);

    /**
     * A preconfigured mapper instance used for de-/serialization of Json
     * objects.
     */
    private static ObjectMapper mapper = getObjectMapper();
    /** A counter for failed connection tries. */
    private int numberOfConnectionTries = 0;
    /** The client used to send requests. */
    private AbstractClient client;

    /**
     * Initialize the Connection Handler.
     * 
     * @throws Exception
     *             If no connection to the HiveJ Node could be established.
     */
    public CommunicationHandler() throws Exception {
        // Create a new connection
        initializeNewClient();
    }

    /**
     * Initialize a new <code>client</code> by selecting one of the configured
     * endpoints.
     * 
     * @throws Exception
     *             If no {@link AbstractClient} implementation for the given
     *             schema is available.
     */
    public void initializeNewClient() throws Exception {
        if (client != null) {
            try {
                client.closeConnection();
            } catch (IOException e) {
                throw new Exception("Could not close the current client connection.", e);
            }
        }
        // Get a new endpoint URI based on the number of retries.
        Pair<URI, Boolean> endpoint = HiveJConfig.getInstance().getNextEndpointURI(0);

        if (endpoint.getLeft().getScheme().toLowerCase().matches("(http){1}[s]?")) {
            client = new HttpClient();
        } else if (endpoint.getLeft().getScheme().toLowerCase().matches("(ws){1}[s]?")) {
//            client = new WebsocketClient();
        } else {
            throw new InvalidParameterException("No client implementation for the following protocol available: "
                    + endpoint.getLeft().getScheme().toLowerCase());
        }
    }

    /**
     * Perform a request to the web socket API whose response will automatically
     * get transformed into the given object.
     * 
     * @param requestObject
     *            A request object that contains all needed parameters.
     * @param targetClass
     *            The type the response should be transformed to.
     * @param <T>
     *            The type that should be returned.
     * @return The server response transformed into a list of given objects.
     * @throws Exception
     *             If the Server returned an error object.
     */
    public <T> List<T> performRequest(JsonRPCRequest requestObject, Class<T> targetClass)
            throws Exception {
        try {
            Pair<URI, Boolean> endpoint = HiveJConfig.getInstance().getNextEndpointURI(numberOfConnectionTries++);
            JsonRPCResponse rawJsonResponse = client.invokeAndReadResponse(requestObject, endpoint.getLeft(),
                    endpoint.getRight());
            LOGGER.debug("Received {} ", rawJsonResponse);

            if (rawJsonResponse.isError()) {
            	// TODO: Add appropriate Error Handling
            	// throw rawJsonResponse.handleError(requestObject.getId());
            	return null;
            } else {
                // HANDLE NORMAL RESPONSE
                JavaType expectedResultType = mapper.getTypeFactory().constructCollectionType(List.class, targetClass);
                return rawJsonResponse.handleResult(expectedResultType, requestObject.getId());
            }
        } catch (Exception e) {
            LOGGER.warn("The connection has been closed. Switching the endpoint and reconnecting.");
            LOGGER.debug("For the following reason: ", e);
//            return performRequest(requestObject, targetClass);
            return null;
        }
    }

    /**
     * Get a preconfigured Jackson Object Mapper instance.
     * 
     * @return The object mapper.
     */
    public static ObjectMapper getObjectMapper() {
        if (mapper == null) {
            mapper = new ObjectMapper();

            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

            SimpleModule simpleModule = new SimpleModule("BooleanAsString", new Version(1, 0, 0, null, null, null));

            mapper.registerModule(simpleModule);
        }

        return mapper;
    }
}
