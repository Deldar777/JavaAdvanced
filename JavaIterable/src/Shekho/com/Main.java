package Shekho.com;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Collection<String> collection = list;
        
        Iterable<String> iterable = collection;

//        Four ways to iterate through an object of iterable interface

//        1. foreach
        for (String element: iterable
             ) {
            System.out.println(element);
        }

//        2.Via an iterator
        Iterator<String> iterator = iterable.iterator();

        while (iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element);
        }

//        3. Call the foreach function
        list.forEach(element -> System.out.println(element));

//        4. Via an spliterator
        Spliterator<String> spliterator = list.spliterator();
        while(spliterator.tryAdvance(element -> System.out.println(element)));
    }
}
