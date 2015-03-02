package com.epam.runner;
import java.io.IOException;
import java.text.ParseException;
import com.epam.view.View;



public class Runner {

	public static void main(String[] args) throws IOException, CloneNotSupportedException, ParseException{
		View vw = new View();
		vw.run();
	}
}