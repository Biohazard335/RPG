package menu.map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import locations.Game;
import locations.Lolcation;

public class Pnl extends JPanel {

	/* 
	  *
	  */
	private static final long serialVersionUID = 1L;
	private int sizeXY = 150;

	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 500, 500);
		Image map = Toolkit.getDefaultToolkit().getImage("./data/Map1.png");
		if (Game.z != -1) {
			g.drawImage(map, -140 - (2 * sizeXY) + -(Game.x * sizeXY), -150
					- (2 * sizeXY) + (Game.y * sizeXY), this);
		}

		for (Lolcation l : Game.locations) {
			g.setColor(Color.BLACK);

			if (l.explored == false && l.z == Game.z) {
				g.setColor(Color.BLACK);
				g.fillRect((l.x * sizeXY) + 160 - (Game.x * sizeXY),
						-(l.y * sizeXY) + 150 + (Game.y * sizeXY), sizeXY,
						sizeXY);
			}

		}

	}
}
