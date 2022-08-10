/*Ishaan Bhattacharya NQUEENSV3 with all the solutions and the number of solutions printed.
 * 
 * V1 had just the 8x8 solution 
 * 
 * v2 had all solutions for the 8x8 
 * 
 * IMPORTANT IF U WANT ONLY # OF SOLUTION AND NOT BOARDS THEN COMMENT OUT LINES 129 and 130
 * 
 */

import java.util.*; // used to import the scanner

//import java.lang.Math;i tried using some absolute value stuff here but it did not work

//only class and the one that holds main
public class NQueensv3 {
	//class wide variable to hold number of solutions intialized to zero.
	public static int Numbersolutions = 0;

		public static void main(String[] args) {
			//input value to determine number of queens and board dimensions
			int N;
			//scanning in input.
				Scanner sc = new Scanner(System.in);
				N = sc.nextInt();
					//declaring the board as a 2d array
					int Board[][] = new int [N][N];
						//initalizing the boards as all 0 or with no queens anywhere
						//1 = queen in spot  0=empty spot
						for(int i = 0; i < N; i++) {
								for(int j = 0; j<N; j++) {
										Board[i][j] = 0;
									}
							}
						
							//backtracking function to find all the solutions
							recurse(Board,0,0,N);
							//print the number of solutions
							System.out.println(Numbersolutions+ " Solutions Above");
							//close scanner
							sc.close();
		}	
			
		 	
		 	

		
		/* rules	1.no queens on same row
					2.no queens on same column
					3.no queens on any diagonal
					*/
		public static Boolean ValidityCheck(int N, int row, int column, int Board[][]) {
			//variables declaration and intializtion
			int counter1=0, counter2=0, counter3 = 0;
			int i,j;

			//for loop used to see if two queens are on same row on column
			for(i=0;i<N;i++) {
				if(Board[row][i] == 1) {
					counter1 = counter1+1;
					
				}//end of if
				if(Board[i][column] == 1) {
					counter2 = counter2 +1;
				}//end of if
				//if there is another on same row return false and backtrack
				if(counter1 >= 1 || counter2 >= 1) {
					return false;
				}//end of last if
			}// end of for loop
			
			
				//for loop to see if two queens are on the same diagonal or not
				for(i=0; i < N; i++) {
					for(j=0; j<N; j++) {
						if((i+j) == (row + column) || (row-column) == (i-j)) { //same value as diagonals if u add or subtract .
							if(Board[i][j]==1) {
								counter3 = counter3+1;
												}// end of inner if
																			}// end of outer if
										}// end of inner for	
				
									}//end of outer for
							//if on the same diagonal then return false and backtrack.
							if(counter3 >= 1) {
									return false;
							}//end of if
							
			//other conditons not met meant that the function is valid
			return true;
		}//end of validity check
		
		
		
		
		
		
		
		//print my Board hopefully when it's done
		public static void Print(int Board[][],int N) {
			int i, j;
			for(i=0; i < N; i++) {
				for(j=0; j<N; j++) {
					System.out.print(Board[i][j] + " ");
				}
				System.out.println();
			}
			
			
			
			
			
			
			
			
		}
		
		//recursive function to print all solutions
		public static void recurse(int Board[][],int row, int column, int N) {
			//System.out.println(row);
			//base case n is size 0 no solutions and no board
			if (N==0) {
				return ;
			}
			//you have reached the end of the board with no violations so print the board or increment the number of solutions
			// comment out the print function and system.out.println if u only want number of solutions
			if(row == N) {
				Numbersolutions = Numbersolutions+1;
				Print(Board,N);
				System.out.println();
				
				return;
			}
			
				//for each row check each column to see if inserting a queen is valid
				//if a queen is in a row then go down a column.
				for(column=0; column<N; column++) {
					
					//if the current board is valid put a queen down and go down a row.
					if(ValidityCheck(N,row,column,Board)) {
						Board[row][column]=1;
						//the down a row recursive function
						recurse(Board,row+1,column,N);
						//u must backtrack in order to find all solutions.
						// this backtracks and creates another board state disimialar from the last one.
						Board[row][column]=0;
						
							
					}//end of if statement
						
				}//end of for loop
		


	}//end of recursive function
	



}//end of class
