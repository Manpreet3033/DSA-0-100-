import java.util.Arrays;
import java.util.HashSet;

public class BasicsOfArray {
    int BruteForceLargestInAnArray(int [] arr){
        // TC -> Sorting Array = O (N log (N))
        Arrays.sort(arr);
        int n = arr.length;
        return arr[n-1];
    }
    int OptimalLargestInAnArray(int[] arr){
        // TC -> O(N) -> Most Optimal Solution for Largest Element in An Array...
        int largest = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i] > largest) largest = arr[i];
        }
        return largest;
    }
    int BruteForceSecondLargestInArray(int[] arr){
        // TC -> O(N log(N)) + O(N)
        Arrays.sort(arr);
        int n = arr.length;
        int largest = arr[n-1];
        int secondLargest = -1;
        for(int i=n-2;i>=0;i--){
            if(arr[i] != largest){
                secondLargest = arr[i];
                break;
            }
        }
        return secondLargest;
    }
    int BetterSecondLargestInArray(int[] arr){
        //  TC -> O(2N) -> Better Than Brute force but can be optimized more
        int largest = arr[0];
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        int secondLarge = -1;
        for(int i=0;i<n;i++){
            if(arr[i] > secondLarge && arr[i] != largest){
                secondLarge = arr[i];
            }
        }
        return secondLarge;
    }
    int OptimalSecondLargestInArray(int[] arr){
        // TC -> O(N) -> Most Optimal Solution
        int n = arr.length;
        int largest = arr[0];
        int secondLarge = -1;
        for(int i=0;i<n;i++){
            if(arr[i] > largest){
                secondLarge = largest;
                largest = arr[i];
            }else if(arr[i] > secondLarge && arr[i] < largest){
                secondLarge = arr[i];
            }
        }
        return secondLarge;
    }
    int OptimalSecondSmallest(int[] arr){
        // TC -> O(N) -> Most Optimal Solution
        // We Initialized ssmall as Max Value because we need to find smallest element
        int n = arr.length;
        int small = arr[0],ssmall = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i] < small){
                ssmall = small;
                small = arr[i];
            }else if(arr[i] > small && arr[i] < ssmall){
                ssmall = arr[i];
            }
        }
        return ssmall;
    }
    int BruteForceRemoveDuplicatesFromArray(int[] arr){
        // It is Brute force as Set take O(N log(N)) Time Complexity to Insert a Element in it
        // TC -> O(N log (N)) + O(N)
        // SC -> O(N)
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int ind = 0;
        for(int num: set){
            arr[ind] = num;
            ind++;
        }
        return ind;
    }
    int OptimalRemoveDuplicatesFromArray(int[] arr){
        // TC -> O(N)
        // SC -> O(1)
        int i = 0;
        for(int j=1;j<arr.length;j++){
            if(arr[i] != arr[j]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        BasicsOfArray boa = new BasicsOfArray();
        int[] arr = {-3,-1,0,0,0,3,3};
        System.out.println(boa.OptimalRemoveDuplicatesFromArray(arr));
    }
}
