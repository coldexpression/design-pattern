package pattern.abstractFactory.factory;

import pattern.abstractFactory.domain.product.dao.ProductDao;
import pattern.abstractFactory.domain.product.dao.oracle.ProductOracleDao;
import pattern.abstractFactory.domain.userinfo.dao.UserInfoDao;
import pattern.abstractFactory.domain.userinfo.dao.oracle.UserInfoOracleDao;

public class OracleDaoFactory implements DaoFactory{
    @Override
    public UserInfoDao createUserInfoDao() {
        return new UserInfoOracleDao();
    }

    @Override
    public ProductDao createProductInfoDao() {
        return new ProductOracleDao();
    }
}
