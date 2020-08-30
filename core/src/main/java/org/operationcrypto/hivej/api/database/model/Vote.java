package org.operationcrypto.hivej.api.database.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vote {
	@JsonProperty("id")
	private String mId;
	@JsonProperty("voter")
	private String mVoter;
	@JsonProperty("author")
	private String mAuthor;
	@JsonProperty("permlink")
	private String mPermlink;
	@JsonProperty("weight")
	private int mWeight;
	@JsonProperty("rshares")
	private String mRShares;
	@JsonProperty("vote_percent")
	private int mPercent;
	@JsonProperty("last_update")
	private String mLastUpdate;
	@JsonProperty("num_changes")
	private int mNumChanges;

	public String getId() {
		return mId;
	}

	public void setId(String mId) {
		this.mId = mId;
	}

	public String getVoter() {
		return mVoter;
	}

	public void setVoter(String mVoter) {
		this.mVoter = mVoter;
	}

	public String getAuthor() {
		return mAuthor;
	}

	public void setmuthor(String mAuthor) {
		this.mAuthor = mAuthor;
	}

	public String getPermlink() {
		return mPermlink;
	}

	public void setPermlink(String mPermlink) {
		this.mPermlink = mPermlink;
	}

	public int getWeight() {
		return mWeight;
	}

	public void setWeight(int mWeight) {
		this.mWeight = mWeight;
	}

	public String getRShares() {
		return mRShares;
	}

	public void setRShares(String mRShares) {
		this.mRShares = mRShares;
	}

	public int getPercent() {
		return mPercent;
	}

	public void setPercent(int mPercent) {
		this.mPercent = mPercent;
	}

	public String getLastUpdate() {
		return mLastUpdate;
	}

	public void setLastUpdate(String mLastUpdate) {
		this.mLastUpdate = mLastUpdate;
	}

	public int getNumChanges() {
		return mNumChanges;
	}

	public void setNumChanges(int mNumChanges) {
		this.mNumChanges = mNumChanges;
	}

	public Vote() {
		super();
	}
}
