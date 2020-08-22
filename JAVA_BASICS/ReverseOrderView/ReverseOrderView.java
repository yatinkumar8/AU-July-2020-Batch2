import java.util.TreeMap;

public class ReverseOrderView {
    public static void main(String[] args) {
        TreeMap <Integer,Character> map = new TreeMap <> ();
        map.put(1, 'A');
        map.put(2, 'B');
        map.put(3, 'C');
        map.put(4, 'D');
        System.out.println("Initial: " + map);
        System.out.println("Reverse order view of keys: " + map.descendingKeySet());
    }
}