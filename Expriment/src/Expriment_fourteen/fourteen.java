package Expriment_fourteen;

import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;



public class fourteen {
    public static class Frame_one extends JFrame implements ActionListener {
        JPanel contentPane;
        JScrollPane jScrollPane1 = new JScrollPane();
        BorderLayout borderLayout1 = new BorderLayout();
        JPanel jPanel1 = new JPanel();
        JTextArea jTextArea1 = new JTextArea();
        JButton jButton1 = new JButton("保存");
        JButton jButton2 = new JButton("打开");

        //构造函数
        public Frame_one() {
            setLayout(borderLayout1);
            jButton1.addActionListener(this);
            jButton2.addActionListener(this);

            add(jTextArea1, borderLayout1.CENTER);
            add(jPanel1, borderLayout1.SOUTH);
            jPanel1.setLayout(new FlowLayout());
            jPanel1.add(jButton1);
            jPanel1.add(jButton2);
            setBounds(200, 200, 600, 600);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    setVisible(false);
                    System.exit(0);
                }
            });
        }

        //jbInit()方法完成界面的初始化设置
        private void jbInit() throws Exception {
            Frame_one frame = new Frame_one();
            // 使窗口居中
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension frameSize = frame.getSize();
            if (frameSize.height > screenSize.height) {
                frameSize.height = screenSize.height;
            }
            if (frameSize.width > screenSize.width) {
                frameSize.width = screenSize.width;
            }
            frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
            frame.setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //如果用户点击保存按钮
            if (e.getSource() == jButton1) {
                JFileChooser fc1 = new JFileChooser();
                int option = fc1.showSaveDialog(null);  // 显示文件对话框
                if (option == JFileChooser.APPROVE_OPTION) // 如果确认选取文件
                {
                    File file = fc1.getSelectedFile();  // 取得选择的文件
                    setTitle(file.toString());  // 在标题栏上设定文件名称
                    try {
                        file.createNewFile(); // 建立文件
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, e1.toString(),
                                "无法建立新文件", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            //如果用户点击打开按钮
            if (e.getSource() == jButton2) {
                jTextArea1.setText("");
                JFileChooser fc = new JFileChooser();
                int option1 = fc.showDialog(null, null);
                // 使用者按下确认键
                if (option1 == JFileChooser.APPROVE_OPTION) {
                    try {
                        // 开启选取的文件
                        BufferedReader buf = new BufferedReader(new FileReader(fc.getSelectedFile()));
                        String lineSeparator = System.getProperty("line.separator");
                        // 取得系统相依的换行字符
                        String text;// 读取文件并附加至文字编辑区
                        while ((text = buf.readLine()) != null) {
                            jTextArea1.append(text);
                            jTextArea1.append(lineSeparator);
                        }
                        buf.close();

                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ee) {
                        JOptionPane.showMessageDialog(null, ee.toString(), "开启文件失败", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

        public static void main(String[] args) throws Exception {
            new Frame_one().jbInit();
        }
    }
}