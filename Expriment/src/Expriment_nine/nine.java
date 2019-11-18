package Expriment_nine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class nine {
    static class frame extends JFrame{
        private static final long serialVer=-3229434935585351686L;
        public void lauchFrame() {
            setBounds(300, 300, 300, 300);

            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    setVisible(false);
                    System.exit(0);
                }
            });
            setVisible(true);
        }

        public void paint(Graphics g)
        {
            Random r=new Random();
            int i=r.nextInt(3);

            if(i==0){
                g.setColor(Color.BLACK);
                g.fillOval(50,50,100,100);
            }
            else if(i==1) {
                g.setColor(Color.blue);
                g.fillOval(50,50,100,100);
            }
            else {
                g.setColor(Color.cyan);
                g.drawLine(50,50,100,100);
            }
        }

        public static void main(String[] args)
        {
            new frame().lauchFrame();
        }
    }

    static class frame_two extends JFrame{
        public void launchFFrame(){
            setBounds(300,300,300,300);

            addWindowFocusListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    setVisible(false);
                    System.exit(0);
                }
            });

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    int x=e.getX();
                    int y=e.getY();
                    System.out.println("x:"+x+",y:"+y);
                }
            });

            setVisible(true);
        }

        public void paint(Graphics g)
        {
            g.drawString("五星",200,200);
            g.drawLine(81,55,37,190);
            g.drawLine(37,190,159,93);
            g.drawLine(159,93,32,96);
            g.drawLine(32,96,155,188);
            g.drawLine(155,188,81,55);
        }

        public static void main(String[] args)
        {
            new frame_two().launchFFrame();
        }
    }

    static class frame_three extends JFrame{
        private void lauchFFrame(){
            setBounds(300,300,500,400);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    setVisible(false);
                    System.exit(0);
                }
            });

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    int x=e.getX();
                    int y=e.getY();
                    System.out.println("x:"+x+",y:"+y);
                }
            });
            setVisible(true);
        }

        public void paint(Graphics g){
            g.setColor(Color.blue);
            g.fillRect(200,80,100,100);
            g.drawOval(175,60,150,150);

            g.setColor(Color.red);
            g.fillRect(175,150,300,100);
            g.fillOval(90,140,20,30);
            g.fillOval(390,140,20,20);
            g.fillOval(90,140,20,30);
            g.fillOval(390,140,20,20);

            g.fillRect(90,150,10,100);
            g.fillRect(400,150,10,100);
            g.fillRect(100,140,300,10);
            g.fillRect(100,250,300,10);

            g.fillOval(140,240,60,60);
            g.fillOval(300,240,60,60);

            g.setColor(Color.BLACK);
            g.drawLine(50,300,450,300);
        }

        public static void main(String[] args)
        {
            new frame_three().lauchFFrame();
        }
    }
}
