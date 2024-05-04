public class RecursionDay2 {
    int factorial(int n){
        if(n == 1 || n == 0) return n;
        return n * factorial(n-1);
    }
    static void swap(int i,int j,int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void reverse(int i,int n,int[] nums){
        if(i >= n/2) return;
        swap(i,n-i-1,nums);
        reverse(i+=1,n,nums);
    }
    public static int[] reverseArray(int n, int []nums) {
        reverse(0,n,nums);
        return nums;
    }
    static boolean f(int i,int j,String s){
        if(i >= j/2) return true;
        if(s.charAt(i) != s.charAt(j-i-1)) return false;
        return f(i+=1,j,s);
    }
    public static boolean isPalindrome(String str) {
        // Write your code here.
        return f(0,str.length(),str);
    }
    public static void main(String[] args) {
        RecursionDay2 rc2 = new RecursionDay2();
        System.out.println(rc2.factorial(5));
        int[] arr = {1,2,3,4,5};
        int[] rev = reverseArray(5,arr);
        for(int i=0;i<rev.length;i++){
            System.out.print(rev[i] + " ");
        }
        System.out.println();
    }
}
