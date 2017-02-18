package pkTextAdvanturerGUI;

import javax.swing.*;
import javax.swing.text.TabableView;

import pkTextAdvanture.Game;

import java.awt.event.*;
import java.awt.*;
public class TextAdvantures extends JFrame implements KeyListener {
	
	private JTextArea txaDisplay;
	private JTextField txfCommand;
	private Game gameTA;
	public TextAdvantures() {
		setSize(600, 600);
		setTitle("Text Advantures");
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.pink);
		
		txaDisplay = new JTextArea();
		txaDisplay.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		txaDisplay.setEditable(false);
		txaDisplay.setBackground(Color.CYAN);
		JScrollPane jsp = new JScrollPane(
				txaDisplay, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(jsp, BorderLayout.CENTER);
		
		txfCommand = new JTextField();
		txfCommand.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txfCommand.addKeyListener(this);
		add(txfCommand, BorderLayout.SOUTH);
		
		JLabel lblhead = new JLabel("Text Advantures Game");
		lblhead.setForeground(Color.blue);
		lblhead.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblhead.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		add(lblhead, BorderLayout.NORTH);
		
		String initial = "Game will start soon. Type 'help' if you need help!\n";
		
		gameTA = new Game();		
		initial += gameTA.parser("look") + "\n";
		txaDisplay.setText(initial);
		
		setVisible(true);
		txfCommand.requestFocus();
	}

	public static void main(String[] args) {
		new TextAdvantures();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		if (ke.getKeyChar() == '\n') {
			String cmd = txfCommand.getText().trim();
			String temp = txaDisplay.getText();
			temp += ">>" +cmd + "\n" + gameTA.parser(cmd) + "\n";
			txaDisplay.setText(temp);
			txfCommand.setText("");
			txfCommand.requestFocus();
		}
		
	}

}
