package FileOperations;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class deleteFile implements OperationsDelete {

    
     //This method deletes file if it exists in the directory else it will display file doesn't exist.
     
     
    @Override
    public void deleteFileFunc(String folderpath, String filename) throws IOException {
    	
        displayFile obj = new displayFile();
        int count = obj.countFilesFunc(folderpath);
        if (count > 0) 
    	  
        {
			              Path path = Paths.get(folderpath, filename);
			              if (Files.exists(path))
			               {
			                Files.deleteIfExists(Paths.get(folderpath, filename));
			                System.out.println("Deleted Successfully");
			
			                } 
			            else {
			                System.out.println("File Doesn't Exist");
			            	}
        } 
        else 
        {
            System.out.println("Directory is Empty");
        }

        
    }
}

 interface OperationsDelete {
    
    public void deleteFileFunc(String folderpath,String filename) throws IOException;
}