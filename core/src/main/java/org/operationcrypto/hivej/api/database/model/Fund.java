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
 * This class implements the Hive "api_reward_fund_object" object.
 * 
 * @author <a href="https://github.com/Jodo1985">jodo1985</a>  
 */
public class Fund {
	@JsonProperty("id")
	private String mId;
	@JsonProperty("name")
	private String mName;
	@JsonProperty("reward_balance")
	private RewardBalance mRewardBalance;
	@JsonProperty("recent_claims")
	private String mRecentClaims;
	@JsonProperty("last_update")
	private String mLastUpdate;
	@JsonProperty("content_constant")
	private String mContentConstant;
	@JsonProperty("percent_curation_rewards")
	private int mPercentCurationRewards;
	@JsonProperty("percent_content_rewards")
	private int mPercentContentRewards;
	@JsonProperty("author_reward_curve")
	private String mAuthorRewardCurve;
	@JsonProperty("curation_reward_curve")
	private String mCurationRewardCurve;
	
	public Fund() {
		// Default Constructor 
	}

	public String getId() {
		return mId;
	}

	public void setId(String id) {
		this.mId = id;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		this.mName = name;
	}

	public RewardBalance getRewardBalance() {
		return mRewardBalance;
	}

	public void setRewardBalance(RewardBalance rewardBalance) {
		this.mRewardBalance = rewardBalance;
	}

	public String getRecentClaims() {
		return mRecentClaims;
	}

	public void setRecentClaims(String recentClaims) {
		this.mRecentClaims = recentClaims;
	}

	public String getLastUpdate() {
		return mLastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.mLastUpdate = lastUpdate;
	}

	public String getContentConstant() {
		return mContentConstant;
	}

	public void setContentConstant(String contentConstant) {
		this.mContentConstant = contentConstant;
	}

	public int getPercentCurationRewards() {
		return mPercentCurationRewards;
	}

	public void setPercentCurationRewards(int percentCurationRewards) {
		this.mPercentCurationRewards = percentCurationRewards;
	}

	public int getPercentContentRewards() {
		return mPercentContentRewards;
	}

	public void setPercentContentRewards(int percentContentRewards) {
		this.mPercentContentRewards = percentContentRewards;
	}

	public String getAuthorRewardCurve() {
		return mAuthorRewardCurve;
	}

	public void setAuthorRewardCurve(String authorRewardCurve) {
		this.mAuthorRewardCurve = authorRewardCurve;
	}

	public String getCurationRewardCurve() {
		return mCurationRewardCurve;
	}

	public void setCurationRewardCurve(String curationRewardCurve) {
		this.mCurationRewardCurve = curationRewardCurve;
	}
}
