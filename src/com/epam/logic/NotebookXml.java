package com.epam.logic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.epam.notebook.Note;
import com.epam.notebook.NoteWithEMail;
import com.epam.notebook.NoteWithSignature;
import com.epam.notebook.NoteWithTitle;
import com.epam.resource.ResourceProvider;

public class NotebookXml {
	
	private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	private static Document doc;
	private int noteCount = 0;
	private static Element rootElement = null;
	private static File file = new File(ResourceProvider.getXmlKeeper());
	private static Transformer transformer = null;
	
	{
		factory.setNamespaceAware(true);

		try {
			doc = factory.newDocumentBuilder().newDocument();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}				
		rootElement = doc.createElement("Notebook");
		rootElement.setAttribute("xmlns", "http://com/epam/dao/impl/schemas/");
		doc.appendChild(rootElement);
	}	
	
	public void addSimpleNote(Date date, String note){
		
		Element currentNote = doc.createElement("Note");
		rootElement.appendChild(currentNote);

		Attr attr = doc.createAttribute("id");
		attr.setValue(noteCount+"");
		currentNote.setAttributeNode(attr); 

		Element param0 = doc.createElement("date");
		int year = date.getYear()+1900;
		int month = date.getMonth()+1;
		int day = date.getDate();
		param0.appendChild(doc.createTextNode(year+"/"+month+"/"+day));
		currentNote.appendChild(param0);

		Element param1 = doc.createElement("text");
		param1.appendChild(doc.createTextNode(note));
		currentNote.appendChild(param1);
		noteCount++;	
		
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(rootElement), new StreamResult(file));
			//Writer writer = new FileWriter(file, true);
			//transformer.transform(new DOMSource(element), new StreamResult(writer));
		} catch (TransformerConfigurationException | TransformerFactoryConfigurationError e1) {
			e1.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} /*catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	

}
