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

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;

/**
 * This class is used to initialize a http request.
 * 
 * @author <a href="https://github.com/marvin-we">marvin-we</a>
 */
public class HttpClientRequestInitializer implements HttpRequestInitializer {

    @Override
    public void initialize(HttpRequest request) throws IOException {
        request.setConnectTimeout(1000);
        request.setReadTimeout(1000);
        request.setNumberOfRetries(0);
    }
}
