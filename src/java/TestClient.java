import java.net.URL;
import org.apache.axis.client.Stub;
import com.idega.block.process.webservice.server.CaseEntry;
import com.idega.block.process.webservice.server.Item;
import com.idega.block.process.webservice.server.Owner;
import com.idega.block.process.webservice.server.ticketService.TicketService;
import com.idega.block.process.webservice.server.ticketService.TicketServiceServiceLocator;
import com.idega.block.process.wsclient.WSCaseConstants;
import com.idega.util.IWTimestamp;

public class TestClient {

	// private static String endpoint =
	// "http://azskjalfandi.skjalfandi.is/services/CreateNewCaseHttp";
	// private static String endpoint =
	// "http://213.167.155.187:6580/GoProHusavik.nsf/webservicenewcase?OpenAgent";
	private static String endpoint = "http://localhost:9090/services/TicketService";
	// private static String endpoint = "http://rrtest.rvk.is/services/CaseService";
	// private static String endpoint =
	// "http://localhost:8090/rvk/services/CaseService";
	//private static String endpoint = "http://213.167.155.148/Case/Case_NewCase_SoapPort.asmx?op=NewCase";

	// private static String endpoint =
	// "http://157.157.136.149:8080/axis/services/CreateNewCaseHttp";
	public static void main(String[] args) {
		// testDummy();
		testVUF();
	}

	/**
	 * <p>
	 * TODO tryggvil describe method testDummy
	 * </p>
	 */
	private static void testVUF() {
		try {
			Owner owner = new Owner();
			owner.setAddress("Tjarnarmýri 5");
			owner.setCity("Reykjavik");
			owner.setEmail("hello@idega.is");
			owner.setGsm("00000");
			owner.setName("");
			owner.setPostalcode("170");
			//owner.setSocialsecurity("12");
			owner.setSocialsecurity("1703532189");
			CaseEntry wsCase = new CaseEntry();
			//wsCase.setStatus(WSCaseConstants.STATUS_CLOSED);
			wsCase.setCode("JOBA");
			wsCase.setCreated(IWTimestamp.RightNow().toSQLDateString());
			wsCase.setModified(IWTimestamp.RightNow().toSQLDateString());
			wsCase.setExternalCase_id("AAC-UHE-0000203");
			wsCase.setSubject("Hello venusv starfsumsokn");
			wsCase.setStatus("UBEH");
			wsCase.setOwner(owner);
			//wsCase.setMessage("my message");
			Item[] items = new Item[4];
			for (int i = 0; i < items.length; i++) {
				items[i] = new Item();
			}
			items[0].setKey("CASE_URL");
			items[0].setValue("http://vuf.rvk.is/umsokn?id=AG-UHE-0000201&kt=2004522249");
			items[1] = null;
			items[2].setKey(WSCaseConstants.MAIL_MESSAGE_SUBJECT);
			items[2].setValue("My subject");
			items[3].setKey(WSCaseConstants.MAIL_MESSAGE_BODY);
			items[3].setValue("Hi Thomas! Hvað segir þú?");
			wsCase.setMetadata(items);
			//CaseServiceServiceLocator service = new CaseServiceServiceLocator();
			TicketServiceServiceLocator ticketService = new TicketServiceServiceLocator();
			// Now use the service to get a stub which implements the SDI.
			//CaseService port = service.getCaseService(new URL(endpoint)); //
			TicketService port2 = ticketService.getTicketService(new URL(endpoint));
			Stub stub = (Stub) port2;
			stub.setUsername("Thoma");
			stub.setPassword("Weser");
			//NewCasePort port = service.getCreateNewCaseHttp();
			boolean ret2 = port2.validateTicket("10t1703532189193346C6A4DA9FAB9BDB9E8D170D1FAC");
			//CaseResult ret = port.createOrUpdateCase(wsCase);
			System.out.print(ret2);
			//System.out.println("Sent 'Hello!', got operation='" + ret.getOperation() + "'and id=" + ret.getId());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*private static void testDummy() {
		try {
			Case_NewCase_SoapPortLocator locator = new Case_NewCase_SoapPortLocator();
			Case_NewCase_SoapPortSoap_PortType port = locator.getCase_NewCase_SoapPortSoap(new URL(endpoint));
			Case_request request = new Case_request();
			request.setCase_id("-1");
			request.setCode("GENERAL");
			request.setCreated(IWTimestamp.RightNow().getDateString("dd-MM-yyyy hh:mm:ss"));
			request.setBody("body");
			request.setExternal_case_id("23456");
			request.setSf_id(8716);// husavik = 6100, hveragerdi = 8716
			request.setStatus(WSCaseConstants.STATUS_PENDING);
			request.setSubject("test case");
			// request.set
			Case_requestOwner owner = new Case_requestOwner();
			owner.setAddress("Galtalind 13");
			owner.setCase_role("eigandi");
			owner.setCity("KÃ³pavogur");
			owner.setEmail("palli@idega.is");
			owner.setGsm("8671374");
			owner.setName("PÃ¡ll Helgason");
			owner.setPhone("5555555");
			owner.setPostalcode("201");
			owner.setSocialsecurity("0610703899");
			request.setOwner(owner);
			Case_response response = port.newCase(request);
			System.out.println("response = " + response.getExternal_case_id());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}