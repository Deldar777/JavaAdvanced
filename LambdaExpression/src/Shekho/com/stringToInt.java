package Shekho.com;

@FunctionalInterface
public interface stringToInt {
    Integer apply(String s);

    default  Integer convert(String s){
        return  s.length();
    }
}
