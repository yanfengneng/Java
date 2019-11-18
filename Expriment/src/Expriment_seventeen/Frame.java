package Expriment_seventeen;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame {
    private JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JButton button1;
    JButton button2;
    String[] str = new String[]{"日", "一", "二", "三", "四", "五", "六"};
    JButton[] button;
    JLabel[] label;
    JLabel now;
    calendarBean calen;
    String[] day;

    Frame() {
        this.button = new JButton[this.str.length];
        this.now = new JLabel();
        this.calen = new calendarBean();
        this.init();
    }

    void init() {
        this.calen.setYear(2019);
        this.calen.setMonth(3);
        this.button1 = new JButton("上月");
        this.button1.setActionCommand("last");
        this.button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame.this.calen.actionPerformed(e);
            }
        });
        this.button2 = new JButton("下月");
        this.button2.setActionCommand("next");
        this.button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame.this.calen.actionPerformed(e);
            }
        });
        this.panel1 = new JPanel();
        this.panel1.add(this.button1);
        this.panel1.add(this.button2);
        GridLayout grid = new GridLayout(7, 7);
        this.add(this.panel1, "North");
        this.panel2 = new JPanel();

        int i;
        for(i = 0; i < this.str.length; ++i) {
            this.button[i] = new JButton(this.str[i]);
            this.panel2.add(this.button[i]);
        }

        this.day = this.calen.getCalendar();
        this.label = new JLabel[42];

        for(i = 0; i < 42; ++i) {
            this.label[i] = new JLabel();
            this.panel2.add(this.label[i]);
        }

        this.calen.label = this.label;

        for(i = 0; i < this.day.length; ++i) {
            this.label[i].setText("        " + this.day[i]);
        }

        this.add(this.panel2, "Center");
        this.panel2.setLayout(grid);
        this.panel3 = new JPanel();
        this.now.setText(this.calen.year + "年" + this.calen.month + "月");
        this.calen.now = this.now;
        this.panel3.add(this.now);
        this.add(this.panel3, "South");
    }
}