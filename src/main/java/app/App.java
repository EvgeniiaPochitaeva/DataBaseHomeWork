package app;

import app.database.Database;
import app.database.DatabaseQueryService;

public class App {
    public static void main(String[] args) throws Exception {
        Database database = Database.getInstance();
        System.out.println(new DatabaseQueryService().findMaxSalaryWorker(database));
        System.out.println(new DatabaseQueryService().findMaxProjectsClient(database));
        System.out.println(new DatabaseQueryService().findLongestProject(database));
        System.out.println(new DatabaseQueryService().findYoungestEldestWorkers(database));
       System.out.println(new DatabaseQueryService().findProjectPrices(database));
    }
}
