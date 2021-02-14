package labbRegex;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {

	private JFrame frame;

	public UserInterface() {
	}

	@Override
	public void run() {
		frame = new JFrame("Title");
		frame.setPreferredSize(new Dimension(1000, 400));

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		createComponents(frame.getContentPane());

		frame.pack();
		frame.setVisible(true);
	}

	private void createComponents(Container container) {
		//GridLayout gridLayout = new GridLayout(4, 1);
		GridLayout gridLayout = new GridLayout(2,3,10,10);
		container.setLayout(gridLayout);

		JLabel msg = new JLabel("Some Text here");
		JTextField input1 = new JTextField("name");
		JTextField input2 = new JTextField("tel");
		JTextField input3 = new JTextField("mail");

		JTextArea output = new JTextArea();
		
		JButton checkButton = new JButton("Check");
		
		MessageListener check = new MessageListener(input1,input2,input3, output);
		checkButton.addActionListener(check);

		container.add(msg);
		container.add(input1);
		container.add(input2);
		container.add(input3);
		container.add(checkButton);
		container.add(output);


	}

	public JFrame getFrame() {
		return frame;
	}

}
