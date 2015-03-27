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
	private ArrayList<Note> notes;

	public ArrayList<Note> xmlDomParser(File file){

		notes = new ArrayList<Note>();
		
		try {

			if(!file.exists()){
				return null;
			}
			
			dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
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
			return notes;	


		} catch (Exception e) {
			e.printStackTrace();			
		}
		return null;
	}

}
