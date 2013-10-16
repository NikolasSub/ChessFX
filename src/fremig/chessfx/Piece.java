package fremig.chessfx;

import java.awt.Point;


public class Piece {
	private ChessPiece piece;
	private Position position;
	Boolean live = true;
	
	Piece(ChessPiece piece, String aPos) {
		this.piece = piece;
		position = new Position(0,0);
		position.setPosition(aPos);
		live = true;
	}
	
	Piece(ChessPiece piece) {
		this.piece = piece;
		live = true;
	}
	
	public void setPosition(String aPos) {
		position.setPosition(aPos);
	}
	
	public void setPosition(Point point) {
		position.setPosition(point);
	}
	
	public void takePiece() {
		live = false;
	}
	
	public Boolean isAlive() {
		return live;
	}
	
	public String getImageFile() {
		return piece.getImageFile();
	}
	
	public Point getPosition()  {
		return position.getPosition();
	}
	
	public String getNotation() {
		return position.getNotation();
	}
}