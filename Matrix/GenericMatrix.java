import javax.management.RuntimeErrorException;
import java.lang.String;

public abstract class GenericMatrix <E extends Number>{
    protected abstract E add(E element1,E element2);
    protected abstract E multiply(E element1,E element2);
    protected abstract E zero();//零矩阵

    //矩阵加法
    public E[][] addMatrix(E[][] matrix1,E[][] matrix2){
        if((matrix1.length!=matrix2.length)||matrix1[0].length!=matrix2[0].length){
            throw new RuntimeException("The matrices do not have the same size!");
        }
        E[][] result=(E[][])new Number[matrix1.length][matrix1[0].length];

        for(int i=0;i<result.length;++i)
            for(int j=0;j<result[0].length;++j){
                result[i][j]=add(matrix1[i][j],matrix2[i][j]);
            }
        return result;
    }

    //矩阵乘法
    public E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2) {

        if (matrix1[0].length != matrix2.length)
            throw new RuntimeException("The matrices do not have compatible size!");

        E[][] result = (E[][]) new Number[matrix1.length][matrix2[0].length];

        for(int i = 0 ;i < result.length; i++) {
            for (int j = 0; j <result[0].length; j++) {
                result [i][j] = zero();

                //matrix1的第i行的第k号元素与matrix2的第j列的第k号元素对应相乘
                for(int k= 0 ;k < matrix1[0].length; k++) {
                    result[i][j] = add(result[i][j],multiply(matrix1[i][k],matrix2[k][j]));
                }
            }
        }
        return result;
    }

    //打印矩阵
    public static void printResult(Number[][] m1,Number[][] m2,Number[][] m3,char op)
    {
        for(int i = 0; i<m1.length ; i++) {
            for ( int j = 0; j < m1[0].length; j++)
                System.out.print("  " + m1[i][j]);

            if (i == m1.length / 2)
                System.out.print("  " + op + "  ");
            else
                System.out.print("     ");

            for(int j = 0; j < m2.length; j++)
                System.out.print("  " + m2[i][j]);

            if (i == m1.length / 2)
                System.out.print("  =   ");
            else
                System.out.print("      ");

            for(int j = 0; j < m3.length; j++)
                System.out.print(m3[i][j] + "   ");

            System.out.println();
        }
    }
}