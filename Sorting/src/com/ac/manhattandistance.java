package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class manhattandistance {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int xn=Integer.parseInt(in.readLine().trim());
        int yn=xn;
        int[]xcord=new int[xn];
        int[]ycord=new int[yn];
        String[]elementsofx=(in.readLine().trim()).split("\\s+");
        String[]elementsofy=(in.readLine().trim()).split("\\s+");
        int sumx=0;
        int sumy=0;
        for (int i = 0; i <xn ; i++) {
            xcord[i]=Integer.parseInt(elementsofx[i]);
            sumx+=xcord[i];
            ycord[i]=Integer.parseInt(elementsofy[i]);
            sumy+=ycord[i];
        }
        Arrays.sort(xcord);
        Arrays.sort(ycord);
        int manhatanofx=0;
        int manhatanofy=0;
        for (int i = 0; i <xn ; i++) {
            int point=xcord[i];
            sumx=sumx-point;
            manhatanofx+=sumx-((xn-(i+1))*point);
        }
        for (int i = 0; i <yn ; i++) {
            int point=ycord[i];
            sumy=sumy-point;
            manhatanofy+=sumy-((yn-(i+1))*point);
        }
        System.out.println(manhatanofx+manhatanofy);
    }
}
