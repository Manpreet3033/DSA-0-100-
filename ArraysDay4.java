import java.util.HashMap;

public class ArraysDay4 {
    void BruteForceLongestSubArraySumEqualsKWithOnlyPositivesAndZeroes(int[] arr,int d){
        // TC -> O(N*N) -> O(N^2)
        // SC -> O(1)
        int len = 0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            int sum = 0;
          for(int j=i;j<n;j++){
              sum += arr[j];
              if(sum == d){
                  len = Math.max(len,j-i+1);
              }
          }
        }
        System.out.println("Max Length: " + len);
    }
    void BetterSolutionLongestSubArraySumEqualsKWithOnlyPositivesAndZeroes(int[] arr,int k){
        // TC -> O(N)
        // SC -> O(N)
        HashMap<Integer,Integer> map = new HashMap<>();
        int len=0,prefixSum=0;
        for(int i=0;i<arr.length;i++){
            prefixSum += arr[i];
            if(prefixSum == k){
                len = Math.max(len,i+1);
            }
            int remaining = prefixSum - k;
            if(map.containsKey(remaining)){
                int newLen = i - map.get(remaining);
                len = Math.max(len,newLen);
            }
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum,i);
            }
        }
        System.out.println("Max Length: " + len);
    }
    void OptimalSolutionLongestSubArraySumEqualsKWithOnlyPositivesAndZeroes(int[] arr,int k){
        // TC -> O(2N)
        // SC -> O(1)
        int left=0,right=0,len=0;
        int sum = arr[0];
        while(right < arr.length){
            while(left <= right && sum > k){
                sum -= arr[left];
                left++;
            }
            if(sum == k){
                len = Math.max(len,right-left+1);
            }
            right++;
            if(right < arr.length){
                sum += arr[right];
            }
        }
        System.out.println("Max Length: " + len);
    }
    void OptimalSolutionLongestSubArraySumEqualsKWithPositivesAndNegatives(int[] arr,int k){
        // TC -> O(N)
        // SC -> O(N)
        HashMap<Integer,Integer> map = new HashMap<>();
        int len=0,prefixSum=0;
        for(int i=0;i<arr.length;i++){
            prefixSum += arr[i];
            if(prefixSum == k){
                len = Math.max(len,i+1);
            }
            int remaining = prefixSum - k;
            if(map.containsKey(remaining)){
                int newLen = i - map.get(remaining);
                len = Math.max(len,newLen);
            }
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum,i);
            }
        }
        System.out.println("Max Length: " + len);
    }
    public static void main(String[] args) {
        ArraysDay4 ad4 = new ArraysDay4();
        int[] arr = {1,2,3,1,1,1,1,4,2,3};
        ad4.OptimalSolutionLongestSubArraySumEqualsKWithOnlyPositivesAndZeroes(arr,4);
    }
}
