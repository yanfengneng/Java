package Expriment_eight;

import javafx.scene.text.Text;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eight {
    static class graphInter{
        public static void main(String[] args)
        {
            Frame f=new Frame();
            f.setBounds(300,300,300,300);
            Panel p1=new Panel(),p2=new Panel(),p21=new Panel(),p22=new Panel();

            p1.setLayout(new GridLayout(1,0));

            Choice c=new Choice();
            c.add("red");c.add("green");c.add("blue");

            p1.add(c);
            p2.setLayout(new GridLayout(2,1));
            p21.setLayout(new FlowLayout(FlowLayout.CENTER));
            p22.setLayout(new FlowLayout(FlowLayout.CENTER));

            p21.add(new Checkbox("background"));
            p21.add(new Checkbox("frontground"));
            p22.add(new Checkbox("sure"));
            p22.add(new Checkbox("cancle"));

            p2.add(p21);
            p2.add(p22);

            f.add(p1,BorderLayout.NORTH);
            f.add(p2,BorderLayout.CENTER);

            f.setVisible(true);
       }
    }

    static class graph_2 extends Frame{
        static TextField tf1=new TextField();
        static TextField tf2=new TextField();
        static TextField tf3=new TextField();

        static Button b1=new Button("求和");
        static Button b2=new Button("清除");

        public static void main(String[] args)
        {
            graph_2 g=new graph_2();
            g.setBounds(300,300,300,300);
            g.setLayout(new GridLayout(3,13));
            g.add(new Label("加数1："));

            g.add(tf1);
            g.add(new Label());
            tf1.getText();
            g.add(new Label("加数2："));

            g.add(tf2);
            g.add(new Label());

            b1.addActionListener(new graph_2().new T());
            b2.addActionListener((new graph_2().new T()));

            g.add(b1);
            g.add(tf3);
            g.add(b2);

            g.setVisible(true);
        }
        class T implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(actionEvent.getSource()==b1)
                {
                    int a=Integer.parseInt(tf1.getText());
                    int b=Integer.parseInt(tf2.getText());
                    tf3.setText(""+(a+b));
                }
                else if(actionEvent.getSource()==b2)
                {
                    tf1.setText("");
                    tf2.setText("");
                    tf1.setText("");
                }
            }
        }
    }

}
