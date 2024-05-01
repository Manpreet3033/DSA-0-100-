import java.util.Scanner;

public class BasicMaths {
    Scanner in = new Scanner(System.in);
    private boolean armstrongNumber(int num){
        int n = num,armNum = 0,cnt = 0;
        while(n > 0){
            int ld = n % 10;
            cnt++;
            n /= 10;
        }
        // TC = O(log(num))
        n = num;
        while(n > 0){
            int ld = n % 10;
            armNum += (int)Math.pow(ld,cnt);
            n /= 10;
        }
        // TC = O(log(num))
        return armNum == num;
    }
    private boolean armstrongNumber(){
        int num = in.nextInt();
        return  armstrongNumber(num);
    }
    private boolean palindromeNumber(int num){
        int revNum = 0,n = num;
        while(num > 0){
            int ld = num % 10;
            revNum = (revNum * 10) + ld;
            num /= 10;
        }
        // TC = O(log(num))
        return revNum == n;
    }
    private boolean palindromeNumber(){
        int num = in.nextInt();
        return palindromeNumber(num);
    }
    private int reverseNum(int num){
        int revNum = 0;
        while(num != 0){
            // Edge case as if revNum == 2147483647/10 ie 214748364 then if last digit that is being added
            // may be greater than 7 which leads to integer overflow so we return 0 for this case
            if(revNum > Integer.MAX_VALUE/10 || revNum < Integer.MIN_VALUE/10) return 0;
            int ld = num % 10;
            revNum = (revNum*10) + ld;
            num /= 10;
        }
        // TC = O(log(num))
        return revNum ;
    }
    private int reverseNum(){
        int num = in.nextInt();
        return reverseNum(num);
    }
    private int countDigitsUsingLog10(int num){
        return (int)Math.log10(num)+1;
        // TC = O(log(num))
    }
    private int countDigits(int num){
        int cnt = 0;
        while(num > 0){
            int lastDigit = num % 10;
            cnt++;
            num /= 10;
        }
        return cnt;
        // TC = O(log(num))
    }
    private int countDigits(){
        int num = in.nextInt();
        return countDigitsUsingLog10(num);
    }
    private void printAllDivisors(int num){
        for(int i=1;i*i<=num;i++){
            if(num % i == 0){
                System.out.print(i + " ");
                if(num/i != i){
                    System.out.print(num/i + " ");
                }
            }
        }
        // TC = O(sqrt(num))
    }
    private void printAllDivisors(){
        int num = in.nextInt();
        printAllDivisors(num);
    }
    private boolean isPrime(int num){
        int cnt = 0;
        for(int i=1;i*i<=num;i++){
            if(num % i == 0){
                cnt++;
                if(num/i != i) cnt++;
            }
        }
        return cnt == 2;
        // TC = O(sqrt(num))
    }
    private boolean isPrime(){
        int num = in.nextInt();
        return isPrime(num);
    }
    private int gcd(int a,int b){
        while(a > 0 && b > 0){
            if(a > b){
                a = a % b;
            }else{
                b = b % a;
            }
        }
        return (a == 0) ? b : a;
    }
    private int gcd(){
        int a = in.nextInt();
        int b = in.nextInt();
        return gcd(a,b);
    }
    public static void main(String[] args) {
        BasicMaths bm = new BasicMaths();
//        int ans = bm.countDigits();
//        System.out.println(ans);
//        int revNum = bm.reverseNum();
//        System.out.println(revNum);
//        boolean palindrome = bm.palindromeNumber();
//        System.out.println(palindrome);
//        System.out.println(bm.armstrongNumber());
//        bm.printAllDivisors();
//        System.out.println(bm.isPrime());
        System.out.println(bm.gcd());
    }
}
