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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class implements the Hive "get_reward_funds_return" object.
 * 
 * @author <a href="https://github.com/Jodo1985">jodo1985</a>  
 */
public class GetRewardFundsReturn {
	@JsonProperty("funds")
	private List<Fund> mFunds;
	
	private GetRewardFundsReturn() {
		// Default Constructor 
	}

	public List<Fund> getFunds() {
		return mFunds;
	}

	public void setFunds(List<Fund> funds) {
		this.mFunds = funds;
	}
}
