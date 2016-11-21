package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class Send extends JButton{
	public Send(JTextArea ta) {
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta.append("\nklick send");
			}

	});
}
}