import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

import org.apache.axis.encoding.Base64;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.idega.block.process.wsclient.WSCaseConstants;
import com.idega.io.MemoryFileBuffer;
import com.idega.io.MemoryOutputStream;
import com.idega.xml.XMLCDATA;
import com.idega.xml.XMLDocument;
import com.idega.xml.XMLElement;
import com.idega.xml.XMLOutput;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

public class TestClientOS {

	public TestClientOS() {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String URL = "http://one.kerfisveita.is/datareceiver/saveapplication.aspx";

		TestClientOS client = new TestClientOS();
		client.doStuff(URL);
	}

	public void doStuff(String URL) {
		String xml = createFile();
		
		sendFile(xml, URL);
	}

	private String createFile() {
		final String XML_CASE = "case";
		final String XML_ID = "id";
		final String XML_EXTERNAL_ID = "external_id";
		final String XML_CREATED = "created";
		final String XML_CODE = "code";
		final String XML_CATEGORY = "category";
		final String XML_MODIFIED = "modified";
		final String XML_STATUS = "status";
		final String XML_SUBJECT = "subject";
		final String XML_BODY = "body";
		final String XML_OWNER = "owner";
		final String XML_NAME = "name";
		final String XML_SSN = "socialsecurity";
		final String XML_ADDRESS = "address";
		final String XML_CITY = "city";
		final String XML_POSTAL_CODE = "postalcode";
		final String XML_PHONE = "phone";
		final String XML_GSM = "gsm";
		final String XML_EMAIL = "email";
		final String XML_FILE_DATA = "file_data";
		final String XML_FILE_SIZE = "file_size";

		String outputString = "nothing";

		File xmlFile = null;
		try {
			xmlFile = File.createTempFile("testOS", "xml");
			xmlFile = File.createTempFile("testOS", ".xml");

			Document document = new Document();
			MemoryFileBuffer buffer = new MemoryFileBuffer();
			MemoryOutputStream mos = new MemoryOutputStream(buffer);

			try {
				PdfReader reader = new PdfReader(
						"/Users/bluebottle/Desktop/Desk_drasl/kvortun.pdf");
				int nop = reader.getNumberOfPages();
				Rectangle psize = reader.getPageSize(1);

				document = new Document(psize, 50, 50, 50, 50);
				document.setPageCount(nop);
				PdfWriter writer = PdfWriter.getInstance(document, mos);
				document.open();
				PdfContentByte cb = writer.getDirectContent();
				for (int i = 1; i <= nop; i++) {
					PdfImportedPage page = writer.getImportedPage(reader, i);
					cb.addTemplate(page, 0, 0);
				}

				document.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (DocumentException e) {
				e.printStackTrace();
			}

			XMLDocument doc = new XMLDocument(new XMLElement(XML_CASE));

			XMLElement case_ = doc.getRootElement();
			case_.addContent(XML_ID, "-1");
			case_.addContent(XML_EXTERNAL_ID, "904");
			case_.addContent(XML_CREATED, "2006-03-07 11:17:07");
			case_.addContent(XML_CODE, "Kvörtun");
			case_.addContent(XML_CATEGORY, "10");
			case_.addContent(XML_MODIFIED, "");
			case_.addContent(XML_STATUS, WSCaseConstants.STATUS_PENDING);
			case_.addContent(XML_SUBJECT, "Kvörtun");
			case_.addContent(XML_BODY, "Test kvörtun. Tegund = Kvörtun Málaflokkur = Hiti/rafmagn/vatn.");

			FileOutputStream outStream = new FileOutputStream("/Users/bluebottle/Desktop/Desk_drasl/kvortun2.pdf");
			outStream.write(buffer.buffer());
			outStream.close();

			XMLElement file = new XMLElement(XML_FILE_DATA);
			case_.addContent(file);
			
			int length = buffer.buffer().length;
			case_.addContent(XML_FILE_SIZE, Integer.toString(length));
			file.addContent(new XMLCDATA(Base64.encode(buffer.buffer())));

			XMLElement owner = new XMLElement(XML_OWNER);
			case_.addContent(owner);

			owner.addContent(XML_NAME, "Guðlaug Sigurðardóttir");
			owner.addContent(XML_SSN, "1009663879");
			owner.addContent(XML_ADDRESS, "HRAUNTJÖRN 4");
			owner.addContent(XML_CITY, "Selfoss");
			owner.addContent(XML_POSTAL_CODE, "800");
			owner.addContent(XML_PHONE, "43342456");
			owner.addContent(XML_GSM, "11223345");
			owner.addContent(XML_EMAIL, "steina@idega.is");
			
			FileOutputStream out = new FileOutputStream(xmlFile);

			XMLOutput output = new XMLOutput(" ", true);
			output.setLineSeparator(System.getProperty("line.separator"));
			output.setTextNormalize(true);
			output.setEncoding("UTF-8");
			output.output(doc, out);

			out.close();

			try {
				output = new XMLOutput();
				output.setLineSeparator(System.getProperty("line.separator"));
				output.setTextNormalize(true);
				output.setEncoding("UTF-8");
				outputString = output.outputString(doc);
			} catch (Exception e) {
				e.printStackTrace();
			}

			com.idega.util.SendMail.send("palli@idega.is", "palli@idega.is",
					null, null, "mail.idega.is", "test", outputString, xmlFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return outputString;
	}

	private void sendFile(String xml, String URL) {
		PostMethod authpost = new PostMethod(URL);

		try {
			HttpClient client = new HttpClient();
			
			NameValuePair file = new NameValuePair("xmldata", URLEncoder.encode(xml, "ISO-8859-1"));
			authpost.setRequestBody(new NameValuePair[] { file });

			int status = client.executeMethod(authpost);

			if (status == HttpStatus.SC_OK) {
				// System.out.println("Submit complete, response="
				// + authpost.getResponseBodyAsString());
			} else {
				// System.out.println("Submit failed, response="
				// + HttpStatus.getStatusText(status));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			authpost.releaseConnection();
		}

	}
}