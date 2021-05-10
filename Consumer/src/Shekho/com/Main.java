package Shekho.com;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
	// write your code here

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        //External iteration
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (Integer number:list
             ) {
            System.out.println(number);
        }


        //Internal iteration stream API
        // Consumer to display a number
        Consumer<Integer> c = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };

        Consumer<Integer> consumer = i -> System.out.println(i);
        consumer.accept(212);
        c.accept(333);
        list.forEach(i -> System.out.println(i));
        // Passing a method as reference
        list.forEach(System.out::println);

        // Consumer to multiply 2 to every integer of a list
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        Consumer<List<Integer>> modify = l -> {
            for (int i = 0; i < l.size(); i++)
                l.set(i, 2 * l.get(i));
        };
        // Consumer to display  a list of numbers
        Consumer<List<Integer>> displayList = l -> l.stream().forEach(a -> System.out.println(a + " "));


        modify.accept(integers);
        displayList.accept(integers);
    }
}
