import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Framed {
public static int width,height;
public static Canvas canvas;
public static JFrame frame;

public Framed(int width,int height){
	this.height= height;
	this.width = width;
}
public void display(){
	frame = new JFrame();
	frame.setSize(width, height);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	canvas = new Canvas();
	canvas.setPreferredSize(new Dimension(width,height));
	canvas.setMaximumSize(new Dimension(width,height));
	canvas.setMinimumSize(new Dimension(width,height));
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	frame.add(canvas);
	frame.setLocation((int)(d.getWidth()-width)/2,(int)(d.getHeight()-height)/2);
	frame.pack();
}
public static void setTitle(String title){
	frame.setTitle(title);
}
public static Canvas getCanvas(){
	return canvas;
}

public static JFrame getFrame(){
	return frame;
}

}
