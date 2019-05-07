import java.util.ArrayList;

public class Board {
	private Pieces[][] gameBoard;
	private Pieces.Type pieceType;
	private Pieces.Color pieceColor;
	
		public Board(int rows, int cols){
			gameBoard = new Pieces[rows][cols];
		}
		
		public Board() {
			gameBoard = new Pieces[8][8];
		}
		
		public void printBoard(){
//			System.out.println("\t1(0)\t2(1)\t3(2)\t4(3)\t5(4)\t6(5)\t7(6)\t8(7)");
			System.out.println("\t1\t2\t3\t4\t5\t6\t7\t8");
			for(int r = 0; r < gameBoard.length; r++) {
				System.out.print((r + 1) + "  ");
				for(int c = 0; c < gameBoard[r].length; c++) {
					if(gameBoard[r][c] == null)
						System.out.print("\t_");
					else
						System.out.print("\t" + gameBoard[r][c]);
				}
				System.out.println("");
			}
			System.out.println("");
		}

		public Pieces getGamePeice(int x, int y) {
			return gameBoard[y][x];
		}

		public void setGamePiece(Pieces gamePiece, int x, int y) {
			gameBoard[y - 1][x - 1] = gamePiece;
		}

		public Pieces.Color getPieceColor() {
			return pieceColor;
		}

//		public void setPieceColor(Pieces.Color pieceColor) {
//			this.pieceColor = pieceColor;
//		}

		public Pieces.Type getPieceType() {
			return pieceType;
		}

//		public void setPieceType(Pieces.Type pieceType) {
//			this.pieceType = pieceType;
//		}

		public void removeGamePiece(int x, int y) {
			gameBoard[y][x] = null;
		}

		public void basicSetup(ArrayList<Pieces> fun) {
			for(int i = 0; i < fun.size(); i++) {
				setGamePiece(fun.get(i), fun.get(i).getxPosition(), fun.get(i).getyPosition());
			}
		}
}
