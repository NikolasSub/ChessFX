package fremig.chessfx;

import java.util.ArrayList;

public class ChessSet {
	ArrayList<Piece> thePieces = new ArrayList<Piece>(32);
	
	public ChessSet() {
		thePieces.add(new Piece(ChessPiece.WhiteRook, "a1"));
		thePieces.add(new Piece(ChessPiece.WhiteKnight, "a2"));
		thePieces.add(new Piece(ChessPiece.WhiteBishop, "a3"));
		thePieces.add(new Piece(ChessPiece.WhiteQueen, "a4"));
		thePieces.add(new Piece(ChessPiece.WhiteKing, "a5"));
		thePieces.add(new Piece(ChessPiece.WhiteBishop, "a6"));
		thePieces.add(new Piece(ChessPiece.WhiteKnight, "a7"));
		thePieces.add(new Piece(ChessPiece.WhiteRook, "a8"));
		thePieces.add(new Piece(ChessPiece.WhitePawn, "b8"));
		thePieces.add(new Piece(ChessPiece.WhitePawn, "b7"));
		thePieces.add(new Piece(ChessPiece.WhitePawn, "b6"));
		thePieces.add(new Piece(ChessPiece.WhitePawn, "b5"));
		thePieces.add(new Piece(ChessPiece.WhitePawn, "b4"));
		thePieces.add(new Piece(ChessPiece.WhitePawn, "b3"));
		thePieces.add(new Piece(ChessPiece.WhitePawn, "b2"));
		thePieces.add(new Piece(ChessPiece.WhitePawn, "b1"));
		thePieces.add(new Piece(ChessPiece.BlackPawn, "g1"));
		thePieces.add(new Piece(ChessPiece.BlackPawn, "g2"));
		thePieces.add(new Piece(ChessPiece.BlackPawn, "g3"));
		thePieces.add(new Piece(ChessPiece.BlackPawn, "g4"));
		thePieces.add(new Piece(ChessPiece.BlackPawn, "g5"));
		thePieces.add(new Piece(ChessPiece.BlackPawn, "g6"));
		thePieces.add(new Piece(ChessPiece.BlackPawn, "g7"));
		thePieces.add(new Piece(ChessPiece.BlackPawn, "g8"));
		thePieces.add(new Piece(ChessPiece.BlackRook, "h8"));
		thePieces.add(new Piece(ChessPiece.BlackKnight, "h7"));
		thePieces.add(new Piece(ChessPiece.BlackBishop, "h6"));
		thePieces.add(new Piece(ChessPiece.BlackKing, "h5"));
		thePieces.add(new Piece(ChessPiece.BlackQueen, "h4"));
		thePieces.add(new Piece(ChessPiece.BlackBishop, "h3"));
		thePieces.add(new Piece(ChessPiece.BlackKnight, "h2"));
		thePieces.add(new Piece(ChessPiece.BlackRook, "h1"));
	}
	
	public ArrayList<Piece> thePieces() {
		return thePieces;
	}
}
