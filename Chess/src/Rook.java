public class Rook extends Pieces{
	public Rook(int a, int b, Color c) {
		setxPosition(a);
		setyPosition(b);
		setPieceColor(c);
		setPieceType(Pieces.Type.Rook);
	}
	public boolean canMove(int xMove, int yMove, Board gameBoard) {
		int xMoves = xMove - this.getxPosition() + 1;	//Negative indicates left, positive indicates right
		int yMoves = this.getyPosition() - 1 - yMove;	//Negative indicates down, positive indicates up
		int counter = 0;
		
		if(gameBoard.getGamePeice(xMove, yMove) == null || gameBoard.getGamePeice(xMove, yMove).isOpponent(this)) {
			if(gameBoard.getGamePeice(xMove, yMove).isOpponent(this)) {
				counter++;
			}
			if (xMoves == 0 && yMoves > 0) {
				if(gameBoard.getGamePeice(xMove, yMove).isOpponent(this))
					counter++;
				for(int i = this.getyPosition(); i > this.getyPosition() - yMoves; i--){
					if(gameBoard.getGamePeice(xMove, i) == null || gameBoard.getGamePeice(xMove, i) == this)
						counter++;
				}
				if(counter <= yMoves)
					return true;
			}
			else if (xMoves == 0 && yMoves < 0) {
				System.out.println("hit");
				for(int i = this.getyPosition(); i < this.getyPosition() - yMoves; i++){
					if(gameBoard.getGamePeice(xMove, i) == null || gameBoard.getGamePeice(xMove, i) == this)
						counter++;
				}
				if(counter <= Math.abs(yMoves))
					return true;
			}
			else if (xMoves < 0 && yMoves == 0) {
				counter++;
				for(int i = this.getxPosition() - 1; i > this.getxPosition() + xMoves; i--){
					if(gameBoard.getGamePeice(yMove, i) == null || gameBoard.getGamePeice(i, yMove) == this)
						counter++;
				}
				if(counter >= Math.abs(xMoves))
					return true;
			}
			else{
				counter++;
				for(int i = this.getxPosition(); i < this.getxPosition() + xMoves; i++){
					if(gameBoard.getGamePeice(yMove, i) == null || gameBoard.getGamePeice(i, yMove) == this)
						counter++;
				}
				if(counter >= xMoves)
					return true;
			}
		}
		
		System.out.println("You can't move that Rook, oof!");
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
			return "wRook";
		else
			return "bRook";
	}

}