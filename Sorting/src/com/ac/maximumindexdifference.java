package com.ac;
import java.io.*;
import java.util.*;
public class maximumindexdifference {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]elements=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        int maxdif=maxidifference(arr,n);
        System.out.println(maxdif);
    }
    static int maxidifference(int[]arr,int n){
        List<pairsofindex>lis=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            lis.add(new pairsofindex(arr[i],i));
        }
        Collections.sort(lis,new comparebyvaluewithindex());
        int ans=Integer.MIN_VALUE;
        int sufmax=lis.get(lis.size()-1).index;
        if (n==1||n==0)return -1;
        for (int i =lis.size()-2; i >=0 ; i--) {
            ans=Math.max(ans,sufmax-lis.get(i).index);
            sufmax=Math.max(sufmax,lis.get(i).index);
        }
        if (ans<0)return 0;
        return ans;
    }
}
class  pairsofindex{
    int value;
    int index;
    pairsofindex(int value,int index){
        this.value=value;
        this.index=index;
    }
}
class comparebyvaluewithindex implements Comparator<pairsofindex>{
    @Override
    public int compare(pairsofindex o1,pairsofindex o2){
        if (o1.value!=o2.value){
            return Integer.compare(o1.value,o2.value);
        }else {
            if (o1.index<o2.index)return -1;
            else return 1;
        }
    }
}
