package com.ac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wordboogle {
    public static void main(String[] args) {
       // String []dictionary = {"GEEKS","FOR","QUIZ","GO"};
        String[]dictionary={"bcd","db"};
       // char[][]board = {{'G','I','Z'},{'U','E','K'},{'Q','S','E'}};
        char[][]board={{'d','d'},{'b','f'},{'e','c'},{'b','c'},{'d','c'}};
        System.out.println(Arrays.toString(wordbooggle(board,dictionary)));
    }
    static String[] wordbooggle(char[][]board,String[]dictionary){
        List<String>ans=new ArrayList<>();
        for (int i = 0; i <dictionary.length ; i++) {
                for (int k = 0; k <board.length ; k++) {
                    for (int l = 0; l <board[k].length ; l++) {
                        int sum=0;
                        if (board[k][l]==dictionary[i].toCharArray()[0]){
                            int[][]isvisited=new int[board.length][board[0].length];

                            List<Character>temp=new ArrayList<>();
                            temp.add(board[k][l]);
                            sum=present(board,k,l,isvisited,temp,dictionary[i].toCharArray());
                            if (sum!=0)ans.add(dictionary[i]);
                            temp.remove(temp.size()-1);
                        }
                        if (sum!=0)break;
                    }
                    if (ans.contains(dictionary[i]))break;
                }

        }
        String []as=new String[ans.size()];
        int ind=0;
        for (String i:ans) {
            as[ind]=i;
            ind++;
        }
        return as;
    }
    static int present(char[][]board,int i,int j,int[][]isvisited,List<Character>temp,char[]arr){
        if (temp.size()== arr.length)return 1;
        isvisited[i][j]=1;
        int sum=0;
        if (issafe(board,i,j+1)&&(isvisited[i][j+1]!=1)){
            if (board[i][j+1]==arr[temp.size()]){
                temp.add(board[i][j+1]);
                sum+=present(board,i,j+1,isvisited,temp,arr);
                temp.remove(temp.size()-1);
            }
        }
        if (issafe(board,i,j-1)&&(isvisited[i][j-1]!=1)){
            if (board[i][j-1]==arr[temp.size()]){
                temp.add(board[i][j-1]);
                sum+=present(board,i,j-1,isvisited,temp,arr);
                temp.remove(temp.size()-1);
            }
        }
        if (issafe(board,i-1,j)&&(isvisited[i-1][j]!=1)){
            if (board[i-1][j]==arr[temp.size()]){
                temp.add(board[i-1][j]);
                sum+=present(board,i-1,j,isvisited,temp,arr);
                temp.remove(temp.size()-1);
            }
        }
        if (issafe(board,i+1,j)&&(isvisited[i+1][j]!=1)){
            if (board[i+1][j]==arr[temp.size()]){
                temp.add(board[i+1][j]);
                sum+=present(board,i+1,j,isvisited,temp,arr);
                temp.remove(temp.size()-1);
            }
        }
        //////////////////////////////
        //upperrightdiagonal
        if (issafe(board,i-1,j+1)&&(isvisited[i-1][j+1]!=1)){
            if (board[i-1][j+1]==arr[temp.size()]){
                temp.add(board[i-1][j+1]);
                sum+=present(board,i-1,j+1,isvisited,temp,arr);
                temp.remove(temp.size()-1);
            }
        }
        //upperleftdiagonal
        if (issafe(board,i-1,j-1)&&(isvisited[i-1][j-1]!=1)){
            if (board[i-1][j-1]==arr[temp.size()]){
                temp.add(board[i-1][j-1]);
                sum+=present(board,i-1,j-1,isvisited,temp,arr);
                temp.remove(temp.size()-1);
            }
        }
        //lowerrightdiagonal
        if (issafe(board,i+1,j+1)&&(isvisited[i+1][j+1]!=1)){
            if (board[i+1][j+1]==arr[temp.size()]){
                temp.add(board[i+1][j+1]);
                sum+=present(board,i+1,j+1,isvisited,temp,arr);
                temp.remove(temp.size()-1);
            }
        }
        //lowerleftdiagonal
        if (issafe(board,i+1,j-1)&&(isvisited[i+1][j-1]!=1)){
            if (board[i+1][j-1]==arr[temp.size()]){
                temp.add(board[i+1][j-1]);
                sum+=present(board,i+1,j-1,isvisited,temp,arr);
                temp.remove(temp.size()-1);
            }
        }
        isvisited[i][j]=0;
        return sum;
    }
    static boolean issafe(char[][]board,int i,int j){
        if ((i<board.length&&i>=0)&&(j<board[i].length&&j>=0)){
            return true;
        }
        return false;
    }
}
