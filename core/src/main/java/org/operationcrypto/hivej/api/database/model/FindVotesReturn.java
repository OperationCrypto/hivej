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

public class FindVotesReturn {
	@JsonProperty("votes")
	private List<Vote> mVotes;

	public List<Vote> getVotes() {
		return mVotes;
	}

	public void setVotes(List<Vote> votes) {
		this.mVotes = votes;
	}

	public FindVotesReturn() {
		super();
	}
}
