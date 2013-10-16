package fremig.chessfx;

import java.awt.Point;

import org.apache.log4j.Logger;

public class Position {
	private String chessNotation;
	private Point chessPosition;
	char left, right;
	int x,y;
	
	static Logger log = Logger.getLogger(Position.class);
	
	Position(int x, int y) {
		chessPosition = new Point(x,y);
		setPosition(chessPosition);
	}
	
	Position(String aPos) {
		if(aPos.isEmpty()) {
			return;
		}
		aPos.trim();
		if(aPos.length() != 2) {
			return;
		}
		aPos.toLowerCase();
		chessNotation = aPos;
		setPosition(chessNotation);
	}
	
	public void setPosition(String aPos) {
		if(aPos.isEmpty()) {
			return;
		}
		aPos.trim();
		if(aPos.length() != 2) {
			return;
		}
		aPos.toLowerCase();
		x = Character.digit(aPos.charAt(1), 10) - 1;
		if(x < 0 || x > 7) {
			log.error("Not a valid board position " + aPos);
			return;
		}
		
		chessNotation = aPos;
		switch(aPos.charAt(0)) {
		case 'a':
			chessPosition.setLocation(x, 7);
			break;
		case 'b':
			chessPosition.setLocation(x, 6);
			break;
		case 'c':
			chessPosition.setLocation(x, 5);
			break;
		case 'd':
			chessPosition.setLocation(x, 4);
			break;
		case 'e':
			chessPosition.setLocation(x, 3);
			break;
		case 'f':
			chessPosition.setLocation(x, 2);
			break;
		case 'g':
			chessPosition.setLocation(x, 1);
			break;
		case 'h':
			chessPosition.setLocation(x, 0);
			break;
		default:
			log.error("Not a valid board position " + aPos);
			return;
		}
	}
	
	public void setPosition(Point point) {
		if(point.getX() < 0 || point.getX() > 7 || point.getY() < 0 || point.getY() > 7) {
			log.error("Not a valid board position " + point.toString());
			return;
		}
		right = Character.forDigit(1 + (int)point.getX(), 10);
		switch((int)point.getY()) {
		case 0:
			left = 'h';
			break;
		case 1:
			left = 'g';
			break;
		case 2:
			left = 'f';
			break;
		case 3:
			left = 'e';
			break;
		case 4:
			left = 'd';
			break;
		case 5:
			left = 'c';
			break;
		case 6:
			left = 'b';
			break;
		case 7:
			left = 'a';
			break;
		default:
			log.error("Not a valid board position " + point.toString());
			return;
		}
		chessNotation = new StringBuilder().append(left).append(right).toString();
	}
	
	public Point getPosition() {
		return chessPosition;
	}
	
	public String getNotation() {
		return chessNotation;
	}
}
