package ui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import game.*;

@SuppressWarnings("serial")
public class BoardView extends JFrame {

	JPanel fieldGameBoard = new JPanel();
	JPanel fieldMainBoard = new JPanel();

	JButton[][] buttons;

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem quit;
	private JMenuItem newGame;

	BoardModel board;

	public BoardView(BoardModel boardModel) {

		this.board = boardModel;
		int size = boardModel.size;

		buttons = new JButton[size][size];
		System.out.println(size);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		board.test();
		initializeBoardView();
		inatilizeMenuBar();

	}

	public void resetBoard(BoardModel modellBoard) {

		this.board = modellBoard;

	}

	private void placeStone(int xGrid, int yGrid) {
		
		boolean wasPlaced = board.placeStone(xGrid, yGrid);
		
		//TODO Placement needs to be checked in the model.
		if (wasPlaced) {
			int size = board.size;
		
			for (int x = 0; x < size; x++) {
				for (int y = 0; y < size; y++) {
					
					// Ask the model about the state of the clicked field.
					EFieldState state = board.fields[x][y];
					
					// Adjust labels accordingly.
					if (state == EFieldState.RED) {
						this.buttons[x][y].setIcon(new ImageIcon(Stone_Red()));
					}
					else if (state == EFieldState.BLUE) {
						this.buttons[x][y].setIcon(new ImageIcon(Stone_Blue()));
					}
				}
			}
		}		
	}

	private void initializeBoardView() {
		
		int size = board.size;
		this.fieldGameBoard.setLayout(new GridLayout(size, size));
		this.setSize(800, 800);
		ButtonListener bl = new ButtonListener();
		
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				
				this.buttons[x][y] = new JButton();

				this.buttons[x][y].setBorder(new LineBorder(Color.BLACK));
				this.buttons[x][y].setFocusPainted(true);
				this.buttons[x][y].setContentAreaFilled(true);
				
				if (board.fields[x][y] == EFieldState.RED) {
					this.buttons[x][y].setIcon(new ImageIcon(Stone_Red()));

				} else if (board.fields[x][y] == EFieldState.BLUE) {
					this.buttons[x][y].setIcon(new ImageIcon(Stone_Blue()));
				} else {
					this.buttons[x][y].setBackground(Color.WHITE);
					this.buttons[x][y].setText(x + "" + y);
				}

				this.buttons[x][y].setForeground(Color.BLACK);
				buttons[x][y].addActionListener(bl);
				fieldGameBoard.add(buttons[x][y]);
			}
		}
		this.setContentPane(fieldGameBoard);

	}

	private void inatilizeMenuBar() {
		menuBar = new JMenuBar();
		menu = new JMenu("File");// File weil konvention
		newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AppManager.resetBoardView();
			}

		});
		quit = new JMenuItem("Quit");
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		menu.add(newGame);
		menu.add(quit);
		menuBar.add(menu);
		setJMenuBar(menuBar);

	}

	class ButtonListener implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent e) {

			for (int x = 0; x < 8; x++) {
				for (int y = 0; y < 8; y++) {
					if (e.getSource() == buttons[x][y]) {
						System.out.println("JButton " + (x + 1) + " wurde geklickt.");
						placeStone(x, y);
					}
				}
			}
		}
	}

	private Image Stone_Red() {
		Image RED_STONE = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
		Graphics red_stone = RED_STONE.getGraphics();
		red_stone.setColor(Color.RED);
		red_stone.fillOval(0, 0, 1000, 1000);
		RED_STONE = RED_STONE.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		return RED_STONE;

	}

	private Image Stone_Blue() {

		Image BLUE_STONE = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
		Graphics blue_stone = BLUE_STONE.getGraphics();
		blue_stone.setColor(Color.BLUE);
		blue_stone.fillOval(0, 0, 1000, 1000);
		BLUE_STONE = BLUE_STONE.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		return BLUE_STONE;
	}

}