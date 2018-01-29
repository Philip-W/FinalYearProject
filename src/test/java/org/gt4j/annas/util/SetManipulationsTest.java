package org.gt4j.annas.util;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SetManipulationsTest {
    @Test
    public void removeAll() throws Exception {
        ArrayList<Integer> list1  = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);


        list2.add(3);
        list2.add(4);
        list2.add(6);

        ArrayList<Integer> list3 = (ArrayList<Integer>) SetManipulations.removeAll(list1, list2);
        assertTrue(list3.contains(1));
        assertTrue(list3.contains(2));
        assertTrue(list3.contains(5));
        assertTrue(list3.contains(1));
        assertTrue(!list3.contains(3));
        assertTrue(!list3.contains(4));
        assertTrue(!list3.contains(6));


    }

}