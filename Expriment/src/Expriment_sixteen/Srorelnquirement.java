package Expriment_sixteen;

import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;
class ScoreInquirement
{
    public ScoreInquirement() throws Exception {
        ScoreInquirementFrame frame = new ScoreInquirementFrame();
        //令窗体对象居中显示
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height)
        {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width)
        {
            frameSize.width = screenSize.width;
        }
        frame.setLocation( (screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        frame.setVisible(true);
    }
    //主方法
    public static void main(String[] args) throws Exception {
        new ScoreInquirement();
    }
}