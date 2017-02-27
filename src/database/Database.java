package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This is a class for working with database. This class uses Singleton pattern.
 */

public class Database {
    private static Database instance = null;

    /**
     * This are params of connection
     */
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://localhost/dictionarytest";
    private static String name = "username";
    private static String password = "password";
    private static String table = "table";

    /**
     * This are params for creating requests and update them
     */
    private Connection connection = null;
    private Statement statement = null;

    /**
     * This is a method to create and use {@link Database}
     * @return Instance of Database class state
     */
    public synchronized static Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;
    }
    /*
    public synchronized boolean setConnection(String databaseURL, String name, String password) {
        DB_URL = databaseURL;
        this.name = name;
        this.password = password;
        return connectToDatabase(databaseURL, name, password);
    }

    // TODO delete this method before production
    public synchronized void setDefaultConnection() {
        this.DB_URL = "jdbc:mysql://localhost/dictionarytest";
        this.name = "username";
        this.password = "password";
        connectToDatabase(DB_URL, name, password);
    }*/

    /**
     * This is a method for connecting to database
     * @param tableName The name of table
     * @param name The name of user
     * @param password The user's password
     * @return Is connected
     */
    public synchronized boolean connectToDatabase(String tableName, String name, String password) {
        table = tableName;
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database \'" + name + "\'...");
            connection = DriverManager.getConnection(DB_URL, name, password);
            statement = connection.createStatement();
            System.out.println("Connected to database \'" + name + "\'");
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // TODO end method for adding new word into database
    public synchronized boolean addWord(String fromLang, String toLang, String fromWord, String toWord, String partOfSpeach) {
        updateQuery("INSERT INTO " + table +
            " VALUES('" + fromLang + "', '" + toLang + "', '" +
                fromWord + "', '" + toWord + "', '" + partOfSpeach + "')");
        return false;
    }

    /**
     * This is a method for executing new sql requests
     * @param sql The text of request
     * @return Is request completed
     */
    private boolean executeQuery(String sql) {
        try {
            if (sql != null) {
                System.out.println("Executing query \'" + sql + "\'...");
                statement.executeQuery(sql);
                System.out.println("Executed");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This is a method for updating sql requests
     * @param sql The text of request
     * @return Is request completed
     */
    private boolean updateQuery(String sql) {
        try {
            if (sql != null) {
                System.out.println("Update query \'" + sql + "\'...");
                statement.executeUpdate(sql);
                System.out.println("Updated");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
