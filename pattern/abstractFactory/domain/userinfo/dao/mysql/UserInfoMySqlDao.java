package pattern.abstractFactory.domain.userinfo.dao.mysql;

import pattern.abstractFactory.domain.userinfo.UserInfo;
import pattern.abstractFactory.domain.userinfo.dao.UserInfoDao;

public class UserInfoMySqlDao implements UserInfoDao {
    @Override
    public void insertUserInfo(UserInfo userInfo) {
        System.out.println("insert into MYSQL DB userId =" + userInfo.getUserId());
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        System.out.println("insert into MYSQL DB userId =" + userInfo.getUserId());
    }

    @Override
    public void deleteUserInfo(UserInfo userInfo) {
        System.out.println("insert into MYSQL DB userId =" +  userInfo.getUserId());
    }
}
