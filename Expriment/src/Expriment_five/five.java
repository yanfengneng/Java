package Expriment_five;
import java.util.*;
public class five {

    static class BankCount                      //定义类
    {
        int id;
        String name, date;
        float money;

        public BankCount(int id, String name, String date, float money)  //构造方法
        {
            this.id = id;
            this.name = name;
            this.date = date;
            this.money = money;
        }
    }

    class BCOption {

        Vector vec = new Vector();       //对象声明与实例化
        int count = 0;            //类中静态变量的定义

        public void kaihu(BankCount bc) //方法体，实现开户功能                      //实例方法
        {
            count++;
            vec.add(bc);
        }

        public void moneyOut(int id, float outmoney) //方法体，实现取钱功能
        {
            BankCount bc=(BankCount)vec.get(id);
            bc.money-=outmoney;
            vec.set(id,bc);
        }

        public void moneyIn(int id, float inmoney) {//方法体，实现存钱功能
            BankCount bc=(BankCount)vec.get(id);
            bc.money+=inmoney;
            vec.set(id,bc);
        }

        public void query(int id) {//方法体，查询并输出账户信息
            BankCount bc=(BankCount)vec.get(id);
            System.out.println(bc.id+" "+bc.name+" "+bc.date+" "+bc.money);
        }

    }

    public static void main(String args[]) {//实现账户的相关操作
        five f = new five();
        BCOption bco = f.new BCOption();
        bco.kaihu(new BankCount(1, "", "", 12));
        bco.query(0);
    }

}