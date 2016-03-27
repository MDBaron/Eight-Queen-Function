package practice;

public class RemoteKeypad {
	int width;
	int cursorRow;
	int cursorCol;
	RemoteKeypad(int width){
		this.width = width;
		cursorRow = 0;
		cursorCol = 0;
	}//constructor
	
	public void getMoves(String str){
		for(int index = 0; index < str.length(); index++){
			char next = str.charAt(index);
				int a = getRow(next);
				int b = getCol(next);
				int cursorRowTemp = a;
				int cursorColTemp = b;
				String output = "";
				
				if (a > cursorRow) {
				while(a > cursorRow){
					output = output + " " + "Down" + " ";
					a--;
				}//while
			} else {
				while(a < cursorRow){
					output = output + " " + "Up" + " ";
					a++;
				}//while
			}//else
			
			 if (b > cursorCol) {
				while(b > cursorCol ){
					output = output + " " + "Right" + " ";
					b--;
				}//while
			} else {
				while(b < cursorCol){
					output = output + " " + "Left" + " ";
					b++;
				}//while
			}//else
			System.out.println(output + "Enter");	
			cursorRow = cursorRowTemp;
			cursorCol = cursorColTemp;
		}//for
	}//getMoves
	
	int getRow(char c){
		return (c - 'a') / width;
	}//getRow
	
	int getCol(char c){
		return (c - 'a') % width;
	}//getCol
}//class
