package FileOperations;


import java.io.File;
import java.io.IOException;


public class searchFile implements OperationsSearch{

   
     // This method searches for a file in the directory irrespective of case -sensitivity
    
    @Override
    public String searchFile(String FolderPath,String FileName) throws IOException {
        displayFile obj =new displayFile();
        int count=obj.countFilesFunc(FolderPath);
        String DirectoryName=FolderPath+"\\";
        String fileFound=null;
        if(count>0) {
            File file =new File(DirectoryName+FileName);
            if(file.exists()){
                fileFound=DirectoryName+FileName;
                System.out.println("File Exists"+" "+DirectoryName+FileName);
            }
            else{
                fileFound=null;
                System.out.println("File Not Found");
            }
        }
        else{
            System.out.println("Directory is empty");
        }

        return fileFound;
    }

}

interface OperationsSearch {
   
    public String searchFile(String FolderPath,String FileName) throws IOException;
}