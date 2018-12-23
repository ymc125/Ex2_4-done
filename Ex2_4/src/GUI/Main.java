package GUI;
//import javax.swing.JFrame;
import javax.swing.*;

public class Main extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label;
	public Main() 
	{
	label= new JLabel("heloow");
	add(label);
}


	public static void main(String[] args)
	{
		MainWindow MainWindow = new MainWindow();//יוצר חלון
		MainWindow.setSize(MainWindow.myImage.getWidth(),MainWindow.myImage.getHeight());
		
		MainWindow.setTitle("pakmen");
		MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainWindow.setVisible(true);//מאפשר לראות את החלון פיזי
	
	}
}
