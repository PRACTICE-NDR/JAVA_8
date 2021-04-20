package Predicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * @author dinakar on 27/03/21
 */
public class PredicateTest {
    public static void main(String[] args) {
        //Predicate
        Predicate<Integer> predicate = a -> a > 100;
        //System.out.println(predicate.test(11));
        //System.out.println(predicate.test(10));

        //BiPrdicate
        BiPredicate<String, String> biPredicate = (a, b) -> a.toLowerCase().length() > b.toLowerCase().length();
        System.out.println(biPredicate.test("abc", "ab")); //true
        Predicate<Integer> predicate1 = a -> a > 10;
        System.out.println(predicate.and(predicate).test(12)); //false
        System.out.println(predicate.or(predicate1).test(12)); //true
    }
}
