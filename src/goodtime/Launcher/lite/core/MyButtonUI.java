package goodtime.Launcher.lite.core;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.LookAndFeel;
import javax.swing.plaf.basic.BasicButtonUI;

public class MyButtonUI extends BasicButtonUI {

	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
	}

	@Override
	protected void installDefaults(AbstractButton b) {
		super.installDefaults(b);
		LookAndFeel.installProperty(b, "opaque", Boolean.FALSE);
	}

	@Override
	protected void paintButtonPressed(Graphics g, AbstractButton b) {
		super.paintButtonPressed(g, b);
	}

	@Override
	protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect,
			Rectangle textRect, Rectangle iconRect) {
		super.paintFocus(g, b, viewRect, textRect, iconRect);
	}

	@Override
	protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect) {
		super.paintIcon(g, c, iconRect);
	}

	@Override
	protected void paintText(Graphics g, AbstractButton b, Rectangle textRect,
			String text) {
		super.paintText(g, b, textRect, text);
	}

	@Override
	protected void paintText(Graphics g, JComponent c, Rectangle textRect,
			String text) {
		super.paintText(g, c, textRect, text);
	}

}
