package org.example;

import java.sql.*;
/**
 * Data adapter.
 */

public class DataAdapter implements SaveMe {

  public void save(Commodity commodity){
    try {
      Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/girrafe", "root", "password");
      Statement statement = connection.createStatement();
      String query = "INSERT INTO commodity VALUES()";
      statement.executeQuery(query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void save(InvoiceElement invoiceElement){
    try {
      Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/girrafe", "root", "password");
      Statement statement = connection.createStatement();
      String query = "INSERT INTO invoiceElement VALUES()";
      statement.executeQuery(query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void save(Invoice invoice){
    try {
      Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/girrafe", "root", "password");
      Statement statement = connection.createStatement();
      String query = "INSERT INTO invoice VALUES()";
      statement.executeQuery(query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
