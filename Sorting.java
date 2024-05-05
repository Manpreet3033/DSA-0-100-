import java.util.ArrayList;

public class Sorting {
    void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    void selectionSort(int []arr){
        // TC = O(N^2)
        for(int i=0;i<=arr.length-2;i++){
            int minIdx = i;
            for(int j=i;j<arr.length;j++){
                if(arr[j] <= arr[minIdx]){
                    minIdx = j;
                }
            }
            if(minIdx != i) swap(arr,minIdx,i);
        }
    }
    void bubbleSortRecursive(int[] arr,int n){
        if(n == 1) return;
        boolean swapped = false;
        for(int j=0;j<=n-2;j++){
            if(arr[j] > arr[j+1]){
                swapped = true;
                swap(arr, j, j+1);
            }
        }
        if(!swapped) return;
        bubbleSortRecursive(arr, n-1);
    }
    void bubbleSort(int[] arr){
        //TC-> O(N^2) -> Average and Worst Case
        //TC-> O(N) -> Best Case
        //We are keeping a check if a swap happens then we move ahead
        //else we break from the loop
        int swapCnt = 0;
        for(int i=arr.length-1;i>=1;i--){
            boolean swapped = false;
            for(int j=0;j<=i-1;j++){
                if(arr[j] > arr[j+1]){
                    swapped = true;
                    swap(arr,j,j+1);
                }
            }
            if(!swapped) break;
            swapCnt++;
            System.out.println("swap no: " + swapCnt);
        }
    }
    void insertionSort(int[] arr){
        //TC-> O(N^2) -> Average and Worst Case
        //TC-> O(N) -> Best Case
        for(int i=0;i<arr.length;i++){
            int j = i;
            while(j > 0 && arr[j-1] > arr[j]){
                swap(arr,j,j-1);
                j--;
            }
        }
    }
    void merge(int[]arr,int l,int mid,int r){
        ArrayList<Integer> list = new ArrayList<>();
        int left = l,m = mid+1;
        while(left <= mid && m <= r){
            if(arr[left] <=  arr[m]){
                list.add(arr[left]);
                left++;
            }else{
                list.add(arr[m]);
                m++;
            }
        }
        while(left <= mid){
            list.add(arr[left]);
            left++;
        }
        while(m <= r){
            list.add(arr[m]);
            m++;
        }
        for(int i=l;i<=r;i++){
            arr[i] = list.get(i-l);
        }
    }
    void mergeSort(int[] arr, int l, int r){
        if(l >= r) return;
        int mid = (l+r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr,l,mid,r);
    }
    public static void main(String[] args) {
        Sorting sort = new Sorting();
        int[] arr = {6,5,4,3,2,1};
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        sort.mergeSort(arr,0,arr.length-1);
        System.out.println();
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
