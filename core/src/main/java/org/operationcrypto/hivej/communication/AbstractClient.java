package org.operationcrypto.hivej.communication;

import java.io.IOException;
import java.net.URI;

import org.operationcrypto.hivej.jrpc.JsonRPCRequest;
import org.operationcrypto.hivej.jrpc.JsonRPCResponse;



/**
 * This class defines the set of methods expected from a client.
 * 
 * @author 
 */
public abstract class AbstractClient {
    /**
     * Use this method to send a <code>requestObject</code> to the
     * <code>endpointUri</code> and to receive an answer.
     * 
     * @param requestObject
     *            The object to send.
     * @param endpointUri
     *            The endpoint to connect and send to.
     * @param sslVerificationDisabled
     *            Define if the SSL verification should be disabled.
     * @return The response returned by the HiveJ Node wrapped in a
     *         {@link JsonRPCResponse} object.
     * @throws Exception
     *             In case of communication problems.
     */
    public abstract JsonRPCResponse invokeAndReadResponse(JsonRPCRequest requestObject, URI endpointUri,
            boolean sslVerificationDisabled) throws Exception;

    /**
     * Use this method to close the connection of this client.
     * 
     * @throws IOException
     *             If the connection can't be closed.
     */
    public abstract void closeConnection() throws IOException;
}
