package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Production Line Tracker with a GUI and database. Software for a media player production facility
 * that will keep track of what products are produced.
 *
 * @author Cody Buckley
 */
public class Main extends Application {

  /**
   * The starting point of a JavaFX program.
   *
   * @param primaryStage the first thing the user sees
   * @throws Exception general exception handler
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    connectDB();

    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 500, 375));
    primaryStage.show();
  }

  public static Statement connectDB() {

    // Driver and URL pointing to Database
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/production";

    //  Database credentials
    final String USER = "";
    final String PASS = "";

    Connection conn;
    Statement stmt = null;

    try {
      // Register Java Database driver
      Class.forName(JDBC_DRIVER);

      // Open a connection
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      // Execute a query
      stmt = conn.createStatement();

      return stmt;
    } catch (Exception ex) {
      ex.printStackTrace();
      return null;
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
