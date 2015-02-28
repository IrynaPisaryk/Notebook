package com.epam.command.all;

import java.io.IOException;
import com.epam.command.Command;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.logic.NotebookEditor;

public class AddCommand implements Command {

	@Override
	public Response execute(Request request) throws IOException{
		NotebookEditor editor = new NotebookEditor();
		if(request.getNote() != null){
			editor.addNote(request.getNote().getDate(), request.getNote().getNote());
		}
		else if(request.getNoteWithEMail() != null){
			editor.addNoteWithEMail(request.getNote().getDate(), request.getNote().getNote(), request.getNoteWithEMail().getEMail());
		}
		else if(request.getNoteWithSignature() != null){
			editor.addNoteWithSignature(request.getNoteWithSignature().getDate(), request.getNoteWithSignature().getNote(), request.getNoteWithSignature().getSignature());
		}
		else if(request.getNoteWithTitle() != null){
			editor.addNoteWithTitle(request.getNoteWithTitle().getDate(), request.getNoteWithTitle().getNote(), request.getNoteWithTitle().getTitle());
		}				
		Response response = new Response();
		return response;
	}

	
		
}
