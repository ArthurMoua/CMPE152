import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class drawRec extends JPanel
{
	
	public int x;
	public int y;
	public int z;
	public int a;
	
	
	drawRec(int q, int w, int e, int r)
	{
		x = q;
		y = w;
		z = e;
		a = r;
	}
	
	public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			this.setBackground(Color.WHITE);
			
			//g.setColor(Color.BLUE);
			g.fillRect(x,y,z,a);
		}

}

