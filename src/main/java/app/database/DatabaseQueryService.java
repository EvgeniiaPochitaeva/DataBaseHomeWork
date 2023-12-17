package app.database;

import app.database.find.classes.*;
import app.prefs.Prefs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<MaxProjectCountClient> findMaxProjectsClient(Database database) throws Exception {
        List<MaxProjectCountClient> listMaxProjectCountClients = new ArrayList<>();
        try (Connection connection = database.getConnection()) {
        String findMaxProjectsClientFilename = new Prefs().getString(Prefs.FIND_MAX_PROJECT_CLIENT);
        String sql = String.join("\n", Files.readAllLines(Path.of(findMaxProjectsClientFilename)));

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            String name = rs.getString("client.name");
            int id = rs.getInt("PROJECT_COUNT");
            MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient(name, id);
            listMaxProjectCountClients.add(maxProjectCountClient);
        }

    } catch (Exception exc) {
        exc.printStackTrace();
    }
        return listMaxProjectCountClients;
    }
    public List<FindLongestProject> findLongestProject (Database database) throws Exception{

        List<FindLongestProject> listfindLongestProject = new ArrayList<>();
        try (Connection connection = database.getConnection()) {
            String findLongestProjectFilename = new Prefs().getString(Prefs.FIND_LONGEST_PROJECT);
            String sql = String.join("\n", Files.readAllLines(Path.of(findLongestProjectFilename)));

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int project_id = rs.getInt("project_id");
                int monthCount = rs.getInt("MONTH_COUNT");
                FindLongestProject findLongestProject = new FindLongestProject(project_id, monthCount);
                listfindLongestProject.add(findLongestProject);
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return listfindLongestProject;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker (Database database) throws Exception {
        List<MaxSalaryWorker> listMaxSalaryWorker = new ArrayList<>();
        try (Connection connection = database.getConnection()) {
            String findMaxSalaryWorkerFilename = new Prefs().getString(Prefs.FIND_MAX_SALARY_WORKER);
            String sql = String.join("\n", Files.readAllLines(Path.of(findMaxSalaryWorkerFilename)));

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("name");
                int salary = rs.getInt("salary");
                MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker(name, salary);
                listMaxSalaryWorker.add(maxSalaryWorker);
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return listMaxSalaryWorker;
    }
    public List<FindYoungestEldestWorkers> findYoungestEldestWorkers (Database database) throws Exception {
        List<FindYoungestEldestWorkers> listFindYoungestEldestWorkers = new ArrayList<>();
        try (Connection connection = database.getConnection()) {
            String findYoungestEldestWorkersFilename = new Prefs().getString(Prefs.FIND_YOUNGEST_ELDEST_WORKERS);
            String sql = String.join("\n", Files.readAllLines(Path.of(findYoungestEldestWorkersFilename)));

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String type = rs.getString("type");
                String name = rs.getString("name");
                Date birthday = rs.getDate("birthday");

                FindYoungestEldestWorkers findYoungestEldestWorkers = new FindYoungestEldestWorkers(type, name, birthday);
                listFindYoungestEldestWorkers.add(findYoungestEldestWorkers);
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return listFindYoungestEldestWorkers;
    }
    public List<FindProjectPrices> findProjectPrices (Database database) throws Exception {
        List<FindProjectPrices> listProjectPrices = new ArrayList<>();
        try (Connection connection = database.getConnection()) {
            String findProjectPricesFilename = new Prefs().getString(Prefs.PRINT_PROJECT_PRICES);
            String sql = String.join("\n", Files.readAllLines(Path.of(findProjectPricesFilename)));

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int project_id = rs.getInt("project_id");
                long price = rs.getLong("PRICE");
                FindProjectPrices findprojectPrices = new FindProjectPrices(project_id, price);
                listProjectPrices.add(findprojectPrices);
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return listProjectPrices;
    }

}
