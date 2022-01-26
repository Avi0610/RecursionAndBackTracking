package com.avinash.backTracck;
/*
 * The Famous NQueens Problem Programmmed By Avinash Singh
 * Using Backtracking Algorithm
 * 
 */

import java.util.Scanner;

public class NQueensProblem {
	
	public static int size;
	public static int tracker = 0;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size");
		size = sc.nextInt();
		int arr[][] = new int[size][size];
		
		arr[0][0] = 0;
		solver(arr,size,0);
		if(tracker == 0) {
			System.out.println("No Solutionn is possibble");
		}
	}
	
	public static void solver(int arr[][], int size, int i) {
		
		if(size == i) {
			tracker++;
			System.out.println(tracker+" Possible Solution is");
			for(int k = 0; k < size; k++) {
				for(int j = 0; j < size; j++) {
					System.out.print(arr[k][j]+"\t");
				}
				System.out.println();
			}
			
		}
		
		
		else {
			for(int k = 0; k < size; k++) {
				arr[i][k] = 1;
				if(isValid(arr,size,i,k)) {
					solver(arr,size,i+1);
				}
				arr[i][k] = 0;
			}
		}
	}
	
	public static boolean isValid(int[][] arr,int size, int i, int j) {
		int count = 0;
		for(int k = 0; k < size; k++) {
			if(arr[i][k] != 0) {
				count++;
			}
			if(count > 1) {
				return false;
			}
		}
		count = 0;
		for(int k = 0; k < size; k++) {
			if(arr[k][j] != 0) {
				count++;
			}
			
			if(count > 1) {
				return false;
			}
		}
		count = 0;
		int row = i;
		int col = j;
		while(row < size && col < size) {
			if(arr[row][col] != 0) {
				count++;
			}
			if(count > 1)  {
				
				return false;
			}
			row++;
			col++;
		}
		row = i;
		col = j;
		count = 0;
		while(row >= 0 && col >= 0) {
			if(arr[row][col] != 0) {
				count++;
			}
			if(count > 1) {
				return false;
			}
			row--;
			col--;
		}
		row = i;
		col = j;
		count = 0;
		while(row < size && col >= 0) {
			if(arr[row][col] != 0) {
				count++;
			}
			if(count > 1) {
				return false;
			}
			
			col--;
			row++;
		}
		row = i;
		col = j;
		count = 0;
		while(row >= 0 && col < size) {
			if(arr[row][col] != 0) {
				count++;;
			}
			if(count > 1) {
				return false;
			}
			col++;;
			row--;
		}
		return true;
	}

}
