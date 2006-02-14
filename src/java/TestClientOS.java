import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.idega.block.process.wsclient.WSCaseConstants;
import com.idega.util.IWTimestamp;
import com.idega.xml.XMLDocument;
import com.idega.xml.XMLElement;
import com.idega.xml.XMLOutput;

public class TestClientOS {

	public TestClientOS() {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String URL = "http://one.kerfisveita.is/datareceiver/saveapplication.aspx";
//		String URL = "http://localhost:8080";

		TestClientOS client = new TestClientOS();
		client.doStuff(URL);
	}

	public void doStuff(String URL) {
		String xml = createFile();
		sendFile(xml, URL);
	}

	private String createFile() {
		// final String XML_ROOT = "xml";
		final String XML_CASE = "case";
		final String XML_ID = "id";
		final String XML_EXTERNAL_ID = "external_id";
		final String XML_CREATED = "created";
		final String XML_CODE = "code";
		final String XML_MODIFIED = "modified";
		final String XML_STATUS = "case";
		final String XML_SUBJECT = "case";
		final String XML_BODY = "case";
		final String XML_OWNER = "owner";
		final String XML_CONTACT = "contact";
		final String XML_HANDLER = "handler";
		final String XML_NAME = "name";
		final String XML_SSN = "socialsecurity";
		final String XML_ADDRESS = "address";
		final String XML_CITY = "city";
		final String XML_POSTAL_CODE = "postalcode";
		final String XML_PHONE = "phone";
		final String XML_GSM = "gsm";
		final String XML_EMAIL = "email";
		final String XML_TITLE = "title";
		final String XML_DEPARTMENT = "department";
		final String XML_CASE_ROLE = "case_role";
		final String XML_METADATA = "metadata";
		final String XML_ITEM = "item";
		final String XML_KEY = "key";
		final String XML_VALUE = "value";

		// File xmlFile = null;
		// try {
		// xmlFile = File.createTempFile("testOS", "xml");
		// xmlFile = File.createTempFile("testOS", ".xml");

		XMLDocument doc = new XMLDocument(new XMLElement(XML_CASE));

		XMLElement case_ = doc.getRootElement();
		case_.addContent(XML_ID, "-1");
		case_.addContent(XML_EXTERNAL_ID, "12345");
		case_.addContent(XML_CREATED, IWTimestamp.RightNow().toString());
		case_.addContent(XML_CODE, "MBARN");
		case_.addContent(XML_MODIFIED, IWTimestamp.RightNow().toString());
		case_.addContent(XML_STATUS, WSCaseConstants.STATUS_CLOSED);
		case_.addContent(XML_SUBJECT, "Test subject");
		case_.addContent(XML_BODY, "Test body");

		XMLElement owner = new XMLElement(XML_OWNER);
		case_.addContent(owner);
		XMLElement handler = new XMLElement(XML_HANDLER);
		case_.addContent(handler);
		XMLElement metadata = new XMLElement(XML_METADATA);
		case_.addContent(metadata);

		owner.addContent(XML_NAME, "Pall Helgason");
		owner.addContent(XML_SSN, "0610703899");
		owner.addContent(XML_ADDRESS, "Galtalind 13");
		owner.addContent(XML_CITY, "Kopavogur");
		owner.addContent(XML_POSTAL_CODE, "201");
		owner.addContent(XML_PHONE, "1234567");
		owner.addContent(XML_GSM, "8971234");
		owner.addContent(XML_EMAIL, "palli@idega.is");
		owner.addContent(XML_TITLE, "Mr.");
		owner.addContent(XML_DEPARTMENT, "Department of ws");
		owner.addContent(XML_CASE_ROLE, "Tester 1");

		XMLElement ownerContact = new XMLElement(XML_CONTACT);
		owner.addContent(ownerContact);

		ownerContact.addContent(XML_NAME, "Thorhallur Helgason");
		ownerContact.addContent(XML_SSN, "0202774919");
		ownerContact.addContent(XML_ADDRESS, "Stafnasel 5");
		ownerContact.addContent(XML_CITY, "Reykjavik");
		ownerContact.addContent(XML_POSTAL_CODE, "109");
		ownerContact.addContent(XML_PHONE, "1234567");
		ownerContact.addContent(XML_GSM, "8971234");
		ownerContact.addContent(XML_EMAIL, "laddi@idega.is");
		ownerContact.addContent(XML_TITLE, "Mr.");
		ownerContact.addContent(XML_DEPARTMENT, "Department of ws contacts");
		ownerContact.addContent(XML_CASE_ROLE, "Tester 3");

		handler.addContent(XML_NAME, "Grimur Jonsson");
		handler.addContent(XML_SSN, "2311771234");
		handler.addContent(XML_ADDRESS, "Hraunnaer 110");
		handler.addContent(XML_CITY, "Reykjavik");
		handler.addContent(XML_POSTAL_CODE, "119");
		handler.addContent(XML_PHONE, "1234567");
		handler.addContent(XML_GSM, "8971234");
		handler.addContent(XML_EMAIL, "gimmi@idega.is");
		handler.addContent(XML_TITLE, "Mr.");
		handler.addContent(XML_DEPARTMENT, "Department of ws handlers");
		handler.addContent(XML_CASE_ROLE, "Tester 2");

		XMLElement handlerContact = new XMLElement(XML_CONTACT);
		handler.addContent(handlerContact);

		handlerContact.addContent(XML_NAME, "Thorhallur Helgason");
		handlerContact.addContent(XML_SSN, "0202774919");
		handlerContact.addContent(XML_ADDRESS, "Stafnasel 5");
		handlerContact.addContent(XML_CITY, "Reykjavik");
		handlerContact.addContent(XML_POSTAL_CODE, "109");
		handlerContact.addContent(XML_PHONE, "1234567");
		handlerContact.addContent(XML_GSM, "8971234");
		handlerContact.addContent(XML_EMAIL, "laddi@idega.is");
		handlerContact.addContent(XML_TITLE, "Mr.");
		handlerContact.addContent(XML_DEPARTMENT, "Department of ws contacts");
		handlerContact.addContent(XML_CASE_ROLE, "Tester 3");

		XMLElement item = new XMLElement(XML_ITEM);
		metadata.addContent(item);
		item.addContent(XML_KEY, "metadata_key_1");
		item.addContent(XML_VALUE, "value 1");
		item = new XMLElement(XML_ITEM);
		metadata.addContent(item);
		item.addContent(XML_KEY, "metadata_key_2");
		item.addContent(XML_VALUE, "value 2");
		item = new XMLElement(XML_ITEM);
		metadata.addContent(item);
		item.addContent(XML_KEY, "metadata_key_3");
		item.addContent(XML_VALUE, "value 3");

		/*
		 * FileOutputStream out = new FileOutputStream(xmlFile);
		 * 
		 * XMLOutput output = new XMLOutput(" ", true);
		 * output.setLineSeparator(System.getProperty("line.separator"));
		 * output.setTextNormalize(true); output.setEncoding("UTF-8");
		 * output.output(doc, out);
		 * 
		 * out.close();
		 */

		String outputString = "nothing";
		try {
			XMLOutput output = new XMLOutput();
			output.setLineSeparator(System.getProperty("line.separator"));
			output.setTextNormalize(true);
			output.setEncoding("UTF-8");
			outputString = output.outputString(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//System.out.println(outputString);

		/*
		 * com.idega.util.SendMail.send("palli@idega.is", "palli@idega.is",
		 * null, null, "mail.idega.is", "test", outputString, xmlFile);
		 */
		/* catch (MessagingException e) { e.printStackTrace(); } */

		return outputString;
	}

	/*
	 * private void sendFile(File file, String URL) { PostMethod filePost = new
	 * PostMethod(URL);
	 * 
	 * filePost.getParams().setBooleanParameter(
	 * HttpMethodParams.USE_EXPECT_CONTINUE, true);
	 * 
	 * try { Part[] parts = { new FilePart("xmldata", file) };
	 * filePost.setRequestEntity(new MultipartRequestEntity(parts,
	 * filePost.getParams())); HttpClient client = new HttpClient();
	 * client.getHttpConnectionManager().getParams().setConnectionTimeout(
	 * 5000);
	 * 
	 * int status = client.executeMethod(filePost); if (status ==
	 * HttpStatus.SC_OK) { System.out.println("Upload complete, response=" +
	 * filePost.getResponseBodyAsString()); } else { System.out.println("Upload
	 * failed, response=" + HttpStatus.getStatusText(status)); } } catch
	 * (Exception ex) { ex.printStackTrace(); } finally {
	 * filePost.releaseConnection(); } }
	 */

	private void sendFile(String xml, String URL) {
		PostMethod authpost = new PostMethod(URL);

		//authpost.getParams().setBooleanParameter(HttpMethodParams.USE_EXPECT_CONTINUE, true);
		try {

			HttpClient client = new HttpClient();
			//client.getHttpConnectionManager().getParams().setConnectionTimeout(5000);

			// Prepare login parameters
			NameValuePair file = new NameValuePair("xmldata", xml);
			authpost.setRequestBody(new NameValuePair[] { file });

			int status = client.executeMethod(authpost);
			System.out.println("Form post: "
					+ authpost.getStatusLine().toString());
			if (status == HttpStatus.SC_OK) {
				System.out.println("Submit complete, response="
						+ authpost.getResponseBodyAsString());
			} else {
				System.out.println("Submit failed, response="
						+ HttpStatus.getStatusText(status));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			authpost.releaseConnection();
		}

	}
}