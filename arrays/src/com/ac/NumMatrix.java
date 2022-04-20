package com.ac;
class matrix{
    public static void main(String[] args) {
        int[][]arr={{1,2,3},{4,5,6},{7,8,9}};
        NumMatrix obj=new NumMatrix(arr);
        System.out.println(obj.sumRegion(1,2,2,2));
    }
}
class NumMatrix {
     int[][]ans;
    public NumMatrix(int[][] matrix) {
         int n=matrix.length;
        int m=matrix[0].length;
        ans=new int[n][m];

        for (int i = 0; i <matrix.length ; i++) {
            ans[i][0]=matrix[i][0];
            for (int j = 1; j <matrix[0].length ; j++) {
                ans[i][j]=ans[i][j-1]+matrix[i][j];
            }
        }
        for (int i = 0; i < ans[0].length ; i++) {
            for (int j =1; j <ans.length ; j++) {
                ans[j][i]=ans[j-1][i]+ans[j][i];
            }
        }
    }

    public int sumRegion(int i1, int j1, int i2, int j2) {
       int sum;
        sum=ans[i2][j2];
        if (!(j1-1<0)&&(!(i1-1<0))){
            sum-=ans[i2][j1-1];
            sum-=ans[i1-1][j2];
            sum+=ans[i1-1][j1-1];
        }else{
            if (j1-1<0&&(i1-1>=0)){
                sum-=ans[i1-1][j2];
            }else if (i1-1<0&&(j1-1>=0)){
                sum-=ans[i2][j1-1];
            }
        }
        return sum;
    }
}


/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */