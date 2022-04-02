package com;

import java.util.Scanner;
import java.io.*;
import java.util.TreeSet;
import java.util.Stack; 

class OptionException extends Exception {
	public OptionException() {
	
	}
	OptionException(String str){
		super(str);	// calling Exception super class parameter constructor to set the message
	}
}

public class DemoTest {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input your Option:");
		System.out.println("Option 1: Retrieve all file in ascending order");
		System.out.println("Option 2: Create new file");
		System.out.println("Option 3: Delete file");
		System.out.println("Option 4: Search the file");
		System.out.println("Option 5: Exit");
		
		int userinp = sc.nextInt();
		try {
			if (userinp < 1 || userinp > 5) {
				throw new OptionException("Please keyin value 1 to 5");
			}
				
		}
		catch(Exception e) {
			System.out.println(e);
		}
		switch (userinp) {
		case 1:	
			File ff1 = new File("/home/kuansiongmayban/Desktop/File Info");
			String listOfFiles[] = ff1.list();
			TreeSet ts = new TreeSet();
			for(String fname : listOfFiles) {
				ts.add(fname);
			}
			System.out.println("File name: "+ts);
			break;
					
		case 2: 
			Scanner scfile=new Scanner(System.in);       
			System.out.print("Enter the file name to create: ");  
			String name=scfile.nextLine();          
			FileOutputStream fos = new FileOutputStream("/home/kuansiongmayban/Desktop/File Info/"+name,false); 
			System.out.println("File name "+name+ " is created successfully");
			fos.close();
			break;
					
		case 3:
	        try {
				Scanner delfile=new Scanner(System.in);       
				System.out.print("Enter the file to delete: ");  
				String delfilename=delfile.nextLine();   
	            boolean success = (new File("/home/kuansiongmayban/Desktop/File Info/"+delfilename)).delete();
	            
	            if (success) {
	               System.out.println("The file "+ delfilename+ " has been deleted successfully"); 
	            } else {
	            	System.out.println("The file "+ delfilename+ " does not exist!!!");
	            }
	            
	         }catch (Exception e) {
	            System.out.println("exception occoured"+ e);
	            System.out.println("File does not exist or you are trying to read a file that has been deleted");
	         }
        
		     break;
		           
		case 4: 
			File ff2 = new File("/home/kuansiongmayban/Desktop/File Info");
			String listOfFiles2[] = ff2.list();
			Stack ssfile = new Stack();
			for(String fname1 : listOfFiles2) {
				ssfile.push(fname1);
			}
			Scanner searchfile=new Scanner(System.in);       
			System.out.print("Enter the file name to search: ");  
			String searchfilename=searchfile.nextLine();   
			
			if (ssfile.search(searchfilename) > 0) {
				System.out.println("File " +searchfilename+ " is found");
			} else {
            	System.out.println("The file " +searchfilename+ " is not found!!!");
			}
        	break;
        			
		case 5: System.out.println("EXIT");
        		break;
        		
		default:System.out.println("Wrong choice");
				break;
				
		}
		System.out.println("Program completed");
	}

}
