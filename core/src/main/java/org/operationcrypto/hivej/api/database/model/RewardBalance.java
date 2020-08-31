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
package org.operationcrypto.hivej.api.database.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class implements the Hive "?" object.
 * 
 * @author <a href="https://github.com/Jodo1985">jodo1985</a>  
 */
public class RewardBalance {
	@JsonProperty("amount")
	private String mAmount;
	@JsonProperty("precision")
	private int mPrecision;
	@JsonProperty("nai")
	private String mNai;
	
	public RewardBalance() {
		
	}

	public String getAmount() {
		return mAmount;
	}

	public void setAmount(String amount) {
		this.mAmount = amount;
	}

	public int getPrecision() {
		return mPrecision;
	}

	public void setPrecision(int precision) {
		this.mPrecision = precision;
	}

	public String getNai() {
		return mNai;
	}

	public void setNai(String nai) {
		this.mNai = nai;
	}
    
}
