import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Chess extends Application {

    @Override
    public void start(Stage primaryStage) {
        int boardSize = 8;
        GridPane chessboard = new GridPane();
        chessboard.setAlignment(Pos.CENTER);

        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                Rectangle square = new Rectangle(80, 80);
                square.setFill(getSquareColor(row, col));
                chessboard.add(square, col, row);
            }
        }

        Scene scene = new Scene(chessboard, 640, 640); // Adjust the size as needed
        primaryStage.setTitle("Chess Board");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Color getSquareColor(int row, int col) {
        return (row + col) % 2 == 0 ? Color.WHITE : Color.BLACK;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
