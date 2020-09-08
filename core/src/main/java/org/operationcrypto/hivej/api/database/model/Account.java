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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "owner",
    "active",
    "posting",
    "memo_key",
    "json_metadata",
    "posting_json_metadata",
    "proxy",
    "last_owner_update",
    "last_account_update",
    "created",
    "mined",
    "recovery_account",
    "last_account_recovery",
    "reset_account",
    "comment_count",
    "lifetime_vote_count",
    "post_count",
    "can_vote",
    "voting_manabar",
    "downvote_manabar",
    "balance",
    "savings_balance",
    "sbd_balance",
    "sbd_seconds",
    "sbd_seconds_last_update",
    "sbd_last_interest_payment",
    "savings_sbd_balance",
    "savings_sbd_seconds",
    "savings_sbd_seconds_last_update",
    "savings_sbd_last_interest_payment",
    "savings_withdraw_requests",
    "reward_sbd_balance",
    "reward_steem_balance",
    "reward_vesting_balance",
    "reward_vesting_steem",
    "vesting_shares",
    "delegated_vesting_shares",
    "received_vesting_shares",
    "vesting_withdraw_rate",
    "next_vesting_withdrawal",
    "withdrawn",
    "to_withdraw",
    "withdraw_routes",
    "curation_rewards",
    "posting_rewards",
    "proxied_vsf_votes",
    "witnesses_voted_for",
    "last_post",
    "last_root_post",
    "last_post_edit",
    "last_vote_time",
    "post_bandwidth",
    "pending_claimed_accounts",
    "is_smt"
})
public class Account {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("active")
    private Active active;
    @JsonProperty("posting")
    private Posting posting;
    @JsonProperty("memo_key")
    private String memoKey;
    @JsonProperty("json_metadata")
    private String jsonMetadata;
    @JsonProperty("posting_json_metadata")
    private String postingJsonMetadata;
    @JsonProperty("proxy")
    private String proxy;
    @JsonProperty("last_owner_update")
    private String lastOwnerUpdate;
    @JsonProperty("last_account_update")
    private String lastAccountUpdate;
    @JsonProperty("created")
    private String created;
    @JsonProperty("mined")
    private Boolean mined;
    @JsonProperty("recovery_account")
    private String recoveryAccount;
    @JsonProperty("last_account_recovery")
    private String lastAccountRecovery;
    @JsonProperty("reset_account")
    private String resetAccount;
    @JsonProperty("comment_count")
    private Integer commentCount;
    @JsonProperty("lifetime_vote_count")
    private Integer lifetimeVoteCount;
    @JsonProperty("post_count")
    private Integer postCount;
    @JsonProperty("can_vote")
    private Boolean canVote;
    @JsonProperty("voting_manabar")
    private VotingManabar votingManabar;
    @JsonProperty("downvote_manabar")
    private DownvoteManabar downvoteManabar;
    @JsonProperty("balance")
    private Balance balance;
    @JsonProperty("savings_balance")
    private SavingsBalance savingsBalance;
    @JsonProperty("sbd_balance")
    private SbdBalance sbdBalance;
    @JsonProperty("sbd_seconds")
    private String sbdSeconds;
    @JsonProperty("sbd_seconds_last_update")
    private String sbdSecondsLastUpdate;
    @JsonProperty("sbd_last_interest_payment")
    private String sbdLastInterestPayment;
    @JsonProperty("savings_sbd_balance")
    private SavingsSbdBalance savingsSbdBalance;
    @JsonProperty("savings_sbd_seconds")
    private String savingsSbdSeconds;
    @JsonProperty("savings_sbd_seconds_last_update")
    private String savingsSbdSecondsLastUpdate;
    @JsonProperty("savings_sbd_last_interest_payment")
    private String savingsSbdLastInterestPayment;
    @JsonProperty("savings_withdraw_requests")
    private Integer savingsWithdrawRequests;
    @JsonProperty("reward_sbd_balance")
    private RewardSbdBalance rewardSbdBalance;
    @JsonProperty("reward_steem_balance")
    private RewardSteemBalance rewardSteemBalance;
    @JsonProperty("reward_vesting_balance")
    private RewardVestingBalance rewardVestingBalance;
    @JsonProperty("reward_vesting_steem")
    private RewardVestingSteem rewardVestingSteem;
    @JsonProperty("vesting_shares")
    private VestingShares vestingShares;
    @JsonProperty("delegated_vesting_shares")
    private DelegatedVestingShares delegatedVestingShares;
    @JsonProperty("received_vesting_shares")
    private ReceivedVestingShares receivedVestingShares;
    @JsonProperty("vesting_withdraw_rate")
    private VestingWithdrawRate vestingWithdrawRate;
    @JsonProperty("next_vesting_withdrawal")
    private String nextVestingWithdrawal;
    @JsonProperty("withdrawn")
    private Integer withdrawn;
    @JsonProperty("to_withdraw")
    private Integer toWithdraw;
    @JsonProperty("withdraw_routes")
    private Integer withdrawRoutes;
    @JsonProperty("curation_rewards")
    private Integer curationRewards;
    @JsonProperty("posting_rewards")
    private Integer postingRewards;
    @JsonProperty("proxied_vsf_votes")
    private List<String> proxiedVsfVotes = null;
    @JsonProperty("witnesses_voted_for")
    private Integer witnessesVotedFor;
    @JsonProperty("last_post")
    private String lastPost;
    @JsonProperty("last_root_post")
    private String lastRootPost;
    @JsonProperty("last_post_edit")
    private String lastPostEdit;
    @JsonProperty("last_vote_time")
    private String lastVoteTime;
    @JsonProperty("post_bandwidth")
    private Integer postBandwidth;
    @JsonProperty("pending_claimed_accounts")
    private Integer pendingClaimedAccounts;
    @JsonProperty("is_smt")
    private Boolean isSmt;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("owner")
    public Owner getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @JsonProperty("active")
    public Active getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Active active) {
        this.active = active;
    }

    @JsonProperty("posting")
    public Posting getPosting() {
        return posting;
    }

    @JsonProperty("posting")
    public void setPosting(Posting posting) {
        this.posting = posting;
    }

    @JsonProperty("memo_key")
    public String getMemoKey() {
        return memoKey;
    }

    @JsonProperty("memo_key")
    public void setMemoKey(String memoKey) {
        this.memoKey = memoKey;
    }

    @JsonProperty("json_metadata")
    public String getJsonMetadata() {
        return jsonMetadata;
    }

    @JsonProperty("json_metadata")
    public void setJsonMetadata(String jsonMetadata) {
        this.jsonMetadata = jsonMetadata;
    }

    @JsonProperty("posting_json_metadata")
    public String getPostingJsonMetadata() {
        return postingJsonMetadata;
    }

    @JsonProperty("posting_json_metadata")
    public void setPostingJsonMetadata(String postingJsonMetadata) {
        this.postingJsonMetadata = postingJsonMetadata;
    }

    @JsonProperty("proxy")
    public String getProxy() {
        return proxy;
    }

    @JsonProperty("proxy")
    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    @JsonProperty("last_owner_update")
    public String getLastOwnerUpdate() {
        return lastOwnerUpdate;
    }

    @JsonProperty("last_owner_update")
    public void setLastOwnerUpdate(String lastOwnerUpdate) {
        this.lastOwnerUpdate = lastOwnerUpdate;
    }

    @JsonProperty("last_account_update")
    public String getLastAccountUpdate() {
        return lastAccountUpdate;
    }

    @JsonProperty("last_account_update")
    public void setLastAccountUpdate(String lastAccountUpdate) {
        this.lastAccountUpdate = lastAccountUpdate;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("mined")
    public Boolean getMined() {
        return mined;
    }

    @JsonProperty("mined")
    public void setMined(Boolean mined) {
        this.mined = mined;
    }

    @JsonProperty("recovery_account")
    public String getRecoveryAccount() {
        return recoveryAccount;
    }

    @JsonProperty("recovery_account")
    public void setRecoveryAccount(String recoveryAccount) {
        this.recoveryAccount = recoveryAccount;
    }

    @JsonProperty("last_account_recovery")
    public String getLastAccountRecovery() {
        return lastAccountRecovery;
    }

    @JsonProperty("last_account_recovery")
    public void setLastAccountRecovery(String lastAccountRecovery) {
        this.lastAccountRecovery = lastAccountRecovery;
    }

    @JsonProperty("reset_account")
    public String getResetAccount() {
        return resetAccount;
    }

    @JsonProperty("reset_account")
    public void setResetAccount(String resetAccount) {
        this.resetAccount = resetAccount;
    }

    @JsonProperty("comment_count")
    public Integer getCommentCount() {
        return commentCount;
    }

    @JsonProperty("comment_count")
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @JsonProperty("lifetime_vote_count")
    public Integer getLifetimeVoteCount() {
        return lifetimeVoteCount;
    }

    @JsonProperty("lifetime_vote_count")
    public void setLifetimeVoteCount(Integer lifetimeVoteCount) {
        this.lifetimeVoteCount = lifetimeVoteCount;
    }

    @JsonProperty("post_count")
    public Integer getPostCount() {
        return postCount;
    }

    @JsonProperty("post_count")
    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }

    @JsonProperty("can_vote")
    public Boolean getCanVote() {
        return canVote;
    }

    @JsonProperty("can_vote")
    public void setCanVote(Boolean canVote) {
        this.canVote = canVote;
    }

    @JsonProperty("voting_manabar")
    public VotingManabar getVotingManabar() {
        return votingManabar;
    }

    @JsonProperty("voting_manabar")
    public void setVotingManabar(VotingManabar votingManabar) {
        this.votingManabar = votingManabar;
    }

    @JsonProperty("downvote_manabar")
    public DownvoteManabar getDownvoteManabar() {
        return downvoteManabar;
    }

    @JsonProperty("downvote_manabar")
    public void setDownvoteManabar(DownvoteManabar downvoteManabar) {
        this.downvoteManabar = downvoteManabar;
    }

    @JsonProperty("balance")
    public Balance getBalance() {
        return balance;
    }

    @JsonProperty("balance")
    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    @JsonProperty("savings_balance")
    public SavingsBalance getSavingsBalance() {
        return savingsBalance;
    }

    @JsonProperty("savings_balance")
    public void setSavingsBalance(SavingsBalance savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    @JsonProperty("sbd_balance")
    public SbdBalance getSbdBalance() {
        return sbdBalance;
    }

    @JsonProperty("sbd_balance")
    public void setSbdBalance(SbdBalance sbdBalance) {
        this.sbdBalance = sbdBalance;
    }

    @JsonProperty("sbd_seconds")
    public String getSbdSeconds() {
        return sbdSeconds;
    }

    @JsonProperty("sbd_seconds")
    public void setSbdSeconds(String sbdSeconds) {
        this.sbdSeconds = sbdSeconds;
    }

    @JsonProperty("sbd_seconds_last_update")
    public String getSbdSecondsLastUpdate() {
        return sbdSecondsLastUpdate;
    }

    @JsonProperty("sbd_seconds_last_update")
    public void setSbdSecondsLastUpdate(String sbdSecondsLastUpdate) {
        this.sbdSecondsLastUpdate = sbdSecondsLastUpdate;
    }

    @JsonProperty("sbd_last_interest_payment")
    public String getSbdLastInterestPayment() {
        return sbdLastInterestPayment;
    }

    @JsonProperty("sbd_last_interest_payment")
    public void setSbdLastInterestPayment(String sbdLastInterestPayment) {
        this.sbdLastInterestPayment = sbdLastInterestPayment;
    }

    @JsonProperty("savings_sbd_balance")
    public SavingsSbdBalance getSavingsSbdBalance() {
        return savingsSbdBalance;
    }

    @JsonProperty("savings_sbd_balance")
    public void setSavingsSbdBalance(SavingsSbdBalance savingsSbdBalance) {
        this.savingsSbdBalance = savingsSbdBalance;
    }

    @JsonProperty("savings_sbd_seconds")
    public String getSavingsSbdSeconds() {
        return savingsSbdSeconds;
    }

    @JsonProperty("savings_sbd_seconds")
    public void setSavingsSbdSeconds(String savingsSbdSeconds) {
        this.savingsSbdSeconds = savingsSbdSeconds;
    }

    @JsonProperty("savings_sbd_seconds_last_update")
    public String getSavingsSbdSecondsLastUpdate() {
        return savingsSbdSecondsLastUpdate;
    }

    @JsonProperty("savings_sbd_seconds_last_update")
    public void setSavingsSbdSecondsLastUpdate(String savingsSbdSecondsLastUpdate) {
        this.savingsSbdSecondsLastUpdate = savingsSbdSecondsLastUpdate;
    }

    @JsonProperty("savings_sbd_last_interest_payment")
    public String getSavingsSbdLastInterestPayment() {
        return savingsSbdLastInterestPayment;
    }

    @JsonProperty("savings_sbd_last_interest_payment")
    public void setSavingsSbdLastInterestPayment(String savingsSbdLastInterestPayment) {
        this.savingsSbdLastInterestPayment = savingsSbdLastInterestPayment;
    }

    @JsonProperty("savings_withdraw_requests")
    public Integer getSavingsWithdrawRequests() {
        return savingsWithdrawRequests;
    }

    @JsonProperty("savings_withdraw_requests")
    public void setSavingsWithdrawRequests(Integer savingsWithdrawRequests) {
        this.savingsWithdrawRequests = savingsWithdrawRequests;
    }

    @JsonProperty("reward_sbd_balance")
    public RewardSbdBalance getRewardSbdBalance() {
        return rewardSbdBalance;
    }

    @JsonProperty("reward_sbd_balance")
    public void setRewardSbdBalance(RewardSbdBalance rewardSbdBalance) {
        this.rewardSbdBalance = rewardSbdBalance;
    }

    @JsonProperty("reward_steem_balance")
    public RewardSteemBalance getRewardSteemBalance() {
        return rewardSteemBalance;
    }

    @JsonProperty("reward_steem_balance")
    public void setRewardSteemBalance(RewardSteemBalance rewardSteemBalance) {
        this.rewardSteemBalance = rewardSteemBalance;
    }

    @JsonProperty("reward_vesting_balance")
    public RewardVestingBalance getRewardVestingBalance() {
        return rewardVestingBalance;
    }

    @JsonProperty("reward_vesting_balance")
    public void setRewardVestingBalance(RewardVestingBalance rewardVestingBalance) {
        this.rewardVestingBalance = rewardVestingBalance;
    }

    @JsonProperty("reward_vesting_steem")
    public RewardVestingSteem getRewardVestingSteem() {
        return rewardVestingSteem;
    }

    @JsonProperty("reward_vesting_steem")
    public void setRewardVestingSteem(RewardVestingSteem rewardVestingSteem) {
        this.rewardVestingSteem = rewardVestingSteem;
    }

    @JsonProperty("vesting_shares")
    public VestingShares getVestingShares() {
        return vestingShares;
    }

    @JsonProperty("vesting_shares")
    public void setVestingShares(VestingShares vestingShares) {
        this.vestingShares = vestingShares;
    }

    @JsonProperty("delegated_vesting_shares")
    public DelegatedVestingShares getDelegatedVestingShares() {
        return delegatedVestingShares;
    }

    @JsonProperty("delegated_vesting_shares")
    public void setDelegatedVestingShares(DelegatedVestingShares delegatedVestingShares) {
        this.delegatedVestingShares = delegatedVestingShares;
    }

    @JsonProperty("received_vesting_shares")
    public ReceivedVestingShares getReceivedVestingShares() {
        return receivedVestingShares;
    }

    @JsonProperty("received_vesting_shares")
    public void setReceivedVestingShares(ReceivedVestingShares receivedVestingShares) {
        this.receivedVestingShares = receivedVestingShares;
    }

    @JsonProperty("vesting_withdraw_rate")
    public VestingWithdrawRate getVestingWithdrawRate() {
        return vestingWithdrawRate;
    }

    @JsonProperty("vesting_withdraw_rate")
    public void setVestingWithdrawRate(VestingWithdrawRate vestingWithdrawRate) {
        this.vestingWithdrawRate = vestingWithdrawRate;
    }

    @JsonProperty("next_vesting_withdrawal")
    public String getNextVestingWithdrawal() {
        return nextVestingWithdrawal;
    }

    @JsonProperty("next_vesting_withdrawal")
    public void setNextVestingWithdrawal(String nextVestingWithdrawal) {
        this.nextVestingWithdrawal = nextVestingWithdrawal;
    }

    @JsonProperty("withdrawn")
    public Integer getWithdrawn() {
        return withdrawn;
    }

    @JsonProperty("withdrawn")
    public void setWithdrawn(Integer withdrawn) {
        this.withdrawn = withdrawn;
    }

    @JsonProperty("to_withdraw")
    public Integer getToWithdraw() {
        return toWithdraw;
    }

    @JsonProperty("to_withdraw")
    public void setToWithdraw(Integer toWithdraw) {
        this.toWithdraw = toWithdraw;
    }

    @JsonProperty("withdraw_routes")
    public Integer getWithdrawRoutes() {
        return withdrawRoutes;
    }

    @JsonProperty("withdraw_routes")
    public void setWithdrawRoutes(Integer withdrawRoutes) {
        this.withdrawRoutes = withdrawRoutes;
    }

    @JsonProperty("curation_rewards")
    public Integer getCurationRewards() {
        return curationRewards;
    }

    @JsonProperty("curation_rewards")
    public void setCurationRewards(Integer curationRewards) {
        this.curationRewards = curationRewards;
    }

    @JsonProperty("posting_rewards")
    public Integer getPostingRewards() {
        return postingRewards;
    }

    @JsonProperty("posting_rewards")
    public void setPostingRewards(Integer postingRewards) {
        this.postingRewards = postingRewards;
    }

    @JsonProperty("proxied_vsf_votes")
    public List<String> getProxiedVsfVotes() {
        return proxiedVsfVotes;
    }

    @JsonProperty("proxied_vsf_votes")
    public void setProxiedVsfVotes(List<String> proxiedVsfVotes) {
        this.proxiedVsfVotes = proxiedVsfVotes;
    }

    @JsonProperty("witnesses_voted_for")
    public Integer getWitnessesVotedFor() {
        return witnessesVotedFor;
    }

    @JsonProperty("witnesses_voted_for")
    public void setWitnessesVotedFor(Integer witnessesVotedFor) {
        this.witnessesVotedFor = witnessesVotedFor;
    }

    @JsonProperty("last_post")
    public String getLastPost() {
        return lastPost;
    }

    @JsonProperty("last_post")
    public void setLastPost(String lastPost) {
        this.lastPost = lastPost;
    }

    @JsonProperty("last_root_post")
    public String getLastRootPost() {
        return lastRootPost;
    }

    @JsonProperty("last_root_post")
    public void setLastRootPost(String lastRootPost) {
        this.lastRootPost = lastRootPost;
    }

    @JsonProperty("last_post_edit")
    public String getLastPostEdit() {
        return lastPostEdit;
    }

    @JsonProperty("last_post_edit")
    public void setLastPostEdit(String lastPostEdit) {
        this.lastPostEdit = lastPostEdit;
    }

    @JsonProperty("last_vote_time")
    public String getLastVoteTime() {
        return lastVoteTime;
    }

    @JsonProperty("last_vote_time")
    public void setLastVoteTime(String lastVoteTime) {
        this.lastVoteTime = lastVoteTime;
    }

    @JsonProperty("post_bandwidth")
    public Integer getPostBandwidth() {
        return postBandwidth;
    }

    @JsonProperty("post_bandwidth")
    public void setPostBandwidth(Integer postBandwidth) {
        this.postBandwidth = postBandwidth;
    }

    @JsonProperty("pending_claimed_accounts")
    public Integer getPendingClaimedAccounts() {
        return pendingClaimedAccounts;
    }

    @JsonProperty("pending_claimed_accounts")
    public void setPendingClaimedAccounts(Integer pendingClaimedAccounts) {
        this.pendingClaimedAccounts = pendingClaimedAccounts;
    }

    @JsonProperty("is_smt")
    public Boolean getIsSmt() {
        return isSmt;
    }

    @JsonProperty("is_smt")
    public void setIsSmt(Boolean isSmt) {
        this.isSmt = isSmt;
    }

}
