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
	
    private Charset encodingCharset;
    
	private static HiveJConfig sHiveJConfig;
	
	/**
	 * Returns the singleton instance HiveJConfigurationObject
	 * 
	 * @return HiveJConfig
	 */
	public static HiveJConfig getInstance() {
		if(sHiveJConfig==null) {
			sHiveJConfig = new HiveJConfig();
		}
		return sHiveJConfig;
	}
	
	private HiveJConfig() {
		
	}
	
	public Charset getEncodingCharset() {
		return encodingCharset;
	}
	
    public Pair<URI, Boolean> getNextEndpointURI(int selector) throws URISyntaxException {
    	return new ImmutablePair<URI, Boolean>(new URI(DEFAULT_HIVE_API_URI), true);
    }
}
