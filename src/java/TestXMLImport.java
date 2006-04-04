import java.io.FileOutputStream;

import org.apache.axis.encoding.Base64;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class TestXMLImport {

	protected static final String INPUT_FILENAME = "/Users/bluebottle/Desktop/testOS2671.xml";
	protected static final String OUTPUT_FILENAME = "/Users/bluebottle/Desktop/kvortun3.pdf";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestXMLImport imp = new TestXMLImport();

		imp.doImport();
		//imp.doImport3();
	}

	/*public void doImport2() {
		try {
//			File file = new File("/Users/bluebottle/Desktop/umsokn2.txt");
//			System.out.println("file length = " + file.length());
			
//			byte[] buffer = new byte[(int)file.length()];
			
			BufferedReader stream = new BufferedReader(
					new FileReader("/Users/bluebottle/Desktop/umsokn2.txt"));
			String line = null;
			StringBuffer buffer = new StringBuffer();
			while ((line = stream.readLine()) != null) {
				buffer.append(line);
				//buffer.append()
			}
			
			System.out.println(buffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public void doImport() {
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(INPUT_FILENAME);
			Element rootElement = document.getRootElement();
			Element fileElement = rootElement.getChild("file_data");
			String base64String = fileElement.getText();

			System.out.println("base64String = " + base64String);

			byte[] buffer = Base64.decode(base64String);

			FileOutputStream outStream = new FileOutputStream(OUTPUT_FILENAME);
			outStream.write(buffer);
			outStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*public void doImport3() {
		String enc = "%253C%253Fxml%2Bversion%253D%25221.0%2522%2Bencoding%253D%2522UTF-8%2522%253F%253E%250D%250A%253Ccase%253E%253Cid%253E-1%253C%252Fid%253E%253Cexternal_id%253E95cb790a-b82d-11da-b108-9d7497cd6eaf%253C%252Fexternal_id%253E%253Ccreated%253E2006-03-20%2B04%253A21%253A28%253C%252Fcreated%253E%253Ccode%253EHr%25F3s%253C%252Fcode%253E%253Ccategory%253E2%253C%252Fcategory%253E%253Cmodified%253E%253C%252Fmodified%253E%253Cstatus%253EUBEH%253C%252Fstatus%253E%253Csubject%253EHr%25F3s%253C%252Fsubject%253E%253Cbody%253ETest.%2BEkki%2Bsvara%2B%25FEessu%253C%252Fbody%253E%253Cowner%253E%253Cname%253EGu%25F0laug%2BSigur%25F0ard%25F3ttir%253C%252Fname%253E%253Csocialsecurity%253E1009663879%253C%252Fsocialsecurity%253E%253Caddress%253EHrauntj%25F6rn%2B4%253C%252Faddress%253E%253Ccity%253ESelfoss%253C%252Fcity%253E%253Cpostalcode%253E800%253C%252Fpostalcode%253E%253Cphone%253E43342456%253C%252Fphone%253E%253Cgsm%253E11223345%253C%252Fgsm%253E%253Cemail%253Esteina%2540idega.is%253C%252Femail%253E%253C%252Fowner%253E%253Cfile_data%253E%253C%252Ffile_data%253E%253Cfile_size%253E0%253C%252Ffile_size%253E%253C%252Fcase%253E%250D%250A";
		try {
			System.out.println(URLDecoder.decode(URLDecoder.decode(enc, "ISO-8859-1"), "ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}