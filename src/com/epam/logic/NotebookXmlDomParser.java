package com.epam.logic;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.epam.notebook.Note;
import com.epam.notebook.NoteWithEMail;
import com.epam.notebook.NoteWithSignature;
import com.epam.notebook.NoteWithTitle;

public class NotebookXmlDomParser {	

	private DocumentBuilder dBuilder;

	public Map<String, Object> xmlDomParser(File file){

		try {

			if(!file.exists()){
				return null;
			}			
			/*dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = dBuilder.parse(file);	
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("Note");
			for (int i = 0; i < nList.getLength(); i++) {

				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					Note note = new Note(new Date(eElement.getElementsByTagName("date").item(0).getTextContent()), eElement.getElementsByTagName("text").item(0).getTextContent());
					notes.add(note);
				}				
			}
			return notes;*/

			
			//вылетает потому что всё время заходит в первый цикл. Не находит тэги для записей с параметрами
			
			
			dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = dBuilder.parse(file);	
			doc.getDocumentElement().normalize();
			Map<String, Object> notes = new HashMap<String, Object>();

			NodeList noteList = doc.getElementsByTagName("Note");
			NodeList noteMailList = doc.getElementsByTagName("NoteWithEMail");
			NodeList noteSignList = doc.getElementsByTagName("NoteWithSignature");
			NodeList noteTitleList = doc.getElementsByTagName("NoteWithTitle");

			if(noteList.getLength() != 0){
				
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				
				for (int i = 0; i < noteList.getLength(); i++) {
					Node nNode = noteList.item(i);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						Note note = new Note(new Date(eElement.getElementsByTagName("date").item(0).getTextContent()), eElement.getElementsByTagName("text").item(0).getTextContent());
						notes.put(eElement.getAttribute("id"), note);
					}	
				}
			}

			if(noteMailList.getLength() != 0){
				
				System.out.println("1111111111111111111111111111111111111111111");
				
				for (int i = 0; i < noteMailList.getLength(); i++) {
					Node nNode = noteMailList.item(i);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						NoteWithEMail note = new NoteWithEMail(new Date(eElement.getElementsByTagName("date").item(0).getTextContent()), eElement.getElementsByTagName("text").item(0).getTextContent(), eElement.getElementsByTagName("email").item(0).getTextContent());
						notes.put(eElement.getAttribute("id"), note);
					}	
				}
			}

			if(noteSignList.getLength() != 0){
				for (int i = 0; i < noteSignList.getLength(); i++) {
					Node nNode = noteSignList.item(i);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						NoteWithSignature note = new NoteWithSignature(new Date(eElement.getElementsByTagName("date").item(0).getTextContent()), eElement.getElementsByTagName("text").item(0).getTextContent(), eElement.getElementsByTagName("signature").item(0).getTextContent());
						notes.put(eElement.getAttribute("id"), note);
					}	
				}
			}

			if(noteTitleList.getLength() != 0){
				for (int i = 0; i < noteTitleList.getLength(); i++) {
					Node nNode = noteTitleList.item(i);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						NoteWithTitle note = new NoteWithTitle(new Date(eElement.getElementsByTagName("date").item(0).getTextContent()), eElement.getElementsByTagName("text").item(0).getTextContent(), eElement.getElementsByTagName("title").item(0).getTextContent());
						notes.put(eElement.getAttribute("id"), note);
					}	
				}
			}

			return notes;

		} catch (Exception e) {
			e.printStackTrace();			
		}
		return null;
	}

}
