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

	public static void printRoot(){
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		NodeList nList = doc.getElementsByTagName("Note");

		System.out.println("----------------------------");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			System.out.println("\nCurrent Element :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				System.out.println("note id : " + eElement.getAttribute("id"));
				System.out.println("date : " + eElement.getElementsByTagName("date").item(0).getTextContent());
				System.out.println("text : " + eElement.getElementsByTagName("text").item(0).getTextContent());

			}
		}
	}

	public static void writeIntoXml(){		
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

	public void addSimpleNote(Date date, String note){		

		/*(int count = 0;
		if(notes != null){
			for(Note curN: notes){
				Element currentNote = doc.createElement("Note");
				rootElement.appendChild(currentNote);

				Attr attr = doc.createAttribute("id");
				attr.setValue(noteCount+"");
				currentNote.setAttributeNode(attr); 

				Element param0 = doc.createElement("date");
				//param0.appendChild(doc.createTextNode(curN.getDate().toString()));
				int year = curN.getDate().getYear()+1900;
				int month = curN.getDate().getMonth()+1;
				int day = curN.getDate().getDate();
				System.out.println(year+"/"+month+"/"+day);
				param0.appendChild(doc.createTextNode(year+"/"+month+"/"+day));
				currentNote.appendChild(param0);

				Element param1 = doc.createElement("text");
				param1.appendChild(doc.createTextNode(curN.getNote()));
				currentNote.appendChild(param1);

				noteCount++;
			}
		}*/

		rewrite();

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
		writeIntoXml();
		printRoot();

	}

	public void addNoteWithEMail(Date date, String note, String email){
		
		rewrite();
		
		Element currentNote = doc.createElement("NoteWithEMail");
		
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

		Element param2 = doc.createElement("email");
		param2.appendChild(doc.createTextNode(email));
		currentNote.appendChild(param2);		
		noteCount++;
		writeIntoXml();
		printRoot();

	}

	public void addNoteWithSignature(Date date, String note, String signature){
		
		rewrite();
		
		Element currentNote = doc.createElement("NoteWithSignature");
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

		Element param2 = doc.createElement("signature");
		param2.appendChild(doc.createTextNode(signature));
		currentNote.appendChild(param2);
		noteCount++;		
		writeIntoXml();
		printRoot();
	}

	public void addNoteWithTitle(Date date, String note, String title){
		
		rewrite();
		
		Element currentNote = doc.createElement("NoteWithTitle");
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

		Element param2 = doc.createElement("title");
		param2.appendChild(doc.createTextNode(title));
		currentNote.appendChild(param2);
		noteCount++;		
		writeIntoXml();
		printRoot();
	}

	public static void rewrite(){

		NotebookXmlDomParser parser = new NotebookXmlDomParser();
		Map<String, Object> notes = parser.xmlDomParser(file);
		
		if(notes != null){

			for(int i = 0; i < notes.size(); i++){

				if(notes.get(i) instanceof Note){

					Note noteSimple = (Note)notes.get(i);

					Element currentNote = doc.createElement("Note");
					rootElement.appendChild(currentNote);

					Attr attr = doc.createAttribute("id");
					attr.setValue(i+"");
					currentNote.setAttributeNode(attr); 

					Element param0 = doc.createElement("date");
					int year = noteSimple.getDate().getYear()+1900;
					int month = noteSimple.getDate().getMonth()+1;
					int day = noteSimple.getDate().getDate();
					param0.appendChild(doc.createTextNode(year+"/"+month+"/"+day));
					currentNote.appendChild(param0);

					Element param1 = doc.createElement("text");
					param1.appendChild(doc.createTextNode(noteSimple.getNote()));
					currentNote.appendChild(param1);

				} else if(notes.get(i) instanceof NoteWithEMail){

					NoteWithEMail noteMail = (NoteWithEMail)notes.get(i);
					Element currentNote = doc.createElement("NoteWithEMail");
					rootElement.appendChild(currentNote);

					Attr attr = doc.createAttribute("id");
					attr.setValue(i+"");
					currentNote.setAttributeNode(attr); 

					Element param0 = doc.createElement("date");
					int year = noteMail.getDate().getYear()+1900;
					int month = noteMail.getDate().getMonth()+1;
					int day = noteMail.getDate().getDate();
					param0.appendChild(doc.createTextNode(year+"/"+month+"/"+day));
					currentNote.appendChild(param0);

					Element param1 = doc.createElement("text");
					param1.appendChild(doc.createTextNode(noteMail.getNote()));
					currentNote.appendChild(param1);

					Element param2 = doc.createElement("email");
					param2.appendChild(doc.createTextNode(noteMail.getEMail()));
					currentNote.appendChild(param2);
				} else if(notes.get(i) instanceof NoteWithSignature){

					NoteWithSignature noteSign = (NoteWithSignature)notes.get(i);
					Element currentNote = doc.createElement("NoteWithSignature");
					rootElement.appendChild(currentNote);

					Attr attr = doc.createAttribute("id");
					attr.setValue(i+"");
					currentNote.setAttributeNode(attr); 

					Element param0 = doc.createElement("date");
					int year = noteSign.getDate().getYear()+1900;
					int month = noteSign.getDate().getMonth()+1;
					int day = noteSign.getDate().getDate();
					param0.appendChild(doc.createTextNode(year+"/"+month+"/"+day));
					currentNote.appendChild(param0);

					Element param1 = doc.createElement("text");
					param1.appendChild(doc.createTextNode(noteSign.getNote()));
					currentNote.appendChild(param1);

					Element param2 = doc.createElement("signature");
					param2.appendChild(doc.createTextNode(noteSign.getSignature()));
					currentNote.appendChild(param2);
				} else if(notes.get(i) instanceof NoteWithTitle){

					NoteWithTitle noteTitle = (NoteWithTitle)notes.get(i);
					Element currentNote = doc.createElement("NoteWithTitle");
					rootElement.appendChild(currentNote);

					Attr attr = doc.createAttribute("id");
					attr.setValue(i+"");
					currentNote.setAttributeNode(attr); 

					Element param0 = doc.createElement("date");
					int year = noteTitle.getDate().getYear()+1900;
					int month = noteTitle.getDate().getMonth()+1;
					int day = noteTitle.getDate().getDate();
					param0.appendChild(doc.createTextNode(year+"/"+month+"/"+day));
					currentNote.appendChild(param0);

					Element param1 = doc.createElement("text");
					param1.appendChild(doc.createTextNode(noteTitle.getNote()));
					currentNote.appendChild(param1);

					Element param2 = doc.createElement("title");
					param2.appendChild(doc.createTextNode(noteTitle.getTitle()));
					currentNote.appendChild(param2);
				}
				writeIntoXml();
			}
		}
		

		
	}
}
