/*
* 7) WAP to list all files from a directory recursively with Java.
* */



import java.io.File;


public class DeleteFiles {
    public static void main(String[] args) {
        String directoryPath = "/home/yatin/Pictures/delete/";
        File dir = new File(directoryPath);
        File dirFiles[] = dir.listFiles();
        if (dir.exists()){
            for (File f : dirFiles){
                String filename = f.getName();
                if (filename.endsWith(".txt")){
                    if (f.delete()){
                        System.out.println("Deleted " + filename);
                    }else{
                        System.out.println("Failed");
                    }
                }
            }
        }else{
            System.out.println("Directory not found");
        }
    }
}