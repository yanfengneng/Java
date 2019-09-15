
import java.awt.*;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import javax.swing.*;

public class BackGround extends JFrame implements MouseListener {
    //初始化窗口
    public void init(){
        this.setTitle("鄢奉能");
        this.setSize(600,400);
        this.setLocation(600,300);
        addMouseListener(this);
        //关闭窗口退出进程
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //把窗体传入到画图的类中
        //Panel panel = new Panel(this);
        //设定窗体内的内容
        //setContentPane(panel);
        this.setVisible(true);
    }

    //鼠标响应函数
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Panel panel = new Panel(this);
        //传入指定的panel 用来画图
        Graphics g = this.getGraphics();
        //用对象来设定setContentPane(panel);
        panel.DrawRect(g,x,y,100,20,Color.blue);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    //初始化
    public BackGround(){
        super();
        init();
    }

    public static void main(String[] args){
        BackGround backGround = new BackGround();
        //backGround.paint(graphics);
    }
}
