import java.util.ArrayList;
import java.util.HashSet;

public class ArraysDay2 {
    void LeftRotateArrayByOnePlace(int []arr){
        // TC -> O(N)
        // SC -> O(1)
        int n = arr.length;
        int temp = arr[0];
        for(int i=1;i<n;i++){
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;
    }
    void BruteForceLeftRotateArrayByKPlaces(int[] arr,int k){
        // TC -> O(K) + O(N-K) + O(K)
        // SC -> O(K)
        int[] temp = new int[k];
        for(int i=0;i<k;i++){
            temp[i] = arr[i];
        }
        for(int i=k;i<arr.length;i++){
            arr[i-k] = arr[i];
        }
        for(int i=arr.length-k;i<arr.length;i++){
            arr[i] = temp[i-(arr.length-k)];
        }
    }
    void swap(int []arr,int s,int e){
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
    void reverse(int[] arr,int s,int e){
        while(s < e){
            swap(arr,s,e);
            s++;
            e--;
        }
    }
    void OptimalLeftRotateArrayByKPlaces(int[] arr,int k){
        // TC -> O(K) + O(N-K) + O(N) -> O(N)
        // SC -> O(1)
        if(k > arr.length) k = k % arr.length;
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
        reverse(arr,0,arr.length-1);
    }
    void BruteForceMoveZeroesToEndOfArray(int[] nums){
        // TC -> O(N) + O(X) + O(N-X) -> O(2N)
        // SC -> O(X)
        ArrayList<Integer> temp = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] != 0){
                temp.add(nums[i]);
            }
        }
        for(int i=0;i<temp.size();i++){
            nums[i] = temp.get(i);
        }
        for(int i=temp.size();i<n;i++){
            nums[i] = 0;
        }
    }
    void OptimalMoveZeroesToEndOfArray(int[] nums){
        // TC -> O(X) + O(N-X) -> O(N)
        // SC -> O(1)
        int j = -1,n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                j = i;
                break;
            }
        }
        if(j == -1) return;
        for(int i=j+1;i<n;i++){
            if(nums[i] != 0){
                swap(nums,i,j);
                j++;
            }
        }
    }
    int LinearSearch(int[] arr,int num){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == num) return i;
        }
        return -1;
    }
    ArrayList<Integer> BruteForceUnionOfArray(int[] arr1,int[] arr2){
        // TC -> O(N log N) (Storing Unique Element of arr1) + O(M log N) (Storing Unique Element of arr2)+ O(N + M) (Iterating over the Set)
        // SC -> O(N+M) (Size of Set) + O(N+M) (Size of ArrayList)
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int num: set){
            ans.add(num);
        }
        return ans;
    }
    ArrayList<Integer> OptimalUnionOfArray(int[] arr1,int[] arr2){
        // TC -> O(N+M)
        // SC -> O(N+M) -> For returning the answer and not solving...
        int i=0,j=0,n=arr1.length,m=arr2.length;
        ArrayList<Integer> union = new ArrayList<>();
        while(i < n && j < m){
            if(arr1[i] <= arr2[j]){
                if(union.isEmpty() || union.get(union.size()-1) != arr1[i]){
                    union.add(arr1[i]);
                }
                i++;
            }else{
                if(union.isEmpty() || union.get(union.size()-1) != arr2[j]){
                    union.add(arr2[j]);
                }
                j++;
            }
        }
        while(i < n){
            if(union.isEmpty() || union.get(union.size()-1) != arr1[i]){
                union.add(arr1[i]);
            }
            i++;
        }
        while(j < m){
            if(union.isEmpty() || union.get(union.size()-1) != arr2[j]){
                union.add(arr2[j]);
            }
            j++;
        }
        return union;
    }
    ArrayList<Integer> BruteForceIntersectionOfArray(int[] arr1,int[] arr2){
        // TC -> O(N*M)
        // SC -> O(M) -> For visited array
        int n=arr1.length,m=arr2.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int[] vis = new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr1[i] == arr2[j] && vis[j] == 0){
                    ans.add(arr1[i]);
                    vis[j] = 1;
                    break;
                }
                if(arr2[j] > arr1[i]) break;
            }
        }
        return ans;
    }
    ArrayList<Integer> OptimalIntersectionOfArray(int[] arr1,int[] arr2){
        // TC -> O(N+M)
        // SC -> O(1)
        int n=arr1.length,m=arr2.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0,j=0;
        while(i < n && j < m){
            if(arr2[j] > arr1[i]){
                i++;
            }else if(arr2[j] < arr1[i]){
                j++;
            }else{
                ans.add(arr1[i]);
                i++;
                j++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ArraysDay2 array = new ArraysDay2();
        int []arr = {1,2,3,4,5};
        for(int num: arr){
            System.out.print(num + " ");
        }
        System.out.println();
        array.OptimalLeftRotateArrayByKPlaces(arr,2);
        for(int num: arr){
            System.out.print(num + " ");
        }
    }
}
