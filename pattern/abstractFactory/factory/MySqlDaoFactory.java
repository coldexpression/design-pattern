package pattern.abstractFactory.factory;

import pattern.abstractFactory.domain.product.dao.ProductDao;
import pattern.abstractFactory.domain.product.dao.mysql.ProductMySqlDao;
import pattern.abstractFactory.domain.userinfo.dao.UserInfoDao;
import pattern.abstractFactory.domain.userinfo.dao.mysql.UserInfoMySqlDao;

public class MySqlDaoFactory implements DaoFactory{
    @Override
    public UserInfoDao createUserInfoDao() {
        return new UserInfoMySqlDao();
    }

    @Override
    public ProductDao createProductInfoDao() {
        return new ProductMySqlDao();
    }
}
