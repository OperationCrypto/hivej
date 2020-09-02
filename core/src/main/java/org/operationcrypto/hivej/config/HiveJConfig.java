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
package org.operationcrypto.hivej.config;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HiveJConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(HiveJConfig.class);

	/** The default endpoint URI */
	private static final String DEFAULT_HIVE_API_URI = "https://api.hive.blog/";

	/** Configure the encoding for e.g. comments. */
	private Charset encodingCharset;
	/** Configure the maximum time the client should wait for an HTTP response. */
	private int responseTimeout;
	/**
	 * Configure how long a connection should be kept active even if no actions are
	 * performed.
	 */
	private int idleTimeout;
	/**
	 * Configure the maximum time the client should wait until a connection is
	 * established.
	 */
	private int connectionTimeout;

	private static HiveJConfig sHiveJConfig;

	/**
	 * Returns the singleton instance HiveJConfigurationObject
	 * 
	 * @return HiveJConfig
	 */
	public static HiveJConfig getInstance() {
		if (sHiveJConfig == null) {
			sHiveJConfig = new HiveJConfig();
		}
		return sHiveJConfig;
	}

	/**
	 * Create a new <code>HiveJConfig</code> prefilled with default values.
	 */
	private HiveJConfig() {
		super();

		this.setResponseTimeout(1000);
		this.setIdleTimeout(60000);
	}

	/**
	 * Define the Charset that should be used to encode Strings.
	 * 
	 * @param encodingCharset A Charset instance like StandardCharsets.UTF_8.
	 */
	public void setEncodingCharset(Charset encodingCharset) {
		this.encodingCharset = encodingCharset;
	}

	/**
	 * Get the currently configured Charset that will be used to encode Strings.
	 * 
	 * @return The configured Charset.
	 */
	public Charset getEncodingCharset() {
		return encodingCharset;
	}

	/**
	 * Override the default, maximum time that HiveJ will wait for an answer of the
	 * Hive Node. If set to <code>0</code> the timeout mechanism will be disabled.
	 * 
	 * @param responseTimeout Time in milliseconds.
	 * @throws IllegalArgumentException If the value of timeout is negative.
	 */
	public void setResponseTimeout(int responseTimeout) {
		if (responseTimeout < 0) {
			throw new IllegalArgumentException("The timeout has to be greater than 0. (0 will disable the timeout).");
		}

		this.responseTimeout = responseTimeout;
	}

	/**
	 * Get the configured, maximum time that HiveJ will wait for an answer of the
	 * endpoint before throwing an exception.
	 * 
	 * @return Time in milliseconds
	 */
	public int getResponseTimeout() {
		return responseTimeout;
	}

	/**
	 * Override the default, maximum time that HiveJ will keep an unused connection
	 * open.A value that is 0 or negative indicates the sessions will never timeout
	 * due to inactivity.
	 *
	 * @param idleTimeout The time in milliseconds a connection should be left
	 *                    intact even when no activities are performed.
	 */
	public void setIdleTimeout(int idleTimeout) {
		this.idleTimeout = idleTimeout;
	}

	/**
	 * Get the configured, maximum time that HiveJ will wait until a connection to
	 * the node could be established. A value that is 0 or negative indicates to
	 * wait forever.
	 * 
	 * @return The time in milliseconds HiveJ should wait until a connection has been established.
	 */
	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	/**
	 * Override the default, maximum time that HiveJ will wait until a connection to
	 * the node could be established. A value that is 0 or negative indicates to
	 * wait forever.
	 *
	 * @param connectionTimeout The time in milliseconds until a connection has to be established.
	 */
	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	/**
	 * Get the configured, maximum time that HiveJ will keep an unused connection
	 * open. A value that is 0 or negative indicates the sessions will never timeout
	 * due to inactivity.
	 * 
	 * @return The time in milliseconds a connection should be left intact even when
	 *         no activities are performed.
	 */
	public int getIdleTimeout() {
		return idleTimeout;
	}

	public Pair<URI, Boolean> getNextEndpointURI(int selector) throws URISyntaxException {
		return new ImmutablePair<>(new URI(DEFAULT_HIVE_API_URI), true);
	}
}
