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

import org.operationcrypto.hivej.jrpc.JsonRPCRequest;
import org.operationcrypto.hivej.jrpc.JsonRPCResponse;

/**
 * This class defines the set of methods expected from a client.
 * 
 * @author <a href="https://github.com/marvin-we">marvin-we</a>
 */
public abstract class AbstractClient {
    /**
     * The endpoint this client communicates to.
     */
    private Endpoint endpoint;

    /**
     * Use this method to send a <code>requestObject</code> to the
     * <code>endpointUrl</code> and to receive an answer.
     * 
     * @param requestObject The object to send.
     * @return The response returned by the HiveJ Node wrapped in a
     *         {@link JsonRPCResponse} object.
     * @throws Exception In case of communication problems.
     */
    public abstract JsonRPCResponse invokeAndReadResponse(JsonRPCRequest requestObject) throws Exception;

    /**
     * Use this method to close the connection of this client.
     * 
     * @throws IOException If the connection can't be closed.
     */
    public abstract void closeConnection() throws IOException;

    /**
     * Get the endpoint used by this client.
     * 
     * @return The endpoint this client communicates to.
     */
    public Endpoint getEndpoint() {
        return endpoint;
    }

    /**
     * Define the endpoint used by this client.
     * 
     * @param endpoint The endpoint this client communicates to.
     */
    public void setEndpoint(Endpoint endpoint) {
        this.endpoint = endpoint;
    }
}
