
public class SudokuVerifier {
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		//String [][] board = null;
		String splitted = candidateSolution;
		//String delims = "[,\n]";
		//String[] numbers = splitted.split(delims);
		//int lenght = splitted.length();
		//int r=0;
		char[] x = splitted.toCharArray();
		int lenghtOfArray = x.length;
		int rows = lenghtOfArray/9;
		//String [] boxArrayRow = splitted.split("")
		String [] boxArrayRow = null;
		//boxArrayRow = candidateSolution;
		boxArrayRow = splitInParts(splitted,1);
		System.out.print(boxArrayRow);
		int[][] matrix = parseProblem(boxArrayRow);
		//writeMatrix(matrix);
		if (solve(0,0,matrix)) {   // solves in place
			System.out.println("Verify pass");
			return 1;
		}
		   // writeMatrix(matrix);
		else {System.out.println("Verify fail");
		return 0;}
		
		
		//check
	}
	public String[] splitInParts(String s, int partLength)
	{
	    int len = s.length();

	    // Number of parts
	    int nparts = (len + partLength - 1) / partLength;
	    String parts[] = new String[nparts];

	    // Break into parts
	    int offset= 0;
	    int i = 0;
	    while (i < nparts)
	    {
	        parts[i] = s.substring(offset, Math.min(offset + partLength, len));
	        offset += partLength;
	        i++;
	    }

	    return parts;
	}
	
	static boolean solve(int i, int j, int[][] cells) {
		if (i == 9) {
		    i = 0;
 		}
		boolean test = true;
		for (int val = 1; val <= 9; ++val) {
		    test = legal(i,j,val,cells) ;
 		   }
		 return test;
		}


	    static boolean legal(int i, int j, int val, int[][] cells) {
	    	int foundK =0;
	    	int foundVal = 0;
		for (int k = 0; k < 9; ++k) {  // row
		    if (val == cells[k][j])
		    	foundK++;
		}
		    if (foundK > 1)
			return false;
		    

		for (int k = 0; k < 9; ++k) { // col
		    if (val == cells[i][k])
		    	foundVal++;
		}
	    	if (foundVal > 1)
	    	return false;
	    	

	    int valB =0;
		int boxRowOffset = (i / 3)*3;
		int boxColOffset = (j / 3)*3;
		for (int k = 0; k < 3; ++k) // box
		    for (int m = 0; m < 3; ++m)
			if (val == cells[boxRowOffset+k][boxColOffset+m]) {
				valB++;
			}
			if (valB > 1)	
			    return false;

		return true; // no violations, so it's legal
	    }


	    
	    static int[][] parseProblem(String[] args) {
	    	int n=0;
	    	int val=0;
			int[][] problem = new int[9][9]; // default 0 vals
			for(int i =0; i < 9; i++) {
					for(int j =0; j < 9;j++) { 
						//String number = Integer.toString(i) + Integer.toString(j); 
						//n= Integer.parseInt(number);
						val = Integer.parseInt(args[n]); 
						problem[i][j] = val;
						n++;
					}
				}
			return problem;
		    }
	    
	    

	    static void writeMatrix(int[][] solution) {
		for (int i = 0; i < 9; ++i) {
		    if (i % 3 == 0)
			System.out.println(" -----------------------");
		    for (int j = 0; j < 9; ++j) {
			if (j % 3 == 0) System.out.print("| ");
			System.out.print(solution[i][j] == 0
					 ? " "
					 : Integer.toString(solution[i][j]));
			
			System.out.print(' ');
		    }
		    System.out.println("|");
		}
		System.out.println(" -----------------------");
	    }

}

