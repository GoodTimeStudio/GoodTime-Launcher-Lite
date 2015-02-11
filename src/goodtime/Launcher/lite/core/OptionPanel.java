package goodtime.Launcher.lite.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;


public class OptionPanel extends JPanel {

	private static final long serialVersionUID = 3L;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}


	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.setColor(new Color(0, 0, 0));
		g2d.setClip(0, 0, getWidth(), 35);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setClip(null);
		
		g2d.setColor(new Color(0, 0, 0, 80));
		g2d.drawRect(0, 0, getWidth(), getHeight());
		
		g2d.setColor(new Color(160, 230, 230, 50));
		g2d.fillRect(0, 35, getWidth(), getHeight());
	}

	
	@Override
	protected void paintBorder(Graphics g) {
		super.paintBorder(g);
	}

	@Override
	protected void paintChildren(Graphics g) {
		super.paintChildren(g);
	}

}
