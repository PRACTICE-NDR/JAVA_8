package matching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dinakar on 20/07/21
 */
public class MatchingFinal {

   // MergedSetCustomize mergedSet = new MergedSetCustomize();

    Set<List<Integer>> mergedSet = new HashSet<>();

    public static void main(String[] args) {

        MatchingFinal matchingFinal = new MatchingFinal();
        List<Map<Integer, List<Integer>>> listMap = new ArrayList<>();
        List<Map<Integer, Integer>> listIM = new ArrayList<>();
        List<List<Integer>> finalBibList = new ArrayList<>();

        Map<Integer, List<Integer>> t1 = new HashMap<>();
        Map<Integer, List<Integer>> t2 = new HashMap<>();
        Map<Integer, List<Integer>> t3 = new HashMap<>();
        Map<Integer, List<Integer>> t4 = new HashMap<>();
        Map<Integer, List<Integer>> t5 = new HashMap<>();

        Map<Integer, Integer> i1 = new HashMap<>();
        Map<Integer, Integer> i2 = new HashMap<>();
        Map<Integer, Integer> i3 = new HashMap<>();
        Map<Integer, Integer> i4 = new HashMap<>();
        Map<Integer, Integer> i5 = new HashMap<>();

        MatchingFinal.intilizeT1(t1, i1);
        MatchingFinal.intilizeT2(t2, i2);
        MatchingFinal.intilizeT3(t3, i3);
        MatchingFinal.intilizeT4(t4, i4);
        MatchingFinal.intilizeT5(t5, i5);

        listIM.add(i2);
        listIM.add(i3);
        listIM.add(i4);
        listIM.add(i5);

        listMap.add(t2);
        listMap.add(t3);
        listMap.add(t4);
        listMap.add(t5);

        t2.values().stream().forEach(bibIdSet -> {
            finalBibList.add(bibIdSet);
        });
        t3.values().stream().forEach(bibIdSet -> {
            finalBibList.add(bibIdSet);
        });
        t4.values().stream().forEach(bibIdSet -> {
            finalBibList.add(bibIdSet);
        });
        t5.values().stream().forEach(bibIdSet -> {
            finalBibList.add(bibIdSet);
        });

        for (List<Integer> bibSet : finalBibList) {
            matchingFinal.processingFinalBibList(bibSet, listIM, listMap);
        }
        matchingFinal.printResult();

    }

    private void processingFinalBibList(List<Integer> bibSet, List<Map<Integer, Integer>> listIM,
                                               List<Map<Integer, List<Integer>>> listMap) {
        //MergedSetCustomize mergedSet = new MergedSetCustomize();
        //Set<List<Integer>> mergedSet = new HashSet<>();
        Set<List<Integer>> tempSet = new HashSet<>();
        for (Integer bibId : bibSet) {
            Integer matchingId = 0;
            for (int i = 0; i < 4; i++) {
                matchingId = listIM.get(i).get(bibId);
                if (matchingId != null && listMap.get(i).get(matchingId) != null) {
                    tempSet.add(listMap.get(i).get(matchingId));
                }
            }
        }
        if (tempSet.size() > 0) {
            Set<Integer> dieSet = new HashSet<>();
           /* for (List<Integer> set : tempSet){
               dieSet = CollectionsUtils.unions(dieSet,set);
            }

            mergedSet.add(newSet);*/
        }
    }
    public static Set<Integer> mergeSet(Set<Integer> a, Set<Integer> b)
    {
        return new HashSet<Integer>() {{
            addAll(a);
            addAll(b);
        } };
    }
    private void printResult(){
        System.out.println(mergedSet.stream().collect(Collectors.toSet()));

    }

    public static void createIdentityAndThreadMap(Map<Integer, List<Integer>> tm, Map<Integer, Integer> im) {
        for (var entrySet : tm.entrySet()) {
            for (Integer value : entrySet.getValue()) {
                im.put(value, entrySet.getKey());
            }
        }
    }

    public static void intilizeT1(Map<Integer, List<Integer>> t1, Map<Integer, Integer> i1) {
        List<Integer> list1 = Arrays.asList(1, 6, 16);
        List<Integer> l1 = new ArrayList<>(list1);
        t1.put(1, l1);

        createIdentityAndThreadMap(t1, i1);
    }

    public static void intilizeT2(Map<Integer, List<Integer>> t2, Map<Integer, Integer> i2) {

        List<Integer> list1 = Arrays.asList(10, 11, 13, 17, 201);
        List<Integer> list2 = Arrays.asList(14, 15, 101);
        List<Integer> list3 = Arrays.asList(1, 6, 16, 18);

        List<Integer> l1 = new ArrayList<>(list1);
        List<Integer> l2 = new ArrayList<>(list2);
        List<Integer> l3 = new ArrayList<>(list3);
        t2.put(1, l1);
        t2.put(2, l2);
        t2.put(3, l3);
        createIdentityAndThreadMap(t2, i2);
    }

    public static void intilizeT3(Map<Integer, List<Integer>> t3, Map<Integer, Integer> i3) {

        List<Integer> list1 = Arrays.asList(21, 19, 16, 30, 28, 100);
        List<Integer> list2 = Arrays.asList(14, 23, 24);

        List<Integer> l1 = new ArrayList<>(list1);
        List<Integer> l2 = new ArrayList<>(list2);
        t3.put(1, l1);
        t3.put(2, l2);

        createIdentityAndThreadMap(t3, i3);
    }


    public static void intilizeT4(Map<Integer, List<Integer>> t4, Map<Integer, Integer> i4) {

        List<Integer> list1 = Arrays.asList(501, 502);
        List<Integer> list2 = Arrays.asList(601, 602, 201);

        List<Integer> l1 = new ArrayList<>(list1);
        List<Integer> l2 = new ArrayList<>(list2);
        t4.put(1, l1);
        t4.put(2, l2);

        createIdentityAndThreadMap(t4, i4);
    }

    public static void intilizeT5(Map<Integer, List<Integer>> t5, Map<Integer, Integer> i5) {

        List<Integer> list1 = Arrays.asList(701, 702);
        List<Integer> list2 = Arrays.asList(801, 802);

        List<Integer> l1 = new ArrayList<>(list1);
        List<Integer> l2 = new ArrayList<>(list2);
        t5.put(1, l1);
        t5.put(2, l2);

        createIdentityAndThreadMap(t5, i5);
    }
    public class MergedSetCustomize{
        private List<Integer> setOfIntegers;

        public List<Integer> getSetOfIntegers() {
            return setOfIntegers;
        }

        public void setSetOfIntegers(List<Integer> setOfIntegers) {
            this.setOfIntegers = setOfIntegers;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if(!this.equals(obj))
                return false;
            else
                return this.equals(obj);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}