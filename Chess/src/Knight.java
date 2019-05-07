public class Knight extends Pieces{
	public Knight(int a, int b, Color c) {
		setxPosition(a);
		setyPosition(b);
		setPieceColor(c);
		setPieceType(Pieces.Type.Knight);
	}
	public boolean canMove(int xMove, int yMove, Board gameBoard) {
		int xMoves = this.getxPosition() - 1 - xMove;	//Negative indicates left, positive indicates right
		int yMoves = this.getyPosition() - 1 - yMove;	//Negative indicates down, positive indicates up
		
		if(gameBoard.getGamePeice(xMove, yMove) == null) {
			if (((xMoves == 1 || xMoves == -1 ) && (yMoves == 2 || yMoves == -2)) || ((xMoves == 2 || xMoves == -2 ) && (yMoves == 1 || yMoves == -1)))
					return true;
		}
		else if(gameBoard.getGamePeice(xMove, yMove).isOpponent((Pieces)this) && (((xMoves == 1 || xMoves == -1 ) && (yMoves == 2 || yMoves == -2)) || ((xMoves == 2 || xMoves == -2 ) && (yMoves == 1 || yMoves == -1))))
			return true;
		System.out.println("You can't move that Kight, oof!");
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
			return "wKnight";
		else
			return "bKnight";
	}

}
