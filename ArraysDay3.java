import java.util.HashMap;

public class ArraysDay3 {
    void BruteForceMissingNumber(int []arr,int N){
        // TC -> O(N * N ) -> O(N^2) -> In the Worst Scenario
        // SC -> O(1)
        for(int i=1;i<=N;i++){
            boolean flag = false;
            for(int j=0;j<arr.length;j++){
                if(arr[j] == i){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println("Missing Number: " + i);
                break;
            }
        }
    }
    void BetterSolutionMissingNumber(int []arr,int N){
        // TC -> O(N + N) -> O(2N)
        // SC -> O(N+1) -> O(N)
        int[] hash = new int[N+1];
        for(int i=0;i<arr.length;i++){
            hash[arr[i]]++;
        }
        for(int i=1;i<=N;i++){
            if(hash[i] == 0){
                System.out.println("Missing Number: " + i);
                break;
            }
        }
    }
    void OptimalSolutionMissingNumberUsingSumMethod(int []arr,int N){
        // TC -> O(N)
        // SC -> O(1)
        int sum = N * (N+1)/2;
        int sum2 = 0;
        for(int i=0;i<arr.length;i++){
            sum2 += arr[i];
        }
        System.out.println("Missing Number: " + (sum-sum2));
    }
    void OptimalSolutionMissingNumberUsingXORMethod(int[] arr,int N){
        // TC -> O(N)
        // SC -> O(1)
        int xor1=0,xor2=0;
        for(int i=0;i<N-1;i++){
            xor2 ^= arr[i];
            xor1 ^= i+1;
        }
        xor1 ^= N;
        System.out.println("Missing Number: " + (xor1 ^ xor2));
    }
    int OptimalMaximumConsecutiveOnes(int[] arr){
        // TC -> O(N)
        // SC -> O(1)
        int cnt=0,maxi=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 1){
                cnt++;
                maxi = Math.max(maxi,cnt);
            }else{
                cnt = 0;
            }
        }
        return maxi;
    }
    void BruteForceNumberThatAppearsOnce(int[] arr){
        // TC -> O(N*N) -> O(N^2)
        // SC -> O(1)
        for(int i=0;i<arr.length;i++){
            int num = arr[i],cnt=0;
            for(int j=0;j<arr.length;j++){
                if(num == arr[j]){
                    cnt++;
                }
            }
            if(cnt == 1){
                System.out.println("Number That Appears Once: " + num);
                break;
            }
        }
    }
    void BetterSolutionNumberThatAppearOnce(int []arr){
        // TC -> O(N) + O(N/2 + 1) -> O(N)
        // SC -> O(N/2 + 1)
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(HashMap.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                System.out.println("Number That Appears Once: " + entry.getKey());
                break;
            }
        }
    }
    void OptimalSolutionNumberThatAppearOnce(int[] arr){
        // TC -> O(N)
        // SC -> O(1)
        int xor = 0;
        for(int i=0;i<arr.length;i++){
            xor ^= arr[i];
        }
        System.out.println("Number That Appears Once: " + xor);
    }
    public static void main(String[] args) {
        ArraysDay3 ad3 = new ArraysDay3();
        int[] arr = {1,1,2,3,3,4,4,5,5};
        //ad3.OptimalSolutionMissingNumberUsingXORMethod(arr,5);
        //System.out.println("Maximum Consecutive Ones: " + ad3.OptimalMaximumConsecutiveOnes(arr));
        ad3.BruteForceNumberThatAppearsOnce(arr);
        ad3.BetterSolutionNumberThatAppearOnce(arr);
        ad3.OptimalSolutionNumberThatAppearOnce(arr);
    }
}
