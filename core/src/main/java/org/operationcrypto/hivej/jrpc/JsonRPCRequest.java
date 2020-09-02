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
package org.operationcrypto.hivej.jrpc;

import java.util.Random;

import javax.annotation.Nullable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.operationcrypto.hivej.communication.CommunicationHandler;
import org.operationcrypto.hivej.enums.RequestMethod;
import org.operationcrypto.hivej.enums.HiveApiType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;


/**
 * A wrapper object that carries all required fields for a request.
 * 
 * @author <a href="https://github.com/marvin-we">marvin-we</a>
 */
@JsonPropertyOrder({ "jsonrpc", "method", "params", "id" })
public class JsonRPCRequest {
    /** A shared <code>Random</code> instance. */
    private static final Random randomGenerator = new Random();
    /** The JSON RPC version. */
    private static final String JSONRPC = "2.0";
    /** The ID of this request. */
    private final long id = randomGenerator.nextLong();
    private String method;
    /**
     * The parameters of the request which should only be added in case there
     * are parameters at all.
     */
    @JsonInclude(Include.NON_NULL)
    private Object params;

    /**
     * Instantiate a new RequestObject.
     * 
     * @param hiveApiType
     *            The {@link HiveApiType} the <code>requestMethod</code>
     *            belongs to or <code>null</code> if the default namespace
     *            should be used.
     * @param requestMethod
     *            The {@link RequestMethod} to request.
     * @param params
     *            An object which contains all parameters required by the
     *            <code>requestMethod</code> or <code>null</code> if no
     *            parameters are required.
     */
    public JsonRPCRequest(@Nullable HiveApiType hiveApiType, RequestMethod requestMethod, @Nullable Object params) {
        String namespaceAndMethod = "";
        if (hiveApiType != null) {
            namespaceAndMethod = hiveApiType.name().toLowerCase() + ".";
        }
        this.method = namespaceAndMethod + requestMethod.name().toLowerCase();
        this.params = params;
    }

    /**
     * Get the JSON-RPC version.
     * 
     * @return The used JSON-RPC version.
     */
    public String getJsonrpc() {
        return JSONRPC;
    }

    /**
     * Get the id of this request.
     * 
     * @return The id of this request.
     */
    public long getId() {
        return id;
    }

    /**
     * Get the full namespace and method name.
     * 
     * @return The full namespace and method name.
     */
    public String getMethod() {
        return method;
    }

    /**
     * Get the additional parameters.
     * 
     * @return The additional parameters.
     */
    public Object getParams() {
        return this.params;
    }

    /**
     * Tramsform this request object into its JSON representation.
     *  
     * @return The JSON representation of this object.
     * @throws JsonProcessingException
     *             If the object can not be transformed into valid json.
     */
    public String toJson() throws JsonProcessingException {
        return CommunicationHandler.getObjectMapper().writeValueAsString(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
