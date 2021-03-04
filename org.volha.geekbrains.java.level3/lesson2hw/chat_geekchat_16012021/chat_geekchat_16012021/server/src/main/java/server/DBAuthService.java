package server;

import java.sql.SQLException;

public class DBAuthService implements AuthService{

    @Override
    public String getNicknameByLoginAndPassword(String login, String password){
        System.out.println("Selected nick "+ DBCrud.selectNicknameByLoginAndPassword(login, password));
return DBCrud.selectNicknameByLoginAndPassword(login, password);
      }

    @Override
    public boolean registration(String login, String password, String nickname) {
        return false;
    }
}
