import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class MyButton extends JButton{

	private static final long serialVersionUID = -3674520473553164221L;

	public MyButton(String buttonText){
		super(buttonText);
		setPreferredSize(new Dimension(250, 40));
		setBackground(Color.BLACK);
		setForeground(Color.GRAY);
		setBorderPainted(false);
		setFocusPainted(false);
		setRolloverEnabled(false);
		setFont(new Font("Helvetica",1,20));
	}
}
