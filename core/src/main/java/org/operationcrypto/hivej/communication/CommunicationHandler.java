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

import java.util.List;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import org.operationcrypto.hivej.base.serializer.BooleanSerializer;
import org.operationcrypto.hivej.jrpc.JsonRPCRequest;
import org.operationcrypto.hivej.jrpc.JsonRPCResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class handles the communication to the HiveJ web socket API.
 * 
 * @author <a href="https://github.com/marvin-we">marvin-we</a>
 */
public class CommunicationHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommunicationHandler.class);

    /**
     * A preconfigured mapper instance used for de-/serialization of Json objects.
     */
    private static ObjectMapper mapper = getObjectMapper();

    /**
     * Perform a request to the node api whose response will automatically get
     * transformed into the given object.
     * 
     * @param requestObject A request object that contains all needed parameters.
     * @param targetClass   The type, the response should be transformed to.
     * @param <T>           The type, that should be returned.
     * @return The server response transformed into a list of given objects.
     * @throws Exception If the Server returned an error object.
     */
    public <T> List<T> performRequest(JsonRPCRequest requestObject, Class<T> targetClass) throws Exception {
        try {
            JsonRPCResponse rawJsonResponse = ConnectionManager.getInstance().getClient()
                    .invokeAndReadResponse(requestObject);

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
            LOGGER.warn("The connection has been closed.", e);
            throw e;
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

            // There are cases in which the response only contains a single value, which is
            // still returned as an array (e.g. '["result1"]' instead of a real array such
            // as '["result1","result2"]') - The following command configures
            // jackson to accept even those cases.
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

            // Hive nodes require to boolean values to be send in their String
            // representation - Therefore, tell jackson to use the custom seralizer for
            // those classes.
            SimpleModule simpleModule = new SimpleModule("BooleanAsString", new Version(1, 0, 0, null, null, null));
            simpleModule.addSerializer(Boolean.class, new BooleanSerializer());
            simpleModule.addSerializer(boolean.class, new BooleanSerializer());

            mapper.registerModule(simpleModule);
        }

        return mapper;
    }
}
