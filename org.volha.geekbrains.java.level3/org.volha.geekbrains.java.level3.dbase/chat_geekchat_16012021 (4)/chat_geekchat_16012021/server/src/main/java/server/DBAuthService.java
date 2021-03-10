package server;

import java.sql.SQLException;

public class DBAuthService implements AuthService {
    static {
        try {
            DBMain.connect();
            System.out.println("db connected");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        return DBMain.selectNicknameByLoginAndPassword(login, password);
    }

    @Override
    public boolean registration(String login, String password, String nickname) {

        try {
            if ((DBMain.selectLogin(login)) || (DBMain.selectNickName(nickname))) {
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            DBMain.addUser(login, password, nickname);
            System.out.println("User added to DB, login " + login + " password " + password + " nickname " + nickname);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
}






