package FileEntryConsole;

import FileOperations.displayFile;
import FileOperations.searchFile;
import FileOperations.deleteFile;
import FileOperations.addFile;
import java.io.IOException;
import java.util.Scanner;



public class FileAppManager {
	
	public void filemanager() throws IOException{
		try
		{
		boolean exit = false;
        Scanner scChoice = new Scanner(System.in);
        int optionChoosen = 0;

        do {
            System.out.println("");
            System.out.println("Choose from 1 to 5 and press Enter to perform the below operations");
            System.out.println("");
            System.out.println("1-Display Files in Sorted order");
            System.out.println("2-Search For a File");
            System.out.println("3-Delete File");
            System.out.println("4-Add a New File");
            System.out.println("5-Exit");

            optionChoosen = scChoice.nextInt();
            switch (optionChoosen) {
                case 1:
                    displayFile obj = new displayFile();
                    obj.displayFileFunc("root");
                    break;
                case 2:
                    System.out.println("Enter the File Name to Search");
                    Scanner scSearch = new Scanner(System.in);
                    String FileToSearch = scSearch.nextLine();
                    
                    searchFile obj2 = new searchFile();
                    obj2.searchFile("root", FileToSearch.trim());
                    break;
                case 3:
                    System.out.println("Enter the File Name to Delete");
                    Scanner scDel = new Scanner(System.in);
                    String FileToDelete = scDel.nextLine();
                    
                    deleteFile obj3 = new deleteFile();
                    obj3.deleteFileFunc("root", FileToDelete.trim());
                    break;
                case 4:
                   System.out.println("Enter the File Name to Add");
                   Scanner scAdd = new Scanner(System.in);
                   String FileNameToAdd = scAdd.nextLine();
                   
                    addFile obj4=new addFile();
                    obj4.AddFileFunc("root",FileNameToAdd.trim());
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Choose the Correct option from  1 to 5 to perform the below operations");
                    exit = true;
                    break;
            }
        }
        while (!exit);

    }
    catch (Exception e){
        System.out.println(" "+"PLEASE CHECK THE OPTION ENTERED");
    }

	
	}

}
