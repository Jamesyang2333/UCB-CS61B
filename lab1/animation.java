import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class animation implements ActionListener{
JFrame frame;
int x=50;
int y=50;
MyDrawPanel drawPanel=new MyDrawPanel();
public static void main(String[] args){
	animation gui=new animation();
	gui.go();
}

public void go(){
	frame=new JFrame();
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	JButton button=new JButton("Change colors");
	button.addActionListener(this);
frame.getContentPane().add(BorderLayout.SOUTH,button);
frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
frame.setSize(300,300);
frame.setVisible(true);
for(int i=0;i<130;i++)
{
	
	x++;
	y++;
	drawPanel.repaint();
	try{Thread.sleep(50);
	}catch(Exception ex){}
}
}
public void actionPerformed (ActionEvent event){
drawPanel.setColor();
}
public class MyDrawPanel extends JPanel{
	
	GradientPaint gradient=new GradientPaint(50,50,Color.blue,200,200,Color.green);
	public void paintComponent(Graphics g){
		Graphics2D g2d=(Graphics2D) g;
	
	
	g2d.setPaint(gradient);
		g.fillOval(x,y,100,100);

	}
	public void setColor(){
		int red=(int)(Math.random()*255);
	int green=(int)(Math.random()*255);
	int blue=(int)(Math.random()*255);
	Color startColor=new Color(red,green,blue);
		red=(int)(Math.random()*255);
	 green=(int)(Math.random()*255);
	blue=(int)(Math.random()*255);
	Color endColor=new Color(red,green,blue);
	gradient=new GradientPaint(50,50,startColor,200,200,endColor);
	}
}
}