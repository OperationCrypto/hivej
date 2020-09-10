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
package org.operationcrypto.hivej.samples;

import java.net.URL;
import java.util.List;

import org.operationcrypto.hivej.api.database.model.FindVotesArgs;
import org.operationcrypto.hivej.api.database.model.FindVotesReturn;
import org.operationcrypto.hivej.communication.CommunicationHandler;
import org.operationcrypto.hivej.communication.Endpoint;
import org.operationcrypto.hivej.config.HiveJConfig;
import org.operationcrypto.hivej.enums.HiveApiType;
import org.operationcrypto.hivej.enums.RequestMethod;
import org.operationcrypto.hivej.jrpc.JsonRPCRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This sample class shows and explains how to configure HiveJ to handle
 * connections to multiple endpoints (http(s) and ws(s)).
 * 
 * @author <a href="https://github.com/marvin-we">marvin-we</a>
 */
public class HandleMultipleConnections {
    private static final Logger LOGGER = LoggerFactory.getLogger(HandleMultipleConnections.class);

    private HandleMultipleConnections() {
        // Do not initialize this sample.
    }

    /**
     * Define multiple endpoints in various ways.
     */
    public static void main(String args[]) {
        // Get an instance of the global config object.
        HiveJConfig config = HiveJConfig.getInstance();

        // By default, HiveJ is pre-configured with an endpoint.
        List<Endpoint> currentlyConfiguredEndpoints = config.getEndpoints();
        for (Endpoint endpoint : currentlyConfiguredEndpoints) {
            LOGGER.info("Endpoint: {}", endpoint.getEndpointURL());
        }

        // HiveJ allows to configure multiple endpoints and will automatically
        // loadbalance between the known endpoints.
        try {
            // Lets add a new HTTPs endpoint to connect to.
            config.addEndpoint(new URL("https://api.hive.blog"));
            /*
             * Add another endpoint, but this time HiveJ should not validate the SSL
             * certificates of the node.
             * 
             * Be careful! Disabling certificate validation is dangerous and should only be
             * done in testing environments!
             */

            config.addEndpoint(new URL("https://api.openhive.network"), true);
        } catch (Exception e) {
            LOGGER.error("Could not transfer the given String into a valid URL.", e);
        }

        // Run 4 calls against the Hive node.
        for (int i = 0; i < 4; i++) {
            String permlink = "steemj-dev-diary-9-14-01-2018";
            String author = "dez1337";

            FindVotesArgs arguments = new FindVotesArgs(author, permlink);

            JsonRPCRequest request = new JsonRPCRequest(HiveApiType.DATABASE_API, RequestMethod.FIND_VOTES, arguments);

            CommunicationHandler communicationHandler = new CommunicationHandler();
            try {
                communicationHandler.performRequest(request, FindVotesReturn.class).get(0);
            } catch (Exception e) {
                LOGGER.error("Could not perform request.", e);
            }
        }
        /*
         * The logging config for this sample proejct (see
         * /src/main/resources/log4j2.xml) is configured to show also DEBUG log
         * messages.
         * 
         * Those detailed log messages include a unique id of the used client - The
         * debug logs of the sample above should look like this:
         * 
         * [...] Client https://api.hive.blog/-7677fca2-b778-4040-bc87-4e0ae32db7d6 send
         * / receive
         * 
         * [...] Client https://api.hive.blog-3bae0c5a-041d-4c33-87e1-f0ae1ff67845 send
         * / receive
         * 
         * [...] Client
         * https://api.openhive.network-4fba0916-bc8a-462d-9a84-4ef31f15f6c6 send /
         * receive
         * 
         * [...] Client https://api.hive.blog/-7677fca2-b778-4040-bc87-4e0ae32db7d6 send
         * / receive
         * 
         * In total, 4 requests have been initiated, while 3 clients were configured
         * (the pre-configured endpoint and the two added by this sample).
         * 
         * Request | Client 1 | 1 2 | 2 3 | 3 4 | 1 5 | 2 ... | ...
         */
    }
}
