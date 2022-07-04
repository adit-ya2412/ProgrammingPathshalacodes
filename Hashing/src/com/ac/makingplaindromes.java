package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class makingplaindromes {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]words=(br.readLine().trim()).split("\\s+");
//        String[]words=new String[2];
//        words[0]="a";
//        words[1]="";
       List<List<Integer>>ans= palindromePairs(words);
        for (List<Integer>i:ans) {
            System.out.println(i);
        }
    }
//    static List<List<Integer>>palindromepairs(String[]words){
//        HashMap<String,Integer>map=new HashMap<>();
//        for (int i=0;i<words.length;i++){
//            String rev=new StringBuffer(words[i]).reverse().toString();
//            map.put(rev,i);
//        }
//        HashMap<String,Boolean>exists=new HashMap<>();
//        List<List<Integer>>ans=new ArrayList<>();
//        for (int i = 0; i < words.length ; i++) {
//            if (map.get("")!=null&&(map.get("")!=i)&&(ispalindrome(words[i],0,words[i].length()))&&(exists.get(i+""+map.get(""))==null)){
//             String t=i+""+map.get("");
//             exists.put(t,true);
//             t=map.get("")+""+i;
//             exists.put(t,true);
//             List<Integer>temp=new ArrayList<>();
//             temp.add(i);
//             temp.add(map.get(""));
//             ans.add(new ArrayList<>(temp));
//             temp.remove(temp.size()-1);
//             temp.remove(temp.size()-1);
//             temp.add(map.get(""));
//             temp.add(i);
//             ans.add(new ArrayList<>(temp));
//            }
//            String prefix;
//            for (int j = 0; j <words[i].length() ; j++) {
//                prefix=words[i].substring(0,j+1);
//                if (map.get(prefix)!=null&&(map.get(prefix)!=i)&&(ispalindrome(words[i],j+1,words[i].length()))&&(exists.get(i+""+map.get(prefix))==null)){
//                     String t=i+""+map.get(prefix);
//                     List<Integer>temp=new ArrayList<>();
//                     temp.add(i);
//                     temp.add(map.get(prefix));
//                     exists.put(t,true);
//                     ans.add(new ArrayList<>(temp));
//                }
//            }
//            String suffix;
//            for (int j =words[i].length()-1; j >=0 ; j--) {
//                suffix=words[i].substring(j,words[i].length());
//                if (map.get(suffix)!=null&&(map.get(suffix)!=i)&&(ispalindrome(words[i],0, j))&&(exists.get(map.get(suffix)+""+i)==null)){
//                    String t=map.get(suffix)+""+i;
//                    exists.put(t,true);
//                    List<Integer>temp=new ArrayList<>();
//                    temp.add(map.get(suffix));
//                    temp.add(i);
//                    ans.add(new ArrayList<>(temp));
//                }
//            }
//        }
//        return ans;
//    }
//    static boolean ispalindrome(String words,int st,int end){
//        end=end-1;
//        while (st<end){
//            if (words.charAt(st)==words.charAt(end)){
//                st++;
//                end--;
//            }else return false;
//        }
//        return true;
//    }
    static public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>>ans=new ArrayList<>();
        HashMap<String,Integer>maps=new HashMap<>();
        String te;
        for(int i=0;i<words.length;i++){
            te=new StringBuffer(words[i]).reverse().toString();
            maps.put(te,i);
        }
        HashMap<String,Boolean>exists=new HashMap<>();
        for(int i=0;i<words.length;i++){
            if((maps.get("")!=null)&&(maps.get("")!=i)&&(ispalindrome(words[i],0,words[i].length()))&&(exists.get(i+""+maps.get(""))==null)){
                String t1=i+""+maps.get("");
                exists.put(t1,true);
                List<Integer>temp=new ArrayList<>();
                temp.add(i);
                temp.add(maps.get(""));
                ans.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
                temp.remove(temp.size()-1);
                temp.add(maps.get(""));
                temp.add(i);
                ans.add(new ArrayList<>(temp));
            }
            String prefix;
            for(int j=0;j<words[i].length();j++){
                prefix=words[i].substring(0,j+1);
                if(maps.get(prefix)!=null&&(maps.get(prefix)!=i)&&ispalindrome(words[i],j+1,words[i].length())&&(exists.get(i+""+maps.get(prefix))==null)){
                    String t2=i+""+maps.get(prefix);
                    exists.put(t2,true);
                    List<Integer>temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(maps.get(prefix));
                    ans.add(new ArrayList<>(temp));
                }
            }
            String suffix;
            for(int j=words[i].length()-1;j>=0;j--){
                suffix=words[i].substring(j,words[i].length());
                if(maps.get(suffix)!=null&&(maps.get(suffix)!=i)&&(ispalindrome(words[i],0,j))&&(exists.get(maps.get(suffix)+""+i)==null)){
                    String t3=maps.get(suffix)+""+i;
                    exists.put(t3,true);
                    List<Integer>temp=new ArrayList<>();
                    temp.add(maps.get(suffix));
                    temp.add(i);
                    ans.add(new ArrayList<>(temp));
                }
            }

        }
        return ans;
    }
   static boolean ispalindrome(String word,int st,int end){
        end=end-1;
        while(st<end){
            if(word.charAt(st)==word.charAt(end)){
                st++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }


}
