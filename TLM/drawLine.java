import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.*;

public class drawLine extends JComponent
{
	public float x;
	public float y;
	public float z;
	public float a;
	
	
	drawLine(int q, int w, int e, int r)
	{
		x = q;
		y = w;
		z = e;
		a = r;
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		Line2D.Float line = new Line2D.Float(x, y, z, a);
		g2.draw(line);
	}
}
