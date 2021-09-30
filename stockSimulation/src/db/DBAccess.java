package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBAccess {
  private static Connection conn = null;

  public void init() {
    try {
      Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static Connection setConnection() {
    //url 확인
    String url = "jdbc:postgresql://localhost:5432/stock_simulator";
    String userName = "kuk";
    String password = "zxcv4489";

    try {
      conn = DriverManager.getConnection(url, userName, password);
    } catch(SQLException e) {
      e.printStackTrace();
    }

    return conn;
  }

}
