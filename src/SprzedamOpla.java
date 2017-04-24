import java.awt.EventQueue;

import javax.swing.JFrame;

public class SprzedamOpla{
	/**Made by Konrad Kucharczyk
	 * Data Base for car dealer with GUI
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				JFrame frame = new MainFrame();
				
				frame.setTitle("Sprzedam Opla");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}	
}
