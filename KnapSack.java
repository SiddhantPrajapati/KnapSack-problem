// Java program to solve fractional Knapsack Problem
import java.util.*;
import java.util.*;
 
// Greedy approach
public class KnapSack {
    // function to get maximum value
    private static double getMaxValue(ItemValue[] arr,int capacity){
        // sorting items by value/weight ratio;
        Arrays.sort(arr, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue item1,ItemValue item2){
                double cpr1= new Double((double)item1.value/ (double)item1.weight);
                double cpr2= new Double((double)item2.value/ (double)item2.weight);
				//compare two ratio
                if (cpr1 < cpr2)
                    return 1;
                else
                    return -1;
            }
        });

        double totalValue = 0d;
        for (ItemValue i : arr) {
            int curWt = (int)i.weight;
            int curVal = (int)i.value;
            if (capacity - curWt >= 0) {
                // this weight can be picked while
                capacity = capacity - curWt;
                totalValue += curVal;
            }
            else {
                // item cant be picked whole
                double fraction = ((double)capacity / (double)curWt);
                totalValue += (curVal * fraction);
                capacity = (int)(capacity - (curWt * fraction));
                break;
            }
        }
        return totalValue;
    }
 
    // item value class
    static class ItemValue {
        int value, weight;
        // item value function
        public ItemValue(int val, int wt){
            this.weight = wt;
            this.value = val;
        }
    }
 
    // Driver's code
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("How many item:");
		int n = sc.nextInt();
		ItemValue[] arr = new ItemValue[n];
		for(int i=0; i<n ; i++){
		System.out.println("Enter value & weight simultanuesly:");
		int a = sc.nextInt();
		int b = sc.nextInt();
        arr[i] =  new ItemValue(a, b);
		}
		System.out.println("Enter the Capacity:");
        int capacity = sc.nextInt(); 
        double maxValue = getMaxValue(arr, capacity);
        // Function call
        System.out.println("Maximum value we can obtain = "+ maxValue);
    }
}