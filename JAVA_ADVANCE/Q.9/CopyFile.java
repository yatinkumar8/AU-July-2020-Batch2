/*
* 9) WAP to copy one file into another.
* */



import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("/home/yatin/Pictures/input.txt");
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("/home/yatin/Pictures/output.txt", true);
            String str;

            while ((str = br.readLine()) != null) { // read a line
                fw.write(str); // write to output file
                fw.flush();
            }
            br.close();
            fw.close();
            System.out.println("File copied");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}