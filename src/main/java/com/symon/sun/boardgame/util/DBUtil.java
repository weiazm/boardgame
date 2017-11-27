package com.symon.sun.boardgame.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    boolean bInited = false;
    /* 本地 */
    // private static final String URL =
    // "jdbc:mysql://119.32.13.218:3306/board_game?useUnicode=true&characterEncoding=UTF8";
    /* 测试数据库 */
    private static final String URL = "jdbc:mysql://localhost/board_game?useUnicode=true&characterEncoding=UTF8";
    /* 云平台 */
    // private static final String URL = "jdbc:mysql://192.168.44.31/AD_display?useUnicode=true&characterEncoding=UTF8";
    private static final String UNAME = "root";
    private static final String PWD = "xmt123";

    /* 云平台密码 */
    // private static final String PWD = "Gzcatv2016**";
    // 加载驱动
    public void initJDBC() throws ClassNotFoundException {
        // 加载MYSQL JDBC驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        bInited = true;
        System.out.println("Success loading Mysql Driver!");
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (!bInited) {
            initJDBC();
        }
        // 连接URL为 jdbc:mysql//服务器地址/数据库名
        // 后面的2个参数分别是登陆用户名和密码
        Connection conn = DriverManager.getConnection(URL, UNAME, PWD);
        return conn;
    }

    /**
     * 
     * @Title: loginSuccess
     * @Description: TODO
     * @param userName
     * @param password
     * @return
     * @return: boolean
     */
    public boolean loginSuccess(String userName, String password) {
        boolean returnValue = false;
        String sql = "SELECT * FROM tb_user";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String userNameInDB = rs.getString("username");
                String passwordInDB = rs.getString("password");
                if (userNameInDB.equals(userName) && passwordInDB.equals(password)) {
                    returnValue = true;
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return returnValue;

    }
}