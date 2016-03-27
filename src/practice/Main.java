package practice;

public class Main {
	public static void main(String args[]){
		System.out.println("step2 : print function");
		myPrint();
		System.out.println("step3: backtracking");
		EightQueenSolver solver = new EightQueenSolver();
		solver.solve(0);
		solver.printBoard();
		
		System.out.println("step4: remote keypad");
		RemoteKeypad keypad = new RemoteKeypad(Integer.parseInt(args[0]));
		
		for (int i = 1; i < args.length; i++) {
			keypad.getMoves(args[i]);
		}
	}
	
	public static void myPrint(){
		int outside = 4;
		int inside = 1;
		for (int z = 0; z < 5; z++){
			for (int i = 0; i < outside; i++){
				System.out.print(" ");
			
			}
			for (int j = 0; j < inside; j++){
				System.out.print("*");
			}
			for (int k = 0; k < outside; k++) {
				System.out.print(" ");
			}
			outside--;
			inside += 2;
			System.out.println();
		}
	}
}
