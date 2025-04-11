package com.seleniumexpress.selexplms.config;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Test {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String name = "=========================";
		PrintStream out = new PrintStream(System.out, true, "UTF-8");
		System.out.println(name);
	}

}
