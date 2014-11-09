package study.zsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by zsw on 11/9/14.
 */
public class JDBCTest {

    public static void main(String[] args) {
        String RL = "jdbc:mysql://localhost/mypro?useUnicode=true&characterEncoding=utf8";
        String user ="root";//这里替换成你自已的数据库用户名
        String password = "root";//这里替换成你自已的数据库用户密码
        String sqlStr = "select * from test";

        try{     //这里的异常处理语句是必需的.否则不能通过编译!
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println( "类实例化成功!" );
            System.out.println("slkdjf");
            Connection con = DriverManager.getConnection(RL, user, password);
            System.out.println( "创建连接对像成功!" );

            Statement st = con.createStatement();
            System.out.println( "创建Statement成功!" );

            ResultSet rs = st.executeQuery( sqlStr );
            System.out.println( "操作数据表成功!" );
            System.out.println( "----------------!" );

            while(rs.next())
            {
                System.out.print(rs.getInt("age") + "     ");
                System.out.print(rs.getString("name") + "     ");

            }
            rs.close();
            st.close();
            con.close();
        }
        catch(Exception err){
            err.printStackTrace(System.out);
        }
    }
}


