package Shekho.com;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        // 1.Integer stream
        IntStream.range(1,11).forEach(i -> System.out.println(i));

        // 2.Integer stream with skip
        IntStream.range(1,11).skip(5).forEach(System.out::println);

        // 3.Integer stream with sum
        System.out.println(IntStream.range(1,11).sum());

        // 4.Stream of sorted and find first
        Stream.of("C","B","A").sorted().findFirst().ifPresent(System.out::println);

        // 5.Stream form array, sort, filter and print
        String [] names = {"Deldar","Ali","Ciwan","Rezan","Dlo","Dilber"};
        Arrays.stream(names).filter(name -> name.startsWith("D")).sorted().forEach(System.out::println);

        // 6.Squares of an int array
        Integer [] numbers = {1,2,3,4,5};
        System.out.println(Arrays.stream(numbers).map(number -> number * number).count());

        // 7.Stream form list, filter and print
        Arrays.stream(names).map(String::toUpperCase).filter(name -> name.startsWith("D")).forEach(System.out::println);

        // 8.Stream rows form text file, filter, sort and print
//        File file = new File("D:\\JavaAdvanced\\StreamAPI\\src\\Shekho\\com\\motorcycles.txt");
//        Scanner fileReader = new Scanner(file);
//        while(fileReader.hasNextLine()){
//            System.out.println(fileReader.nextLine());
//        }
        Stream<String> motorcycles = Files.lines(Paths.get("D:\\JavaAdvanced\\StreamAPI\\src\\Shekho\\com\\motorcycles.txt"));
        motorcycles.sorted().filter(name -> name.startsWith("Al")).forEach(System.out::println);
        motorcycles.close();
        System.out.println("");

        // 9.Stream row form text file and save to list
        List<String> motors = Files.lines(Paths.get("D:\\JavaAdvanced\\StreamAPI\\src\\Shekho\\com\\motorcycles.txt")).
                filter(M -> M.contains("cyc")).
                collect(Collectors.toList());
        motors.forEach(Motor -> System.out.println(Motor));
        System.out.println("");


        // 10.Stream rows from text file and count
        Stream<String> data = Files.lines(Paths.get("D:\\JavaAdvanced\\StreamAPI\\src\\Shekho\\com\\data.txt"));
        int count1 = (int)data.map(row -> row.split(",")).
                filter(row -> row.length == 4).
                count();
        System.out.println(count1);
        data.close();

        // 11.Stream rows from text file and parse data
        Stream<String> data1 = Files.lines(Paths.get("D:\\JavaAdvanced\\StreamAPI\\src\\Shekho\\com\\data.txt"));
        data1.map(row -> row.split(",")).
                filter(row -> row.length == 4).
                filter(row -> Integer.parseInt(row[1]) > 10).
                forEach(row -> System.out.println(row[0] + " " + row[1] + " " + row[2] + " " + row[3]));
        data1.close();

        // 12.Stream rows form text file, store it to hashmap
        Stream<String> data2 = Files.lines(Paths.get("D:\\JavaAdvanced\\StreamAPI\\src\\Shekho\\com\\data.txt"));
        Map<String,Integer> hashmap = new HashMap<>();
        hashmap = data2.map(row -> row.split(",")).
                filter(row -> row.length == 4).
                filter(row -> Integer.parseInt(row[1]) > 10).
                collect(Collectors.toMap(
                        row -> row[0],
                        row -> Integer.parseInt(row[2])
                ));
        data2.close();

        for (String key:hashmap.keySet()
             ) {
            System.out.println(key + " " + hashmap.get(key));
            
        }
        System.out.println("");

        // 13.Reduction to sum
        double total = Stream.of(1.1,1.2,1.3).
                count();
        System.out.println(total);

        System.out.println("");

        double total1 = Stream.of(1.1,1.2,1.3).
                reduce(0.0, Double::sum);
        System.out.println(total1);

        // 14.Reduction to show summary statistics
        IntSummaryStatistics summaryStatistics = IntStream.of(2,4,5,6,7).
                summaryStatistics();
        System.out.println(summaryStatistics);
    }
}
