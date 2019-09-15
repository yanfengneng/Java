import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class dynamicProxy {
    //继承调用处理器接口
    public static class MyProxy implements InvocationHandler {
        private Object proxied;
        //构造函数
        public MyProxy(Object proxied){
            this.proxied=proxied;
        }
        //重写
        @Override
        public Object invoke(Object proxied, Method method, Object[] args)
                throws Throwable{
            method.invoke(this.proxied,args);
            System.out.println("运行时间："+System.currentTimeMillis());
            return null;
        }
    }
    public static void main(String[] args){
        staicProxy.Person person=new staicProxy.Person();
        staicProxy.Speakable speakable=(staicProxy.Speakable) Proxy. newProxyInstance(
                staicProxy.Speakable.class.getClassLoader(),
                new Class[]{staicProxy.Speakable.class},new MyProxy(person));
        speakable.speak("Chinese");
    }
}
