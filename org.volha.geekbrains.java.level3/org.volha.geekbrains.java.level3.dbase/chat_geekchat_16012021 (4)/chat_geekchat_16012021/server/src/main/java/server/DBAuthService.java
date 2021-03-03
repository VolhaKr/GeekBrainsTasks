package server;

import org.sqlite.core.DB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBAuthService implements AuthService {
    private class UserData {
        String login;
        String password;
        String nickname;

        public UserData(String login, String password, String nickname) {
            this.login = login;
            this.password = password;
            this.nickname = nickname;
        }
    }

  //  private List<SimpleAuthService.UserData> users;

    public DBAuthService() {
//        try {
//            DBMain.connect();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        //users = new ArrayList<>();
  //      users.add(new SimpleAuthService.UserData("qwe", "qwe", "qwe"));
        DBMain.addUser ("qwe", "qwe", "qwe");
        DBMain.addUser ("asd", "asd", "asd");
        DBMain.addUser ("zxc", "zxc", "zxc");
//        users.add(new SimpleAuthService.UserData("asd", "asd", "asd"));
//        users.add(new SimpleAuthService.UserData("zxc", "zxc", "zxc"));
//        for (int i = 1; i < 10; i++) {
//            users.add(new SimpleAuthService.UserData("user" + i, "pass" + i, "nick" + i));
//        }
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        System.out.println(DBMain.selectNicknameByLoginAndPassword(login, password));
        return DBMain.selectNicknameByLoginAndPassword(login, password);
    }

    @Override
    public boolean registration(String login, String password, String nickname) {

        try {
            if ((DBMain.selectLogin(login))||(DBMain.selectNickName(nickname))){
            //if(user.login.equals(login) || user.nickname.equals(nickname)){
                    return false;
                }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            DBMain.add(login, password, nickname);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

}










//
//
//
//
//    public class SimpleAuthService implements AuthService {
//        private class UserData {
//            String login;
//            String password;
//            String nickname;
//
//            public UserData(String login, String password, String nickname) {
//                this.login = login;
//                this.password = password;
//                this.nickname = nickname;
//            }
//        }
//
//        private List<server.SimpleAuthService.UserData> users;
//
//        public SimpleAuthService() {
//            users = new ArrayList<>();
//            users.add(new server.SimpleAuthService.UserData("qwe", "qwe", "qwe"));
//            users.add(new server.SimpleAuthService.UserData("asd", "asd", "asd"));
//            users.add(new server.SimpleAuthService.UserData("zxc", "zxc", "zxc"));
//            for (int i = 1; i < 10; i++) {
//                users.add(new server.SimpleAuthService.UserData("user" + i, "pass" + i, "nick" + i));
//            }
//        }
//
//        @Override
//        public String getNicknameByLoginAndPassword(String login, String password) {
//            for ( server.SimpleAuthService.UserData user : users) {
//                if(user.login.equals(login) && user.password.equals(password)){
//                    return user.nickname;
//                }
//            }
//            return null;
//        }
//
//        @Override
//        public boolean registration(String login, String password, String nickname) {
//            for ( server.SimpleAuthService.UserData user : users) {
//                if(user.login.equals(login) || user.nickname.equals(nickname)){
//                    return false;
//                }
//            }
//            users.add(new server.SimpleAuthService.UserData(login, password, nickname));
//            return true;
//        }
//    }

    //////---------------------------
//
//import java.sql.SQLException;
//
//    public class DBAuthService implements AuthService{
//
//        @Override
//        public String getNicknameByLoginAndPassword(String login, String password){
//            System.out.println("Selected nick "+ DBCrud.selectNicknameByLoginAndPassword(login, password));
//            return DBCrud.selectNicknameByLoginAndPassword(login, password);
//        }
//
//        @Override
//        public boolean registration(String login, String password, String nickname) {
//            return false;
//        }
//    }







