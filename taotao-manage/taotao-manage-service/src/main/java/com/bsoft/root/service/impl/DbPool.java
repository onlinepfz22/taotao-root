package com.bsoft.root.service.impl;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Logger;
/**
 * 自定以数据库连接池
 * */
public class DbPool implements DataSource {
    private static Vector vector = new Vector();

    static {
        InputStream inputStream = DbPool.class.getClassLoader().getResourceAsStream("properties/db.properties");//获得数据库配置文件中的数据库信息转化为流
        Properties properties = new Properties();
        try {
            properties.load(inputStream);//加载流
            /*获得流中数据库信息*/
            String driver = properties.getProperty("jdbc.driver").toString();//"com.mysql.jdbc.Driver";
            String url = properties.getProperty("jdbc.url").toString();//"jdbc:mysql://localhost:3306/pornography?useUnicode=true&amp;characterEncoding=utf-8";
            String userName = properties.getProperty("jdbc.username").toString();//"root";
            String password = properties.getProperty("jdbc.password").toString();
            Integer jdbcPoolInitSize = Integer.parseInt(properties.getProperty("jdbcPoolInitSize").toString());

            /*创建数据库连接*/
            Class.forName(driver);//加载数据库驱动类
            for (int i = 0; i < jdbcPoolInitSize; i++) {
                Connection connection = (Connection) DriverManager.getConnection(url, userName, password);
                System.out.println("获得第" + (i + 1) + "个数据库连接...");
                vector.addElement(connection);
            }
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        //如果数据库连接池中的连接对象的个数大于0可以获取数据库连接
        if (vector.size() > 0) {
            //从Connections集合中获取一个数据库连接
            final Connection conn = (Connection) vector.remove(vector.size() - 1 < 0 ? 0 : vector.size() - 1);//每次获取一个连接
            System.out.println("Connections数据库连接池大小是" + vector.size());
            //返回Connection对象的代理对象
            return (Connection) Proxy.newProxyInstance(DbPool.class.getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args)
                        throws Throwable {
                    if (!method.getName().equals("close")) {
                        return method.invoke(conn, args);
                    } else {
                        //如果调用的是Connection对象的close方法，就把conn还给数据库连接池
                        vector.addElement(conn);
                        System.out.println(conn + "被还给Connections数据库连接池了！！");
                        System.out.println("Connections数据库连接池大小为" + vector.size());
                        return null;
                    }
                }
            });
        } else {
            throw new RuntimeException("对不起，数据库忙");
        }

    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return true;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    public static void main(String[] args) {
        Object obj = new Object();
        final DbPool dbPool = new DbPool();
        try {
            for (int i = 0; i < 9; i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        dbPool.executeSql();
                    }
                }).start();
                //Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void executeSql() {
        try {
            Connection connection = this.getConnection();
            PreparedStatement preStat = connection.prepareStatement("select * from po_log limit 0,10");
            ResultSet rs = preStat.executeQuery();

            while (rs.next()) {
                System.out.println("当前线程名称为:" + Thread.currentThread().getName());
                System.out.print(rs.getInt("ID") + ",");
                System.out.print(rs.getString("USERNAME") + ",");
                System.out.print(rs.getString("DESCRIPTION") + ",");
                System.out.print(rs.getString("METHOD"));
                System.out.print("\n");
            }

            if (null != rs) {
                rs.close();
            }

            if (null != preStat) {
                preStat.close();
            }

            if (null != connection) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}