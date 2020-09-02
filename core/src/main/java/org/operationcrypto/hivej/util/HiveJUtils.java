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
package org.operationcrypto.hivej.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.InvalidParameterException;
import java.util.List;

import org.operationcrypto.hivej.config.HiveJConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.bittrade.crypto.core.VarInt;

/**
 * This class contains some utility methods used by SteemJ.
 * 
 * @author <a href="http://steemit.com/@dez1337">dez1337</a>
 */
public class HiveJUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(HiveJUtils.class);

    /** Add a private constructor to hide the implicit public one. */
    private HiveJUtils() {
    }

    /**
     * Get the VarInt-byte representation of a String.
     * 
     * Serializing a String has to be done in two steps:
     * 
     * <ul>
     * <li>1. Length as VarInt</li>
     * <li>2. The account name.</li>
     * </ul>
     *
     * @param string The string to transform.
     * @return The VarInt-byte representation of the given String.
     */
    public static byte[] transformStringToVarIntByteArray(String string) {
        if (string == null) {
            return new byte[0];
        }

        Charset encodingCharset = HiveJConfig.getInstance().getEncodingCharset();
        try (ByteArrayOutputStream resultingByteRepresentation = new ByteArrayOutputStream()) {
            byte[] stringAsByteArray = string.getBytes(encodingCharset);

            resultingByteRepresentation.write(transformLongToVarIntByteArray(stringAsByteArray.length));
            resultingByteRepresentation.write(stringAsByteArray);

            return resultingByteRepresentation.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException("A problem occured while transforming the string into a byte array.", e);
        }
    }

    /**
     * Transform a long value into its byte representation.
     * 
     * @param longValue value The long value to transform.
     * @return The byte representation of the given value.
     */
    public static byte[] transformLongToVarIntByteArray(long longValue) {
        try {
            long value = longValue;

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutput out = new DataOutputStream(byteArrayOutputStream);

            while ((value & 0xFFFFFFFFFFFFFF80L) != 0L) {
                out.writeByte(((int) value & 0x7F) | 0x80);
                value >>>= 7;
            }

            out.writeByte((int) value & 0x7F);

            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            LOGGER.error("Could not transform the given long value into its VarInt representation - "
                    + "Using BitcoinJ as Fallback. This could cause problems for values > 127.", e);
            return (new VarInt(longValue)).encode();
        }
    }

    /**
     * 
     * @param collectionToSet
     * @param message
     * @return
     */
    public static <T> List<T> setIfNotNullAndNotEmpty(List<T> collectionToSet, String message) {
        if (collectionToSet == null || collectionToSet.isEmpty()) {
            throw new InvalidParameterException(message);
        }

        return collectionToSet;
    }
}
