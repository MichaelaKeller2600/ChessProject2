public class Pawn extends Pieces{
	public Pawn(int a, int b, Color c) {
		setxPosition(a);
		setyPosition(b);
		setPieceColor(c);
		setPieceType(Pieces.Type.Pawn);
	}
	public boolean canMove(int xMove, int yMove, Board gameBoard) {
		int xMoves = this.getxPosition() - 1 - xMove;	//Negative indicates left, positive indicates right
		int yMoves = this.getyPosition() - 1 - yMove;	//Negative indicates down, positive indicates up
		
		if(gameBoard.getGamePeice(xMove, yMove) == null) {
//			System.out.printf("x: %d - %d = %d\n", this.getxPosition(), xMove, xMoves);
//			System.out.printf("y: %d - %d = %d\n", this.getyPosition(), yMove, yMoves);
			if(xMoves == 0 && (yMoves == 1 || yMoves == -1)) {
				return true;
			}
		}
		else if(gameBoard.getGamePeice(xMove, yMove).isOpponent((Pieces)this) && yMoves == 1 && (xMoves == 1 || xMoves == -1)) {
			return true;
		}
		System.out.println("You can't move that pawn, oof!");
		return false;
		
		
	}
	
	public void moveMethod(int xMove, int yMove, Board game, int origX, int origY) {
		game.setGamePiece(this, xMove + 1, yMove + 1);
		setxPosition(xMove + 1);
		setyPosition(yMove + 1);
		game.removeGamePiece(origX, origY);
	}
	
	public String toString() {
		if(this.getPieceColor() == Color.white)
			return "wPawn";
		else
			return "bPawn";
	}

}
