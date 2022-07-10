package com.revature.helpers;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  
import java.io.File;  

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.NodeList;

public class AnnotatedClassesRetriever {

	private static List<Class<?>> AnnotatedClassesList = new LinkedList<>();
	
	public static List<Class<?>> getAnnotatedClassesList(){
		//Credit: https://www.javatpoint.com/how-to-read-xml-file-in-java
 		
		
		try   
		{  
		//creating a constructor of file class and parsing an XML file  
		File file = new File("C:\\Users\\Nothing\\Desktop\\SpringToolsWorkSpace\\project1\\src\\main\\resources\\myorm.cfg.xml");  
		//an instance of factory that gives a document builder  
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
		//an instance of builder to parse the specified xml file  
		DocumentBuilder db = dbf.newDocumentBuilder();  
		Document doc = db.parse(file);  
		doc.getDocumentElement().normalize();  
		NodeList nodeList = doc.getElementsByTagName("class");  
		// nodeList is not iterable, so we are using for loop  
		for (int itr = 0; itr < nodeList.getLength(); itr++)   
		{  
		Node node = nodeList.item(itr);  
		if (node.getNodeType() == Node.ELEMENT_NODE)   
		{  
		Element eElement = (Element) node;  
		System.out.println();
		Class<?> claz =(Class) Class.forName(((NodeList) eElement).item(0).getTextContent());
		AnnotatedClassesList.add(claz);
		}  
		}  
		}   
		catch (Exception e)   
		{  
		e.printStackTrace();  
		}  
	
		return AnnotatedClassesList;

	}
}
