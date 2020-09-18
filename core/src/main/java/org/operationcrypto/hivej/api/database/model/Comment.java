package org.operationcrypto.hivej.api.database.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "author", "permlink", "category", "parent_author", "parent_permlink", "title", "body",
		"json_metadata", "last_update", "created", "active", "last_payout", "depth", "children", "net_rshares",
		"abs_rshares", "vote_rshares", "children_abs_rshares", "cashout_time", "max_cashout_time", "total_vote_weight",
		"reward_weight", "total_payout_value", "curator_payout_value", "author_rewards", "net_votes", "root_author",
		"root_permlink", "max_accepted_payout", "percent_steem_dollars", "allow_replies", "allow_votes",
		"allow_curation_rewards", "beneficiaries" })
public class Comment {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("author")
	private String author;
	@JsonProperty("permlink")
	private String permlink;
	@JsonProperty("category")
	private String category;
	@JsonProperty("parent_author")
	private String parentAuthor;
	@JsonProperty("parent_permlink")
	private String parentPermlink;
	@JsonProperty("title")
	private String title;
	@JsonProperty("body")
	private String body;
	@JsonProperty("json_metadata")
	private String jsonMetadata;
	@JsonProperty("last_update")
	private String lastUpdate;
	@JsonProperty("created")
	private String created;
	@JsonProperty("active")
	private String active;
	@JsonProperty("last_payout")
	private String lastPayout;
	@JsonProperty("depth")
	private Integer depth;
	@JsonProperty("children")
	private Integer children;
	@JsonProperty("net_rshares")
	private Integer netRshares;
	@JsonProperty("abs_rshares")
	private Integer absRshares;
	@JsonProperty("vote_rshares")
	private Integer voteRshares;
	@JsonProperty("children_abs_rshares")
	private Integer childrenAbsRshares;
	@JsonProperty("cashout_time")
	private String cashoutTime;
	@JsonProperty("max_cashout_time")
	private String maxCashoutTime;
	@JsonProperty("total_vote_weight")
	private Integer totalVoteWeight;
	@JsonProperty("reward_weight")
	private Integer rewardWeight;
	@JsonProperty("total_payout_value")
	private Money totalPayoutValue;
	@JsonProperty("curator_payout_value")
	private Money curatorPayoutValue;
	@JsonProperty("author_rewards")
	private Integer authorRewards;
	@JsonProperty("net_votes")
	private Integer netVotes;
	@JsonProperty("root_author")
	private String rootAuthor;
	@JsonProperty("root_permlink")
	private String rootPermlink;
	@JsonProperty("max_accepted_payout")
	private Money maxAcceptedPayout;
	@JsonProperty("percent_steem_dollars")
	private Integer percentSteemDollars;
	@JsonProperty("allow_replies")
	private Boolean allowReplies;
	@JsonProperty("allow_votes")
	private Boolean allowVotes;
	@JsonProperty("allow_curation_rewards")
	private Boolean allowCurationRewards;
	@JsonProperty("beneficiaries")
	private List<Object> beneficiaries = null;

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("author")
	public String getAuthor() {
		return author;
	}

	@JsonProperty("author")
	public void setAuthor(String author) {
		this.author = author;
	}

	@JsonProperty("permlink")
	public String getPermlink() {
		return permlink;
	}

	@JsonProperty("permlink")
	public void setPermlink(String permlink) {
		this.permlink = permlink;
	}

	@JsonProperty("category")
	public String getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(String category) {
		this.category = category;
	}

	@JsonProperty("parent_author")
	public String getParentAuthor() {
		return parentAuthor;
	}

	@JsonProperty("parent_author")
	public void setParentAuthor(String parentAuthor) {
		this.parentAuthor = parentAuthor;
	}

	@JsonProperty("parent_permlink")
	public String getParentPermlink() {
		return parentPermlink;
	}

	@JsonProperty("parent_permlink")
	public void setParentPermlink(String parentPermlink) {
		this.parentPermlink = parentPermlink;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("body")
	public String getBody() {
		return body;
	}

	@JsonProperty("body")
	public void setBody(String body) {
		this.body = body;
	}

	@JsonProperty("json_metadata")
	public String getJsonMetadata() {
		return jsonMetadata;
	}

	@JsonProperty("json_metadata")
	public void setJsonMetadata(String jsonMetadata) {
		this.jsonMetadata = jsonMetadata;
	}

	@JsonProperty("last_update")
	public String getLastUpdate() {
		return lastUpdate;
	}

	@JsonProperty("last_update")
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@JsonProperty("created")
	public String getCreated() {
		return created;
	}

	@JsonProperty("created")
	public void setCreated(String created) {
		this.created = created;
	}

	@JsonProperty("active")
	public String getActive() {
		return active;
	}

	@JsonProperty("active")
	public void setActive(String active) {
		this.active = active;
	}

	@JsonProperty("last_payout")
	public String getLastPayout() {
		return lastPayout;
	}

	@JsonProperty("last_payout")
	public void setLastPayout(String lastPayout) {
		this.lastPayout = lastPayout;
	}

	@JsonProperty("depth")
	public Integer getDepth() {
		return depth;
	}

	@JsonProperty("depth")
	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	@JsonProperty("children")
	public Integer getChildren() {
		return children;
	}

	@JsonProperty("children")
	public void setChildren(Integer children) {
		this.children = children;
	}

	@JsonProperty("net_rshares")
	public Integer getNetRshares() {
		return netRshares;
	}

	@JsonProperty("net_rshares")
	public void setNetRshares(Integer netRshares) {
		this.netRshares = netRshares;
	}

	@JsonProperty("abs_rshares")
	public Integer getAbsRshares() {
		return absRshares;
	}

	@JsonProperty("abs_rshares")
	public void setAbsRshares(Integer absRshares) {
		this.absRshares = absRshares;
	}

	@JsonProperty("vote_rshares")
	public Integer getVoteRshares() {
		return voteRshares;
	}

	@JsonProperty("vote_rshares")
	public void setVoteRshares(Integer voteRshares) {
		this.voteRshares = voteRshares;
	}

	@JsonProperty("children_abs_rshares")
	public Integer getChildrenAbsRshares() {
		return childrenAbsRshares;
	}

	@JsonProperty("children_abs_rshares")
	public void setChildrenAbsRshares(Integer childrenAbsRshares) {
		this.childrenAbsRshares = childrenAbsRshares;
	}

	@JsonProperty("cashout_time")
	public String getCashoutTime() {
		return cashoutTime;
	}

	@JsonProperty("cashout_time")
	public void setCashoutTime(String cashoutTime) {
		this.cashoutTime = cashoutTime;
	}

	@JsonProperty("max_cashout_time")
	public String getMaxCashoutTime() {
		return maxCashoutTime;
	}

	@JsonProperty("max_cashout_time")
	public void setMaxCashoutTime(String maxCashoutTime) {
		this.maxCashoutTime = maxCashoutTime;
	}

	@JsonProperty("total_vote_weight")
	public Integer getTotalVoteWeight() {
		return totalVoteWeight;
	}

	@JsonProperty("total_vote_weight")
	public void setTotalVoteWeight(Integer totalVoteWeight) {
		this.totalVoteWeight = totalVoteWeight;
	}

	@JsonProperty("reward_weight")
	public Integer getRewardWeight() {
		return rewardWeight;
	}

	@JsonProperty("reward_weight")
	public void setRewardWeight(Integer rewardWeight) {
		this.rewardWeight = rewardWeight;
	}

	@JsonProperty("total_payout_value")
	public Money getTotalPayoutValue() {
		return totalPayoutValue;
	}

	@JsonProperty("total_payout_value")
	public void setTotalPayoutValue(Money totalPayoutValue) {
		this.totalPayoutValue = totalPayoutValue;
	}

	@JsonProperty("curator_payout_value")
	public Money getCuratorPayoutValue() {
		return curatorPayoutValue;
	}

	@JsonProperty("curator_payout_value")
	public void setCuratorPayoutValue(Money curatorPayoutValue) {
		this.curatorPayoutValue = curatorPayoutValue;
	}

	@JsonProperty("author_rewards")
	public Integer getAuthorRewards() {
		return authorRewards;
	}

	@JsonProperty("author_rewards")
	public void setAuthorRewards(Integer authorRewards) {
		this.authorRewards = authorRewards;
	}

	@JsonProperty("net_votes")
	public Integer getNetVotes() {
		return netVotes;
	}

	@JsonProperty("net_votes")
	public void setNetVotes(Integer netVotes) {
		this.netVotes = netVotes;
	}

	@JsonProperty("root_author")
	public String getRootAuthor() {
		return rootAuthor;
	}

	@JsonProperty("root_author")
	public void setRootAuthor(String rootAuthor) {
		this.rootAuthor = rootAuthor;
	}

	@JsonProperty("root_permlink")
	public String getRootPermlink() {
		return rootPermlink;
	}

	@JsonProperty("root_permlink")
	public void setRootPermlink(String rootPermlink) {
		this.rootPermlink = rootPermlink;
	}

	@JsonProperty("max_accepted_payout")
	public Money getMaxAcceptedPayout() {
		return maxAcceptedPayout;
	}

	@JsonProperty("max_accepted_payout")
	public void setMaxAcceptedPayout(Money maxAcceptedPayout) {
		this.maxAcceptedPayout = maxAcceptedPayout;
	}

	@JsonProperty("percent_steem_dollars")
	public Integer getPercentSteemDollars() {
		return percentSteemDollars;
	}

	@JsonProperty("percent_steem_dollars")
	public void setPercentSteemDollars(Integer percentSteemDollars) {
		this.percentSteemDollars = percentSteemDollars;
	}

	@JsonProperty("allow_replies")
	public Boolean getAllowReplies() {
		return allowReplies;
	}

	@JsonProperty("allow_replies")
	public void setAllowReplies(Boolean allowReplies) {
		this.allowReplies = allowReplies;
	}

	@JsonProperty("allow_votes")
	public Boolean getAllowVotes() {
		return allowVotes;
	}

	@JsonProperty("allow_votes")
	public void setAllowVotes(Boolean allowVotes) {
		this.allowVotes = allowVotes;
	}

	@JsonProperty("allow_curation_rewards")
	public Boolean getAllowCurationRewards() {
		return allowCurationRewards;
	}

	@JsonProperty("allow_curation_rewards")
	public void setAllowCurationRewards(Boolean allowCurationRewards) {
		this.allowCurationRewards = allowCurationRewards;
	}

	@JsonProperty("beneficiaries")
	public List<Object> getBeneficiaries() {
		return beneficiaries;
	}

	@JsonProperty("beneficiaries")
	public void setBeneficiaries(List<Object> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

}