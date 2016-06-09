package menu.map;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JApplet;
import javax.swing.JButton;

import locations.Game;

public class RPGMap extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton ok = new JButton("Ok");

	public void init() {
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.map.get(Game.game).setEnabled(true);
				Game.map.get(RPGMap.this).dispose();
			}
		});

		Box bh = Box.createHorizontalBox();
		bh.add(Box.createHorizontalStrut(210));
		bh.add(ok);

		Container cp = getContentPane();
		cp.add(new Pnl());
		cp.add(BorderLayout.SOUTH, bh);
	}

}
