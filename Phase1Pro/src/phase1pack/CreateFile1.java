package phase1pack;

import java.io.FileOutputStream; 
import java.io.File;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.Scanner;  
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;


public class CreateFile1  
{  
	
public static void main(String argS[]) throws IOException
{
	boolean optionflg = true;
//do
//{
  

while(optionflg) 
{
	//sub menu
	System.out.println(" Press : ");
	System.out.println(" 1. To list all the files from the directory ");
	System.out.println(" 2. To add a file");
	System.out.println(" 3. To delete a file");
	System.out.println(" 4. To search a file");
	System.out.println(" 5. Exit");
	
	Scanner sc=new Scanner(System.in);         //object of Scanner class
	int option = Integer.parseInt(sc.nextLine());
	
	switch(option)
	{
				case 1: {
					System.out.println("Enter the file path: "); // filepath : "C:\\Users\\Ajunu\\Phase1FinalProject\\Phase1Pro"
		            String testPath = sc.nextLine(); // Takes the directory path as the user input
//		            Path testPath = Paths.get("C:\\Users\\Ajunu\\Phase1FinalProject\\Phase1Pro");
//					System.out.println(testPath); //file with exactly same visible path exists on disk
//					
		            File folder = new File(testPath);
		            if(folder.isDirectory())
		            {
		                File[] fileList = folder.listFiles();

		                Arrays.sort(fileList);

		                System.out.println("\nTotal number of items present in the directory: " + fileList.length );


		                // Lists only files since we have applied file filter
		                for(File file:fileList)
		                {
		                    System.out.println(file.getName());
		                }

		                // Creating a filter to return only files.
		                FileFilter fileFilter = new FileFilter()
		                {
		                    @Override
		                    public boolean accept(File file) {
		                        return !file.isDirectory();
		                    }
		                };

		                fileList = folder.listFiles(fileFilter);

		                // Sort files by name
		                Arrays.sort(fileList, new Comparator()
		                {
		                    @Override
		                    public int compare(Object f1, Object f2) {
		                        return ((File) f1).getName().compareTo(((File) f2).getName());
		                    }
		                });

		                //Prints the files in file name ascending order
		                for(File file:fileList)
		                {
		                    System.out.println(file.getName());
		                }

		            }   
					break;
				}
				case 2: {
					try {
						System.out.print("Enter the new file name to Add: ");  
						String name=sc.nextLine();              //variable name to store the file name  
						FileOutputStream fos=new FileOutputStream(name, true);  // true for append mode  
						System.out.print("Enter file content: ");         
						String str=sc.nextLine()+"\n";      //str stores the string which we have entered  
						byte[] b= str.getBytes();       //converts string into bytes  
						fos.write(b);           //writes bytes into file  
						fos.close();            //close the file  
						System.out.println("file saved.");  
						}  
						catch(Exception e)  
						{  
						e.printStackTrace();          
						}
					break;
				}
					
				case 3: {
						try  
						{     
						System.out.print("Enter the file name to delete: ");  
						String filename= sc.nextLine();              //variable name to store the file name 
						File f= new File(filename);           //file to be delete  
						if(f.delete())                      //returns Boolean value  
						{  
						System.out.println(f.getName() + " deleted");   //getting and printing the file name  
						}  
						else  
						{  
						System.out.println("failed");  
						}  
						}  
						catch(Exception e)  
						{  
						e.printStackTrace();  
						}  
						break;
				}
				case 4: {
					try
					{
					System.out.print("Enter the file name to Search: ");  
					String searchname= sc.nextLine();              //variable name to store the file name 
					//String testPath = "C:\\Users\\Ajunu\\Phase1FinalProject\\Phase1Pro";
					Path testPath = Paths.get("C:\\Users\\Ajunu\\Phase1FinalProject\\Phase1Pro");
					System.out.println(testPath); //file with exactly same visible path exists on disk
						
			
			        //finding files containing 'items' in name
			        Stream<Path> stream =
			                Files.find(testPath, 100,
			                        (path, basicFileAttributes) -> {
			                            File file = path.toFile();
			                            return !file.isDirectory() &&
			                                    file.getName().contains(searchname);
			                            
			                        });
			        stream.forEach(System.out::println);
			      }  
					catch (FileNotFoundException e) {
				        e.printStackTrace();
						}
					break;
				}
						
				case 5: {
					System.exit(0);
			        break;
						}
				
				default:
		            System.out.printf("Error");
		            return;
	}
} 

//while(optionflg!=4);
}  
}
