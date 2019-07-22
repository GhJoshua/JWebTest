/**
 * 
 */
package test.webpages;


/**
 * 
 */
public class GoogleMainPage extends BasePage {
	private static String defaultBrowserString = "chrome";
	String[] searchBox = {"ID","kw"};
	/**
	 * default browser is Chrome
	 * @throws Exception 
	 */
	public GoogleMainPage() throws Exception {
		super(defaultBrowserString);
	}
	
	public void inputSearchContent(String searchContent) {
		type(super.findElement(searchBox), searchContent);
		enter(super.findElement(searchBox));
	}
}
