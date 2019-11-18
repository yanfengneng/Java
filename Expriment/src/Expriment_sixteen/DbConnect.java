package Expriment_sixteen;

import java.sql.*;

public class DbConnect {
    public Connection connection;
    DbConnect dbConnect;

    public void getConn() throws SQLException, ClassNotFoundException {
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        final String USER = "root";
        final String PASS ="yan.10291165";
        Class.forName(JDBC_DRIVER);//　Java加载数据库驱动的方法是调用Class类的静态方法forName
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public static PreparedStatement preparedStatement(String sql) {
        return preparedStatement(sql);
    }

    public String chooseone(int sno) throws SQLException, ClassNotFoundException {
        getConn();
        String sql = "select * from student_1 where no=?";//查询
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, sno);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        int num = rs.getInt("no");
        String name = rs.getString("name");
        int score = rs.getInt(3);
        preparedStatement.close();
        return ("学号为 " + num + " 的学生的姓名为: " + name + "  ,成绩为: " + score + "\n");
    }

    public String choosenotpass() throws SQLException, ClassNotFoundException {
        getConn();
        String a=null;
        String sql = "select * from chengji where score<60";//查询
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()) {
            int num = rs.getInt(1);
            int score = rs.getInt(2);
            String name = rs.getString(3);

            a="学号为 " + num + " 的学生的姓名为: " + name + "  ,成绩为: " + score + "\n"+a;
        }
        statement.close();//要放在最外层，不然没查完就关闭了
        return a;
    }

    public String chooserank() throws SQLException, ClassNotFoundException {
        getConn();
        String a=null;
        String sql = "select * from chengji order by score ASC";//排序
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()) {
            int num = rs.getInt(1);
            int score = rs.getInt(2);
            String name = rs.getString(3);

            a="学号为 " + num + " 的学生的姓名为: " + name + "  ,成绩为: " + score + "\n"+a;
        }
        statement.close();//要放在最外层，不然没查完就关闭了
        return a;
    }
}