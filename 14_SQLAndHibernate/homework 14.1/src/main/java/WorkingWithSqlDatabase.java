import java.sql.*;

public class WorkingWithSqlDatabase {

    private String url = "";
    private String user = "";
    private String password = "";

    public WorkingWithSqlDatabase(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void getInformationFromConnection(String query){
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String courseName = resultSet.getString(1);
                String averageMonthsSales = resultSet.getString(2);
                System.out.println(courseName + " - " + averageMonthsSales);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
