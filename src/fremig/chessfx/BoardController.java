package fremig.chessfx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.scene.shape.FillRule;
import javafx.stage.Stage;

public class BoardController {
	double step;

	private Rectangle lastOne;

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
		Group pW = makePawnWhite();
//		pW.getTransforms().add(new Translate(2 * step, 2 * step));

		chessboard.getChildren().add(pW);
		Group pB = makePawnBlack();
		pB.getTransforms().add(new Translate(2 * step, 2 * step));

		chessboard.getChildren().add(pB);
	}

	private double adjustTransform(Node content) {
		content.getTransforms().clear();
		double step = 0;

		double cx = content.getBoundsInParent().getMinX();
		double cy = content.getBoundsInParent().getMinY();
		double cw = content.getBoundsInParent().getWidth();
		double ch = content.getBoundsInParent().getHeight();

		double ew = chessboard.getWidth();
		double eh = chessboard.getHeight();

		if (ew > 0.0 && eh > 0.0) {
			double sc = Math.min(ew / cw, eh / ch);
			double scale = .76 * Math.min(ew / (8 * cw), eh / (8 * ch));

			// Offset to center content
			step = Math.min(ew / 8, eh / 8);
			// Offset to center content
			double sx = 0.5 * (ew - cw * sc);
			double sy = 0.5 * (eh - ch * sc);

			content.getTransforms().add(new Translate(sx, sy));
			content.getTransforms().add(new Translate(-cx, -cy));
			content.getTransforms().add(new Scale(scale, scale, cx, cy));
		}
		return step;
	}

	Group makePawnWhite() {
		Group control = new Group();
		Node out, bot, top;

		String svgPawnTop = "m 54.522611,141.9901 18.84375,0 -7.910156,-6.71485 c 3.140584,-0.72651 4.710895,-2.73042 4.710938,-6.01171 -4.3e-5,-1.7812 -0.621136,-3.25776 -1.863282,-4.42969 -1.218789,-1.19526 -2.671912,-1.79291 -4.359375,-1.79297 -1.710971,6e-5 -3.175814,0.59771 -4.394531,1.79297 -1.21878,1.17193 -1.828155,2.64849 -1.828125,4.42969 -3e-5,3.28129 1.570281,5.2852 4.710938,6.01171 l -7.910157,6.71485 Z";
		String svgPawnBlack = "m 63.944486,172.54088 -20.320312,0 0,-2.60156 c -0.09377,-1.87499 0.386703,-3.48046 1.441406,-4.81641 1.078107,-1.33592 2.554668,-2.60154 4.429688,-3.79687 2.742163,-2.1328 4.746067,-4.67576 6.011718,-7.62891 1.289034,-2.97653 2.214814,-6.11716 2.777344,-9.42188 l -10.089844,0 9.984375,-8.40234 c -2.015653,-1.73433 -3.023464,-3.93745 -3.023437,-6.60937 -2.7e-5,-2.41401 0.855441,-4.48823 2.566406,-6.22266 1.710906,-1.73432 3.785123,-2.6015 6.222656,-2.60156 2.414024,6e-5 4.476522,0.86724 6.1875,2.60156 1.734331,1.73443 2.601518,3.80865 2.601563,6.22266 -4.5e-5,2.67192 -1.007856,4.87504 -3.023438,6.60937 l 9.984375,8.40234 -10.089843,0 c 0.53902,3.30472 1.453082,6.44535 2.742187,9.42188 1.289017,2.95315 3.30464,5.49611 6.046875,7.62891 1.85151,1.19533 3.304634,2.46095 4.359375,3.79687 1.078069,1.33595 1.581975,2.94142 1.511719,4.81641 l 0,2.60156 -20.320313,0 Z";
		String svgPawnBot = "m 46.225736,169.93932 35.4375,0 c 0.187446,-2.27343 -1.359427,-4.40624 -4.640625,-6.39844 -3.093796,-2.36717 -5.402387,-5.16795 -6.925781,-8.40234 -1.500041,-3.25779 -2.425821,-6.87888 -2.777344,-10.86329 l -6.75,0 c -0.351594,3.98441 -1.289093,7.6055 -2.8125,10.86329 -1.500028,3.23439 -3.796901,6.03517 -6.890625,8.40234 -3.304707,1.9922 -4.85158,4.12501 -4.640625,6.39844 Z";

		out = loadContent(svgPawnBlack, Color.BLACK);
		control.getChildren().add(out);

		bot = loadContent(svgPawnBot, Color.WHITE);
		control.getChildren().add(bot);

		top = loadContent(svgPawnTop, Color.WHITE);
		control.getChildren().add(top);

		step = adjustTransform(control);
		return control;
	}

	Group makePawnBlack() {
		Group control = new Group();
		Node out;

		String svgPawnBlack = "M 63.944486,172.54088 L 43.624174,172.54088 L 43.624174,"
				+ "169.93932 C 43.530408,168.06433 44.010877,166.45886 45.06558,165.12291 C 46.143687,163.78699 47.620248,"
				+ "162.52137 49.495268,161.32604 C 52.237431,159.19324 54.241335,156.65028 55.506986,153.69713 C 56.79602,"
				+ "150.7206 57.7218,147.57997 58.28433,144.27525 L 48.194486,144.27525 L 58.178861,135.87291 C 56.163208,"
				+ "134.13858 55.155397,131.93546 55.155424,129.26354 C 55.155397,126.84953 56.010865,124.77531 57.72183,"
				+ "123.04088 C 59.432736,121.30656 61.506953,120.43938 63.944486,120.43932 C 66.35851,120.43938 68.421008,"
				+ "121.30656 70.131986,123.04088 C 71.866317,124.77531 72.733504,126.84953 72.733549,129.26354 C 72.733504,"
				+ "131.93546 71.725693,134.13858 69.710111,135.87291 L 79.694486,144.27525 L 69.604643,144.27525 C 70.143663,"
				+ "147.57997 71.057725,150.7206 72.34683,153.69713 C 73.635847,156.65028 75.65147,159.19324 78.393705,161.32604 C 80.245215,"
				+ "162.52137 81.698339,163.78699 82.75308,165.12291 C 83.831149,166.45886 84.335055,168.06433 84.264799,"
				+ "169.93932 L 84.264799,172.54088 L 63.944486,172.54088 Z";

		out = loadContent(svgPawnBlack, Color.BLACK);
		control.getChildren().add(out);

		step = adjustTransform(control);

		return control;
	}

	private Node loadContent(String svg, Paint color) {
		SVGPath p = new SVGPath();
		p.setContent(svg);
		p.setFill(color);
		p.setStroke(Color.BLACK);
		p.setStrokeMiterLimit(4.0);
		Group content = new Group();
		content.getChildren().add(p);
		return content;
	}

	@FXML
	void initialize() {
		assert button != null : "fx:id=\"button\" was not injected: check your FXML file 'ChessFX.fxml'.";
		assert chessboard != null : "fx:id=\"chessboard\" was not injected: check your FXML file 'ChessFX.fxml'.";

		int grid_x = 8; // number of rows
		int grid_y = 8; // number of columns

		// this binding will find out which parameter is smaller: height or
		// width
		NumberBinding rectsAreaSize = Bindings.min(chessboard.heightProperty(),
				chessboard.widthProperty());

		for (int x = 0, c = 0; x < grid_x; x++, c++) {
			for (int y = 0; y < grid_y; y++) {
				Rectangle rectangle = new Rectangle();
				rectangle.setStroke(Color.BLACK);
				if (c % 2 == 0) {
					rectangle.setFill(Color.ROSYBROWN);
				} else {
					rectangle.setFill(Color.SNOW);
				}
				// here we position rects (this depends on pane size as well)
				rectangle.xProperty().bind(
						rectsAreaSize.multiply(x).divide(grid_x));
				rectangle.yProperty().bind(
						rectsAreaSize.multiply(y).divide(grid_y));

				// here we bind rectangle size to pane size
				rectangle.heightProperty().bind(rectsAreaSize.divide(grid_x));
				rectangle.widthProperty().bind(rectangle.heightProperty());
				c++;

				chessboard.getChildren().add(rectangle);
			}
		}

	}
}
