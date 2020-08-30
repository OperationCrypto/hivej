package communication;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.operationcrypto.hivej.api.database.model.FindVotesArgs;
import org.operationcrypto.hivej.api.database.model.FindVotesReturn;
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
}
 