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
import com.epam.logic.NotebookXml;
import com.epam.notebook.Note;
import com.epam.resource.ResourceProvider;

public class NotebookXmlImpl implements INotebookDAO{					

	@Override
	public void addNote(Date date, String note) throws DAOException {	
		NotebookXml io = new NotebookXml();
		io.addSimpleNote(date, note);
	}

	@Override
	public void addNoteWithEMail(Date date, String note, String email) throws DAOException {		
		NotebookXml io = new NotebookXml();
		io.addNoteWithEMail(date, note, email);
	}

	@Override
	public void addNoteWithSignature(Date date, String note, String signature) throws DAOException {
		NotebookXml io = new NotebookXml();
		io.addNoteWithSignature(date, note, signature);
	}

	@Override
	public void addNoteWithTitle(Date date, String note, String title) throws DAOException {
		NotebookXml io = new NotebookXml();
		io.addNoteWithTitle(date, note, title);
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
