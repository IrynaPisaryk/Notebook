package com.epam.view;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.epam.command.CommandName;
import com.epam.command.Manager;
import com.epam.command.ManagerException;
import com.epam.command.Request;
import com.epam.command.Response;
import com.epam.exception.ViewException;

public class View {

	private Manager manager = new Manager();
	private Request request = new Request();
	private Printer printer = new Printer();
	private static Locale locale = null;
	private static ResourceBundle resourseMenu = null;
	
	static {		
		getLocale();
	}
	
	public static void getLocale(){		
		System.out.println("Please, change language: english(1)/russian(2)");
		Scanner scan = new Scanner(System.in);	
		int resultLang = 0;
		if(scan.hasNextInt()){
			resultLang = scan.nextInt();			
			switch(resultLang){			
			case(1):
				locale = new Locale("en", "US");
			break;
			case(2):				
				locale =  new Locale("ru", "RU");
			break;
			}						
		}else{
			System.out.println("Incorrect symbol");
			return;
		}
	}
	
	public static int getMenu(){			
		String path = System.getProperty("user.dir");
		File file = new File(path);
		URL[] urls = new URL[1];
		
		ClassLoader loader;
		 {
			try {
				urls[0] = file.toURI().toURL();
			} catch (MalformedURLException e) {
				System.out.println("Can not path to resourse file");
				e.printStackTrace();
			}
			loader = new URLClassLoader(urls);
			try{		
				resourseMenu = ResourceBundle.getBundle("Menu", locale, loader);
			} catch(MissingResourceException e){
				System.out.println("Missing resource file");
				e.printStackTrace();
			}
		}
		System.out.println(resourseMenu.getString("menu"));
		Scanner scan = new Scanner(System.in);
		int result = 0;		
		int failFlag = -100;
		if(scan.hasNextInt()){
			result = scan.nextInt();
			if(result >= 0 && result < 18){
				return result;
			}else{
				System.out.println("Incorrect number");
				return failFlag;
			}
		}else{
			System.out.println("Incorrect symbol");
			return failFlag;
		}
	}
	
 	public void run() {
		int whatDo = -1;
		int failFlag = -100;		
		while(whatDo != 0){
			whatDo = getMenu();
			if(whatDo == failFlag){
				return;
			}
			try{
				request = prepareParams(whatDo, request);
			}catch(ViewException e){
				//logger.log(Level.SEVERE, "Input patemeters error", e);				
			}			
			if( request == null){
				return;
			}else{		
					CommandName name = getCommandName(whatDo);
					Response response = null;
					//try{
						response = manager.doRequest(name, this.request);
						/*}catch(ManagerException e){
						//logger.log(Level.SEVERE, "Programm error", e);
						response = new Response("", null);
					}*/
					try{
						printer.printResponse(this.request.getKey(), response, resourseMenu);
					}catch(ViewException e){
						//logger.log(Level.SEVERE, "Printer error", e);
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
			return conductor.prepareAddParams(request, resourseMenu);
		case(2):
			return conductor.prepareAddEMailParams(request, resourseMenu);
		case(3):
			return conductor.prepareAddSignParams(request, resourseMenu);
		case(4):
			return conductor.prepareAddTitleParams(request, resourseMenu);
		case(5):
			return conductor.prepareChangeParams(request, resourseMenu);
		case(6):
			return conductor.prepareCloneParams(request, resourseMenu);
		case(7):
			return conductor.prepareDeleteAllParams(request);
		case(8):
			return conductor.prepareDeleteParams(request, resourseMenu);
		case(9):
			return conductor.prepareFindParams(request, resourseMenu);
		case(10):
			return conductor.prepareFindEMailParams(request, resourseMenu);
		case(11):
			return conductor.prepareFindSignParams(request, resourseMenu);
		case(12):
			return conductor.prepareFindTitleParams(request, resourseMenu);
		case(13):
			return conductor.prepareFindDateParams(request, resourseMenu);
		case(14):
			return conductor.prepareFindNoteParams(request, resourseMenu);
		case(15):
			return conductor.prepareFormatParams(request, resourseMenu);
		case(16):
			return conductor.prepareReplaceParams(request, resourseMenu);
		case(17):
			return conductor.prepareSortParams(request);
		case(0):
			System.out.println(resourseMenu.getString("exitWord"));
		return null;
		}
		return request;
	}

}
