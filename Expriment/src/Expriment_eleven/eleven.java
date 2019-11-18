package Expriment_eleven;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class eleven {
    static class GunClip//弹夹
    {
        //用来放子弹
        private List<Integer> list=null;
        //bFull用来表示满没满
        private boolean bFull=false;

        //在弹夹中存放子弹
        public synchronized void put(List list)
        {
            if(!bFull)//表示弹夹还没有压满，需要向里面存放子弹
            {
                this.list=list;
                bFull=true;//放满了子弹，在把boolean变量变为true表示，弹夹满了
                notify();//通知，等待取子弹的线程来取子弹
            }
            try{
                wait();//在弹夹压满的情况下，暂停本线程，等待取子弹
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //在弹夹中取子弹
        public synchronized void get(){
            if(!bFull){//如果弹夹没满那么就不能取子弹
                try{
                    wait();//弹夹没满，所以取不了，只能等待，只有弹夹满了才能取
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            //下面是弹夹满了，那么我开始取子弹
            System.out.println("\n"+"机枪开始射出子弹:"+"\n");
            for(int i=list.size();i>0;i--){
                int j=(Integer)list.get(i-1);
                System.out.println("已射出第"+j+"颗子弹");
            }
            //弹夹被取空了，即没子弹了，那么只能等待重新填充，
            //所以boolean变为false，表示没满，通知装子弹的线程装子弹
            bFull=false;
            notify();
        }

    }

    //生产者即装子弹，需要一个弹夹实体
    static class Producer extends Thread
    {
        private GunClip clip;//弹夹实体
        private List<Integer> list;

        Producer(GunClip clip){
            this.clip=clip;
        }

        public void run(){
            for(int i=0;i<3;++i)//产生三个弹夹
            {
                list=new ArrayList();
                System.out.println("\n"+"机枪开始压入子弹"+"\n");
                for(int j=0;j<12;++j){
                    list.add(j+1);
                    System.out.println("已压入第"+(j+1)+"颗子弹");
                }
                clip.put(list);//将子弹压入弹夹中
            }
        }
    }
    //消费者，发射子弹
    static class Concumer extends Thread {
        private GunClip clip;//弹夹实体

        Concumer(GunClip clip) {
            this.clip = clip;
        }

        public void run() {
            while (true) {
                clip.get();//发射子弹
            }
        }
    }

    public static void main(String[] args)
    {
        GunClip clip=new GunClip();
        Producer p=new Producer(clip);
        Concumer c=new Concumer(clip);
        p.start();
        c.start();
    }
}