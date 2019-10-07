package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Pattern;

public class download {
    public static void main(String[] args) throws IOException {
        try{
            //获取网页资源
            URL url=new URL("https://www.w3.org/Consortium/Member/List/");

            //openConnection()方法返回HttpURLConnection对象，本地可以访问网页资源
            URLConnection uconn=url.openConnection();
            uconn.setDoOutput(true);//使用URL进行输出
            uconn.connect();

            String temp;
            final StringBuffer sb=new StringBuffer();//final不可改变

            //注意编码格式，查看网页源码中的charset的值
            String key = ".*class=\"member\".*";//\"表示转义，也就是表示"

            //返回URL中的输入流，用于读取资源
            final BufferedReader in=new BufferedReader(new InputStreamReader(url.openStream()));

            while((temp=in.readLine())!=null){//读取每一个行的内容
                if(Pattern.matches(key,temp)){//利用正则表达式将temp与模式串相匹配
                    //通过两次分割得到目标数据
                    //System.out.println(temp);
                    String [] split=temp.split(">");//将网站分成两段了，公司名在第二段
                    String[] need=split[1].split("<");//取<前面的公司名
                    sb.append(need[0]);
                    sb.append('\n');
                }
            }

            in.close();
            System.out.println(sb);
            String targetPath="target.txt";
            File f=new File(targetPath);
            try{
                BufferedWriter bw=new BufferedWriter(new FileWriter(f));
                bw.write(sb.toString());
                bw.flush();
                bw.close();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("出错了！");
        }
    }
}
