/*
* 10)WAP to copy a file from one dir to another dir.
* */



import java.io.IOException;
import java.nio.file.*;

public class FileCopyDir {
    public static void copyFile(String from, String to) throws IOException {
        Path src = Paths.get(from);
        Path dest = Paths.get(to);
        Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Copied file to " + to);
    }
    public static void main(String[] args) throws IOException {
        String src = "/home/yatin/Pictures/input.txt";
        String target = "/home/yatin/Pictures/Webcam/output.txt";
        copyFile(src, target);
    }
}