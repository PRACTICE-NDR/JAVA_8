package matching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dinakar on 20/07/21
 */
public class Matching {


    public static void main(String[] args) {
        Matching matching = new Matching();
        List<Map<Integer, List<Integer>>> listMap = new ArrayList<>();
        Map<Integer, List<Integer>> t1 = new HashMap<>();
        Map<Integer, List<Integer>> t2 = new HashMap<>();
        Map<Integer, List<Integer>> t3 = new HashMap<>();
        Matching.intilizeT1(t1);
        Matching.intilizeT2(t2);
        Matching.intilizeT3(t3);

        listMap.add(t1);
        listMap.add(t2);
        listMap.add(t3);

        matching.process(listMap);
    }

    public static List<Integer> getValues(Map<Integer, List<Integer>> t, Integer num) {
        List<Integer> listInteger = new ArrayList<>();
        for (var entry : t.entrySet()) {
            if (entry.getValue().contains(num)) {
                return entry.getValue();
            }
        }
        return listInteger;
    }

    public static Map<Integer, List<Integer>> getValuesForResponse(Map<Integer, List<Integer>> t, Integer num, Integer key) {
        Map<Integer, List<Integer>> res = new HashMap<Integer, List<Integer>>();
        Integer keyValue;
        for (var entry : t.entrySet()) {
            if (key != entry.getKey()) {
                if (entry.getValue().contains(num)) {
                    keyValue = entry.getKey();
                    List<Integer> listInteger = entry.getValue();
                    res.put(keyValue, listInteger);
                    return res;
                }
            }
        }
        return res;
    }

    public static void intilizeT1(Map<Integer, List<Integer>> t1) {

        List<Integer> l1 = Arrays.asList(1, 2, 3, 5, 7);
        List<Integer> l2 = Arrays.asList(8, 9);
        t1.put(1, l1);
        t1.put(2, l2);
    }

    public static void intilizeT2(Map<Integer, List<Integer>> t2) {

        List<Integer> l1 = Arrays.asList(3, 10, 11, 13, 17, 19);
        List<Integer> l2 = Arrays.asList(14, 15);
        List<Integer> l3 = Arrays.asList(1, 6, 16, 18);
        t2.put(1, l1);
        t2.put(2, l2);
        t2.put(3, l3);
    }

    public static void intilizeT3(Map<Integer, List<Integer>> t3) {
        List<Integer> l1 = Arrays.asList(21, 19, 16, 7, 28);
        List<Integer> l2 = Arrays.asList(23, 24, 14);
        t3.put(1, l1);
        t3.put(2, l2);
    }


    public void process(List<Map<Integer, List<Integer>>> list) {
        Map<Integer, List<Integer>> response = new HashMap<>();
        for (Map<Integer, List<Integer>> result : list) {
            for (var entry : result.entrySet()) {
                for (Map<Integer, List<Integer>> map : list) {
                    boolean isInserted = false;
                    if (result != map) {
                        for (Integer value : entry.getValue()) {
                            List<Integer> listInteger = getValues(map, value);
                            if (listInteger.size() > 0) {
                                isInserted = true;
                                List<Integer> newList = Stream.of(entry.getValue(), listInteger)
                                        .flatMap(Collection::stream)
                                        .collect(Collectors.toList());
                                response.put(entry.getKey(), newList);
                                map.remove(entry.getKey());
                            }
                        }
                    }
                    if (!isInserted) {
                        Integer max = response.keySet().stream().max(Integer::compareTo).orElse(0);
                        response.put(max + 1, entry.getValue());
                    }
                }
            }
        }
        processfinalResponse(response);
    }

    public void processfinalResponse(Map<Integer, List<Integer>> res) {
        List<Integer> keysToRemove = new ArrayList<>();
        for (var entrySet : res.entrySet()) {
            for (Integer num : entrySet.getValue()) {
                Map<Integer, List<Integer>> response = getValuesForResponse(res, num, entrySet.getKey());
                if (response != null) {
                    for (var newEntrySet : response.entrySet()) {
                        if (newEntrySet.getValue().size() > 0) {
                            keysToRemove.add(newEntrySet.getKey());
                            List<Integer> newList = Stream.of(entrySet.getValue(), newEntrySet.getValue())
                                    .flatMap(Collection::stream)
                                    .collect(Collectors.toList());
                            res.put(entrySet.getKey(), newList);
                        }
                    }
                }

            }
        }
        printResultContent(res);
    }

    private static void removeDuplicates(final Map<Integer, List<Integer>> map) {
        System.out.println("DUPLICATES::::::::::::\n");
        final Iterator<Map.Entry<Integer, List<Integer>>> iter = map.entrySet().iterator();
        final HashSet<List<Integer>> valueSet = new HashSet<>();
        while (iter.hasNext()) {
            final Map.Entry<Integer, List<Integer>> next = iter.next();
            if (!valueSet.add(next.getValue())) {
                iter.remove();
                TreeSet treeSet = new TreeSet();
                treeSet.addAll(next.getValue());
                System.out.println(treeSet.stream().collect(Collectors.toSet()));
            }
        }
        System.out.println("\n");
    }

    public static void printResultContent(Map<Integer, List<Integer>> result) {
        removeDuplicates(result);
        System.out.println("ACTUAL RESULT::::::::::::::\n");
        result.entrySet().forEach(entry -> {
            TreeSet treeSet = new TreeSet();
            treeSet.addAll(entry.getValue());
            System.out.println(treeSet.stream().collect(Collectors.toSet()));
        });
    }
}
