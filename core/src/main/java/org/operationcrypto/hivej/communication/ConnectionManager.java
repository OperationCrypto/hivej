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
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class manages connections. Pools LoadBalance
 * 
 * @author <a href="https://github.com/marvin-we">marvin-we</a>
 */
public class ConnectionManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionManager.class);
    /** Pattern to identify the HTTP protocol */
    private static final String HTTP_PROTOCOL_PATTERN = "(http){1}[s]?"

    /** The one and only instance. */
    private static volatile ConnectionManager sConnectionManager;

    /** A pointer to the next client to use. */
    private int nextClient;
    /** The list of endpoints known to the ConnectionManager. */
    private CopyOnWriteArrayList<AbstractClient> clients;

    /**
     * Create a new <code>ConnectionManager</code>.
     */
    private ConnectionManager() {
        // Make sure the internal instance can only be initialized once, even if
        // reflection is used.
        if (sConnectionManager != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }

        this.nextClient = 0;
        this.clients = new CopyOnWriteArrayList<>();
    }

    /**
     * Returns the singleton instance HiveJConfigurationObject
     * 
     * @return HiveJConfig
     */
    public static synchronized ConnectionManager getInstance() {
        // Double-checked locking pattern
        if (sConnectionManager == null) {
            synchronized (ConnectionManager.class) {
                if (sConnectionManager == null)
                    sConnectionManager = new ConnectionManager();
            }

        }
        return sConnectionManager;
    }

    /**
     * Add a new Client to the ConnectionManager.
     * 
     * @param endpoint The endpoint for which a client should be created.
     * @throws Exception In case the client could not be initialized.
     */
    public void addClient(Endpoint endpoint) throws Exception {
        if (endpoint.getEndpointURL().getProtocol().toLowerCase().matches(HTTP_PROTOCOL_PATTERN)) {
            this.clients.add(new HttpClient(endpoint));
        } else {
            throw new InvalidParameterException("No client implementation for the following protocol available: "
                    + endpoint.getEndpointURL().getProtocol().toLowerCase());
        }
    }

    /**
     * Remove a client from the list of clients managed by this
     * <code>ConnectionManager</code>.
     * 
     * @param endpoint The endpoint of which the client to remove is responsible
     *                 for.
     * @return The number of clients whose have been identified for the given
     *         <code>endpoint</code> and have been removed.
     */
    public int removeClient(Endpoint endpoint) {
        int numberOfRemovedEndpoints = 0;
        // Find the client responsible for the given endpoint.
        for (AbstractClient client : clients) {
            if (endpoint.equals(client.getEndpoint())) {
                // Close it's connection.
                try {
                    client.closeConnection();
                } catch (IOException e) {
                    LOGGER.error("Unable to close the connection.", e);
                }
                // Remove the client from the list of managed clients.
                clients.remove(client);
                // Raise the number of removed endpoints.
                numberOfRemovedEndpoints++;
            }
        }
        return numberOfRemovedEndpoints;
    }

    /**
     * Get one of the clients managed by the <code>ConnectionManager</code>. The
     * <code>ConnectionManager</code> uses the Round-Robin load balancing mechanism.
     * 
     * @return The next available client.
     * @throws Exception In case no client is available.
     */
    public AbstractClient getClient() throws Exception {
        // Check if an endpoint is available.
        if (clients == null || clients.isEmpty()) {
            throw new Exception("No clients available.");
        }
        // Check if the nextClient counter is higher than the actual number of clients -
        // If it is, reset it.
        if (nextClient >= clients.size()) {
            nextClient = 0;
        }

        // Get the next client and raise the counter afterwards.
        return clients.get(nextClient++);
    }

    /**
     * Get all currently configured endpoints known to HiveJ.
     */
    public List<Endpoint> getEndpoints() {
        ArrayList<Endpoint> endpoints = new ArrayList<>();
        // Construct a list of all endpoints by iterating over all known clients.
        for (AbstractClient client : clients) {
            endpoints.add(client.getEndpoint());
        }
        return endpoints;
    }

}
