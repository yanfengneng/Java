import java.sql.*;
import java.util.Date;

public class testMysql {
    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
    static final String USER = "root";
    static final String PASS ="yan.10291165";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM pet";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while(rs.next()){
                String name = rs.getString("name");
                String owner = rs.getString("owner");
                String species = rs.getString("species");
                String sex = rs.getString("sex");
                Date birth = rs.getDate("birth");
                Date death = rs.getDate("death");
                System.out.println("name: "+name+" owner: "+owner+" species: "+species+" sex: "+sex+" birth: "+birth
                +" death: "+death);

            }
            // 完成后关闭
            rs.close();
            stmt.close();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("88");
    }
}
