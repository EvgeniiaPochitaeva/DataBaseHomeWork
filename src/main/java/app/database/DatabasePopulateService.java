package app.database;

import app.prefs.Prefs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void processSQLFile(String filePath, Connection connection) throws IOException, SQLException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sqlBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sqlBuilder.append(line);
                sqlBuilder.append("\n");

                if (line.contains(";")) {
                    String[] sqlStatements = sqlBuilder.toString().split(";");
                    try (Statement statement = connection.createStatement()) {
                        for (String sqlStatement : sqlStatements) {
                            if (!sqlStatement.trim().isEmpty()) {
                                statement.execute(sqlStatement);
                            }
                        }
                    }
                    sqlBuilder.setLength(0); // Очистка StringBuilder
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            Database database = Database.getInstance();
            Connection connection = database.getConnection();
            processSQLFile(new Prefs().getString(Prefs.POPULAR_DB_SQL_FILE_PATH), connection);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        } finally {
            Database.getInstance().close();
        }
    }
}
