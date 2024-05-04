import java.util.Scanner;

public class BasicRecursion {
    private void f(int cnt){
       if(cnt == 3) return;
       System.out.println(cnt);
       cnt++;
       f(cnt);
    }

    private void printName(int cnt,int n){
        if(cnt > n) return;
        System.out.println("Manpreet Singh");
        cnt++;
        printName(cnt,n);
    }
    private void printNto1(int[]arr,int i,int n){
        if(i >= n) return;
        arr[i] = n-i;
        printNto1(arr,i+1,n);
    }
    private void print1toN(int i,int x,int[] arr){
        if(i >= x) return;
        arr[i] =i+1;
        print1toN(i+1, x,arr);
    }
    private long sumOfFirstNNaturalNumbers(long n){
        if(n == 0) return 0;
        return n + sumOfFirstNNaturalNumbers(n-1);
    }
    private void print1toNusingBacktrack(int i,int n){
        if(i < 1) return;
        print1toNusingBacktrack(i-1,n);
        System.out.println(i);
    }
    private void printNto1usingBacktrack(int i,int n){
        if(i < 1) return;
        System.out.println(i);
        printNto1usingBacktrack(i-1,n);
    }
    public static void main(String[] args) {
        BasicRecursion br = new BasicRecursion();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        br.print1toNusingBacktrack(n,n);
        br.printNto1usingBacktrack(n,n);
    }
}
