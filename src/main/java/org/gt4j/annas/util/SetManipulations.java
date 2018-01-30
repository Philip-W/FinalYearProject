package org.gt4j.annas.util;

import java.util.*;

/**
 * TODO
 * * Test order preservations on lists
 *
 */
public class SetManipulations {

    public static <V> List<V> union(Collection<V> list1, Collection<V> list2){
        Set<V> set = new HashSet<V>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<V>(set);
    }

    /**
     * Should be order preserving on lists, test.
     * @param mainList
     * @param setToRemove
     * @param <V>
     * @return
     */
    public static <V> List<V> removeAll(Collection<V> mainList,
                                        Collection<V> setToRemove){

        Set<V> set = new HashSet<V>();

        for (V v : mainList){
            if (!setToRemove.contains(v)){
                set.add(v);
            }
        }

        return new ArrayList<V>(set);
    }

    public static <V> List<V> intersection(Collection<V> list1, Collection<V> list2){
        List<V> list = new ArrayList<>();

        for (V v : list1){
            if (list2.contains(v)){
                list.add(v);
            }
        }

        return list;
    }
}
