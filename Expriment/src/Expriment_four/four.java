package Expriment_four;

import java.util.Scanner;

public class four {
    static class Car{
        public String license;
        public double price;
        public Car(String license,double price)
        {
            this.license=license;
            this.price=price;
        }
    }
    static class test{
        public Car car=new Car("6666",200000);

        public void dicount(double count)
        {
            System.out.println("原始价格为："+car.price);
            car.price*=count;
            System.out.println("车牌号："+car.license+" 打折之后的价格为："+car.price);
        }
        public static void main(String[] args)
        {
            System.out.print("请输入打折的折扣为：");
            double count;
            Scanner in=new Scanner(System.in);
            count=in.nextDouble();
            test t=new test();
            t.dicount(count);
        }
    }
    static class bankAccount{
        private int account;
        private String name;
        private String data;
        private String num;
        private double money;

        public bankAccount(int account,String name,String data,String num,double money)
        {
            this.account=account;
            this.name=name;
            this.data=data;
            this.num=num;
            this.money=money;
        }
        public int getAccount(){return account;}
        public String getName(){return name;}
        public String getData(){return data;}
        public String getNum(){return num;}
        public double getMoney(){return money;}

        public void storeMoney(double money)
        {
            this.money+=money;
        }

        public void putMoney(double money)
        {
            this.money-=money;
        }

        public static void main(String[] args)
        {
            bankAccount b[]=new bankAccount[10];
            for(int i=0;i<10;++i)
            {
                b[i]=new bankAccount(i,"i","2019 11 5","10000+i",200*i+100);
            }
            for(int i=0;i<10;++i)
            {
                System.out.println(b[i].account+" "+b[i].name+" "+b[i].data+" "+b[i].num+" "+b[i].money);
            }
            b[0].storeMoney(1000.0);
            System.out.println("第一位顾客存了1000块之后的余额为："+b[0].getMoney());
            b[0].putMoney(100);
            System.out.println("第一位顾客取了100块之后的余额为："+b[0].getMoney());
        }
    }

    static class Vehicle{
        private int wheels;
        private double weight;
        Vehicle(int wheels,double weight){
            this.wheels=wheels;
            this.weight=weight;
        }

        public double getWeight() {
            return weight;
        }

        public int getWheels() {
            return wheels;
        }
    }
    static class Car1 extends Vehicle{
        private int loader;

        Car1(int wheels, double weight,int loader) {
            super(wheels, weight);
            this.loader=loader;
        }
        public int getLoader(){return loader;}
    }
    static class Truck extends Car1{
        private int payload;

        Truck(int wheels, double weight,int loader,int payload) {
            super(wheels, weight,loader);
            this.payload=payload;
        }

        public int getPayload(){return payload;}

        public static void main(String[] args)
        {
            Truck truck=new Truck(4,200,4,100);
            System.out.println(truck.getWheels()+" "+truck.getWeight()+" "+truck.getLoader()+" "+truck.getPayload());
        }
    }
}
