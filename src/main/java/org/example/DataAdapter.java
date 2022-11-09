package org.example;

import java.sql.*;
/**
 * Data adapter.
 */

public class DataAdapter implements SaveMe {
  static int currentCommodityId = 0;
  static int currentInvoiceId = 0;

  /**
 * Saving commodity.

 * @param commodity commodity
 */
  public void save(Commodity commodity) {
    try {
      Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/girrafe",
                                                      "root", "password");
      Statement statement = connection.createStatement();
      String query = "INSERT INTO commodity VALUES('" + currentCommodityId + "','"
                    + commodity.getName() + "','" + commodity.getUnitPrice() + "')";
      currentCommodityId++;
      statement.executeQuery(query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
 * Saving Invoice Element.

 * @param invoiceElement invoiceElement
 */
  public void save(InvoiceElement invoiceElement) {
    try {
      Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/girrafe",
                                                      "root", "password");
      Statement statement = connection.createStatement();
      String query = "INSERT INTO invoiceElement VALUES('" + currentInvoiceId
                     + "','" + invoiceElement.getAmount() + "','" + currentCommodityId + "')";
      invoiceElement.getCommodity().save();
      statement.executeQuery(query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
 * Saving Invoice.

 * @param invoice invoice
 */
  public void save(Invoice invoice) {
    try {
      Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/girrafe",
                                                      "root", "password");
      Statement statement = connection.createStatement();
      String query = "INSERT INTO invoice VALUES('" + invoice.id + "','" + invoice.getEmployeeName()
                      + "','" + invoice.getClientName() + "')";
      currentInvoiceId = invoice.id;
      statement.executeQuery(query);
      for (InvoiceElement element : invoice.elementList
           ) {
        element.saveElement();
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
