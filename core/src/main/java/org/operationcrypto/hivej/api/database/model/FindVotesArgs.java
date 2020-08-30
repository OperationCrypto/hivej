package org.operationcrypto.hivej.api.database.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FindVotesArgs {
	@JsonProperty("author")
	private String mAuthor;
	@JsonProperty("permlink")
	private String mPermlink;
	public String getmArg1() {
		return mAuthor;
	}
	public void setmArg1(String mArg1) {
		this.mAuthor = mArg1;
	}
	public String getmArg2() {
		return mPermlink;
	}
	public void setmArg2(String mArg2) {
		this.mPermlink = mArg2;
	}
	public FindVotesArgs(String mArg1, String mArg2) {
		super();
		this.mAuthor = mArg1;
		this.mPermlink = mArg2;
	}
	
	
}
