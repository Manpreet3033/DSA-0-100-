import java.util.HashMap;
import java.util.Scanner;

public class BasicHashing {
    Scanner in = new Scanner(System.in);
    void numberHashing(){
        int n = in.nextInt();
        int []arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        // Precompute
        //int []hash = new int[13];
        int []hash = new int[(int)1e9+1];
        for(int i=0;i<n;i++){
            hash[arr[i]]++;
        }

        System.out.println(hash.length);

        int q = in.nextInt();
        while(q-- != 0){
            int num = in.nextInt();
            // Fetch from Hash
            System.out.println(hash[num]);
        }
    }

    void characterHashing(){
        String s = in.nextLine();
        int []hash = new int[26];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
        }
        int q = in.nextInt();
        while(q-- != 0){
            char c = in.next().charAt(0);
            System.out.println(hash[c-'a']);
        }
    }
    void numberHashingUsingMap(){
        int n = in.nextInt();
        int []arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(HashMap.Entry<Integer,Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        int q = in.nextInt();
        while(q-- != 0){
            int num = in.nextInt();
            if(map.get(num) == null) {
                System.out.println(0);
            }else{
                System.out.println(map.get(num));
            }
        }
    }
    void characterHashingUsingMap(){
        String s = in.nextLine();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(HashMap.Entry<Character,Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        int q = in.nextInt();
        while(q-- != 0){
            char c = in.next().charAt(0);
            if(map.get(c) == null) {
                System.out.println(0);
            }else{
                System.out.println(map.get(c));
            }
        }
    }
    public static int[] getHighestAndLowestFrequenciesElement(int[] v) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < v.length; i++) {
            map.put(v[i], map.getOrDefault(v[i], 0) + 1);
        }
        int lowestFreq = Integer.MAX_VALUE;
        int lowestVal = Integer.MAX_VALUE;
        int highestFreq = Integer.MIN_VALUE;
        int highestVal = Integer.MAX_VALUE;
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getKey();
            int frequency = entry.getValue();
            if (frequency <= lowestFreq) {
                if (frequency < lowestFreq) {
                    lowestFreq = frequency;
                    lowestVal = value;
                } else {
                    lowestVal = Math.min(value, lowestVal);
                }
            }
            if (frequency >= highestFreq) {
                if (frequency > highestFreq) {
                    highestFreq = frequency;
                    highestVal = value;
                } else {
                    highestVal = Math.min(value, highestVal);
                }
            }
        }
        return new int[]{highestVal, lowestVal};
    }
    public static void main(String[] args) {
        /*
        Input Criteria: Size of Array, Elements of Array, Total Numbers to Search, Input Number that need to be searched
        Array size = 5
        Array[] = 1 3 2 1 3
        Total Num to Search = 5
        Input = 1 2 3 12 10
        */
        BasicHashing bh = new BasicHashing();
        bh.characterHashingUsingMap();
    }
}