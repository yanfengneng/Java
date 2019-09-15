public class Rational extends Number {
    private long numerator=0;
    private long denominator=1;
    public Rational(){
        this(0,1);
    }

    public Rational(long num1,long num2){
        long gcd=gcd(num1,num2);
        this.numerator=(num2>0?1:-1)*num1/gcd;
        this.denominator=Math.abs(num2)/gcd;
    }

    private static long gcd(long n,long d){
        long n1=Math.abs(n);
        long n2=Math.abs(d);
        int gcd=1;
        for(int k=1;k<=n1&&k<=n2;k++){
            if(n1%k==0&&n2%k==0)
                gcd=k;
        }
        return gcd;
    }
    public String toString(){
        if(denominator==1)
            return numerator+"";
        else
            return numerator+"/"+denominator;
    }
    @Override
    public double doubleValue() {
        // TODO 自动生成的方法存根
        return numerator*1.0/denominator;
    }
    @Override
    public float floatValue() {
        // TODO 自动生成的方法存根
        return (float) doubleValue();
    }
    @Override
    public int intValue() {
        // TODO 自动生成的方法存根
        return (int) doubleValue();
    }

    @Override
    public long longValue() {
        // TODO 自动生成的方法存根
        return (long) doubleValue();
    }
    public long getNumerator(){
        return numerator;
    }

    public long GetDenominator(){
        return denominator;
    }
    public Rational add(Rational second){
        long n=numerator*second.GetDenominator()+denominator*second.getNumerator();
        long d=denominator*second.GetDenominator();
        return new Rational(n,d);
    }
    public Rational multiply(Rational second){
        long n=numerator*second.getNumerator();
        long d=denominator*second.GetDenominator();
        return new Rational(n,d);
    }
}