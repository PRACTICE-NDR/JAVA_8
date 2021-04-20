package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dinakar on 27/03/21
 */
public class StreamsTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(10);


        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("IND", "emp1"));
        employeeList.add(new Employee("IND", "emp2"));
        employeeList.add(new Employee("PAK", "emp3"));
        employeeList.add(new Employee("CHN", "emp4"));
        Map<String, List<Employee>> stringListMap = new HashMap<>();
        stringListMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getCountry));
        stringListMap.forEach((a, b) ->
        {
            System.out.print(a+"::  ");
            b.stream().forEach(c->
            {
                System.out.print(c.getName()+",");
            });
            System.out.println();
        });


        StreamsTest streamsTest = new StreamsTest();
        List<Integer> list1 = list.stream().map(a -> a + a).collect(Collectors.toList());
        //  Stream distinctStream = list.stream().distinct();
        //  System.out.println(distinctStream.count());
        // System.out.println(list1);
        Stream s = list.stream().map(a -> a + a).sorted();
        System.out.println(s.count());
        Stream limit = list.stream().limit(2).sorted();
        // System.out.println(limit.count());

        //MAP and FLAT MAP
        String[] stringA = {"TEST", "Dinakar"};
        List<String> map = Arrays.stream(stringA).map(a -> a.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(map);
    }

    static class Employee {
        String country;
        String name;

        public Employee(String country, String name) {
            this.country = country;
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
