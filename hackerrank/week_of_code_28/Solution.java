import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.math.BigInteger;


public class Solution {

	private static BigInteger [] pow2;

	private static void init() {
		BigInteger two = new BigInteger("2");
		pow2[0] = new BigInteger("1");
		for(int i=1; i < 35; i++) {
			pow2[i] = pow2[i-1].multiply(two);
		}
	}



	private static BigInteger solve(String n) {
		int flag = 0;
		BigInteger ans = BigInteger.ZERO;
		int length = n.length()-1;

		for(int i = length; i >= 0; i--) {
			char bit = n.charAt(i);
			
			if (bit == '1') {
				if (flag == 0) {
					ans = pow2[i];
					flag = 1;
				}
				else
					ans = ans.subtract(pow2[i]);
			}
		}
		return ans.subtract(BigInteger.ONE);

	}

    public static void main(String[] args) {
        pow2 = new BigInteger[35];
        init();

        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        BigInteger n;

        for(int a0 = 0; a0 < q; a0++){
            //long x = in.nextLong();
            // your code goes here
        	n = in.nextBigInteger();
        	String binary = n.toString(2);

        	StringBuilder input = new StringBuilder();
        	input.append(binary);

        	
        	System.out.println( solve(input.reverse().toString()) );
        }
    }
}