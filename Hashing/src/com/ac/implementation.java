package com.ac;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class implementation {
    public static void main(String[] args)throws IOException {
        HashMap<Integer,Integer>m=new HashMap<Integer, Integer>();
        m.put(5,2);
        m.put(2,1);
        m.put(24,12);
        System.out.println("The hash map is "+m);
        System.out.println(m.get(2));
        //can not have duplicate key.
        for (Map.Entry<Integer,Integer>entry:m.entrySet()) {
            int key=entry.getKey();
            int value=entry.getValue();
            System.out.println(key+":"+value);
        }

    }
}
