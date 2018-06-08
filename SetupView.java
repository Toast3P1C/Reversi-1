package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import game.*;

@SuppressWarnings("serial")
public class SetupView extends JFrame {
	private JButton buttonklein;
	private JButton buttonmittel;
	private JButton buttongross;
	private JLabel labelauswahl;

	private int boardSize = BoardModel.MIN_SIZE;

	public SetupView() {

		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setSize(400, 300);
		this.initialisiereKomponenten();
		this.ordneKomponentenAn();
		this.registriereListener();

	}

	public int getBoardSize() {
		return boardSize;
	}

	private void initialisiereKomponenten() {
		this.labelauswahl = new JLabel("Wie groß soll ihr Spielfeld sein? ");
		this.buttonklein = new JButton("8x8");
		this.buttonmittel = new JButton("12x12");
		this.buttongross = new JButton("16x16");

	}

	private void ordneKomponentenAn() {
		GridBagLayout layout = new GridBagLayout();
		this.getContentPane().setLayout(layout);
		GridBagConstraints c = new GridBagConstraints();
		// c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(4, 4, 4, 4);

		c.gridx = 1;
		c.gridy = 0;
		this.getContentPane().add(this.labelauswahl, c);

		c.gridx = 0;
		c.gridy = 1;
		this.getContentPane().add(this.buttonklein, c);

		c.gridx = 1;
		c.gridy = 1;
		this.getContentPane().add(this.buttonmittel, c);

		c.gridx = 2;
		c.gridy = 1;
		this.getContentPane().add(this.buttongross, c);

	}

	private void registriereListener() {
		this.buttonklein.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boardSize = BoardModel.MIN_SIZE;
				AppManager.createBoard(boardSize);
			}
		});
		this.buttonmittel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boardSize = BoardModel.MEDIUM_SIZE;
				AppManager.createBoard(boardSize);
			}
		});
		this.buttongross.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boardSize = BoardModel.MAX_SIZE;
				AppManager.createBoard(boardSize);
			}
		});

	}

}
