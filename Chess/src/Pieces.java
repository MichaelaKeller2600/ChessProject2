public abstract class Pieces {
	private int xPosition;
	private int yPosition;
	public enum Type {King, Queen, Rook, Knight, Bishop, Pawn};
	private Type pieceType;
	public enum Color {black, white};
	private Color pieceColor;

	public void setPosition(int xPosition, int yPosition, Board gameBoard) {
		gameBoard.setGamePiece(this, xPosition, yPosition);
	}

	public Type getPieceType() {
		return pieceType;
	}
	
	public boolean isOpponent(Pieces i) {
		return (i.pieceColor != this.pieceColor);
	}

	public void setPieceType(Type pieceType) {
		this.pieceType = pieceType;
	}

	public Color getPieceColor() {
		return pieceColor;
	}

	public void setPieceColor(Color pieceColor) {
		this.pieceColor = pieceColor;
	}

	public int getxPosition() {
		return this.xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public abstract boolean canMove(int i, int j, Board game);

	public abstract void moveMethod(int i, int j, Board game, int a, int b);
}
