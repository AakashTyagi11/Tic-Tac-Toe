import java.util.Scanner;

public class Tictactoe {

	int[][] board;
	int player;
	boolean empty;
	int result;
	public void initialize() {
		
		board=new int[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++) {
				board[i][j]=0;
			}
		}
		player=1;	
		empty=true;
		result=0;
	}
		
	public int getPlayer(){
		if(player==1) {
		return player;
		}
		else {
			return 2;
		}
	}
	
	public boolean isEmpty(int x, int y) {
		if(board[x][y]!=0){
			return false;
		}
		else {
			return true;
		}
	}
	
	public void setMarks(int x, int y) {
		
		if(x<0||x>2||y<0||y>2) {
			System.out.println("Not a valid location");
			return;	
		}
		
		if(!isEmpty(x,y)) {
			System.out.println("Already Filled position");
			return;
		}
		
		board[x][y]=player;
		
		if(winner(player)){  
			if(player==1) {
				System.out.println("Player:"+player+""+"wins");
				result=1;
				printCurrentState();
				return;
				}
			else {
				System.out.println("Player: 2 wins");
				result=1;
				printCurrentState();
				return;
			}
			
		}
		changePlayer();
	}
	
	public void changePlayer() {
		if(player==1) {
			player=-1;
			
		}
		else if(player==-1) {
			player=1;
		}
	}
	
	public boolean winner(int player) {
		 return (   (board[0][0] + board[0][1] + board[0][2] == player*3) ||
	                (board[1][0] + board[1][1] + board[1][2] == player*3) ||
	                (board[2][0] + board[2][1] + board[2][2] == player*3) ||
	                (board[0][0] + board[1][0] + board[2][0] == player*3) ||
	                (board[0][1] + board[1][1] + board[2][1] == player*3) ||
	                (board[0][2] + board[1][2] + board[2][2] == player*3) ||
	                (board[0][0] + board[1][1] + board[2][2] == player*3) ||
	                (board[2][0] + board[1][1] + board[0][2] == player*3));
	}

	
public void printCurrentState() {
	empty=false;
	for(int i=0;i<3;i++){
		System.out.print("|");
		for(int j=0;j<3;j++) {
			if(board[i][j]==0) {
				empty=true;
				System.out.print(" "+"|");
			}
			else if(board[i][j]==-1) {
				System.out.print("O"+"|");
			}
			else {
				System.out.print(board[i][j]+"|");
			}
			
		}
		System.out.println("");
		System.out.println("-------");
	}
}


	public static void main(String args[]) {
		
		Tictactoe obj=new Tictactoe();
		obj.initialize();
		Scanner sc = new Scanner(System.in); 
		
		while (obj.empty && obj.result==0) {
			 System.out.println("Current State of board");
			obj.printCurrentState();
			System.out.println("Player:"+obj.getPlayer()+" turn !");
	        System.out.println("Enter x: ");
			 int x = sc.nextInt(); 
			 System.out.println("Enter y: ");
			 int y = sc.nextInt(); 
			 obj.setMarks(x,y);
			
			
		} 
		
		
		if(!obj.empty && obj.result!=1) {
			System.out.println("Match Tied");
			return;
		}
		
	}
	
}
