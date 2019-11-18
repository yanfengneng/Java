package Expriment_six;

import javax.swing.*;

public class six {

    class negative extends Exception{
        negative(int i) {
            System.out.println("分数为负数");
        }
    }

    class height extends Exception{
        height(int i) {
            System.out.println("分数过高！");
        }
    }

    public class ExceptionDemo
    {
        static final int number=2;
        int score[]=new int[number];
        public void check(int score) throws negative, height {
            if(score>100)throw new height(score);
            if(score<0)throw new negative(score);
        }

        public void input()
        {
            int i;
            for(i=0;i<number;++i)
            {
                try{
                    score[i]=Integer.parseInt(JOptionPane.showInputDialog("请输入第"+(i+1)+"个同学的成绩"));
                }catch(NumberFormatException e) { }

                try{check(score[i]);

            } catch(height e){
                    System.out.println(e);
                }
                catch(negative e) {
                    System.out.println(e);
                }
            }
        }

        public void putScore()
        {
            System.out.println(score[0]);
            System.out.println(score[1]);
        }
    }
    public static void main(String[] args)
    {
        six s=new six();
        ExceptionDemo demo=s.new ExceptionDemo();
        demo.input();
        demo.putScore();
    }
}
