/*
* 4) Find the replacement of continue keyword when you are iterating over a collection using forEach() method.
   eg-List<integer> ints=new ArrayList<>();
      ints.forEach(x->System.out.println(x))

	  Now using this method if we want to skip some object contditionally. Then How are we gonna do. (In for loop we have continue keyword but here how we'll do)
	  Please write a program for the same.
* */


import java.util.*;

public class Replacement{
    public static void main(String args[]) {
        List<Integer> integers=new ArrayList<>();

        for(int i=0;i<10;i++){
            integers.add(i);
        }
        integers.stream().filter(x-> (x & 1) == 0).forEach(System.out::println);
    }
}