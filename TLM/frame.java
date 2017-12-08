import javax.swing.*;

public class frame {
	public static void main(String[] args) {
		JFrame window = new JFrame("Team Last Minute - Best Object drawing ever!");
		window.setSize(640,480);
		//test t = new test();
		//drawRec r = new drawRec(100,100,10,10);
		//drawCir c = new drawCir(100,200,10,10);
		drawLine l = new drawLine(100,100,250,260);
		//window.add(t);
		//window.add(r);
		//window.add(c);
		window.add(l);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
