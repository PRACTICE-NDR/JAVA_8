package Optional;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author dinakar on 27/03/21
 */
public class OptionalTest {
    public static void main(String[] args) {
        Supplier<String> supplier = ()-> "test";
        String tests = null;
        Optional<String> optional = Optional.ofNullable(tests);
        System.out.println(optional.orElseGet(supplier));
        System.out.println(optional.orElse(supplier.get()));

    }
}
