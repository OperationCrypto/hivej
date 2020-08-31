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
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.operationcrypto.hivej.api.database.model.FindVotesArgs;
import org.operationcrypto.hivej.api.database.model.FindVotesReturn;
import org.operationcrypto.hivej.api.database.model.GetRewardFundsReturn;
import org.operationcrypto.hivej.communication.CommunicationHandler;
import org.operationcrypto.hivej.enums.HiveApiType;
import org.operationcrypto.hivej.enums.RequestMethod;
import org.operationcrypto.hivej.jrpc.JsonRPCRequest;

public class DatabaseAPITest {
	@Test
	public void testFindVotes() throws Throwable {
		String permlink = "steemj-dev-diary-9-14-01-2018";
		String author = "dez1337";
		FindVotesArgs args = new FindVotesArgs(author, permlink);
		
		JsonRPCRequest request = new JsonRPCRequest(HiveApiType.DATABASE_API, RequestMethod.FIND_VOTES, args);

		CommunicationHandler communicationHandler = new CommunicationHandler();
		FindVotesReturn result = communicationHandler.performRequest(request, FindVotesReturn.class).get(0);
		
		assertEquals(permlink, result.getVotes().get(0).getPermlink());
		assertEquals(author, result.getVotes().get(0).getAuthor());
	}
	
	@Test
	public void testGetRewardFunds() throws Throwable {
		JsonRPCRequest request = new JsonRPCRequest(HiveApiType.DATABASE_API, RequestMethod.GET_REWARD_FUNDS,
				null);

		CommunicationHandler communicationHandler = new CommunicationHandler();
		GetRewardFundsReturn result = communicationHandler.performRequest(request, GetRewardFundsReturn.class).get(0);

		assertNotNull(result);
		assertNotNull(result.getFunds().get(0));
	}
}
 