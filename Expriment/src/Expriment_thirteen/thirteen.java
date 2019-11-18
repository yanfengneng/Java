package Expriment_thirteen;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class thirteen {
    static void test_one() throws IOException {
        double num[]={1.23,69.88,34.45,67.98,2345.67};
        String cd="D:\\My Program\\Java Project\\Expriment\\src\\Expriment_thirteen\\a.txt";

        FileOutputStream f=new FileOutputStream(cd);

        for(int i=0;i<num.length;++i)
        {
            try {
                f.write((char)num[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void test_two() throws IOException {
        String n="asdasdasdas";
        BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\My Program\\Java Project\\Expriment\\src\\Expriment_thirteen\\b.txt"));
        bw.write(n);
        bw.close();
    }

    static void test_three() throws IOException {
        URL u=new URL("http://www.sina.com");
        InputStream is=u.openStream();
        is=new BufferedInputStream(is);

        Reader r=new InputStreamReader(is);
        FileOutputStream fos=new FileOutputStream("D:\\My Program\\Java Project\\Expriment\\src\\Expriment_thirteen\\c.html");
        int c=0;
        while((c=r.read())!=-1)
            fos.write(c);
    }
    public static void main(String[] args) throws IOException {

        test_one();
        test_two();
        test_three();
    }
}
