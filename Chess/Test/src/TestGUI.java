import javax.swing.*;
import java.awt.*;

public class TestGUI {
	JFrame fun;

	public TestGUI() {
		fun = new JFrame();
		
		fun.setSize(1200, 1200);
		fun.setTitle("MUY FUN");
		fun.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fun.setVisible(true);
		
		Draw draw = new Draw();
		fun.add(draw);
	}
	
	public class Draw extends JComponent{
		public void paintComponent (Graphics g) {
			Graphics2D g2 = (Graphics2D)g;
			g2.setColor(Color.BLACK);
			g2.drawRect(300, 200, 50, 100);
			
			g2.setColor(Color.MAGENTA);
			g2.fillRect(300, 200, 50, 100);
			
			g2.setColor(Color.RED);
			g2.drawLine(150, 150, 100, 50);
			
			g2.drawLine(150, 150, 200, 500);
			
			g2.setColor(Color.BLUE);
			g.fillOval(600, 400, 200, 100);
			
		}
	}
	
}
