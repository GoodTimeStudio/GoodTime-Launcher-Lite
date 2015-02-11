package goodtime.Launcher.lite.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;

	@Override
	public void paint(Graphics arg0) {
		super.paint(arg0);
	}
	@Override
	protected void paintComponent(Graphics arg0) {
		Graphics2D g2d = (Graphics2D) arg0;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.setColor(new Color(0, 0, 0));
		g2d.setClip(0, 0, getWidth(), 35);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setClip(null);
		
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		g2d.drawString("GoodTimeÆô¶¯Æ÷ Lite", 20, 20);
	}
	
	@Override
	protected void paintBorder(Graphics arg0) {
		super.paintBorder(arg0);
	}

	@Override
	protected void paintChildren(Graphics arg0) {
		super.paintChildren(arg0);
	}

	

}
