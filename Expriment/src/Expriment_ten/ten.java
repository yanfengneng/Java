package Expriment_ten;

import javafx.scene.layout.Pane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ten {
    public static class InputData implements ActionListener{
        Frame f;
        Label l1,l2,l3,l4;
        TextField t;
        Checkbox r1,r2;
        CheckboxGroup g;
        Checkbox c1,c2,c3;
        Choice ch;
        Button b;
        TextArea ta;
        Panel p1,p2,p3,p4,p5;
        int i=0;
        public InputData()
        {
            f=new Frame("信息录入");
            f.setBounds(200,200,500,500);
            ch=new Choice();

            l1=new Label("姓名：");l2=new Label("性别：");
            l3=new Label("爱好：");l4=new Label("籍贯：");

            t=new TextField();
            t.setSize(200,10);

            g=new CheckboxGroup();

            r1=new Checkbox("男",g,false);
            r2=new Checkbox("女",g,true);

            c1=new Checkbox("体育");
            c2=new Checkbox("音乐");
            c3=new Checkbox("美术");

            b=new Button("确定");
            b.addActionListener(this);

            ta=new TextArea();
            p2=new Panel();
            p3=new Panel();
            p4=new Panel();
            p5=new Panel();

            ch.add("济南");
            ch.add("廊坊");
            ch.add("济宁");

            Panel p=new Panel();
            p.setLayout(new GridLayout(5,1));

            p1=new Panel();
            p1.setLayout(new FlowLayout(FlowLayout.LEFT));
            p2.setLayout(new FlowLayout(FlowLayout.LEFT));
            p3.setLayout(new FlowLayout(FlowLayout.LEFT));
            p4.setLayout(new FlowLayout(FlowLayout.LEFT));

            p.add(p1);p.add(p2);p.add(p3);p.add(p4);p.add(p5);

            p1.add(l1);p1.add(t);

            p2.add(l2);p2.add(r1);p2.add(r2);
            p3.add(l3);p3.add(c1);p3.add(c2);p3.add(c3);
            p4.add(l4);p4.add(ch);
            p5.setLayout(new FlowLayout(FlowLayout.CENTER));
            p5.add(b);

            f.setLayout(new GridLayout(2,1));
            f.add(p);
            f.add(ta);

            f.addWindowFocusListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    f.setVisible(false);
                    System.exit(0);
                }
            });
            f.setVisible(true);
        }
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            i++;
            String n="第"+i+"名同学的输入信息为：\n";
            n+="姓名："+t.getText()+" ";
            String xingbie=" "+g.getSelectedCheckbox().getLabel();
            String aihao=" "+(c1.getSelectedObjects()==null?"":c1.getLabel())+" "+
                    (c2.getSelectedObjects()==null?"":c2.getLabel())+
                    " "+(c3.getSelectedObjects()==null?"":c3.getLabel());
            n+="性别："+xingbie+" "+"爱好："+aihao;
            n+="籍贯："+(ch.getSelectedIndex()==0?"济南":(ch.getSelectedIndex()==1?"潍坊":"济宁"));
            ta.append(n+"\n");
        }
        public static void main(String[] args)
        {
            new InputData();
        }
    }
}
