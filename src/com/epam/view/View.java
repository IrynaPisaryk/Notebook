package com.epam.view;

import java.util.Scanner;

import com.epam.command.CommandName;
import com.epam.command.Manager;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.exception.ManagerException;
import com.epam.exception.ViewException;

public class View {

	private Manager manager = new Manager();
	private Request request = new Request();

	private int showMenu(){
		System.out.println("What you want to do?"+"\n"
				+"add simple note: 1"+"\n"
				+"add note with email: 2"+"\n"
				+"add note with signature: 3"+"\n"
				+"add note with title: 4"+"\n"
				+"change note: 5"+"\n"
				+"clone note: 6"+"\n"
				+"delete all notes: 7"+"\n"
				+"delete note: 8"+"\n"
				+"find note by index: 9"+"\n"
				+"find note by email: 10"+"\n"
				+"find note by signature: 11"+"\n"
				+"find note by title: 12"+"\n"
				+"find note by date: 13"+"\n"
				+"find note by note: 14"+"\n"
				+"format note: 15"+"\n"
				+"replace note: 16"+"\n"
				+"sort note: 17"+"\n"
				+"exit: 0"+"\n");
		Scanner scan = new Scanner(System.in);	
		int result = 0;
		if(scan.hasNextInt()){
			result = scan.nextInt();
			if(result >= 0 && result < 18){
				return result;
			}
		}else{
			System.out.println("Incorrect number");
			return result;
		}
		return result;

	}

	public void run() throws ViewException{
		int whatDo = -1;
		while(whatDo != 0){
			whatDo = showMenu();	
			if(prepareParams(whatDo, request) == null){
				return;
			}else{		
				CommandName name = getCommandName(whatDo);
				Response response = null;
				try{
					response = manager.doRequest(name, request);
				}catch(ManagerException e){
					throw new ViewException();
				}
				Printer printer = new Printer();
				try{
					printer.printResponse(request.getKey(), response);
				}catch(NullPointerException e){
					throw new ViewException();
				}
			}
		}
	}	
	private CommandName getCommandName(int whatDo){	

		CommandName name = null;
		switch(whatDo){
		case(1):
			name  = CommandName.getType("add");
		break;
		case(2):
			name  = CommandName.getType("addEMail");
		break;
		case(3):
			name  = CommandName.getType("addSign");
		break;
		case(4):
			name  = CommandName.getType("addTitle");
		break;
		case(5):
			name  = CommandName.getType("change");
		break;
		case(6):
			name  = CommandName.getType("clone");
		break;
		case(7):
			name  = CommandName.getType("delete_all");
		break;
		case(8):
			name  = CommandName.getType("delete");
		break;
		case(9):
			name  = CommandName.getType("find");
		break;
		case(10):
			name  = CommandName.getType("findEMail");
		break;
		case(11):
			name  = CommandName.getType("findSign");
		break;
		case(12):
			name  = CommandName.getType("findTitle");
		break;
		case(13):
			name  = CommandName.getType("findDate");
		break;
		case(14):
			name  = CommandName.getType("findNote");
		break;
		case(15):
			name  = CommandName.getType("format");
		break;
		case(16):
			name  = CommandName.getType("replace");
		break;
		case(17):
			name  = CommandName.getType("sort");
		break;
		}		
		return name;
	}

	private Request prepareParams(int i, Request request) throws ViewException {

		ParametersConductor conductor = new ParametersConductor();
		switch(i){
		case(1):
			return conductor.prepareAddParams(request);
		case(2):
			return conductor.prepareAddEMailParams(request);
		case(3):
			return conductor.prepareAddSignParams(request);
		case(4):
			return conductor.prepareAddTitleParams(request);
		case(5):
			return conductor.prepareChangeParams(request);
		case(6):
			return conductor.prepareCloneParams(request);
		case(7):
			return conductor.prepareDeleteAllParams(request);
		case(8):
			return conductor.prepareDeleteParams(request);
		case(9):
			return conductor.prepareFindParams(request);
		case(10):
			return conductor.prepareFindEMailParams(request);
		case(11):
			return conductor.prepareFindSignParams(request);
		case(12):
			return conductor.prepareFindTitleParams(request);
		case(13):
			return conductor.prepareFindDateParams(request);
		case(14):
			return conductor.prepareFindNoteParams(request);
		case(15):
			return conductor.prepareFormatParams(request);
		case(16):
			return conductor.prepareReplaceParams(request);
		case(17):
			return conductor.prepareSortParams(request);
		case(0):
			System.out.println("Bye");
		return null;
		}
		return request;
	}

}
