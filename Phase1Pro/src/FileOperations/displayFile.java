package FileOperations;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class displayFile implements OperationsDisplay {

   
     // This method shows files in the directory in sorted order   
    @Override
    public void displayFileFunc(String FolderPath) throws IOException {
        Files.list(Paths.get(FolderPath)).filter(Files::isRegularFile).sorted().forEach(System.out::println);
    }

    
    // This method returns the countOfFiles in the directory   
    @Override
    public int countFilesFunc(String FolderPath) {
       File FileCount=new File(FolderPath);
       String files[]=FileCount.list();
        return files.length;
    }

  
    //This method checks whether the directory is empty or not
    @Override
    public boolean isEmpty(String FolderPath) {
        File FileCount=new File(FolderPath);
        String files[]=FileCount.list();
        if (files.length>0){
            return false;
        }
        else {
            return true;
        }
    }

}


 interface OperationsDisplay {
   
   public void displayFileFunc(String FolderPath) throws IOException;
    public int  countFilesFunc(String FolderPath);
    public boolean  isEmpty(String FolderPath);

}