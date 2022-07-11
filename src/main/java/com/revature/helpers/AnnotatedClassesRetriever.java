package com.revature.helpers;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;



public class AnnotatedClassesRetriever {

	private static String xmlPath = "";
	private static List<Class<?>> AnnotatedClassesList = new LinkedList<>();

	public static void getPath(String path) {
		xmlPath = path;
	}

	public static List<Class<?>> getAnnotatedClassesList() {
		// Credit: https://www.javatpoint.com/how-to-read-xml-file-in-java
		try {
			// creating a constructor of file class and parsing an XML file
			File file = new File(xmlPath);
			// an instance of factory that gives a document builder
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// an instance of builder to parse the specified xml file
			DocumentBuilder db = null;
			try {
				db = dbf.newDocumentBuilder();
			} catch (ParserConfigurationException e) {

				e.printStackTrace();
			}
			Document doc = null;
			try {
				doc = db.parse(file);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("class");
			for (int itr = 0; itr < nodeList.getLength(); itr++) {
				Node node = nodeList.item(itr);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					Class<?> claz = null;
					try {
						claz = (Class) Class.forName(((NodeList) eElement).item(0).getTextContent());
					} catch (ClassNotFoundException | DOMException e) {

						e.printStackTrace();
					}
					AnnotatedClassesList.add(claz);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return AnnotatedClassesList;

	}
}
