/**
 * @author Jiahui.Wang
 * @version V1.0  2019年7月22日下午5:22:18
 */
package test.common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 
 */
public class TestReport {

	Document reportTemplateDoc = null; // TODO
	Document testReportDoc = null; 
	/**
	 * @throws DocumentException 
	 * 
	 */
	public TestReport() throws DocumentException {
		this.testReportDoc = getDocument();
	}

	public Document getDocument() throws DocumentException {
		SAXReader reader = new SAXReader();
		try {
			testReportDoc = reader.read(CommonConfig.reportFolder +"/src/test/common/TestResultTemplate.html");
		}catch (DocumentException e) {
			// TODO: handle exception
			throw new DocumentException(e.getMessage());
		}
        return testReportDoc	;
	}
	
	/***
	 * TODO: already used template file so here I didn't use the method to initialize the file
	 */
	public void createInitHtmlFile() {
		//if(!testReport.exists() || testReport.isDirectory()) {
		//	throw new FileNotFoundException("TestResult.html is not found");
		//} 
		//BufferedInputStream in = new BufferedInputStream(new FileInputStream(testReport));
		
		//BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(testReport));
	}
	
	/***
	 * Write html file based on internal document instance TODO: set email template as a param
	 * @param testCaseInfo
	 * @return
	 * @throws IOException
	 */
	public Document writeHtmlFile(TestCaseInfo testCaseInfo) throws IOException {
		Element tableElement = (Element) testReportDoc.selectSingleNode("/html/body/table");
		
		Element trElem = tableElement.addElement("tr");
		trElem
			.addElement("td")
			.addText(String.valueOf(testCaseInfo.id));
		trElem
			.addElement("td")
			.addText(testCaseInfo.name);
		trElem
			.addElement("td")
			.addText(testCaseInfo.owner);	
		if(testCaseInfo.result == false) {
			trElem
			.addElement("td")
			.addAttribute("bgcolor", "#FF0000")
			.addText(String.valueOf(testCaseInfo.result));
		} else {
			trElem
			.addElement("td")
			.addText(String.valueOf(testCaseInfo.result));
		}
		
		// write a report
		try {
			XMLWriter writer = new XMLWriter(new FileWriter(new File("./newTestReport.html")));
			writer.write(testReportDoc);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//	e.printStackTrace();
			throw new IOException(e);
		}	
		return testReportDoc;
	}
	
	
	
	//test
	/***
	 * Class internal testing purpose
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TestCaseInfo testCaseInfo = new TestCaseInfo();
			testCaseInfo.id = 1;
			testCaseInfo.name = "searchBox";
			testCaseInfo.owner = "Jiahui.Wang";
			testCaseInfo.result = false;
			
			TestReport report = new TestReport();
			report.writeHtmlFile(testCaseInfo);
			//LogUtility.log("Generate report succeed.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			//LogUtility.log(e.toString());
		}
	}	
}


