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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "blockchain_version", "steem_revision", "fc_revision", "chain_id" })
public class GetVersionReturn {

	@JsonProperty("blockchain_version")
	private String blockchainVersion;
	@JsonProperty("steem_revision")
	private String steemRevision;
	@JsonProperty("fc_revision")
	private String fcRevision;
	@JsonProperty("chain_id")
	private String chainId;

	@JsonProperty("blockchain_version")
	public String getBlockchainVersion() {
		return blockchainVersion;
	}

	@JsonProperty("blockchain_version")
	public void setBlockchainVersion(String blockchainVersion) {
		this.blockchainVersion = blockchainVersion;
	}

	@JsonProperty("steem_revision")
	public String getSteemRevision() {
		return steemRevision;
	}

	@JsonProperty("steem_revision")
	public void setSteemRevision(String steemRevision) {
		this.steemRevision = steemRevision;
	}

	@JsonProperty("fc_revision")
	public String getFcRevision() {
		return fcRevision;
	}

	@JsonProperty("fc_revision")
	public void setFcRevision(String fcRevision) {
		this.fcRevision = fcRevision;
	}

	@JsonProperty("chain_id")
	public String getChainId() {
		return chainId;
	}

	@JsonProperty("chain_id")
	public void setChainId(String chainId) {
		this.chainId = chainId;
	}
}