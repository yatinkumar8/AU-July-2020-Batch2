/*
* 1) Create a functional interface and use - lambda, static method, instance method and contructor references to instantiate it.
* */



import java.util.Scanner;


@FunctionalInterface
interface Square {
    int square(int n);
}

@FunctionalInterface
interface Print {
    void print(String str);
}

public class Functional {

    public Functional(String str) {
        System.out.println(str);
    }

    public static int staticMethod(int n){
        return n * n;
    }

    public int instanceMethod(int n){
        return n * n;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();

        //Lambda expression
        Square a = (int m) -> m * m;
        System.out.println("Lambda:" + a.square(num));

        //Static method
        Square b = Functional::staticMethod;
        System.out.println("Static Method:" + b.square(num));

        //Instance method
        Functional f = new Functional("Instance Method:");
        Square c = f ::instanceMethod;
        System.out.println(c.square(num));

        //Constructor
        Print p = Functional::new;
        p.print("Contructor:" + num);

    }
}