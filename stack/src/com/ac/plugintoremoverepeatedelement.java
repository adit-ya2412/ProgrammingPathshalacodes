package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class plugintoremoverepeatedelement {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input=(br.readLine().trim());
        StringBuilder re=new StringBuilder();
        for (int i = 0; i <input.length() ; i++) {
            if (re.length()==0)re.append(input.charAt(i));
            else if (re.charAt(re.length()-1)==input.charAt(i)){
                re.deleteCharAt(re.length()-1);
            }else {
                re.append(input.charAt(i));
            }
        }
        System.out.println(re);
//        for (int i = 0; i <input.length() ; i++) {
//            if (st.empty())st.push(input.charAt(i));
//            else{
//                if (st.peek()==input.charAt(i)){
//                    st.pop();
//                }else {
//                    st.push(input.charAt(i));
//                }
//            }
//        }
//        StringBuilder re=new StringBuilder();
//        while (!st.isEmpty()){
//            re.insert(0,st.pop());
//        }
//        System.out.println(re);
    }
}
