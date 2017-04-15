package com.overture.npc.executer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.overture.npc.controller.HomeServlet;
import com.overture.npc.methods.POJO;

public class TestCaseDriver {
	List<String> pj;
	
	public TestCaseDriver(List<String> list) {
		this.pj = list;
	}

	public TestCaseDriver() {

	}

	public void testExecuter(POJO tcPojo) {
		
		String b=new TestCaseDriver().testParameterCreator().get("browser");
		
		String pkgName = "com.overture.npc.testcases.";
		System.out.println("FLOW IN TEST EXECUTER");
		List<String> l = new ArrayList<String>();
		l.add("org.uncommons.reportng.HTMLReporter");
		l.add("org.uncommons.reportng.JUnitXMLReporter");
		XmlSuite suite = new XmlSuite();
		suite.setName(b.toUpperCase()+" Execution");
		suite.setParallel("tests");
		suite.setThreadCount(new HomeServlet().getInstanceCount());
		suite.setListeners(l);

		for (int i = 0; i < pj.size(); i++) {
			
			XmlTest test = new XmlTest(suite);
			test.setName(pj.get(i));
			test.setParameters(new TestCaseDriver().testParameterCreator());
			
			List<XmlClass> classes = new ArrayList<XmlClass>();
			System.out.println(new XmlClass(pkgName + pj.get(i)));
			classes.add(new XmlClass(pkgName + pj.get(i)));
			test.setXmlClasses(classes);
		}
		
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		tng.run();

	}
	
	public HashMap<String, String> testParameterCreator(){
		HomeServlet homeServlet = new HomeServlet();
		String brw=homeServlet.browserName();
		HashMap<String, String> hm=new HashMap<String, String>();
		hm.put("browser", brw);
		return hm;
	}

}
