package Function;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author dinakar on 27/03/21
 */
public class FunctionTest {
    public static void main(String[] args) {
        //Function
        Function<String, String> function = a -> a.toLowerCase();
        //System.out.println(function.apply("Test"));
        //BiFunction
        BiFunction<String, String, String> biFunction = (a, b) -> a.concat(b);
        System.out.println(biFunction.andThen(function).apply("Test", "Understood"));
    }

}
