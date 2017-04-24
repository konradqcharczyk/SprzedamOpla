
import javax.swing.JFrame;


public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private Cont container;
	private static final int WIDTH = 1080;
	private static final int HEIGHT = 720;
	
	public MainFrame(){
		setSize(WIDTH, HEIGHT);
		
		container = new Cont();
		setResizable(false);
		setLocationRelativeTo(null);
		add(container);
	}

}
