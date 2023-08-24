package pattern.abstractFactory.factory;

import pattern.abstractFactory.domain.product.dao.ProductDao;
import pattern.abstractFactory.domain.userinfo.dao.UserInfoDao;

public interface DaoFactory {

    public UserInfoDao createUserInfoDao();
    public ProductDao createProductInfoDao();
}
