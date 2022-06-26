package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//wrong answer , sort wrt to score not regions.
public class qualifyingcontest {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String[] inputs=(in.readLine().trim()).split("\\s+");
        int n=Integer.parseInt(inputs[0]);
        int m=Integer.parseInt(inputs[1]);
        List<triplets>ls=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
         String[]participants=(in.readLine().trim()).split("\\s+");
         ls.add(new triplets(participants[0],Integer.parseInt(participants[1]),Integer.parseInt(participants[2])));
        }
    printteams(ls,m,n);
    }
    static void printteams(List<triplets>ls,int m,int n){
        Collections.sort(ls,new sortbyscore());
//        for (triplets o1:ls) {
//            System.out.println(o1.surname+","+o1.region+","+o1.score);
//        }
        int k=0;
        for (int i = 0; i <m ; i++) {
            int c=0;
            for (int j = k; j <n ; j++) {
                if (j!=n-1&&ls.get(j).region!=(i+1)){
                    if (ls.get(j-1).score>ls.get(j-2).score){
                        if (j-3>=0&&ls.get(j-3).region==(i+1)){
                            if (ls.get(j-3).score<ls.get(j-2).score){
                                System.out.println(ls.get(j-1).surname+" "+ls.get(j-2).surname);
                                c=1;
                                k=j;
                                break;
                            }else{
                                k=j;
                                break;
                            }
                        }
                        System.out.println(ls.get(j-1).surname+" "+ls.get(j-2).surname);
                        c=1;
                        k=j;
                        break;
                    }else{
                        k=j;
                        break;
                    }
                }else if (j==n-1){
                    if (ls.get(j).score>ls.get(j-1).score){
                        if (j-2>=0&&ls.get(j-2).region==(i+1)){
                            if (ls.get(j-2).score<ls.get(j-1).score){
                                System.out.println(ls.get(j).surname+" "+ls.get(j-1).surname);
                                c=1;
                                break;
                            }else{
                                break;
                            }
                        }
                        System.out.println(ls.get(j).surname+" "+ls.get(j-1).surname);
                        c=1;
                    }else break;
                }

            }
            if (c==0)System.out.println("?");
        }
    }
}
class sortbyscore implements Comparator<triplets>{
    @Override
    public int compare(triplets o1,triplets o2){
        if (o1.region!=o2.region)return Integer.compare(o1.region,o2.region);
        else{
            return Integer.compare(o1.score,o2.score);
        }
    }
}
class triplets{
    String surname;
    int region;
    int score;
    triplets(String surname,int region,int score){
        this.surname=surname;
        this.region=region;
        this.score=score;
    }
}
