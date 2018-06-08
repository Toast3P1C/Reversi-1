package ui;

//Test

import game.*;

public class AppManager {

	static SetupView setupView;
	static BoardView boardView;
	static BoardModel boardModel;

	public static void main(String[] args) {

		setupView = new SetupView();
		setupView.setVisible(true);
	}

	public static void createBoard(int size) {

		boardModel = new BoardModel(size);
		resetBoardView();
	}

	public static void resetBoardView() {

		if (boardView != null) {
			boardView.setVisible(false);
			boardView.dispose();
		}

		boardView = new BoardView(boardModel);
		boardView.setVisible(true);
		boardView.setResizable(false);
	}
}
