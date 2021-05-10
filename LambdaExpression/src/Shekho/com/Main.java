package Shekho.com;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//
//        for (int i = 0; i < numbers.size(); i++) {
//            System.out.println(numbers.get(i));
//        }
//
//        numbers.forEach(number -> System.out.println(number));

//        Implement the functional calculator interface
        Calculator cal = i -> i + i;
        System.out.println(cal.calculateSquare(4));

//        Implement the functional calculator interface
        PrintSomething printer = ()  -> System.out.println("Printing....");
        printer.print();


        stringToInt convert = s -> s.length() + 1;
        System.out.println(convert.convert("Hello"));

        StringConverter stringConverter = new StringConverter();
        System.out.println(stringConverter.convert("Hello world"));












    }
}
