package matching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dinakar on 20/07/21
 */
public class MatchingFinal {


    public static void main(String[] args) {
        Matching matching = new Matching();
        List<Map<Integer, Set<Integer>>> listMap = new ArrayList<>();
        List<Map<Integer, Integer>> listIM = new ArrayList<>();
        List<Set<Integer>> finalBibList = new ArrayList<>();

        Map<Integer, Set<Integer>> t1 = new HashMap<>();
        Map<Integer, Set<Integer>> t2 = new HashMap<>();
        Map<Integer, Set<Integer>> t3 = new HashMap<>();
        Map<Integer, Set<Integer>> t4 = new HashMap<>();
        Map<Integer, Set<Integer>> t5 = new HashMap<>();

        Map<Integer, Integer> i1 = new HashMap<>();
        Map<Integer, Integer> i2 = new HashMap<>();
        Map<Integer, Integer> i3 = new HashMap<>();
        Map<Integer, Integer> i4 = new HashMap<>();
        Map<Integer, Integer> i5 = new HashMap<>();

        Matching.intilizeT1(t1,i1);
        Matching.intilizeT2(t2,i2);
        Matching.intilizeT3(t3,i3);
        Matching.intilizeT4(t4,i4);
        Matching.intilizeT5(t5,i5);

        listIM.add(i2);
        listIM.add(i3);
        listIM.add(i4);
        listIM.add(i5);

        listMap.add(t2);
        listMap.add(t3);
        listMap.add(t4);
        listMap.add(t5);

        t2.values().stream().forEach(bibIdSet->{
           finalBibList.add(bibIdSet);
            });
        t3.values().stream().forEach(bibIdSet->{
            finalBibList.add(bibIdSet);
        });
        t4.values().stream().forEach(bibIdSet->{
            finalBibList.add(bibIdSet);
        });
        t5.values().stream().forEach(bibIdSet->{
            finalBibList.add(bibIdSet);
        });

        for(Set<Integer> bibSet : finalBibList){
            processingFinalBibList(bibSet,listIM,listMap);
        }

       // matching.process(listMap);
    }

    private static void processingFinalBibList(Set<Integer> bibSet, List<Map<Integer, Integer>> listIM,
                                               List<Map<Integer, Set<Integer>>> listMap) {
        Set<Set<Integer>> tempSet = new HashSet<>();
        for (Integer bibId : bibSet) {
            Integer matchingId = 0;
            for (int i = 0; i < 4; i++) {
                matchingId = listIM.get(i).get(bibId);
                if (matchingId != null && listMap.get(i).get(matchingId) != null) {
                    tempSet.add(listMap.get(i).get(matchingId));
                }
            }
        }
        if(tempSet.size()>0) {
            Set<Integer> mergedSet = new HashSet<>();
            tempSet.stream().forEach(set ->{
                mergedSet.addAll(set);
            });
            TreeSet<Integer> mergedSetUpdated  = new TreeSet<>();
            mergedSetUpdated.addAll(mergedSet);

            System.out.println(UUID.randomUUID()+"   ::     "+mergedSetUpdated.stream().collect(Collectors.toSet()));
        }
    }

    public static Set<Integer> getValues(Map<Integer, Set<Integer>> t, Integer num) {
        Set<Integer> listInteger = new TreeSet<>();
        for (var entry : t.entrySet()) {
            if (entry.getValue().contains(num)) {
                return entry.getValue();
            }
        }
        return listInteger;
    }

    public static Map<Integer, Set<Integer>> getValuesForResponse(Map<Integer, Set<Integer>> t, Integer num, Integer key) {
        Map<Integer, Set<Integer>> res = new HashMap<Integer, Set<Integer>>();
        Integer keyValue;
        for (var entry : t.entrySet()) {
            if (key != entry.getKey()) {
                if (entry.getValue().contains(num)) {
                    keyValue = entry.getKey();
                    Set<Integer> listInteger = entry.getValue();
                    res.put(keyValue, listInteger);
                    return res;
                }
            }
        }
        return res;
    }

    public static void intilizeT1(Map<Integer, Set<Integer>> t1,Map<Integer, Integer> i1) {
        List<Integer> list1 = Arrays.asList(1, 6, 16);
       // List<Integer> list2 = Arrays.asList(8, 9, 202);
        Set<Integer> l1 = new HashSet<>(list1);
        //Set<Integer> l2 = new HashSet<>(list2);
        t1.put(1, l1);
        //t1.put(2, l2);

        createIdentityAndThreadMap(t1,i1);
    }

    public static void intilizeT2(Map<Integer, Set<Integer>> t2,Map<Integer, Integer> i2) {

        List<Integer> list1 = Arrays.asList(10, 11, 13, 17, 201);
        List<Integer> list2 = Arrays.asList(14, 15, 101);
        List<Integer> list3 = Arrays.asList(1, 6, 16, 18);

        Set<Integer> l1 = new HashSet<>(list1);
        Set<Integer> l2 = new HashSet<>(list2);
        Set<Integer> l3 = new HashSet<>(list3);
        t2.put(1, l1);
        t2.put(2, l2);
        t2.put(3, l3);
        createIdentityAndThreadMap(t2,i2);
    }

    public static void intilizeT3(Map<Integer, Set<Integer>> t3,Map<Integer, Integer> i3) {

        List<Integer> list1 = Arrays.asList(21, 19, 16, 30, 28, 100);
        List<Integer> list2 = Arrays.asList(14, 23, 24);

        Set<Integer> l1 = new HashSet<>(list1);
        Set<Integer> l2 = new HashSet<>(list2);
        t3.put(1, l1);
        t3.put(2, l2);

        createIdentityAndThreadMap(t3,i3);
    }


    public static void intilizeT4(Map<Integer, Set<Integer>> t4,Map<Integer, Integer> i4) {

        List<Integer> list1 = Arrays.asList(501,502);
        List<Integer> list2 = Arrays.asList(601,602,201);

        Set<Integer> l1 = new HashSet<>(list1);
        Set<Integer> l2 = new HashSet<>(list2);
        t4.put(1, l1);
        t4.put(2, l2);

        createIdentityAndThreadMap(t4,i4);
    }

    public static void intilizeT5(Map<Integer, Set<Integer>> t5,Map<Integer, Integer> i5) {

        List<Integer> list1 = Arrays.asList(701,702);
        List<Integer> list2 = Arrays.asList(801,802);
        //List<Integer> list3 = Arrays.asList(701,804);

        Set<Integer> l1 = new HashSet<>(list1);
        Set<Integer> l2 = new HashSet<>(list2);
       // Set<Integer> l3 = new HashSet<>(list3);
        t5.put(1, l1);
        t5.put(2, l2);
       // t5.put(3, l3);

        createIdentityAndThreadMap(t5,i5);
    }

    public void process(List<Map<Integer, Set<Integer>>> list) {
        Map<Integer, Set<Integer>> response = new HashMap<>();
        for (Map<Integer, Set<Integer>> result : list) {
            for (var entry : result.entrySet()) {
                for (Map<Integer, Set<Integer>> map : list) {
                    boolean isInserted = false;
                    if (result != map) {
                        for (Integer value : entry.getValue()) {
                            Set<Integer> listInteger = getValues(map, value);
                            if (listInteger.size() > 0) {
                                isInserted = true;
                                Set<Integer> newList = Stream.of(entry.getValue(), listInteger)
                                        .flatMap(Collection::stream)
                                        .collect(Collectors.toSet());
                                response.put(entry.getKey(), newList);
                                //map.remove(entry.getKey());
                            }
                        }
                    }
                    if (!isInserted) {
                        int count = 0;
                        Integer max = response.keySet().stream().max(Integer::compareTo).orElse(0);
                        for(var newEntry : response.entrySet()){
                            if(newEntry.getValue().equals(entry.getValue())){
                                count++;
                            }
                        }
                        if (count == 0) {
                            response.put(max + 1, entry.getValue());
                        }
                    }
                }
            }
        }
        processfinalResponse(response);
    }

    public void processfinalResponse(Map<Integer, Set<Integer>> res) {
        Set<Integer> keysToRemove = new TreeSet<>();
        for (var entrySet : res.entrySet()) {
            for (Integer num : entrySet.getValue()) {
                Map<Integer, Set<Integer>> response = getValuesForResponse(res, num, entrySet.getKey());
                if (response != null) {
                    for (var newEntrySet : response.entrySet()) {
                        if (newEntrySet.getValue().size() > 0) {
                            keysToRemove.add(newEntrySet.getKey());
                            Set<Integer> newList = Stream.of(entrySet.getValue(), newEntrySet.getValue())
                                    .flatMap(Collection::stream)
                                    .collect(Collectors.toSet());
                            res.put(entrySet.getKey(), newList);
                        }
                    }
                }

            }
        }
        printResultContent(res);
    }

    private static void removeDuplicates(final Map<Integer, Set<Integer>> map) {
        System.out.println("DUPLICATES::::::::::::\n");
        final Iterator<Map.Entry<Integer, Set<Integer>>> iter = map.entrySet().iterator();
        final HashSet<Set<Integer>> valueSet = new HashSet<>();
        while (iter.hasNext()) {
            final Map.Entry<Integer, Set<Integer>> next = iter.next();
            if (!valueSet.add(next.getValue())) {
                iter.remove();
                TreeSet treeSet = new TreeSet();
                treeSet.addAll(next.getValue());
                System.out.println(treeSet.stream().collect(Collectors.toSet()));
            }
        }
        System.out.println("\n");
    }

    public static void printResultContent(Map<Integer, Set<Integer>> result) {
        removeDuplicates(result);
        System.out.println("ACTUAL RESULT::::::::::::::\n");
        System.out.println("        MATCHING IDENTFIER          "+"   ::     "+"    BIB ID's");
        result.entrySet().forEach(entry -> {
            TreeSet treeSet = new TreeSet();
            treeSet.addAll(entry.getValue());
            System.out.println(UUID.randomUUID()+"   ::     "+treeSet.stream().collect(Collectors.toSet()));
        });
    }
    public static void createIdentityAndThreadMap(Map<Integer,Set<Integer>> tm,Map<Integer,Integer> im){
       for (var entrySet : tm.entrySet()){
           for(Integer value : entrySet.getValue()){
               im.put(value,entrySet.getKey());
           }
       }
    }

}
class TempInteger extends TreeSet{

  @Override
    public boolean add(Object o){
      if(this.contains(o))
          return true;
      else
          return super.add(o);
  }

}