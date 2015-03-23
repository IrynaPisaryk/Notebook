package com.epam.dao.impl;

import java.io.File;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.epam.dao.DAOException;
import com.epam.dao.INotebookDAO;
import com.epam.notebook.Note;

public class NotebookXmlImpl implements INotebookDAO{
	
	//write
	private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	private Document doc;
	{
		factory.setNamespaceAware(true);
		
		try {
			doc = factory.newDocumentBuilder().newDocument();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		Element root = doc.createElement("Notebook");
		root.setAttribute("xmlns", "http://com/epam/dao/impl/schemas/");
		doc.appendChild(root);
		 
		Element item1 = doc.createElement("Note");
		item1.setAttribute("id", "0");
		root.appendChild(item1);
		             
		Element item2 = doc.createElement("date");
		item2.setAttribute("val", new Date().toString());
		item1.appendChild(item2);
		             
		Element item3 = doc.createElement("text");
		item3.setAttribute("val", "note text");
		item1.appendChild(item3);    
		
		Element item4 = doc.createElement("Note");
		item4.setAttribute("id", "1");
		root.appendChild(item4);
		
		Element item5 = doc.createElement("date");
		item5.setAttribute("val", new Date("1111/11/11").toString());
		item4.appendChild(item5);
		             
		Element item6 = doc.createElement("text");
		item6.setAttribute("val", "note textAAAAAAAAA");
		item4.appendChild(item6);    
		
		File file = new File("D:\\test.xml");
		 
		Transformer transformer = null;
		try {
			transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(root), new StreamResult(file));
		} catch (TransformerConfigurationException | TransformerFactoryConfigurationError e1) {
			e1.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		//parse		
		 try {
			 
				DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			 
				Document doc = dBuilder.parse(file);
			 
				System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
				System.out.println( doc.getDocumentElement().getAttribute("xmlns"));
			 
				if (doc.hasChildNodes()) {
					
					System.out.println("dot1!");
			 
					for (int count = 0; count < doc.getChildNodes().getLength(); count++) {
						
						System.out.println("dot2!");
						 
						Node tempNode = doc.getChildNodes().item(count);
					 
						// make sure it's element node.
						if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
					 
							System.out.println(tempNode.getNodeValue());
							System.out.println(tempNode.getTextContent());
					 
							if (tempNode.hasAttributes()) {
								
								System.out.println("dot3!");
								
								NamedNodeMap nodeMap = tempNode.getAttributes();
					 
								for (int i = 0; i < nodeMap.
										getLength(); i++) {
					 
									Node node = nodeMap.item(i);
									System.out.println(node.getNodeName());
									System.out.println(node.getNodeValue());
					 
								}
					 
							}
					
			 
				}
					}}
			    } catch (Exception e) {
				System.out.println(e.getMessage());
			    }
	}
	
	
	
	

	@Override
	public void addNote(Date date, String note) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNoteWithEMail(Date date, String note, String email) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNoteWithSignature(Date date, String note, String signature) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNoteWithTitle(Date date, String note, String title) throws DAOException {
		// TODO Auto-generated method stub
		
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
