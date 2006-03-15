import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.apache.axis.encoding.Base64;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class TestXMLImport {

	protected static final String INPUT_FILENAME = "/Users/bluebottle/Desktop/testOS53215.xml";
	protected static final String OUTPUT_FILENAME = "/Users/bluebottle/Desktop/kvortun3.pdf";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestXMLImport imp = new TestXMLImport();

		imp.doImport();
	}

	public void doImport2() {
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
	}

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
}
