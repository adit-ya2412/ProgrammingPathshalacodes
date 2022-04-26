package com.ac;

import java.util.ArrayList;
import java.util.List;

public class wordsearchinmatrix {
    public static void main(String[] args) {
        char[][]board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        //char[][]board={{"A","A","A","A","A","A"},{"A","A","A","A","A","A"},{"A","A","A","A","A","A"},{"A","A","A","A","A","A"},{"A","A","A","A","A","A"],["A","A","A","A","A","A"]]
        //"AAAAAAAAAAAABAA"
        //char[][]board={{'a'}};
        String word="ABCCED";
        System.out.println(exist(board,word));
    }
    static boolean exist(char[][]board,String word){
        char[]cha=word.toCharArray();
        int sum=0;
        List<Character>temp=new ArrayList<>();
        int[][]isvisited=new int[board.length][board[0].length];
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[i].length ; j++) {
                if (board[i][j] == cha[0]) {
                    temp.add(board[i][j]);
                    sum += count(board, i, j, isvisited, temp, cha);
                    if (sum != 0) return true;
                    temp.remove(temp.size()-1);
                }
            }
        }
        return false;
    }
    static int count(char[][]board,int i,int j,int[][]isvisited,List<Character>temp,char[]ch){
        if (temp.size()==ch.length){
            return 1;
        }
        isvisited[i][j]=1;
        int sum=0;
        if (issafe(board,i,j+1)&&(isvisited[i][j+1]!=1)){
            if (board[i][j+1]==ch[temp.size()]){
                temp.add(board[i][j+1]);
                sum+=count(board, i, j+1, isvisited, temp, ch);
                temp.remove(temp.size()-1);
            }
        }
        if (issafe(board,i,j-1)&&(isvisited[i][j-1]!=1)){
            if (board[i][j-1]==ch[temp.size()]){
                temp.add(board[i][j-1]);
                sum+=count(board, i, j-1, isvisited, temp, ch);
                temp.remove(temp.size()-1);
            }
        }
        if (issafe(board,i-1,j)&&(isvisited[i-1][j]!=1)){
            if (board[i-1][j]==ch[temp.size()]){
                temp.add(board[i-1][j]);
                sum+=count(board, i-1, j, isvisited, temp, ch);
                temp.remove(temp.size()-1);
            }
        }
        if (issafe(board,i+1,j)&&(isvisited[i+1][j]!=1)){
            if (board[i+1][j]==ch[temp.size()]){
                temp.add(board[i+1][j]);
                sum+=count(board, i+1, j, isvisited, temp, ch);
                temp.remove(temp.size()-1);
            }
        }
        isvisited[i][j]=0;
        return sum;
    }
   static boolean issafe(char[][]board,int i,int j){
        if ((i< board.length&&i>=0)&&(j< board[i].length&&j>=0)){
            return true;
        }
        return false;
   }
}
