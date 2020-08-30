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
