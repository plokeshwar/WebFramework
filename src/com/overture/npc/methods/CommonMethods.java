package com.overture.npc.methods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.overture.npc.controller.HomeServlet;
import com.overture.npc.interfaces.CommonMethodsInterface;

public class CommonMethods implements CommonMethodsInterface {
	PhantomJSDriver phantomJSdriver=null;
	DesiredCapabilities dCaps;

	
	static POJO pj;
	public WebDriver driver = null;
	private final static String TASKLIST = "tasklist";
	private final static String KILL = "taskkill /t /f /im ";

	private final static String BUILD_REPORT = "testng-xslt-report";
	
	@Override
	public ArrayList<String> getClassName(String PackageName) {

		String relPath = PackageName;
		ArrayList<String> cn = null;

		try{
			@SuppressWarnings("rawtypes")
			Class[] classes = getClasses(relPath);
			cn = new ArrayList<String>();
			for (int i = 0; i < classes.length; i++) {
				cn.add(classes[i].getSimpleName());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cn;
	}

	@Override
	public ArrayList<String> boldTextFinder(WebDriver driver, WebElement table) {
		ArrayList<String> stringList=null;
		if (new CommonMethods().waiters(table)) {
			List<WebElement> anchors = table.findElements(By.tagName("b"));
			Iterator<WebElement> i = anchors.iterator();
			stringList = new ArrayList<String>();
			while (i.hasNext()) {
				WebElement anchor = i.next();
				stringList.add(anchor.getText());
			}
		}
	Reporter.log(new CommonMethods().ReporterText("Bold Text List : "+stringList));
	return stringList;
	}
	
	@Override
	public String basepath() {
		File f = new File("");
		String path = f.getAbsolutePath();
		String basepath = path.replaceAll("\\\\", "/");
		return basepath;
	}
	
	//deleteFile method will delete files.
	//If indicator is set to true, it will delete the whole directory
	//Else, it will delete the subFolders Only.
	public void deleteFile (File p_file,boolean deleteSub) {        
        if (p_file.isDirectory()) {
            File [] subFiles = p_file.listFiles();
            for (int i=0;i<subFiles.length;i++) {
            	if(deleteSub)
            		deleteFile(subFiles[i],true);
            	else
            		deleteSubDir (subFiles[i]);
            }
        }
        if(deleteSub)  
        	p_file.delete();
    }
	
	public void deleteSubDir(File p_file)
	{
		 if (p_file.isDirectory()) {
	            File [] subFiles = p_file.listFiles();
	            for (int i=0;i<subFiles.length;i++) {
	            	deleteSubDir (subFiles[i]);
	            }
	        }
	        
	        p_file.delete();
	}
	
	@Override
	public String ReporterText(String message) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		System.out.println("Reporting Text : "+message);
		return "<br><span>" + message + "</span>";
	}
	@Override
	public String ReporterTextBold(String message) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		System.out.println("Reporting Bold Text : "+message);
		return "<br><span><b>" + message + "</b></span>";
	}
	@Override
	public String ReporterLink(String sScreenshotName) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		System.out.println("Reporting Link : "+sScreenshotName);
		return "<a href=\"" + "ScreenShots/" + sScreenshotName + ".jpg"
				+ "\"><p align=\"left\"><h4>Screenshot</h4></p></a>";
	}

	@Override
	public WebDriver getDriver(String browser, String path) {
		driver = BrowserSelection.getDriver(browser, path);
		return driver;
	}

	@Override
	public void datePicker(WebDriver driver, WebElement element, String testData) {
		String[] dt = testData.split("-");
		String year = dt[0];
		String mnth = dt[1];
		String date = dt[2];

		if (mnth.equals("01") || mnth.equals("1")) {
			mnth = "January";
		} else if (mnth.equals("02") || mnth.equals("2")) {
			mnth = "February";
		} else if (mnth.equals("03") || mnth.equals("3")) {
			mnth = "March";
		} else if (mnth.equals("04") || mnth.equals("4")) {
			mnth = "April";
		} else if (mnth.equals("05") || mnth.equals("5")) {
			mnth = "May";
		} else if (mnth.equals("06") || mnth.equals("6")) {
			mnth = "June";
		} else if (mnth.equals("07") || mnth.equals("7")) {
			mnth = "July";
		} else if (mnth.equals("08") || mnth.equals("8")) {
			mnth = "August";
		} else if (mnth.equals("09") || mnth.equals("9")) {
			mnth = "September";
		} else if (mnth.equals("10")) {
			mnth = "October";
		} else if (mnth.equals("11")) {
			mnth = "November";
		} else if (mnth.equals("12")) {
			mnth = "December";
		}

		if (date.startsWith("0")) {
			date = (String) date.subSequence(1, date.length());
		}
		if (waiters(element)) {
			element.click();
		}

		element = driver.findElement(By
				.xpath("//select[contains(@class,'ui-datepicker-new-month')]"));

		Select menuMnth = new Select(element);

		menuMnth.selectByVisibleText(mnth);

		element = driver.findElement(By
				.xpath("//select[contains(@class,'ui-datepicker-new-year')]"));

		Select menuYear = new Select(element);

		menuYear.selectByVisibleText(year);

		WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));

		List<WebElement> columns = dateWidget.findElements(By.tagName("td"));

		for (WebElement cell : columns) {

			if (cell.getText().equals(date)) {

				if (waiters(cell.findElement(By.linkText(date)))) {
					cell.findElement(By.linkText(date)).click();
					break;
				}

			}
		}

	}

	@Override
	public List<String> GetChildElementTextByxpath(WebElement element) {
		List<String> values = new ArrayList<String>();
		String childElement = element.getText();
		String returnValue = "";
		try {

			if (childElement != null) {
				returnValue = childElement;
				values.add(returnValue);
			}
		} catch (Exception r) {

		}

		return values;

	}

	@Override
	public void captureElementScreenShot(WebDriver driver, WebElement element,
			String TestCaseName, String basepath) {
		System.out.println("Capturing ScreenShot.");
		if(element.isDisplayed() && element.isEnabled()){
			for (int i = 0; i < 3; i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(
						"arguments[0].setAttribute('style', arguments[1]);",
						element, "color: red; border: 2px solid red;");
	
				File scrFile = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
				try {
					FileUtils
							.copyFile(scrFile, new File(basepath
									+ "/Reports/ScreenShots" + "/" + TestCaseName
									+ ".jpg"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				js.executeScript(
						"arguments[0].setAttribute('style', arguments[1]);",
						element, "");
			}
		}
		else{
			captureDriverScreenShot(driver, TestCaseName, basepath);
		}
	}

	@Override
	public void captureDriverScreenShot(WebDriver driver, String TestCaseName,
			String basepath) {
		System.out.println("Capturing Driver ScreenShot.");
		try {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(scrFile, new File(basepath
					+ "/Reports/ScreenShots" + "/" + TestCaseName + ".jpg"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public boolean waiters(WebElement element) {
		boolean flag = false;
		int sleepTime = 700;
		for (int i = 1;; i++) {
			try {
				element.isDisplayed();
				flag = true;
			} catch (Exception e) {

				try {
					Thread.sleep(sleepTime);
					System.out.println("!!! Trying to Find the Element : Try No. "+i+"  !!!"+element.toString());
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}

			if (i > 20 || flag == true) {
				break;
			}

		}
		return flag;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class[] getClasses(String packageName)
			throws ClassNotFoundException, IOException {

		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();

		assert classLoader != null;

		String path = packageName.replace('.', '/');

		Enumeration<URL> resources = classLoader.getResources(path);

		List<File> dirs = new ArrayList<File>();

		while (resources.hasMoreElements()) {

			URL resource = resources.nextElement();

			dirs.add(new File(resource.getFile()));

		}

		ArrayList<Class> classes = new ArrayList<Class>();

		for (File directory : dirs) {

			classes.addAll(findClasses(directory, packageName));

		}

		return classes.toArray(new Class[classes.size()]);

	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Class> findClasses(File directory, String packageName)
			throws ClassNotFoundException {

		List<Class> classes = new ArrayList<Class>();

		if (!directory.exists()) {

			return classes;

		}

		File[] files = directory.listFiles();

		for (File file : files) {

			if (file.isDirectory()) {

				assert !file.getName().contains(".");

				classes.addAll(findClasses(file,
						packageName + "." + file.getName()));

			} else if (file.getName().endsWith(".class")) {

				classes.add(Class.forName(packageName
						+ '.'
						+ file.getName().substring(0,
								file.getName().length() - 6)));

			}

		}

		return classes;

	}

	@Override
	public void copyDirectory(File sourceLocation, File targetLocation)
			throws IOException {
		if (sourceLocation.isDirectory()) {
			if (!targetLocation.exists()) {
				targetLocation.mkdir();
			}

			String[] children = sourceLocation.list();
			for (int i = 0; i < children.length; i++) {
			if(targetLocation.isDirectory()){
				copyDirectory(new File(sourceLocation, children[i]), new File(
						targetLocation, children[i]));
			}
				else{
					
				System.out.println("Directory not created");
				}
			}
		} else {

			
			InputStream in = null;
			try {
				in = new FileInputStream(sourceLocation);
			} catch (Exception FileNotFoundException) {
				// TODO Auto-generated catch block
				File  f = new File(sourceLocation.toString());
				System.out.println("Created Reports Directory : "+f.mkdir());
			}
			OutputStream out = new FileOutputStream(targetLocation);

			// Copy the bits from instream to outstream
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
		}

	}

	
	public static boolean isProcessRunning(String serviceName) throws Exception {
		Process p = Runtime.getRuntime().exec(TASKLIST);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {

			// System.out.println(line);
			if (line.contains(serviceName)) {
				System.out.println("");
				return true;
			}
		}

		return false;
	}

	
	public static void killProcess(String serviceName) throws Exception {
		System.out.println("CMD : " + KILL + serviceName);
		Runtime.getRuntime().exec(KILL + serviceName);
		

	}
	
	public static void buildReportExecuture(String path) throws Exception {
		System.out.println("Reporter Executure Path "+ path);
		
        
        File buildFile = new File(path, "build.xml");
        Project p = new Project();
        p.setUserProperty("ant.file", buildFile.getAbsolutePath());
        p.init();
        ProjectHelper helper = ProjectHelper.getProjectHelper();
        p.addReference("ant.projectHelper", helper);
        helper.parse(p, buildFile);
        p.executeTarget(BUILD_REPORT);
		
	}
	
	public static void main(String[] args) throws Exception {
		buildReportExecuture(new CommonMethods().basepath());
		
	}
	

	@Override
	public void terminateProcess(String bwrName) {
		String processName = "";
		if (bwrName.equals("CHROME")) {
			processName = "chromedriver.exe";

		} else if (bwrName.equals("IE")) {
			processName = "IEDriverServer.exe";
		}
		else if (bwrName.equals("FIREFOX")) {
		processName = "firefox.exe";
		}
		try {
			Thread.sleep(2000);
			System.out.println("Process Available : "
					+ CommonMethods.isProcessRunning(processName));
			if (CommonMethods.isProcessRunning(processName)) {
				CommonMethods.killProcess(processName);
			}
		} catch (Exception e) {
		}

	}

	@Override
	public void mouseOver(WebDriver driver, WebElement element, String elementName) {
		Reporter.log(ReporterText("Performing Mouse Over Operation on element "+elementName));
		
		if(new CommonMethods().waiters(element)){
			Actions builder=new Actions(driver);
			builder.moveToElement(element).perform();
		}
		else{
			Reporter.log(ReporterText("Performing Mouse Over Operation on element "+elementName+" Failed"));
			System.out.println("Performing Mouse Over Operation on element "+elementName+"Failed");
		}
        
	}
	
	@Override
	public void moveToElement(WebDriver driver, WebElement element,
			String elementName) {
		Reporter.log(ReporterText("Moving on to Element Operation : "+elementName));
		
		if(new CommonMethods().waiters(element)){ 
			Actions builder=new Actions(driver);
			builder.moveToElement(element).perform();
		}
		else{
			Reporter.log(ReporterText("Moving on to Element Operation : "+elementName+" Failed"));
			System.out.println("Moving on to Element Operation : "+elementName+"Failed");
		}        
	}

	@Override
	public ArrayList<String> linkFinder(WebDriver driver, WebElement table) {
		ArrayList<String> stringList=null;
		if (new CommonMethods().waiters(table)) {
			List<WebElement> anchors = table.findElements(By.tagName("a"));
			Iterator<WebElement> i = anchors.iterator();
			stringList = new ArrayList<String>();
			while (i.hasNext()) {
				WebElement anchor = i.next();
				stringList.add(anchor.getText());
			}
		}
	Reporter.log(new CommonMethods().ReporterText("Actual Link List : "+stringList));
	return stringList;
	}
	
	@Override
	public ArrayList<String> paragraphFinder(WebDriver driver, WebElement table) {
		ArrayList<String> stringList=null;
		List<WebElement> paragraphs = table.findElements(By.tagName("p"));
		 Iterator<WebElement> i = paragraphs.iterator(); 
		 stringList = new ArrayList<String>();
		 while(i.hasNext()) { 
			 WebElement paragraph = i.next(); 
			 stringList.add(paragraph.getText());
		 }
	Reporter.log(new CommonMethods().ReporterText("Actual paragraph Link List : "+stringList));
	return stringList;
	}
	
	@Override
	public ArrayList<String> dropdownValueFinder(WebDriver driver, WebElement element) {
		ArrayList<String> stringList=null;
		if(waiters(element)){
			List<WebElement> options = element.findElements(By.tagName("option"));
				 Iterator<WebElement> i = options.iterator(); 
				 stringList = new ArrayList<String>();
				 while(i.hasNext()) { 
					 WebElement option = i.next(); 
					 stringList.add(option.getText());
				 }
			Reporter.log(new CommonMethods().ReporterText("Actual DropDown List : "+stringList));
		}
	return stringList;
	}
	
	@Override
	public ArrayList<String> createArrayList(String text){
		String [] st=text.split(",");
		ArrayList<String> str=new ArrayList<String>();
		for(int i=0;i<st.length;i++){
			str.add(st[i].trim());
		}
		Reporter.log(new CommonMethods().ReporterText("Expected Link List : "+str));
		return str;
	}

	@Override
	public ArrayList<String> linkFinderByClass(WebDriver driver,WebElement table) {
		ArrayList<String> stringList=null;
		List<WebElement> anchors = table.findElements(By.tagName("span"));
		 Iterator<WebElement> i = anchors.iterator(); 
		 stringList = new ArrayList<String>();
		 while(i.hasNext()) { 
			 WebElement anchor = i.next(); 
			// System.out.println(anchor.getText());
			 stringList.add(anchor.getText());
		 }
	Reporter.log(new CommonMethods().ReporterText("Actual Link List : "+stringList));
	return stringList;
	}
	@Override
	public ArrayList<String> linkFinderByTableColumn(WebDriver driver,
			WebElement table) {
		ArrayList<String> stringList=null;
		List<WebElement> anchors = table.findElements(By.tagName("th"));
		 Iterator<WebElement> i = anchors.iterator(); 
		 stringList = new ArrayList<String>();
		 while(i.hasNext()) { 
			 WebElement anchor = i.next(); 
			 stringList.add(anchor.getText());
		 }
	Reporter.log(new CommonMethods().ReporterText("Actual Link List : "+stringList));
	return stringList;
	}

	@Override
	public  String randomNumberGenerator() {
		List<Integer> numbers = new ArrayList<Integer>();
	    for(int i = 0; i < 10; i++){
	        numbers.add(i);
	    }

	    Collections.shuffle(numbers);

	    String result = "";
	    for(int i = 0; i < 4; i++){
	        result += numbers.get(i).toString();
	    }
	    if(result.charAt(0)==('0'))
	    {
	    	result=result.replace('0','9');
	    }
	    return result;
	}

	
		public void fileTransfer(String path1,String path2,String brName) throws IOException {
		File fileTestOutputA = new File(path1 + "/test-output");
		File fileTestOutputB = new File(path2 + "/test-output/"+brName);
		copyDirectory(fileTestOutputA, fileTestOutputB);
		
		File fileTestResultsA = new File(path1 + "/Reports");
		File fileTestResultsB = new File(path2 + "/test-output/"+brName+"/html");
		copyDirectory(fileTestResultsA, fileTestResultsB);
		
		File fileTestResultsD = new File(path2 + "/test-output/"+brName+"/NPCExecutedSuite");
		copyDirectory(fileTestResultsA, fileTestResultsD);
		
		File fileTestOutputE = new File(path2 + "/test-output/xslReporting");
		copyDirectory(fileTestOutputA, fileTestOutputE);
		
		try {
			System.out.println(path2);
			
			buildReportExecuture(path2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		File fileTestOutputC = new File(path2 + "/test-output/"+brName+"/GraphReporting");
		copyDirectory(fileTestOutputE, fileTestOutputC);
		
	}
		
	public void fileEditingGraphFolder(String path, String browserName){
		String filePath=null,txtFinder1=null,txtReplace1=null,txtFinder2=null,txtReplace2=null;
		
		filePath=path+"/test-output/"+browserName+"/GraphReporting/testng-xslt/navigation.html";
		txtFinder1="<title>TestNG Results</title>";
		txtReplace1="<title>"+browserName+" RESULTS</title>";
		
		txtFinder2=">TestNG Results</h2>";
		txtReplace2=">"+browserName+" RESULTS</h2>";
		
		new FileEditor().editor(filePath, txtFinder1, txtReplace1, txtFinder2, txtReplace2);
		
		filePath=path+"/test-output/"+browserName+"/GraphReporting/testng-xslt/overview.html";
		txtFinder1="<title>TestNG Results</title>";
		txtReplace1="<title>"+browserName+" RESULTS</title>";
		
		txtFinder2="<h2>Test suites overview</h2>";
		txtReplace2="<h2 style='text-align:center'>"+browserName+" RESULTS OVERVIEW</h2>";
		
		new FileEditor().editor(filePath, txtFinder1, txtReplace1, txtFinder2, txtReplace2);
		
	}

	public void fileEditingHTMLFolder(String path, String browserName){
		String filePath=null,txtFinder1=null,txtReplace1=null,txtFinder2=null,txtReplace2=null;
		
		filePath=path+"/test-output/"+browserName+"/html/suites.html";
		txtFinder1="<title>Test Results Report - Suites</title>";
		txtReplace1="<title>"+browserName+" RESULTS</title>";
		
		txtFinder2="<h2>Test Results Report</h2>";
		txtReplace2="<h2 style='text-align:center'>"+browserName+" RESULTS REPORT</h2>";
		
		new FileEditor().editor(filePath, txtFinder1, txtReplace1, txtFinder2, txtReplace2);
		
		filePath=path+"/test-output/"+browserName+"/html/overview.html";
		txtFinder1="<title>Test Results Report - Overview</title>";
		txtReplace1="<title>"+browserName+" Results Report - Overview</title>";
		
		txtFinder2="<h1>Test Results Report</h1>";
		txtReplace2="<h2 style='text-align:center'>"+browserName+" RESULTS REPORT</h2>";
		
		new FileEditor().editor(filePath, txtFinder1, txtReplace1, txtFinder2, txtReplace2);
		
	}
	
	
	public String dateGetter(){
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd - hh-mm a zzz");
		Date date = new Date();
		
		Reporter.log(ReporterText("======================= START ================================="));
		Reporter.log(ReporterText("     LOG DATE : "+dateFormat.format(date).toString()));
		Reporter.log(ReporterText("----------------------------------------------------------------------"));
		
		return dateFormat.format(date);
		
	}
	
public WebDriver getBrowser(String browser){
		
		if (browser.equalsIgnoreCase("chrome")) {
			
			if(MacPlatform()){
				System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
			} else {
			
			if(new HomeServlet().bwrPath() != null){
			System.setProperty("webdriver.chrome.driver",new HomeServlet().bwrPath()+ "browsers\\chromedriver_win32_2.1\\chromedriver.exe");
			}else{
			System.setProperty("webdriver.chrome.driver",basepath()+ "\\WebContent\\browsers\\chromedriver_win32_2.1\\chromedriver.exe");
			}
			}
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Starting firefox");
			driver = new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("phantomjs")) {
			System.out.println("Starting Phantom JS Ghost Browser");
			  dCaps = new DesiredCapabilities();
			  if(MacPlatform()){
					dCaps.setCapability("phantomjs.binary.path","/usr/bin/phantomjs");
				}
			  else{
			  dCaps.setCapability("phantomjs.binary.path",new HomeServlet().bwrPath()+"browsers/phantomJS/phantomjs.exe");
			  }
			  dCaps.setJavascriptEnabled(true);
			  dCaps.setCapability("takesScreenshot", true);
			driver = new PhantomJSDriver(dCaps);
		}else if (browser.equalsIgnoreCase("safari")) {
			System.out.println("Starting Safari");
			driver = new SafariDriver();
		}
		
		return driver;
	}

public boolean MacPlatform() {
	Platform current = Platform.getCurrent();
    return Platform.MAC.is(current);
}
	
}
