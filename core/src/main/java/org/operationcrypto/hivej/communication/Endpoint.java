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

import java.net.URL;

/**
 * This class is used to initialize a http request.
 * 
 * @author <a href="https://github.com/marvin-we">marvin-we</a>
 */
public class Endpoint {
    private URL endpointURL;
    private boolean disableSSLVerification;

    /**
     * Create a new Endpoint to communicate with.
     * 
     * @param endpointURL            The URL of the node to communicate with.
     * @param disableSSLVerification Configure if the verification of SSL
     *                               certificates should be disabled.
     */
    public Endpoint(URL endpointURL, Boolean disableSSLVerification) {
        this.setEndpointURI(endpointURL);
        this.setDisableSSLVerification(disableSSLVerification);
    }

    /**
     * Get the configured URL.
     * 
     * @return The configured URL.
     */
    public URL getEndpointURL() {
        return endpointURL;
    }

    /**
     * Configure the URL to connect to.
     * 
     * @param endpointURL The URL to connect to.
     */
    public void setEndpointURI(URL endpointURL) {
        this.endpointURL = endpointURL;
    }

    /**
     * Get the information if the SSL verification is disabled for this endpoint.
     * 
     * @return The information if the SSL verification is disabled for this
     *         endpoint.
     */
    public boolean getDisableSSLVerification() {
        return disableSSLVerification;
    }

    /**
     * Define if the SSL verification is disabled for this endpoint.
     * 
     * @param disableSSLVerification Set to <code>true</code> to disable the SSL
     *                               verification or <code>false</code> to enable it
     *                               (recommended!).
     */
    public void setDisableSSLVerification(Boolean disableSSLVerification) {
        if (disableSSLVerification == null) {
            this.disableSSLVerification = false;
        }
        this.disableSSLVerification = disableSSLVerification;
    }
}
