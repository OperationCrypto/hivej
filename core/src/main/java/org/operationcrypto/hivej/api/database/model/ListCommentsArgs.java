package org.operationcrypto.hivej.api.database.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "start", "limit", "order" })
public class ListCommentsArgs {

	@JsonProperty("start")
	private List<String> start;
	@JsonProperty("limit")
	private Integer limit;
	@JsonProperty("order")
	private String order;

	@JsonProperty("start")
	public List<String> getStart() {
		return start;
	}

	@JsonProperty("start")
	public void setStart(List<String> start) {
		this.start = start;
	}

	@JsonProperty("limit")
	public Integer getLimit() {
		return limit;
	}

	@JsonProperty("limit")
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	@JsonProperty("order")
	public String getOrder() {
		return order;
	}

	@JsonProperty("order")
	public void setOrder(String order) {
		this.order = order;
	}

}