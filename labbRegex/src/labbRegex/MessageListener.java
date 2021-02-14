package labbRegex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MessageListener implements ActionListener {

	private JTextField input1;
	private JTextField input2;
	private JTextField input3;
	private JTextArea output;

	public MessageListener(JTextField input1, JTextField input2, JTextField input3, JTextArea output) {
		super();
		this.input1 = input1;
		this.input2 = input2;
		this.input3 = input3;
		this.output = output;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = input1.getText();
		String tel = input2.getText();
		String mail = input3.getText();
		String re = "";

		if (rexgexCheck(name, "^[a-zA-Z .'-]+$")) {
			re+="Name: "+name+"\n";
		}else {
			re+="Wrong name\n";
		}
		
		if (rexgexCheck(tel, "^[0-9]+$")) {
			re+="Tel: "+tel+"\n";
		}else {
			re+="Wrong tel\n";
		}
		
		if (rexgexCheck(mail, "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9.]+$")) {
			re+="Mail: "+mail;
		}else {
			re+="Wrong mail";
		}

		this.output.setText(re);
	}

	private boolean rexgexCheck(String toCheck, String pattern) {
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(toCheck);
		return matcher.find();
	}

}
