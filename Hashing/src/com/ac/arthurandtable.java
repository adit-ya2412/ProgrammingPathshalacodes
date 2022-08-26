package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class arthurandtable {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int legs=Integer.parseInt(br.readLine().trim());
        int[]table=new int[legs];
        String[]inpu=(br.readLine().trim()).split("\\s+");

        for (int i = 0; i <legs; i++) {
        table[i]=Integer.parseInt(inpu[i]);
        }
        int[]energy=new int[legs];
        inpu=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <legs ; i++) {
            energy[i]=Integer.parseInt(inpu[i]);
        }
        System.out.println(energyrequired(legs,table,energy));

    }
    static int energyrequired(int legs,int[]table,int[]energy){
        if (legs==1)return 0;
        if (legs==2){
            if (energy[0]==energy[1])return 0;
            else return Math.min(energy[0],energy[1]);
        }
        int energyreq=Integer.MAX_VALUE;
        HashMap<Integer,List<Integer>>legsoflengthindi=new HashMap<>();
        for (int i = 0; i <legs ; i++) {
            if (legsoflengthindi.containsKey(table[i])){
                legsoflengthindi.get(table[i]).add(i);
            }else {
                List<Integer>temp=new ArrayList<>();
                temp.add(i);
                legsoflengthindi.put(table[i],temp);
            }
        }


    }
}
