package pattern.singleton;

public class ConnectionPool {

    // 하나만 존재해야 하기때문에 static 사용
    private static ConnectionPool instance = new ConnectionPool();

    // 외부에서 생성할 수 없도록 생성자를 private 사용
    private ConnectionPool() {
    }

    ;

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }
}
