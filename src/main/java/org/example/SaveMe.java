package org.example;

/**
 * Save interface.
 */
public interface SaveMe {

  void save(Invoice invoice);

  void save(InvoiceElement invoiceElement);

  void save(Commodity commodity);
}
