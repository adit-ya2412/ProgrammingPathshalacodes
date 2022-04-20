import java.util.Scanner;

public class rainbowarray {
    public static void main(String[] args) {

        int[]arr={1,2,3,7,3,2,1};
        solve(arr);

    }
    static void solve(int[]arr)
    {
       int n=arr.length;

        // logic
        int start=0, last=n-1;
        boolean flag = true;

        // check if first element is 1 or not
        if(arr[0] != 1){
            flag = false;
        }else{
//            0 1 2 3 4 5 6 7 8 9 10 11  12 13  14  15  16   17  18
//            1 2 3 4 4 5 6 6 6 7  6  6  6   5  4   4   3    2   1
            while(start<last){
                // check first condition
                if(arr[start] != arr[start+1] && arr[start]+1 != arr[start+1]){
                    flag = false;
                    break;
                }
                // check second condtition
                if(arr[start] != arr[last]){
                    flag = false;
                    break;
                }
                last--;
                start++;
            }
            // after the loop breaks check the start pointer is 7 or not
            // becuse mid element have to be 7
            if(arr[start] != 7){
                flag = false;
            }

            // condition to print result
            if(flag){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }


    }
    }

