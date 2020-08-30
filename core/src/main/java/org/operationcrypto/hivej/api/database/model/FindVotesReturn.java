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
