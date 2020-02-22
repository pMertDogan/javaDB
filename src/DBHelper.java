import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private String userName ="root";
    private String password ="123456";
    //?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC ile zaman dilimi hatası giderildi
    private String dbUrl ="jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


    public Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(dbUrl,userName,password);
    }

    public  void showErrorMesseage(SQLException exception){

        System.out.println("hata " + exception.getMessage());
        System.out.println("hata kodu " + exception.getErrorCode());

    }

}
