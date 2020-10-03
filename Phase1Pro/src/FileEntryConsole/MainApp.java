package FileEntryConsole;
import java.io.IOException;


// Main class of the Application 
public class MainApp {
    public static void main(String args[]) throws IOException {
    
        System.out.println("");
        System.out.println("Welcome To Lockers Pvt File Viewer and Manager Developed by Ajunumasa");
        System.out.println("");
        FileAppManager fm = new FileAppManager();
        fm.filemanager();
        
    }
}