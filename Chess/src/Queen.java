public class Queen  extends Pieces{
	public Queen(int a, int b, Color c) {
		setxPosition(a);
		setyPosition(b);
		setPieceColor(c);
		setPieceType(Pieces.Type.Queen);
	}
	public boolean canMove(int xMove, int yMove, Board gameBoard) {
		boolean direction = false, canTake = false, clearPath = false;
		int xMoves = this.getxPosition() - xMove;	//Negative indicates left, positive indicates right
		int yMoves = this.getyPosition() - yMove;	//Negative indicates down, positive indicates up
		
		//Implement direction and clearPath
//		if (getPiece(xMove, yMove, gameBoard).isOpponent((Pieces)this))
			canTake = true;
		
		if(direction == true && canTake == true && clearPath == true)
			return true;
		return false;
		
	}
	
	public void moveMethod(int xMove, int yMove, Board game, int origX, int origY) {
		game.setGamePiece(this, xMove + 1, yMove + 1);
		setxPosition(xMove);
		setyPosition(yMove);
		game.removeGamePiece(origX, origY);
	}
	
	public String toString() {
		if(this.getPieceColor() == Color.white)
			return "wQueen";
		else
			return "bQueen";
	}

}