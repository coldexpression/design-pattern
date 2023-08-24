package pattern.abstractFactory.web;

import pattern.abstractFactory.domain.product.Product;
import pattern.abstractFactory.domain.product.dao.ProductDao;
import pattern.abstractFactory.domain.userinfo.UserInfo;
import pattern.abstractFactory.domain.userinfo.dao.UserInfoDao;
import pattern.abstractFactory.factory.DaoFactory;
import pattern.abstractFactory.factory.MySqlDaoFactory;
import pattern.abstractFactory.factory.OracleDaoFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebClient {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("db.properties");

        Properties prop = new Properties();
        prop.load(fis);

        String dbType = prop.getProperty("DBTYPE");

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("12345");
        userInfo.setPassword("!@#$");
        userInfo.setUserName("이순신");

        Product product = new Product();
        product.setProductId("0011AA");
        product.setProductName("TV");

        DaoFactory daoFactory = null;

        if (dbType.equals("MYSQL")) {
            daoFactory = new MySqlDaoFactory();
        } else if (dbType.equals("ORACLE")) {
            daoFactory = new OracleDaoFactory();
        } else {
            System.out.println("error");
        }

        UserInfoDao userInfoDao = daoFactory.createUserInfoDao();
        System.out.println("===UserInfo TRANSACTION===");
        userInfoDao.insertUserInfo(userInfo);
        userInfoDao.updateUserInfo(userInfo);
        userInfoDao.deleteUserInfo(userInfo);

        ProductDao productDao = daoFactory.createProductInfoDao();
        System.out.println("===Product TRANSACTION===");
        productDao.insertProduct(product);
        productDao.updateProduct(product);
        productDao.deleteProduct(product);
    }
}
