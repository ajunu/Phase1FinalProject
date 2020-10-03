package FileOperations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class addFile implements OperationsAdd{

    
	// This method adds a File to the directory.It also checks whether a file already exists and if a file exists then it rejects  

    @Override
    public void AddFileFunc(String Foldername, String FileName) throws IOException {
    	
        displayFile obj = new displayFile();
        int count = obj.countFilesFunc(Foldername);
        if (count >= 0) {
            if(!Files.exists(Paths.get(Foldername,FileName))){
                Files.createFile(Paths.get(Foldername,FileName));
                System.out.println("File created successfully");
            }
            else{
                System.out.println("File Already Exists in the Directory");
            }
        }

    }
}

interface OperationsAdd {
 
    public void AddFileFunc(String Foldername,String FileName) throws IOException;

}