import java.sql.*;

public class DBConnection {

    private static Connection connection;
    private static StringBuilder insertQuery = new StringBuilder();

    private static String dbName = "learn";
    private static String dbUser = "root";
    private static String dbPass = "12345";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + dbName +
                        "?user=" + dbUser + "&password=" + dbPass);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                    "id INT NOT NULL AUTO_INCREMENT, " +
                    "name TINYTEXT NOT NULL, " +
                    "birthDate DATE NOT NULL, " +
                    "`count` INT NOT NULL, " +
                    "PRIMARY KEY(id))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void executeMultiInsert() throws SQLException {
        String sql = "INSERT INTO voter_count(name, birthDate, `count`) " +
                "VALUES" + insertQuery.toString();

        DBConnection.getConnection().createStatement().execute(sql);
    }

    public static void countVoter(String name, String birthDay) {
        birthDay = birthDay.replace('.', '-');

        insertQuery.append((insertQuery.length() == 0 ? "" : ", "))
                        .append("('")
                        .append(name)
                        .append("', '")
                        .append(birthDay)
                        .append("', 1)");

        if (insertQuery.length() > 1_000_000){
            try {
                executeMultiInsert();
                insertQuery = new StringBuilder();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
