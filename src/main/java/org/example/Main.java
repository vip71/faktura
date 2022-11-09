package org.example;

/**
 * Main program class.
 */
public class Main {
  /**
  * Constructor.

  * @param args args
  */
  public static void main(final String[] args) {
    Invoice invoice = new Invoice(new DataAdapter());
    new Gui(invoice);
  }
}
