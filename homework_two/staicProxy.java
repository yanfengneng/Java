public class staicProxy {
    //委托接口
    public interface Speakable{
        public void speak(String message);
    }

    //委托类
    public static class Person implements Speakable{
        //重写
        @Override
        public void speak(String message){
            System.out.println("鄢奉能:"+message);
        }
    }

    //代理类
    public static class PersonProxy implements Speakable{
        private Person persion;
        public PersonProxy(Person persion){
            this.persion=persion;
        }
        //重写
        @Override
        public void speak(String message)
        {
            this.persion.speak(message);
            System.out.println("运行时间："+System.currentTimeMillis());
        }
    }

    public static void main(String[] args){
        Person person=new Person();
        PersonProxy proxy=new PersonProxy(person);
        proxy.speak("Chinese");
    }
}
