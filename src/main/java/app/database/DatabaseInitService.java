package app.database;

import app.prefs.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseInitService {

   public void initDb(Database database){
       try {
           String initDbFileName = new Prefs().getString(Prefs.INIT_DB_SQL_FILE_PATH);
           String sql = String.join(
                   "\n",
                   Files.readAllLines(Paths.get(initDbFileName))
           );
           database.executeUpdate(sql);
       } catch (IOException e) {
           e.printStackTrace();

       }

   }
    public static void main(String[] args) {
       Database database = Database.getInstance();
       new DatabaseInitService().initDb(database);


    }
}
