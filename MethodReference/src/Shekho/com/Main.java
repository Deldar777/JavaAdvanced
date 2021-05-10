package Shekho.com;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.forEach(element -> System.out.println(element));

        list.forEach(System.out::println);

        list.forEach(Shekho.com.Main::doubleIt);
    }

    public static void doubleIt(int number){
        System.out.println(number * 2);
    }
}
