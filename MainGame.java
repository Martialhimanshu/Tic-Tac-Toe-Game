package Trie;
import java.util.Scanner;


import TicTacToe.Board;
import TicTacToe.Board.moves;
import TicTacToe.Board.status;
public class MainGame {
	
	public void startGame() throws InterruptedException{
		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter the name of Player 1");
		String name1 = input.next();
		Player Player1 = new Player(name1);
		System.out.println("Please Enter the name of Player 2");
		String name2 = input.next();
		Player Player2 = new Player(name2);
		Player currentPlayer;
		Board board = new Board();
		board.printBoard();
		currentPlayer = Player1;
		boolean done = false;
		moves currentMove = moves.PLAYER1;
		while(!done){
			System.out.println("Your Turn : " + currentPlayer.getName());
			boolean invalid = true;
			while(invalid){
				System.out.println("Enter the row :");
				int row = input.nextInt();
				System.out.println("Enter the column :");
				int column = input.nextInt();
				
				try {
					board.updateBoard(currentMove, row, column);
					invalid = false;
				}
				catch(InvalidMoveException e) {
					System.out.println("Invalid Move " + currentPlayer.getName() + " Try Again." );
				}
			}
			if(board.BoardStatus() != status.NOTDONE){
				done = true;
				break;
			}
			currentPlayer = currentPlayer == Player1?Player2:Player1;
			currentMove = currentMove == moves.PLAYER1?moves.PLAYER2:moves.PLAYER1;
		}
		if (board.BoardStatus() == status.DRAW) {
			System.out.println("DRAW!");
		} else if (board.BoardStatus() == status.PLAYER1) {
			System.out.println("Winner:" + Player1.getName());
		} else {
			System.out.println("Winner:" + Player2.getName());
		}
		input.close();
	}
	public static void main(String[] args) throws InterruptedException{
		MainGame game = new MainGame();
		game.startGame();
		
	}
	
}
