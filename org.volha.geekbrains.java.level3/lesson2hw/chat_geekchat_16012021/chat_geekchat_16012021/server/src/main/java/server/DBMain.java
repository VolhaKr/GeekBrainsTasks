package server;

import java.sql.*;

public class DBMain {


        private static Connection connection;
        private static Statement stmt;
        private static PreparedStatement psInsert;

        public static void main(String[] args) {
            try {
                connect();
                clearTable();
                fillTable();
                System.out.println("filled");
              //  clearTable();
             //   prepareAllStatements();
                //exRollback();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }

//        private static void exRollback() throws SQLException {
//            stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob1', 85);");
//            Savepoint sp1 = connection.setSavepoint();
//            stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob2', 85);");
//            connection.rollback(sp1);
//            stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob3', 85);");
//            connection.setAutoCommit(true);
//        }

        private static void fillTableBatch() throws SQLException {
            long begin = System.currentTimeMillis();
            connection.setAutoCommit(false);
            for (int i = 1; i <= 1000; i++) {
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
            for (int i = 1; i <= 5; i++) {
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
            psInsert = connection.prepareStatement("INSERT INTO users (login, password, nick) VALUES ( ? , ? , ?);");
        }

    private static void clearTable() throws SQLException {
            stmt.executeUpdate("DELETE FROM users;");
        }
        //CRUD create read update delete
//        private static void exSelect() throws SQLException {
//            ResultSet rs = stmt.executeQuery("SELECT name, score FROM students WHERE score > 80;");
//
//            while (rs.next()) {
//                System.out.println(rs.getString("name") + " " + rs.getInt("score"));
//            }
//
//            rs.close();
//        }
//
//        private static void clearTable() throws SQLException {
//            stmt.executeUpdate("DELETE FROM students;");
//        }
//
//        private static void exDelete() throws SQLException {
//            stmt.executeUpdate("DELETE FROM students WHERE score <= 40;");
//        }
//
//        private static void exUpdate() throws SQLException {
//            stmt.executeUpdate("UPDATE students SET score = 100 WHERE score >=85;");
////        UPDATE students SET score = 90 WHERE (score >=85) AND (name='Bob6');
////        UPDATE students SET score = 90 WHERE (score >=85) OR (name='Bob6');
//        }

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
            String nick=null;
            String query = String.format("SELECT nick FROM users WHERE login = '%s'& password = '%s');", login, password);
            ResultSet rs = null;
            try  {
                rs = stmt.executeQuery(query);

                if (rs.next()) {
                    nick = rs.getString("nick");
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
    }



