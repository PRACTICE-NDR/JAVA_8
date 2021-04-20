package Supplier;

import java.util.function.Supplier;

/**
 * @author dinakar on 27/03/21
 */
public class SupplierTest {
    public static void main(String[] args) {
        //Supplier
        Supplier<String> supplier = ()-> "test";
        System.out.println(supplier.get());
        //BiSupplier

    }

}
