package org.operationcrypto.hivej.api.database.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "comments" })
public class ListCommentsReturn {

	@JsonProperty("comments")
	private List<Comment> comments = null;

	@JsonProperty("comments")
	public List<Comment> getComments() {
		return comments;
	}

	@JsonProperty("comments")
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}