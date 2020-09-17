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

import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import org.operationcrypto.hivej.communication.ConnectionManager;
import org.operationcrypto.hivej.communication.Endpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HiveJConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(HiveJConfig.class);

	/** The one and only instance. */
	private static volatile HiveJConfig sHiveJConfig;

	/** Configure the encoding for e.g. comments. */
	private Charset encodingCharset;
	/** Configure the maximum time the client should wait for an HTTP response. */
	private int responseTimeout;
	/**
	 * Configure the maximum time the client should wait until a connection is
	 * established.
	 */
	private int connectionTimeout;

	/**
	 * Create a new <code>HiveJConfig</code> prefilled with default values.
	 */
	private HiveJConfig() {
		// Make sure the internal instance can only be initialized once, even if
		// reflection is used.
		if (sHiveJConfig != null) {
			throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
		}

		this.setResponseTimeout(1000);
		this.setConnectionTimeout(2000);
	}

	/**
	 * Returns the singleton instance HiveJConfigurationObject
	 * 
	 * @return HiveJConfig
	 */
	public static synchronized HiveJConfig getInstance() {
		// Double-checked locking pattern
		if (sHiveJConfig == null) {
			synchronized (HiveJConfig.class) {
				if (sHiveJConfig == null)
					sHiveJConfig = new HiveJConfig();
			}
		}
		return sHiveJConfig;
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
	 * Get the configured, maximum time that HiveJ will wait until a connection to
	 * the node could be established. A value that is 0 or negative indicates to
	 * wait forever.
	 * 
	 * @return The time in milliseconds HiveJ should wait until a connection has
	 *         been established.
	 */
	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	/**
	 * Override the default, maximum time that HiveJ will wait until a connection to
	 * the node could be established. A value that is 0 or negative indicates to
	 * wait forever.
	 *
	 * @param connectionTimeout The time in milliseconds until a connection has to
	 *                          be established.
	 */
	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	/**
	 * Get all currently configured endpoints known to HiveJ.
	 */
	public List<Endpoint> getEndpoints() {
		return ConnectionManager.getInstance().getEndpoints();
	}

	/**
	 * Add a new endpoint to HiveJ. HiveJ will load-balance requests between all
	 * known endpoints.
	 * 
	 * @param endpointURL            The URL of the endpoint.
	 * @param disableSSLVerification Define if the SSL verification should be
	 *                               disabled or not (Default / 'null' keeps the SSL
	 *                               verification active).
	 * @throws Exception In case a new client could not be estabilished for the
	 *                   given endpointURL.
	 */
	public void addEndpoint(URL endpointURL, Boolean disableSSLVerification) throws Exception {
		// Initialize a new list if required.
		ConnectionManager.getInstance().addClient(new Endpoint(endpointURL, disableSSLVerification));
	}

	/**
	 * Add a new endpoint to HiveJ. HiveJ will load-balance requests between all
	 * known endpoints (SSL verification is enabled).
	 * 
	 * @param endpointURL The URL of the endpoint.
	 * @throws Exception In case a new client could not be estabilished for the
	 *                   given endpointURL.
	 */
	public void addEndpoint(URL endpointURL) throws Exception {
		// Initialize a new list if required.
		ConnectionManager.getInstance().addClient(new Endpoint(endpointURL, false));
	}
}
