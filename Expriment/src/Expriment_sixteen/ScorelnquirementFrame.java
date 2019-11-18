package Expriment_sixteen;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

class ScoreInquirementFrame  extends JFrame implements ActionListener
{
    JPanel contentPane;
    Connection connection;
    Statement st;
    JSplitPane jSplitPane1 = new JSplitPane();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel1 = new JPanel();
    JScrollPane jScrollPane1 = new JScrollPane();
    public JTextArea jTextArea1 = new JTextArea();
    JLabel jLabel1 = new JLabel("考号");
    JButton jButton1 = new JButton("成绩名次");
    JButton jButton2 = new JButton("未通过名单");
    JTextField jTextField1 = new JTextField();
    JButton jButton3 = new JButton("按考生查询");

    //构造方法
    public ScoreInquirementFrame() throws Exception {
        jbInit();
    }//进行窗口的初始化

    private void jbInit() throws Exception
    {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(borderLayout1);
        setSize(new Dimension(400, 300));
        setTitle("成绩查询系统");
        jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
        jPanel1.setLayout(null);
        jLabel1.setBounds(new Rectangle(24, 15, 49, 25));
        jButton1.setBounds(new Rectangle(79, 58, 181, 29));
        jButton1.addActionListener(this);
        jButton2.setBounds(new Rectangle(80, 100, 178, 28));
        jButton2.addActionListener(this);
        jTextField1.setBounds(new Rectangle(79, 15, 180, 25));
        jButton3.setBounds(new Rectangle(268, 15, 96, 24));
        jButton3.addActionListener(this);
        contentPane.add(jSplitPane1, java.awt.BorderLayout.CENTER);
        jSplitPane1.add(jPanel1, JSplitPane.TOP);
        jPanel1.add(jButton1);
        jPanel1.add(jButton2);
        jPanel1.add(jTextField1);
        jPanel1.add(jButton3);
        jPanel1.add(jLabel1);
        jSplitPane1.add(jScrollPane1, JSplitPane.BOTTOM);
        jScrollPane1.getViewport().add(jTextArea1);
        jSplitPane1.setDividerLocation(135);
        setVisible(true);
    }
    //按钮的事件处理方法
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton3)
        {//“按考生查询”按钮的事件处理方法
            int sno = Integer.parseInt(jTextField1.getText());
            DbConnect dbConnect = new DbConnect();
            String result = null;
            try {
                result = dbConnect.chooseone(sno);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            jTextArea1.append(result);
            jTextArea1.append("单个学生查询完毕！" + "\n");
        }
        if (e.getSource() == jButton2) {//“未通过名单”按钮的事件处理方法
            DbConnect dbConnect2 = new DbConnect();
            String result2= null;
            try {
                result2 = dbConnect2.choosenotpass();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            jTextArea1.append(result2);
            jTextArea1.append("未通过名单查询完毕！"+"\n");

        }

        if (e.getSource() ==jButton1)//“成绩名次”按钮的事件处理方法
        {
            DbConnect dbConnect3 = new DbConnect();
            String result3= null;
            try {
                result3 = dbConnect3.chooserank();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            jTextArea1.append(result3);
            jTextArea1.append("成绩名次查询完毕！"+"\n");

        }
    }
}
