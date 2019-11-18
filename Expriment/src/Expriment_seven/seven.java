package Expriment_seven;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class seven {
    static class F extends Frame {
        F() {
            int x = 200, y = 200, w = 200, h = 200;
            setBounds(x, y, w, h);
            setBackground(Color.blue);//设置整个窗口颜色为蓝色
            Panel p = new Panel();
            p.setBounds(x / 4, y / 4, w / 2, h / 2); //画一个面板
            p.setBackground(Color.yellow);//设置此面板颜色为黄色
            setLayout(null);//用来设置用户界面上的屏幕组件的格式布局
            add(p);
            setVisible(true);//可以运行开始画图了
        }

        public static void main(String[] args) {
            new F();
        }
    }

    static class Button {
        public static void main(String[] args) {
            Frame f = new Frame();
            f.setLayout(new GridLayout(2, 1));
            f.setBounds(300, 300, 300, 300);

            Panel p1 = new Panel(new BorderLayout());
            Panel p2 = new Panel(new BorderLayout());
            Panel p3 = new Panel(new GridLayout(2, 1));
            Panel p4 = new Panel(new GridLayout(2, 2));

            p1.add(new java.awt.Button("button"), BorderLayout.WEST);
            p1.add(new java.awt.Button("button"), BorderLayout.EAST);
            p3.add(new java.awt.Button("button"));
            p3.add(new java.awt.Button("button"));

            p1.add(p3, BorderLayout.CENTER);
            p2.add(new java.awt.Button("button"), BorderLayout.WEST);
            p2.add(new java.awt.Button("button"), BorderLayout.EAST);

            for(int i=0;i<4;++i)
            {
                p4.add(new java.awt.Button("button"));
            }

            p2.add(p4,BorderLayout.CENTER);
            f.add(p1);f.add(p2);
            f.setVisible(true);
        }
    }

    static class Calculator{
        public static void main(String[] args)
        {
            Frame f=new Frame();
            f.setBounds(300,300,300,300);
            f.setLayout(new BorderLayout());

            Panel p1=new Panel();
            p1.setLayout(new GridLayout(1,0));
            p1.add(new TextField());

            Panel p2=new Panel();
            p2.setLayout(new GridLayout(4,4));

            p2.add(new java.awt.Button("7"));
            p2.add(new java.awt.Button("8"));
            p2.add(new java.awt.Button("9"));
            p2.add(new java.awt.Button("/"));
            p2.add(new java.awt.Button("4"));
            p2.add(new java.awt.Button("5"));
            p2.add(new java.awt.Button("6"));
            p2.add(new java.awt.Button("*"));
            p2.add(new java.awt.Button("1"));
            p2.add(new java.awt.Button("2"));
            p2.add(new java.awt.Button("3"));
            p2.add(new java.awt.Button("-"));
            p2.add(new java.awt.Button("0"));
            p2.add(new java.awt.Button("."));
            p2.add(new java.awt.Button("="));
            p2.add(new java.awt.Button("+"));

            f.add(p1,BorderLayout.NORTH);
            f.add(p2,BorderLayout.CENTER);
            f.addWindowFocusListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e){
                    System.exit(0);
                }
            });
            f.setVisible(true);
        }
    }
}
