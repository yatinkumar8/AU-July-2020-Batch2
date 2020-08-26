/*
* 2) Demonstrate that local variable used in lamda expression must be final or effectively final and instance variable can be changed inside the lambda expression.
* */


@FunctionalInterface
interface Multiply{
    int multiply(int a, int b);
}

interface Print {
    void print();
}

public class FinalVariable {
    int i;

    public FinalVariable(int i){
        this.i = i;
    }

    public static void main(String[] args) {

        int x=2;
        x=4;

        Multiply multiply1= (b,c) ->{
            return b*c*x; //Error
        };

        final int y=1;

        Multiply multiply2= (b, c) ->{
            return b*c*y;
        };


        FinalVariable a = new FinalVariable(3);
        Print p = () -> {
            x = x + 1; //Error
            a.i = a.i + 1; //No error
        };
        p.print();
    }
}