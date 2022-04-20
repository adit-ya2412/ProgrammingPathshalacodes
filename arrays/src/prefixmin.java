import java.util.ArrayList;
import java.util.List;

public class prefixmin {
    public static void main(String[] args) {
        int[]arr={5,-1,0,4,-2,7};
        System.out.println(premin(arr,4));
    }
    static int premin(int[]arr,int i){
        List<Integer>ls=new ArrayList<>();
        ls.add(arr[0]);
        for (int j = 1; j <arr.length ; j++) {
            ls.add(Math.min(ls.get(j-1),arr[j]));
        }
        return ls.get(i);
    }
}
