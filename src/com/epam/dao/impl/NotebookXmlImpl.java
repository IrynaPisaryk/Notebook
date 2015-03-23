package com.epam.dao.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
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
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import com.epam.dao.DAOException;
import com.epam.dao.INotebookDAO;
import com.epam.notebook.Note;

public class NotebookXmlImpl implements INotebookDAO{
	
	//write
	private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	private Document doc;
	private int noteCount = 0;
	private Element rootElement = null;
	
	
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
		
		//----------------------
		
		Element note1 = doc.createElement("Note");
		rootElement.appendChild(note1);
		
		Attr attr1 = doc.createAttribute("id");
		attr1.setValue("1");
		note1.setAttributeNode(attr1); 
		
		Element param01 = doc.createElement("date");
		param01.appendChild(doc.createTextNode(new Date("1111/11/11").toString()));
		note1.appendChild(param01);
		
		Element param11 = doc.createElement("text");
		param11.appendChild(doc.createTextNode("fuckAAAAA"));
		note1.appendChild(param11);    
		
		File file = new File("C:\\Users\\Irina_Pisarik\\Desktop\\test.xml");
		 
		Transformer transformer = null;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(rootElement), new StreamResult(file));
		} catch (TransformerConfigurationException | TransformerFactoryConfigurationError e1) {
			e1.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		//parse		
		
			 
				DocumentBuilder dBuilder;
				
					
					try {
						dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
					
					Document doc = dBuilder.parse(file);					
					
					doc.getDocumentElement().normalize();
					 
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
										
					} catch (Exception e) {
						e.printStackTrace();
					}
	
					}	

	@Override
	public void addNote(Date date, String note) throws DAOException {
		
		Element currentNote = doc.createElement("Note");
		rootElement.appendChild(currentNote);
 
		Attr attr = doc.createAttribute("id");
		attr.setValue(noteCount+"");
		currentNote.setAttributeNode(attr); 
		
		Element param0 = doc.createElement("date");
		param0.appendChild(doc.createTextNode(date.toString()));
		currentNote.appendChild(param0);
		
		Element param1 = doc.createElement("text");
		param1.appendChild(doc.createTextNode(note));
		currentNote.appendChild(param1);
		
		noteCount++;
		
	}

	@Override
	public void addNoteWithEMail(Date date, String note, String email) throws DAOException {
		
		Element currentNote = doc.createElement("NoteWithEMail");
		rootElement.appendChild(currentNote);
 
		Attr attr = doc.createAttribute("id");
		attr.setValue(noteCount+"");
		currentNote.setAttributeNode(attr); 
		
		Element param0 = doc.createElement("date");
		param0.appendChild(doc.createTextNode(date.toString()));
		currentNote.appendChild(param0);
		
		Element param1 = doc.createElement("text");
		param1.appendChild(doc.createTextNode(note));
		currentNote.appendChild(param1);
		
		Element param2 = doc.createElement("email");
		param2.appendChild(doc.createTextNode(email));
		currentNote.appendChild(param2);
		
		noteCount++;
	}

	@Override
	public void addNoteWithSignature(Date date, String note, String signature) throws DAOException {

		Element currentNote = doc.createElement("NoteWithSignature");
		rootElement.appendChild(currentNote);
 
		Attr attr = doc.createAttribute("id");
		attr.setValue(noteCount+"");
		currentNote.setAttributeNode(attr); 
		
		Element param0 = doc.createElement("date");
		param0.appendChild(doc.createTextNode(date.toString()));
		currentNote.appendChild(param0);
		
		Element param1 = doc.createElement("text");
		param1.appendChild(doc.createTextNode(note));
		currentNote.appendChild(param1);
		
		Element param2 = doc.createElement("signature");
		param2.appendChild(doc.createTextNode(signature));
		currentNote.appendChild(param2);
		
		noteCount++;
		
	}

	@Override
	public void addNoteWithTitle(Date date, String note, String title) throws DAOException {

		Element currentNote = doc.createElement("NoteWithTitle");
		rootElement.appendChild(currentNote);
 
		Attr attr = doc.createAttribute("id");
		attr.setValue(noteCount+"");
		currentNote.setAttributeNode(attr); 
		
		Element param0 = doc.createElement("date");
		param0.appendChild(doc.createTextNode(date.toString()));
		currentNote.appendChild(param0);
		
		Element param1 = doc.createElement("text");
		param1.appendChild(doc.createTextNode(note));
		currentNote.appendChild(param1);
		
		Element param2 = doc.createElement("title");
		param2.appendChild(doc.createTextNode(title));
		currentNote.appendChild(param2);
		
		noteCount++;		
		
	}

	@Override
	public void deleteNote(int index) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllNotes() throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Note findNoteByIndex(int index) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Note> findNoteByTitle(String title) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Note> findNoteBySignature(String signature) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Note> findNoteByEMail(String email) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Note> findNoteByDate(Date date) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Note> findNoteByNote(String note) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeNote(int index, String newNote) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortNote() throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replaceNote(int indexOldNote, Note newNote) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Note cloneNote(int index) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void formatNote(int index) throws DAOException {
		// TODO Auto-generated method stub
		
	}

}
