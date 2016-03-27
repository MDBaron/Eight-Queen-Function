package practice;

public class EightQueenSolver {
	 int board[][] = new int[8][8];
	 int queensPlaced = 0;
	 int columnVal[] = new int[8];
	 
	 EightQueenSolver(){
		for (int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				board[i][j] = 0;
				}//for
			}//for
	}//constructor
	
	public void printBoard(){
		for (int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				System.out.print(board[j][i] + " "); 
				}//for
			System.out.println();
			}//for
	}//printBoard
	
	public void solve(int col){
		
		int x = col;
	
			
		for(int y = 0; y < 8; y++){
			
			if(queensPlaced == 8){
				break;
			}//if
			
			if((checkRow(x,y) == true) && (checkCol(x,y) == true) && (checkDiag(x,y) == true)){
				queensPlaced++;
				columnVal[x] = y;
				board[x][y] = 1;
				solve(x+1);
			
			}//if
		}//for
		if(queensPlaced < 8){
			queensPlaced--;
			clearColumn(x-1,columnVal[x-1]);
	    }//if
	}//solve
	
	public void clearColumn(int col,int row){
		
		int x = col;
		board[x][row] = 0;
		
		for(int y = (row + 1); y < 8; y++){
			if((checkRow(x,y) == true) && (checkCol(x,y) == true) && (checkDiag(x,y) == true)){
				queensPlaced++;
				board[x][y] = 0;
				board[x][y] = 1;
				columnVal[x] = y;
				solve(x+1);
			}//if
		}//for
		
		if(queensPlaced < 8){
		queensPlaced--;
		clearColumn(x-1,columnVal[x-1]);
		}//if
	}//clearColumn
	
	  public boolean checkCol(int x, int y) {
		  
	        // check above
	        for(int i = 0; i < y; i++) {
	            if(board[x][i] == 1) return false;
	        }//for
	        
	        // check below
	        for(int i = y+1; i < board.length; i++) {
	             if(board[x][i] == 1) return false;
	        }//for
	     // System.out.print(x + " C");
           // System.out.println(y + " C");
	        return true;
	    }//checkCol
	     
	    public boolean checkRow(int x, int y) {
	    	
	        // check left
	        for(int i = 0; i < x; i++) {
	            if(board[i][y] == 1) return false;
	        }//for
	        
	        // check right
	        for(int i = x+1; i < board.length; i++) {
	            if(board[i][y] == 1) return false;
	        }//for
	      //System.out.print(x + " R");
           // System.out.println(y + " R");
	        return true;
	    }//checkRow
	
	public boolean checkDiag(int x, int y) {
		
        // check above and left
        int dx = x;
        int dy = y;
        if((x > 0) && (y > 0) && (board[x-1][y-1] == 1)){
        	return false;
        }//if
        while((dx > 0) && (dy > 0)) {
            if(board[dx--][dy--] == 1) return false;
        }//while
        
        // check below and right
        dx = x;
        dy = y;
        while((dx < board.length) && (dy < board.length)) {
            if(board[dx++][dy++] == 1) return false;
        }//while
        
        // check above and right
        dx = x;
        dy = y;
        while((dx < board.length) && (dy > 0)) {
            if(board[dx++][dy--] == 1) return false;
        }//while
        
        // check below and left
        dx = x;
        dy = y;
        while((dx > 0) && (dy < board.length)) {
            if(board[dx--][dy++] == 1) return false;
        }//while
      //System.out.print(x + " D");
        //System.out.println(y + " D");
        return true;
    }//checkDiag
}//class EightQueenSolver
