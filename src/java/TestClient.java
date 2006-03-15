import java.net.URL;

import com.idega.block.process.wsclient.Case_NewCase_SoapPortLocator;
import com.idega.block.process.wsclient.Case_NewCase_SoapPortSoap_PortType;
import com.idega.block.process.wsclient.Case_request;
import com.idega.block.process.wsclient.Case_requestOwner;
import com.idega.block.process.wsclient.Case_response;
import com.idega.block.process.wsclient.WSCaseConstants;
import com.idega.util.IWTimestamp;

public class TestClient {
	// private static String endpoint =
	// "http://azskjalfandi.skjalfandi.is/services/CreateNewCaseHttp";
	// private static String endpoint =
	// "http://213.167.155.187:6580/GoProHusavik.nsf/webservicenewcase?OpenAgent";
	// private static String endpoint =
	// "http://localhost:9696/rvk/services/CaseService";
	// private static String endpoint =
	// "http://localhost:8090/rvk/services/CaseService";
	private static String endpoint = "http://213.167.155.148/Case/Case_NewCase_SoapPort.asmx?op=NewCase";

	// private static String endpoint =
	// "http://157.157.136.149:8080/axis/services/CreateNewCaseHttp";

	public static void main(String[] args) {
		testDummy();
		// testVUF();
	}

	/**
	 * <p>
	 * TODO tryggvil describe method testDummy
	 * </p>
	 */
	/*
	 * private static void testVUF() { try { Owner owner = new Owner();
	 * owner.setAddress("H�vallag�tu 13"); owner.setCity("Reykjav�k");
	 * owner.setEmail("tryggvi@idega.is"); owner.setGsm("6954451");
	 * owner.setName("Tryggvi Larusson"); owner.setPostalcode("101");
	 * owner.setSocialsecurity("1011783159");
	 * 
	 * CaseEntry wsCase = new CaseEntry();
	 * wsCase.setStatus(WSCaseConstants.STATUS_CLOSED); wsCase.setCode("JOBA");
	 * wsCase.setCreated(IWTimestamp.RightNow().toSQLDateString());
	 * wsCase.setModified(IWTimestamp.RightNow().toSQLDateString());
	 * wsCase.setExternalCase_id("AG-UHE-0000201"); wsCase.setSubject("G��
	 * starfsums�kn"); wsCase.setStatus("CONFIRMED");
	 * 
	 * wsCase.setOwner(owner);
	 * 
	 * Item[] items = new Item[1]; items[0] = new Item();
	 * items[0].setKey("CASE_URL"); items[0]
	 * .setValue("http://vuf.rvk.is/umsokn?id=AG-UHE-0000201&kt=2004522249");
	 * 
	 * wsCase.setMetadata(items);
	 * 
	 * CaseServiceServiceLocator service = new CaseServiceServiceLocator();
	 *  // Now use the service to get a stub which implements the SDI.
	 * CaseService port = service.getCaseService(new URL(endpoint)); //
	 * NewCasePort port = service.getCreateNewCaseHttp();
	 * 
	 * CaseResult ret = port.createOrUpdateCase(wsCase);
	 * 
	 * System.out.println("Sent 'Hello!', got operation='" + ret.getOperation() + "'
	 * and id=" + ret.getId()); } catch (Exception e) { e.printStackTrace(); } }
	 */

	private static void testDummy() {
		try {
			Case_NewCase_SoapPortLocator locator = new Case_NewCase_SoapPortLocator();
			Case_NewCase_SoapPortSoap_PortType port = locator
					.getCase_NewCase_SoapPortSoap(new URL(endpoint));
			Case_request request = new Case_request();
			request.setCase_id("-1");
			request.setCode("GENERAL");
			request.setCreated(IWTimestamp.RightNow().getDateString("dd-MM-yyyy hh:mm:ss"));
			request.setBody("body");
			request.setExternal_case_id("23456");
			request.setSf_id(8716);//husavik = 6100, hveragerdi = 8716
			request.setStatus(WSCaseConstants.STATUS_PENDING);
			request.setSubject("test case");
			//request.set
			Case_requestOwner owner = new Case_requestOwner();
			owner.setAddress("Galtalind 13");
			owner.setCase_role("eigandi");
			owner.setCity("Kópavogur");
			owner.setEmail("palli@idega.is");
			owner.setGsm("8671374");
			owner.setName("Páll Helgason");
			owner.setPhone("5555555");
			owner.setPostalcode("201");
			owner.setSocialsecurity("0610703899");
			request.setOwner(owner);
			Case_response response = port.newCase(request);
			System.out.println("response = " + response.getExternal_case_id());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}