public class QuickSort {
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static int sort(int[] arr,int low,int high){
        int i = low,j = high,pivot=arr[low];
        while(i < j){
            while(arr[i] <= pivot && i <= high-1){
                i++;
            }
            while(arr[j] > pivot && j >= low+1){
                j--;
            }
            if(i < j){
                swap(arr, i, j);
            }
        }
        swap(arr,low,j);
        return j;
    }

    private static void qs(int[] arr,int low,int high){
        if(low < high){
            int partition = sort(arr,low,high);
            qs(arr, low, partition-1);
            qs(arr, partition+1, high);
        }else return;
    }
    public static void quickSort(int[] input,int startIndex, int endIndex) {
        qs(input,startIndex,endIndex);
    }

    public static void main(String[] args) {
        int[] arr = {10,80,30,90,40};
        for(int num: arr){
            System.out.print(num + " ");
        }
        System.out.println();
        quickSort(arr,0,arr.length-1);
        for(int num: arr){
            System.out.print(num + " ");
        }
    }
}
