import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

    private String currentDirectory = "Karolis/tech-rookie";


    public static void main(String[] args) {

        //List for directories
        List<String> directories = new ArrayList<>();

        //HashMap for directories and its files
        HashMap<String, List<String>> files = new HashMap<>();
        List<String> filesList = new ArrayList<>();


        //add initial directories
        directories.add("Karolis");
        directories.add("internships");
        directories.add("tech-rookie");

        DataInputStream in = new DataInputStream(System.in);

        while(true) {
            try {
                for(String dir : directories) {
                    System.out.print("/" + dir);
                }

                System.out.print("> ");

                String[] command = in.readLine().split(" ");
//
//              System.out.println(command);

                if(command[0].equalsIgnoreCase("stop")){
                    break;
                }
                else {
                    executeCommand(directories, files, command);
                }


            } catch (Exception e) {
                System.out.println("command not read");
            }
        }



    }

    private static void executeCommand(List<String> directories, HashMap<String, List<String>> files, String[] command){

        if (command[0].equalsIgnoreCase("leave")) {

            //remove last directory
            directories.remove(directories.size() - 1);
        }

        if(command[0].equalsIgnoreCase("enter")){
            directories.add(command[1]);
        }

        //create file in the current dir
        if(command[0].equalsIgnoreCase("create")){
            String currentDir = directories.get(directories.size()-1);


            files.put(currentDir, Collections.singletonList(command[1]));
        }

        if(command[0].equalsIgnoreCase("list")){

            for (String file:
                 files.get(directories.get(directories.size()-1))) {

                System.out.println(file);
            }
        }

        if(command[0].equalsIgnoreCase("copy")){

            files.put(command[2], Collections.singletonList(command[1]));
        }
    }


}
