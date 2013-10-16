package fremig.chessfx;


public enum ChessPiece {
	WhiteField  (  0, "fremig/chessfx/res/WhiteTile.png"),
	WhitePawn   (  1, "fremig/chessfx/res/WhitePawn.png"),
	WhiteKnight (  2, "fremig/chessfx/res/WhiteKnight.png"),
	WhiteBishop (  3, "fremig/chessfx/res/WhiteBishop.png"),
	WhiteRook   (  4, "fremig/chessfx/res/WhiteRook.png"),
	WhiteQueen  (  5, "fremig/chessfx/res/WhiteQueen.png"),
	WhiteKing   (  6, "fremig/chessfx/res/WhiteKing.png"),
	BlackField  (  8, "fremig/chessfx/res/BlackTile.png"),
	BlackPawn   (  9, "fremig/chessfx/res/BlackPawn.png"),
	BlackKnight ( 10, "fremig/chessfx/res/BlackKnight.png"),
	BlackBishop ( 11, "fremig/chessfx/res/BlackBishop.png"),
	BlackRook   ( 12, "fremig/chessfx/res/BlackRook.png"),
	BlackQueen  ( 13, "fremig/chessfx/res/BlackQueen.png"),
	BlackKing   ( 14, "fremig/chessfx/res/BlackKing.png");

	private final String field;
	private final int code;
	ChessPiece(int code, String field) {
		this.code = code;
		this.field = field;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getImageFile() {
		return field;
	}
}
