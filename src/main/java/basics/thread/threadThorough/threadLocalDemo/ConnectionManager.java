package basics.thread.threadThorough.threadLocalDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 3. 解决方案
 * ①.在一个方法内创建连接和结束连接 这样就是在一个线程内 不会出现线程安全问题 但是在方法内频繁的连接和关闭 对程序与服务器压力都会增大
 *
 * ②.使用ThreadLocal hreadLocal在每个线程中对该变量会创建一个副本，即每个线程内部都会有一个该变量，
 * 且在线程内部任何地方都可以使用，线程之间互不影响，这样一来就不存在线程安全问题，也不会严重影响程序执行性能
 * Created by sulong on 2019/4/29.
 */
public class ConnectionManager {
    private static Connection connection = null;

    /**
     *  2. 也是因为connection是一个共享连接 可能会多次创建 connection
     * @return
     * @throws SQLException
     */
    public static Connection openConncetion() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection("Demo");
        }
        return connection;
    }

    /**
     * 1. 因为 connection是一个共享变量 当一个线程正在使用时 第二个线程调用closeConnection方法关闭了连接就出现错误了
     * @throws SQLException
     */
    private static void closeConnection() throws SQLException{
        if (connection!=null){
            connection.close();
        }
    }

    class Dao{
        /**
         * 解决方案1实例
         */
        public void insert() throws SQLException {
            ConnectionManager connectionManager = new ConnectionManager();
            Connection connection = ConnectionManager.openConncetion();

            //使用connection进行操作

            ConnectionManager.closeConnection();

        }
    }
}
