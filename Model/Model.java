package Model;

import java.sql.*;

import java.util.*;

public class Model {
    Statement stmt;
    Connection c;

    public Model() {
        System.out.println("Model is up!");
    }

    public void connectToDB() {

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/imdb",
                    "postgres", "admin");
            // c.setAutoCommit(false);
            System.out.println("Connected to database");
        } catch (Exception e) {
            System.out.println("Model.connectToDB failed!");
        }

    }

    public void tearDownConnection() {
        try {
            if (c != null) {
                c.close();
            }
            System.out.println("Connection Teardown");

        } catch (Exception e) {

            System.out.println("model.tearDownConnection failed");
        }

    }

    public void insertToDB(String movieName, String rating, String date) {

        try {

            stmt = c.createStatement();
            String sql = "INSERT INTO movies (moviename,ratings,released) "
                    + "VALUES" + "( '" + movieName + "'," + rating + ",'" + date + "');";
            stmt.executeUpdate(sql);
            stmt.close();
            // c.commit();
            System.out.println("Insert record Success");

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("model.insertToDB() failed");
        }
    }

    public List<String> FetchData(String matchString) {
        List<String> Fetched = new ArrayList<String>();
        try {

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM movies where moviename like '%" + matchString + "%';");
            while (rs.next()) {
                String dispString = "Movie: " + rs.getString("moviename") + " Rating: " + rs.getFloat("ratings")
                        + " Date: " + rs.getString("released");
                Fetched.add(dispString);
            }

        } catch (Exception e) {

            System.out.println(e);
            System.out.println("Model.FetchData failed");
        }

        return Fetched;

    }

}
