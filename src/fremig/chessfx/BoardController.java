package fremig.chessfx;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class BoardController {
	Piece blackTile = new Piece(ChessPiece.BlackField);
	Piece whiteTile = new Piece(ChessPiece.WhiteField);
	ChessSet chessSet = new ChessSet();
	
	static int grid = 8; // grid size
	static double scalePiece = 0.8;
	static double ofsetX = 0.1;
	static double ofsetY = 0.1;
	
	static Logger log = Logger.getLogger(BoardController.class);

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Pane chessboard;

	@FXML
	private Button button;

	@FXML
	void onKeyPress(KeyEvent event) {
	}

	@FXML
	void onPress(ActionEvent event) {
	}

	@FXML
	void initialize() {
		assert button != null : "fx:id=\"button\" was not injected: check your FXML file 'ChessFX.fxml'.";
		assert chessboard != null : "fx:id=\"chessboard\" was not injected: check your FXML file 'ChessFX.fxml'.";
		
		makeBoard();
		setupPieces();

	}
	
	void setupPieces() {
		// this binding will find out which parameter is smaller: height or width
		NumberBinding rectsAreaSize = Bindings.min(chessboard.heightProperty(),	chessboard.widthProperty());
		
		for(Piece piece: chessSet.thePieces()) {
			Image pI = new Image(piece.getImageFile(),true);
			ImageView imageview = new ImageView();
			imageview.setImage(pI);
			double posX = ofsetX + piece.getPosition().getX();
			double posY = ofsetY + piece.getPosition().getY();
			imageview.setX(posX);
			imageview.setY(posY);
			imageview.xProperty().bind(	rectsAreaSize.multiply(posX).divide(grid));
			imageview.yProperty().bind(	rectsAreaSize.multiply(posY).divide(grid));
			// here we bind imageview size to pane size
			imageview.fitHeightProperty().bind(rectsAreaSize.multiply(scalePiece).divide(grid));
			imageview.fitWidthProperty().bind(imageview.fitHeightProperty());
			
			chessboard.getChildren().add(imageview);
		}
	}
	
	void makeBoard() {
		// this binding will find out which parameter is smaller: height or width
		NumberBinding rectsAreaSize = Bindings.min(chessboard.heightProperty(),	chessboard.widthProperty());
		
		Image bT = new Image(blackTile.getImageFile(),true);
		Image wT = new Image(whiteTile.getImageFile(),true);
		for (int x = 0, c = 0; x < grid; x++, c++) {
			for (int y = 0; y < grid; y++) {
				ImageView imageview = new ImageView();
				if (c % 2 == 0) {
					imageview.setImage(wT);
				} else {
					imageview.setImage(bT);
				}
				// here we position rects (this depends on pane size as well)
				imageview.xProperty().bind(	rectsAreaSize.multiply(x).divide(grid));
				imageview.yProperty().bind(	rectsAreaSize.multiply(y).divide(grid));

				// here we bind imageview size to pane size
				imageview.fitHeightProperty().bind(rectsAreaSize.divide(grid));
				imageview.fitWidthProperty().bind(imageview.fitHeightProperty());
				c++;

				chessboard.getChildren().add(imageview);
			}
		}
		
	}
}
