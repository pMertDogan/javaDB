import java.sql.*;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws SQLException {

        /*
        *
        * Silme işlemi ile bitirdik
        *
        * */

        Connection connection = null;
        DBHelper dbHelper = new DBHelper();
        PreparedStatement statement = null; //Cümlecik
        try {
            connection = dbHelper.getConnection();
            String sql = "delete from city where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 4087);

            statement.executeUpdate();
            System.out.println("kayit silindi");


        } catch (SQLException e) {
            dbHelper.showErrorMesseage(e);
        } finally {
            connection.close();


        }
    }

    public void sqlSecimDemo() throws SQLException {
        Connection connection = null;
        DBHelper dbHelper = new DBHelper();
        Statement statement = null; //Cümlecik , konsol gibi bişi heralde aslında
        ResultSet resultSet = null; // SQLSorgusundan geri dönen veri
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select Code,Name,Continent,Region from country");
            ArrayList<Ulkeler> ulkelerListesi = new ArrayList<Ulkeler>();

            while (resultSet.next()) {
                ulkelerListesi.add(new Ulkeler(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region")
                ));
                //System.out.println(resultSet.getString("Name"));

            }
            System.out.println("ülke sayisi " + ulkelerListesi.size());

        } catch (SQLException e) {
            dbHelper.showErrorMesseage(e);
        } finally {
            connection.close();

        }
    }

    public void sqlEklemeDemo() throws SQLException {
        Connection connection = null;
        DBHelper dbHelper = new DBHelper();
        PreparedStatement statement = null; //Cümlecik , konsol gibi bişi heralde aslında
        try {
            /*
            connection = dbHelper.getConnection();
            statement = connection.prepareStatement(
                    "insert into city (Name,CountryCode,District,Population) values ('MertLand','TUR','Düzce','763000')");
*/


            connection = dbHelper.getConnection();
            String sql = " insert into city (Name,CountryCode,District,Population) values (?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "PMELand");
            statement.setString(2, "TUR");
            statement.setString(3, "Sakarya");
            statement.setInt(4, 763);

            statement.executeUpdate();
            System.out.println("kayit eklendi");


        } catch (SQLException e) {
            dbHelper.showErrorMesseage(e);
        } finally {
            connection.close();


        }
    }

    public void sqlGuncellemeDemo() throws SQLException {
        Connection connection = null;
        DBHelper dbHelper = new DBHelper();
        PreparedStatement statement = null; //Cümlecik
        try {
/*
            connection = dbHelper.getConnection();
            String sql = "update city set population = 763,district ='PME' where id = 4087";
            statement = connection.prepareStatement(sql);
*/


            connection = dbHelper.getConnection();
            String sql = "update city set population = 76300,district ='PME' where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 4087);

            statement.executeUpdate();
            System.out.println("kayit güncellendi");


        } catch (SQLException e) {
            dbHelper.showErrorMesseage(e);
        } finally {
            connection.close();


        }
    }

}

