package menu.map;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.Box;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SetButtons extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() {
		Box bh = Box.createHorizontalBox();
		bh.add(Box.createHorizontalStrut(210));
		bh.add(new JButton("bh "));
		Container cp = getContentPane();
		cp.add(BorderLayout.SOUTH, bh);
	}

	public static void main(String[] args) {
		run(new SetButtons(), 450, 300);
	}

	public static void run(JApplet applet, int width, int height) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(applet);
		frame.setSize(width, height);
		applet.init();
		applet.start();
		frame.setVisible(true);
	}
} // /:~

