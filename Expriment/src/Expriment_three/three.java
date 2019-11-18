package Expriment_three;

public class three<Private, Public> {

    static class Location {
        private int x, y;

        public Location(int a, int b) {
            x = a;
            y = b;
        }

        int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public static void main(String args[]) {
            Location loc = new Location(12, 20);
            System.out.println(loc.getX());
            System.out.println(loc.getY());
        }
    }

    //图书库
    static class Books{
        private String bookname="";
        private String author="";
        private String publish="";
        private boolean status=false;

        public Books(String bookname,String author,String publish)
        {
            this.bookname=bookname;
            this.author=author;
            this.publish=publish;
        }
        public void setBooks()
        {
            status=true;
        }

        public void lookStatus()
        {
            if(status)
            {
                System.out.println(bookname+"已外借！！");
            }
            else {
                System.out.println(bookname+"在馆！");
            }
        }
        public static void main(String[] args)
        {
            Books books=new Books("红楼梦","吴承恩","机械出版社");
            books.lookStatus();
            books.setBooks();
            books.lookStatus();
        }
    }

    //生日类
    static class Birthday{
        private int year;
        private int month;
        private int day;
        Birthday(int year,int month,int day)
        {
            this.year=year;
            this.month=month;
            this.day=day;
        }
        void output()
        {
            System.out.println("生日为："+year+"-"+month+"-"+day);
        }
        void age()
        {
            System.out.println("年龄为："+(2019-year)+"岁");
        }

        public static void main(String[] args)
        {
            Birthday b1=new Birthday(1999,07,20);
            b1.output();
            b1.age();
        }
    }

}