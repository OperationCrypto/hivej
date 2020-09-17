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
package communication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collections;

import org.junit.BeforeClass;
import org.junit.Test;
import org.operationcrypto.hivej.api.database.model.Account;
import org.operationcrypto.hivej.api.database.model.FindAccountRecoveryRequestsArgs;
import org.operationcrypto.hivej.api.database.model.FindAccountRecoveryRequestsReturn;
import org.operationcrypto.hivej.api.database.model.FindAccountsArgs;
import org.operationcrypto.hivej.api.database.model.FindAccountsReturn;
import org.operationcrypto.hivej.api.database.model.FindOwnerHistoriesArgs;
import org.operationcrypto.hivej.api.database.model.FindOwnerHistoriesReturn;
import org.operationcrypto.hivej.api.database.model.FindVotesArgs;
import org.operationcrypto.hivej.api.database.model.FindVotesReturn;
import org.operationcrypto.hivej.api.database.model.Fund;
import org.operationcrypto.hivej.api.database.model.GetRewardFundsReturn;
import org.operationcrypto.hivej.api.database.model.GetVersionReturn;
import org.operationcrypto.hivej.api.database.model.RewardBalance;
import org.operationcrypto.hivej.api.database.model.Vote;
import org.operationcrypto.hivej.communication.CommunicationHandler;
import org.operationcrypto.hivej.config.HiveJConfig;
import org.operationcrypto.hivej.enums.HiveApiType;
import org.operationcrypto.hivej.enums.RequestMethod;
import org.operationcrypto.hivej.jrpc.JsonRPCRequest;

public class DatabaseAPITest {
	/**
	 * Tests the database api find votes request and response by passing a user and
	 * permlink.
	 * 
	 * @throws Throwable
	 */
	@Test
	public void testFindVotes() throws Throwable {
		String permlink = "steemj-dev-diary-9-14-01-2018";
		String author = "dez1337";
		FindVotesArgs args = new FindVotesArgs(author, permlink);

		JsonRPCRequest request = new JsonRPCRequest(HiveApiType.DATABASE_API, RequestMethod.FIND_VOTES, args);

		CommunicationHandler communicationHandler = new CommunicationHandler();
		FindVotesReturn result = communicationHandler.performRequest(request, FindVotesReturn.class).get(0);

		Vote vote = result.getVotes().get(0);
		assertEquals(permlink, vote.getPermlink());
		assertEquals(author, vote.getAuthor());
		assertEquals("sergey44", vote.getVoter());
		assertEquals(14701, vote.getWeight());
		assertEquals("9818914530", vote.getRShares());
		assertEquals(10000, vote.getPercent());
		assertEquals(0, vote.getNumChanges());
		assertEquals("2018-01-14T15:50:09", vote.getLastUpdate());
	}

	/**
	 * Tests the database api get reward funds request (no parameters) and response.
	 * 
	 * @throws Throwable
	 */
	@Test
	public void testGetRewardFunds() throws Throwable {
		JsonRPCRequest request = new JsonRPCRequest(HiveApiType.DATABASE_API, RequestMethod.GET_REWARD_FUNDS, null);

		CommunicationHandler communicationHandler = new CommunicationHandler();
		GetRewardFundsReturn result = communicationHandler.performRequest(request, GetRewardFundsReturn.class).get(0);

		Fund fund = result.getFunds().get(0);
		assertNotNull(fund.getId());
		assertNotNull(fund.getName());
		RewardBalance rewardBalance = fund.getRewardBalance();
		assertNotNull(rewardBalance.getAmount());
		assertNotNull(rewardBalance.getNai());
		assertNotNull(Integer.valueOf(rewardBalance.getPrecision()));
		assertNotNull(fund.getAuthorRewardCurve());
		assertNotNull(Integer.valueOf(fund.getPercentContentRewards()));
		assertNotNull(Integer.valueOf(fund.getPercentCurationRewards()));
		assertNotNull(fund.getRecentClaims());
		assertNotNull(fund.getLastUpdate());
		assertNotNull(fund.getContentConstant());
		assertNotNull(fund.getCurationRewardCurve());
	}

	/**
	 * Tests the database api get version request and response.
	 * 
	 * @throws Throwable
	 */
	@Test
	public void testGetVersion() throws Throwable {
		JsonRPCRequest request = new JsonRPCRequest(HiveApiType.DATABASE_API, RequestMethod.GET_VERSION, null);

		CommunicationHandler communicationHandler = new CommunicationHandler();
		GetVersionReturn result = communicationHandler.performRequest(request, GetVersionReturn.class).get(0);

		assertEquals("0.23.0", result.getBlockchainVersion());
		assertNotNull(result.getChainId());
		assertNotNull(result.getFcRevision());
		assertNotNull(result.getSteemRevision());
	}

	/**
	 * Tests the database api find owner history request and response
	 * 
	 * @throws Throwable
	 */
	@Test
	public void testFindOwnerHistories() throws Throwable {
		FindOwnerHistoriesArgs args = new FindOwnerHistoriesArgs();
		args.setOwner("hiveio");

		JsonRPCRequest request = new JsonRPCRequest(HiveApiType.DATABASE_API, RequestMethod.FIND_OWNER_HISTORIES, args);

		CommunicationHandler communicationHandler = new CommunicationHandler();
		FindOwnerHistoriesReturn result = communicationHandler.performRequest(request, FindOwnerHistoriesReturn.class)
				.get(0);

		assertNotNull(result.getOwnerAuths());
	}

	/**
	 * Tests the database api find account recovery requests request and response.
	 * 
	 * @throws Throwable
	 */
	@Test
	public void testFindAccountRecoveryRequests() throws Throwable {
		FindAccountRecoveryRequestsArgs args = new FindAccountRecoveryRequestsArgs();
		args.setAccounts(Collections.singletonList("hiveio"));

		JsonRPCRequest request = new JsonRPCRequest(HiveApiType.DATABASE_API,
				RequestMethod.FIND_ACCOUNT_RECOVERY_REQUESTS, args);

		CommunicationHandler communicationHandler = new CommunicationHandler();
		FindAccountRecoveryRequestsReturn result = communicationHandler
				.performRequest(request, FindAccountRecoveryRequestsReturn.class).get(0);

		assertNotNull(result);
	}

	/**
	 * Tests the database api find accounts request and response.
	 * 
	 * @throws Throwable
	 */
	@Test
	public void testFindAccounts() throws Throwable {
		String dezAccount = "dez1337";

		FindAccountsArgs args = new FindAccountsArgs();
		args.setAccounts(Collections.singletonList(dezAccount));

		JsonRPCRequest request = new JsonRPCRequest(HiveApiType.DATABASE_API, RequestMethod.FIND_ACCOUNTS, args);

		CommunicationHandler communicationHandler = new CommunicationHandler();
		FindAccountsReturn result = communicationHandler.performRequest(request, FindAccountsReturn.class).get(0);

		assertEquals(1, result.getAccounts().size());
		Account account = result.getAccounts().get(0);

		assertEquals(dezAccount, account.getName());
		assertNotNull(account.getActive());
		assertNotNull(account.getBalance());
		assertNotNull(account.getCanVote());
		assertTrue(account.getCommentCount() >= 0);
		assertNotNull(account.getCreated());
		assertTrue(account.getCurationRewards() >= 1);
		assertNotNull(account.getDelegatedVestingShares());
		assertNotNull(account.getDownvoteManabar());
		assertNotNull(account.getId());
		assertFalse(account.getIsSmt());
		assertNotNull(account.getRewardSbdBalance());
		assertNotNull(account.getRewardSteemBalance());
		assertNotNull(account.getRewardVestingBalance());
		assertNotNull(account.getRewardVestingSteem());
		assertNotNull(account.getRecoveryAccount());
		assertNotNull(account.getResetAccount());
		assertNotNull(account.getReceivedVestingShares());
		assertNotNull(account.getVotingManabar());
		assertNotNull(account.getVestingWithdrawRate());
		assertNotNull(account.getVestingShares());
	}
}
