public class TestIntegerMatrix {
    public static void main(String[] args){
        Integer[][] m1=new Integer[][]{{1,2,3},{4,5,6},{0,0,0}};
        Integer[][] m2=new Integer[][]{{1,1,1},{2,2,2},{1,1,1}};
        IntergerMatrix intergerMatrix=new IntergerMatrix();
        System.out.println("\nm1+m2 is");
        GenericMatrix.printResult(m1,m2,intergerMatrix.addMatrix(m1,m2),'+');
        System.out.println("\nm1*m2 is");
        GenericMatrix.printResult(m1,m2,intergerMatrix.multiplyMatrix(m1,m2),'*');
    }
}
