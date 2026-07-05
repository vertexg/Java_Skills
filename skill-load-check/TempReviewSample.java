package demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TempReviewSample {
    public List<String> loadUsers(List<String> ids, Connection connection) throws Exception {
        List<String> users = new ArrayList<>();

        for (String id : ids) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                "select name from users where id = '" + id + "'"
            );

            while (resultSet.next()) {
                users.add(resultSet.getString("name").toString());
            }
        }

        return users;
    }
}
