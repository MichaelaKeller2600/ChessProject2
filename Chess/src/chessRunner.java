import java.util.ArrayList;
import java.util.Scanner;

public class chessRunner {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Pieces.Type pieceType = null;
		Pieces.Color pieceColor = null;
		ArrayList<Pieces> fun = new ArrayList<Pieces>();
		
		fun.add(new King(4, 8, pieceColor.white));
		fun.add(new King(4, 1, pieceColor.black));
		
		fun.add(new Queen(5, 8, pieceColor.white));
		fun.add(new Queen(5, 1, pieceColor.black));
		
		fun.add(new Bishop(3, 8, pieceColor.white));
		fun.add(new Bishop(6, 8, pieceColor.white));
		fun.add(new Bishop(3, 1, pieceColor.black));
		fun.add(new Bishop(6, 1, pieceColor.black));
		
		fun.add(new Knight(2, 8, pieceColor.white));
		fun.add(new Knight(7, 8, pieceColor.white));
		fun.add(new Knight(2, 1, pieceColor.black));
		fun.add(new Knight(7, 1, pieceColor.black));
		
		fun.add(new Rook(1, 8, pieceColor.white));
//		fun.add(new Rook(8, 8, pieceColor.white));
		fun.add(new Rook(1, 1, pieceColor.black));
		fun.add(new Rook(8, 1, pieceColor.black));
		
		fun.add(new Pawn(1, 7, pieceColor.white));
		fun.add(new Pawn(2, 7, pieceColor.white));
		fun.add(new Pawn(3, 7, pieceColor.white));
//		fun.add(new Pawn(4, 7, pieceColor.white));
		fun.add(new Pawn(5, 7, pieceColor.white));
		fun.add(new Pawn(6, 7, pieceColor.white));
		fun.add(new Pawn(7, 7, pieceColor.white));
		fun.add(new Pawn(8, 7, pieceColor.white));
		
		fun.add(new Pawn(1, 2, pieceColor.black));
		fun.add(new Pawn(2, 2, pieceColor.black));
		fun.add(new Pawn(3, 2, pieceColor.black));
		fun.add(new Pawn(4, 2, pieceColor.black));
//		fun.add(new Pawn(5, 2, pieceColor.black));
		fun.add(new Pawn(6, 2, pieceColor.black));
		fun.add(new Pawn(7, 2, pieceColor.black));
		fun.add(new Pawn(8, 2, pieceColor.black));
		
		fun.add(new Pawn(5, 4, pieceColor.black));
		fun.add(new Pawn(4, 5, pieceColor.white));
		fun.add(new Rook(8, 5, pieceColor.white));
		
		Board game = new Board();
		game.basicSetup(fun);
		game.printBoard();
		
		for(int i = 1; i < 6; i++) {
			if(i % 2 != 0) {
				boolean correctColor = false;
				int x = 0, y = 0, y2 = 0, x2 = 0;
				System.out.println("You are White!");
				
				while(correctColor == false) {
					System.out.print("\t" + i + ": Which *ROW* is the piece in? ");
					y = in.nextInt() - 1;
					System.out.print("\t*COLUMN*? ");
					x = in.nextInt() - 1;
					System.out.print("\t" + i + ": Which *ROW* should the piece go to? ");
					y2 = in.nextInt() - 1;
					System.out.print("\t*COLUMN*? ");
					x2 = in.nextInt() - 1;
					
					if(game.getGamePeice(x, y) == null) {
						System.out.println("Oops! There's no piece there, try again.\n");
					}
					else if(game.getGamePeice(x, y).getPieceColor() != Pieces.Color.white)
						System.out.println("Get Wrecked! Thats not your color, try again.\n");
					else
						correctColor = true;
				}
				System.out.print(game.getGamePeice(x, y) + "\t");
				printCoordinates(x, y, x2, y2);
				
				if(game.getGamePeice(x, y).canMove( x2, y2, game))
					game.getGamePeice(x, y).moveMethod(x2, y2, game, x, y);
				
				game.printBoard();
			}
			else {
				System.out.println("You are Black!");
				boolean correctColor = false;
				int x = 0, y = 0, y2 = 0, x2 = 0;
				
				while(correctColor == false) {
					System.out.print("\t" + i + ": Which *ROW* is the piece in? ");
					y = in.nextInt() - 1;
					System.out.print("\t*COLUMN*? ");
					x = in.nextInt() - 1;
					System.out.print("\t" + i + ": Which *ROW* should the piece go to? ");
					y2 = in.nextInt() - 1;
					System.out.print("\t*COLUMN*? ");
					x2 = in.nextInt() - 1;
					
					if(game.getGamePeice(x, y) == null) {
						System.out.println("Oops! There's no piece there, try again.\n");
					}
					else if(game.getGamePeice(x, y).getPieceColor() != Pieces.Color.black)
						System.out.println("Get Wrecked! Thats not your color, try again.\n");
					else
						correctColor = true;
				}
				
				System.out.print(game.getGamePeice(x, y) + "\t");
				printCoordinates(x, y, x2, y2);
				
				if(game.getGamePeice(x, y).canMove( x2, y2, game))
					game.getGamePeice(x, y).moveMethod(x2, y2, game, x, y);
				
				game.printBoard();
			}
		}
	}
	
	public static void printCoordinates(int x, int y, int x2, int y2) {
		System.out.printf("[%d, %d] -> [%d, %d]\n", x, y, x2, y2);
	}

}
