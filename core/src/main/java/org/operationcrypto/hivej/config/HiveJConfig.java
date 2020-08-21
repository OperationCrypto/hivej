package org.operationcrypto.hivej.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HiveJConfig {
	private static final Logger LOGGER = LoggerFactory.getLogger(HiveJConfig.class);
	
	/** The default endpoint URI */
    private static final String DEFAULT_HIVE_API_URI = "https://api.hive.blog/";
	
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
}
