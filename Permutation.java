package com.avinash.backTracck;
/*
*This programme generates all the permutations of a String
*
*
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Permutation {
	public static String str = new String();
	

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the String");
		str = br.readLine();
		
		permutate(str,0,str.length());
	}
	
	public static String swap(String str, int i, int j) {
		char c[] = str.toCharArray();
		char temp = c[i];
		c[i] = c[j];;
		c[j] = temp;
		return new String(c);
	}
	
	
	public static void permutate(String str, int start, int end ){
		if(start == end) {
			System.out.println(str);
			return;
		}
		else {
			for(int i = start; i < end; i++) {
				str  = swap(str, start, i);
				permutate(str, start+1, end);
				str = swap(str,start,i);
				
				
			}
		}
	}
	
	
	
	
}
