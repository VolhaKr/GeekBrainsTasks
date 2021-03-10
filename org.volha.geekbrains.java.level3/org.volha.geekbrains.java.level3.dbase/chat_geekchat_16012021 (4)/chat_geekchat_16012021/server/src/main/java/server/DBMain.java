package server;

import java.sql.*;

public class DBMain {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement psInsert;

    private static void fillTableBatch() throws SQLException {
        long begin = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for ( int i = 1; i <= 1000; i++ ) {
            psInsert.setString(1, "Bob " + i);
            psInsert.setInt(2, i * 15 % 100);

            psInsert.addBatch();
        }
        psInsert.executeBatch();
        connection.commit();
        long end = System.currentTimeMillis();
        System.out.printf("Time %d ms", end - begin);
    }

    private static void fillTable() throws SQLException {
        long begin = System.currentTimeMillis();
        connection.setAutoCommit(false);
        prepareAllStatements();
        for ( int i = 1; i <= 5; i++ ) {
            psInsert.setString(1, "Bob " + i);
            psInsert.setString(2, "123");
            psInsert.setString(3, "Bob " + i);
            psInsert.executeUpdate();
        }
        connection.commit();
        long end = System.currentTimeMillis();
        System.out.printf("Time %d ms", end - begin);
    }

    private static void prepareAllStatements() throws SQLException {
        psInsert = connection.prepareStatement("INSERT INTO users (login, password, nickname) VALUES ( ? , ? , ?);");
    }

    private static void clearTable() throws SQLException {
        stmt.executeUpdate("DELETE FROM users;");
    }

    private static void exInsertMore() throws SQLException {
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob4', 75),('Bob5', 35),('Bob6', 95);");
    }

    private static void exInsert() throws SQLException {
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob3', 85);");
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    private static void disconnect() {
        try {
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static String selectNicknameByLoginAndPassword(String login, String password) {
        String nick = null;
        String query = String.format("SELECT * FROM users WHERE login = '%s' and password = '%s';", login, password);
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(query);
            if (rs.next()) {
                nick = rs.getString("nickname");
            } else {
                nick = null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return nick;
    }

    public static boolean selectLogin(String login) throws SQLException {
        String query = String.format("SELECT * FROM users WHERE login = '%s' ;", login);
        System.out.println(query);
        ResultSet rs = stmt.executeQuery(query);
        System.out.println("result set" + rs);
        if (rs.next()) {
            rs.close();
            System.out.println("true");
            return true;
        }
        rs.close();
        System.out.println("false");
        return false;
    }

    public static boolean selectNickName(String nickname) throws SQLException {
        String query = String.format("SELECT * FROM users WHERE nickname = '%s' ;", nickname);
        ResultSet rs = stmt.executeQuery(query);
        if (rs.next()) {
            rs.close();
            return true;
        }
        rs.close();
        return false;
    }

    public static void addUser(String login, String password, String nickname) throws SQLException {
        connection.setAutoCommit(false);
        prepareAllStatements();
        psInsert.setString(1, login);
        psInsert.setString(2, password);
        psInsert.setString(3, nickname);
        psInsert.executeUpdate();
        connection.commit();

    }
}




