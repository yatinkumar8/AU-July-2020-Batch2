import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Expression{

    static int calculateMini(Queue<Character> q) {
       int num = 0;
       int prev = 0, sum = 0;
       char prevOp = '+';
       while (!q.isEmpty()) {
          char c = q.poll();
          if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
          } else if (c == '(') {
                num = calculateMini(q);
          } else {
                if (prevOp == '+'){
                    sum += prev;
                    prev = num;
                }
                else if (prevOp == '-'){
                    sum += prev;
                    prev = -num;
                }
                else if (prevOp == '*'){
                    prev *= num;
                }
                 else if (prevOp == '/'){
                    prev /= num;
                }
                else if (prevOp == '%'){
                     prev %= num;
                }

                if (c == ')') break;
                num = 0;
                prevOp = c;
             }
        }
        return sum + prev;
    }

    static int calculate(String s) {
        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') { //remove whitespace
                q.add(c);
             }
         }
        q.add(' ');
        return calculateMini(q);
    }

    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter The Expression:");
        String str= s.nextLine();
        System.out.println("Result: " + calculate(str));
    }
}