import java.util.Scanner;

public class ReplacingSubstring {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = s.nextLine();
        System.out.println("Enter Regex: ");
        String regex = s.nextLine();
        System.out.println("Enter Replacement: ");
        String replaceWith = s.nextLine();
        String newStr = str.replaceAll(regex, replaceWith);
        System.out.println(newStr);
    }
}