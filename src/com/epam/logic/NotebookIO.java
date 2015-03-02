package com.epam.logic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.epam.notebook.Notebook;

public final class NotebookIO{

	//сделать ресет??
	public void writeNotebookIntoFile(Notebook notebook) throws IOException{

		String filename = "C:\\Users\\Irina_Pisarik\\Desktop\\test.txt";         
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try
		{
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(notebook);
			out.close();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}

	public Notebook readNotebookFromFile(){

		String filename = "C:\\Users\\Irina_Pisarik\\Desktop\\test.txt";
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try
		{
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			Notebook notebook = (Notebook)in.readObject();
			in.close();
			return notebook;
		} catch(IOException ex)
		{
			ex.printStackTrace();
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		return null;

	}
}
