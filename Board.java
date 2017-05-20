package TicTacToe;

import java.awt.AWTException;
import java.awt.Robot;


public class Board{
	private int temp =0;
	public enum moves {
		PLAYER1 , PLAYER2
	}
	public enum status {
		NOTDONE , DRAW , PLAYER1 , PLAYER2
	}
	private  status currentStatus = status.NOTDONE;
	moves[][] move = new moves[3][3];
	public void printBoard(){
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				if(move[i][j] == moves.PLAYER1)
					System.out.print(" X ");
				else if(move[i][j] == moves.PLAYER2)
					System.out.print(" O ");
				else
					System.out.print("   ");
				if(j<2)
					System.out.print("|");
			}
			System.out.println();
			if(i <2)
				System.out.println("------------");
		}
	}
	public void updateBoard(moves player,int row,int column) throws InvalidMoveException, InterruptedException{
		if((row > 2 || column >2) || (move[row][column] == moves.PLAYER1 || move[row][column] == moves.PLAYER2 ) )
			throw new InvalidMoveException();
		move[row][column] = player;
		temp++;
//		wait(1);
		//try {
	    //    Robot robbie = new Robot();
	    //    robbie.keyPress(16); //shift
	     //   robbie.keyPress(121); //f10
//	        robbie.keyPress(82);//r
//	        robbie.keyRelease(16); // Releases Shift.
//	        robbie.keyRelease(121); // Releases f10.
//	        robbie.keyRelease(82);//Releases r
	    //} catch (AWTException ex) {
//	        Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
//	}
		printBoard();
		if ((move[row][0] == move[row][1]) && (move[row][0] == move[row][2])) {
			if (move[row][0] == moves.PLAYER1) {
				currentStatus = status.PLAYER1;
			} else if(move[row][0] == moves.PLAYER2) {
				currentStatus = status.PLAYER2;
			}
			return;
		}
		if ((move[0][column] == move[1][column]) && (move[1][column] == move[2][column])) {
			if (move[0][column] == moves.PLAYER1) {
				currentStatus = status.PLAYER1;
			} else if (move[0][column] == moves.PLAYER2) {
				currentStatus = status.PLAYER2;
			}
			return;
		}
		if ((move[0][0] == move[1][1]) && (move[1][1] == move[2][2])) {
			if (move[0][0] == moves.PLAYER1) {
				currentStatus = status.PLAYER1;
			} else if (move[0][0] == moves.PLAYER2) {
				currentStatus = status.PLAYER2;
			}
			return;
		}
		if ((move[2][0] == move[1][1]) && (move[1][1] == move[0][2])) {
			if (move[2][0] == moves.PLAYER1) {
				currentStatus = status.PLAYER1;
			} else if (move[2][0] == moves.PLAYER2) {
				currentStatus = status.PLAYER2;
			}
			return;
		}
		if(temp == 9 && currentStatus == status.NOTDONE)
			currentStatus = status.DRAW;
		
	}
	public status BoardStatus(){
		
		return currentStatus;
	}
	
	
}
