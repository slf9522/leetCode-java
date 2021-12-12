package leetcode.editor.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * @ClassName MyPool
 * @Description //TODO
 * @Author fangjiaxin
 * @Date 2021/12/1
 */
public class MyPool {
    private final int init_count = 3; //初始化链接数目

    private final int max_count = 6; //最大连接数

    private int current_count = 0; //到当前连接数

    private LinkedList<Connection> pool = new LinkedList<Connection>();

    public MyPool() throws SQLException, ClassNotFoundException {
        for (int i = 0; i < init_count; i++) {

            //记录当前连接数

            current_count++;

            //createConnection是自定义的创建链接函数．

            Connection connection = createConnection();

            pool.addLast(connection);
        }
    }

    public Connection createConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/keyan", "root", "root");

        return connection;
    }
}
