package Consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author dinakar on 27/03/21
 */
public class ConsumerTest {
    public static void main(String[] args) {
        //Consumer
        Consumer<Integer> consumer = (a) -> System.out.println(a);
        //consumer.accept(10);
        Consumer<Integer> consumer1 = (a) -> System.out.println(a);
        consumer.andThen(consumer1).accept(10);

        //BiConsumer
        BiConsumer<Integer, Integer> biConsumer = (a, b) -> System.out.println(a+"  "+b);
        //biConsumer.accept(4,4);
        BiConsumer<Integer, Integer> biConsumer1 = (a, b) -> System.out.println(a+"  "+b);
        biConsumer.andThen(biConsumer1).accept(5, 5);
    }
}
