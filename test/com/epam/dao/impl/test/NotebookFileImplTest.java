package com.epam.dao.impl.test;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NotebookFileImplTest { 
	
	@BeforeTest
	public void beforeTest(){
		File file = new File("D:\\test1.txt");
	}
	
	@Test
  public void f() {
  }
}
