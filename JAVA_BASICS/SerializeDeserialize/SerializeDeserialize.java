import java.io.*;
import java.util.UUID;

class Yatin implements Serializable{
    private static final UUID SerialVersionUID = UUID.randomUUID();

    transient int f;
    int s;
    transient int t;
    String ft;
    long fi;

    public Yatin(int f, int s, int t, String ft, long fi){
        this.f = f;
        this.s = s;
        this.t = t;
        this.ft = ft;
        this.fi = fi;
    }
    public void printUID(){
        System.out.println("UID is " + SerialVersionUID);
    }
}

public class SerializeDeserialize {
    public static void printInfo(Yatin obj){
        System.out.println("1st " + obj.f);
        System.out.println("2nd " + obj.s);
        System.out.println("3rd " + obj.t);
        System.out.println("4th " + obj.ft);
        System.out.println("5th " + obj.fi);
    }

    public static void main(String[] args) {
        Yatin obj = new Yatin(60, 500, 1000, "YATIN", 250);
        String filename = "serializaepractice.txt";

        //Serialization
        try{
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(obj);
            out.close();
            file.close();
            System.out.println("Object Serialized");
            printInfo(obj);
            obj.printUID();
        } catch (IOException e) {
            e.printStackTrace();
        }

        obj = null;

        //Deserialization
        try{
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            obj = (Yatin)in.readObject();
            in.close();
            System.out.println("Object Deserialized");
            printInfo(obj);
            obj.printUID();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
