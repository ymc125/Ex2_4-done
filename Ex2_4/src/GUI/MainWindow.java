package GUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import GIS.pakmen;
import Geom.Point3D;
import GIS.ShortestPathAlgo;
import GIS.furit;
//This is the graphic department that allows us to play the game (readme in detail)
//	@author yitzhak.
public class MainWindow extends JFrame implements MouseListener
{
	private JTextField filename = new JTextField(), dir = new JTextField();
	public ArrayList<furit> my_fruit=new ArrayList<>();
	public ArrayList<pakmen> my_pakmen=new ArrayList<>();
	private int isCliked=0;
	private static final long serialVersionUID = 1L;
	public BufferedImage myImage;
	public BufferedImage myImagepakmen;
	public BufferedImage myImagefurit;

	public MainWindow() 
	{//Opens the image at a fixed size
		initGUI();		
		this.addMouseListener(this); 
		this.setSize(1433,642);
	}
	//Here we create the menu of the game window
	private void initGUI()  {
		MenuBar menuBar = new MenuBar();

		Menu menu1 = new Menu("file");
		Menu menu2 = new Menu("objects");
		Menu menu3 = new Menu("demo");

		MenuItem item1 = new MenuItem("open");
		MenuItem item2 = new MenuItem("clear");
		MenuItem item3 = new MenuItem("save");

		MenuItem item4 = new MenuItem("pakmen");
		MenuItem item5 = new MenuItem("furit");

		MenuItem item7 = new MenuItem("path");
		MenuItem item8 = new MenuItem("live");
		MenuItem item9 = new MenuItem("to_kml");
		MenuItem run_game = new MenuItem("Run the game");

		menuBar.add(menu1);
		menuBar.add(menu2);
		menuBar.add(menu3);

		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);

		menu2.add(item4);
		menu2.add(item5);

		menu3.add(item7);
		menu3.add(item8);
		menu3.add(item9);
		menu3.add(run_game);
		
		//Here is a function that allows us to listen to our actions for each key from the menu
		run_game.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ShortestPathAlgo test= new ShortestPathAlgo(my_fruit,my_pakmen);
			}
		});
		item1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser c = new JFileChooser();
				// Demonstrate "Open" dialog: 
				int rVal = c.showOpenDialog(dir);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					filename.setText(c.getSelectedFile().getName());
					dir.setText(c.getCurrentDirectory().toString());
					String openFile= c.getCurrentDirectory().toString()+"\\"+c.getSelectedFile().getName();
					System.out.println(openFile);
					try {
						repaint();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "invalid input");
					}
				}
				if (rVal == JFileChooser.CANCEL_OPTION) {
					filename.setText("You pressed cancel");
					dir.setText("");
				}
			}
		});

		item1.setEnabled(true);

		item2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		item2.setEnabled(true);

		item3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		item3.setEnabled(true);

		item4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				isCliked=2;
			}
		});
		item4.setEnabled(true);

		item5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isCliked=1;
			}
		});
		item5.setEnabled(true);

		item7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		item7.setEnabled(true);

		item8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		item8.setEnabled(true);

		run_game.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		run_game.setEnabled(true);

		this.setMenuBar(menuBar);

		try {//Adds the map and the iconic icons of Fackman and the fruits
			myImage = ImageIO.read(new File("C://Ariel1.png"));
			myImagepakmen = ImageIO.read(new File("C://packman.jpg"));
			myImagefurit = ImageIO.read(new File("C://fruit.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	double x = -1;
	double y = -1;

	@Override
	//Here we define the dimensions of the icons
	public void paint (Graphics g) {
		g.drawImage(myImage, 0, 0, getWidth(), getHeight(),this);
		if (isCliked!=0) {
			for (int i = 0; i < my_pakmen.size(); i++) {
				x=my_pakmen.get(i).getPoint().x()*getWidth();
				y=(my_pakmen.get(i).getPoint().y())*getHeight();
				g.drawImage(myImagepakmen,(int) x,(int) y,30,30, null);
			}			
			for (int i = 0; i < my_fruit.size(); i++) {
				g.setColor(Color.GREEN);
				x=my_fruit.get(i).getPoint().x()*getWidth();
				y=my_fruit.get(i).getPoint().y()*getHeight();
				g.drawImage(myImagefurit,(int) x,(int) y,30,30, null);
			}}}
	@Override
	//At the touch of a button, the computer knows how to listen to what we wrote 
	//- to insert the icon into the marked points on the map
	public void mouseClicked(MouseEvent arg) {
		System.out.println("mouse Clicked");
		System.out.println("("+ arg.getX() + "," + arg.getY() +")");
		x = arg.getX();
		y = arg.getY();
		repaint();
		if(isCliked==2) {
			my_pakmen.add(new pakmen(new Point3D(x/getWidth(), y/getHeight()),1,0));
		}
		if(isCliked==1) {
			furit f=new furit();
			f.setPoint(new Point3D(x/getWidth(), y/getHeight()));
			my_fruit.add(f);
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void mouseEntered(MouseEvent arg0) {//אם ניכנס לאזור מסוים
//		System.out.println("mouse entered");
//	}
//	@Override
//	public void mouseExited(MouseEvent arg0) {//כנל אם נצא
//		// TODO Auto-generated method stub
//	}
//	@Override
//	public void mousePressed(MouseEvent arg0) {//כל קליק
//		// TODO Auto-generated method stub
//	}
//	@Override
//	public void mouseReleased(MouseEvent arg0) {//שחרור לחיצה
//		// TODO Auto-generated method stub
	//}
public static void main(String[] args) {
	MainWindow ejemplo= new MainWindow();
	ejemplo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	ejemplo.setVisible(true);
}
}
