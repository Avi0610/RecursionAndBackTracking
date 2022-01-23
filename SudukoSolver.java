/*
 * Here our task is to fill the every empty grid say cell
 * represented with 0 with any number between 1 to 9
 * so that every row every column and every sub grid has a unique digit  
 */

public class SudukoSolver {
	public static int count = 0;
	
	public static void main(String args[]) {
		
		
		int arr[][] = {
				{5,3,0,0,7,0,0,0,0},
				{6,0,0,1,9,5,0,0,0},
				{0,9,8,0,0,0,0,6,0},
				{8,0,0,0,6,0,0,0,3},
				{4,0,0,8,0,3,0,0,1},
				{7,0,0,0,2,0,0,0,6},
				{0,6,0,0,0,0,2,8,0},
				{0,0,0,4,1,9,0,0,5},
				{0,0,0,0,8,0,0,7,9}	
		};
		System.out.println("start");
		solver(arr,0,0,9);
		System.out.println("end");
		
	}
	
	public static void solver(int arr[][], int row,  int col, int size)  {

		if(row == size - 1  && col == size - 1) {
			count++;
			System.out.println("Marix No"+" "+count);
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					System.out.print(arr[i][j]+"\t");
				}
				System.out.println();
			}
			return;
		}
				
		else if(col < size ) {

			if(arr[row][col] == 0) {
				for(int val =1; val <= 9; val++) {
					arr[row][col] = val;
					if(isValid(arr,row,col,size)) {
						solver(arr,row,col+1,size);
					}
					arr[row][col] = 0;
				}
			}
			else {
				solver(arr,row,col+1,size);
			}
		}
		else {
			if(col == size)  {
				solver(arr,row+1,0,size);
			}

		}
		
		
	}
	
	public static boolean isValid(int arr[][], int row, int col, int  size) {
		int ref1[] = new int[9];	
		ref1[0]  = 0;
		
		//Validating the Row
		for(int i = 0; i < size; i++)  {
			if(arr[row][i] != 0) {
				int ele = arr[row][i];
				ref1[ele-1] += 1;
				if(ref1[ele - 1] > 1) {
					return false;
				}
			}
		}
		
		int ref2[] = new int[9];	
		ref2[0]  = 0;
		
		//Validating the Col
		for(int i = 0; i < size; i++)  {
			if(arr[i][col] != 0) {
				int ele = arr[i][col];
				ref2[ele-1] += 1;
				if(ref2[ele - 1] > 1) {
					return false;
				}
			}
		}
		
		//Validating SubGrid;
		int sRowStart = row/3;
		int sColStart = col/3;
		sRowStart *= 3;
		sColStart *= 3;
		int sRowEnd =sRowStart+3; 
		int sColEnd =sColStart+3;
		int ref3[] = new int[9];	
		ref3[0]  = 0;
		for(int i = sRowStart; i < sRowEnd; i++) {
			for(int j = sColStart; j <sColEnd; j++) {
				if(arr[i][j] != 0) {
					int ele = arr[i][j];
					ref3[ele-1] += 1;
					if(ref3[ele - 1] > 1) {
						return false;
					}
				}
			}
		}
		
		return true;
	}

}
