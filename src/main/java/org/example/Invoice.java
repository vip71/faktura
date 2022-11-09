package org.example;

import java.util.ArrayList;

/**
 * GRASP - Responsible for managing invoice.
 */
public class Invoice {
  int id;
  String clientName;
  String employeeName;
  ArrayList<InvoiceElement> elementList;
  SaveMe saveMe;

  Invoice(SaveMe saveMe) {
    this.saveMe = saveMe;
    //GRASP - Creator
    // instances the list of its elements
    elementList = new ArrayList<>();
  }

  //GRASP - Low Coupling
  // delegate creation of product to record, reduces dependency between classes
  //GRASP - High Cohesion
  // Low Coupling = High Cohesion
  void addElement(int amount, float price, String name) {
    elementList.add(new InvoiceElement(amount, price, name, saveMe));
  }

  //GRASP - Expert
  // class invoice has the most info about all the elements,
  //so it creates text that describes all of them
  String allElementText() {
    StringBuilder text = new StringBuilder();

    for (InvoiceElement invoiceElement : elementList) {
      text.append(invoiceElement.elementText()).append("\n");
    }

    return text.toString();
  }


  // GRASP - Information Expert.
  // class invoice has the most info about all the elements,
  // so it calculates total price of an invoice
  float calcTotalPrice() {
    float price = 0;

    for (InvoiceElement invoiceElement : elementList) {
      price += invoiceElement.calcElementPrice();
    }

    return price;
  }

  //GRASP - Expert
  // class invoice has the most info its content,
  //so it can erase it
  public void clearElements() {
    elementList.clear();
  }

  //GRASP - Expert
  // class invoice has the most info about itself,
  //so it creates text that describes it
  String invoiceText() {
    return "Id: " + id + "\n\n" + namesText() + "\n\n" + allElementText()
        + "total: " + calcTotalPrice();
  }

  String namesText() {
    return "Employee: " + employeeName + "\n" + "Client: " + clientName;
  }

  //GRASP - Information expert
  // obvious that this class knows the most about info inside getters and setters
  public void setId(int id) {
    this.id = id;
  }

  //GRASP - Information expert
  // obvious that this class knows the most about info inside getters and setters
  void setClientName(String clientName) {
    this.clientName = clientName;
  }

  //GRASP - Information expert
  // obvious that this class knows the most about info inside getters and setters
  void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  /**
 * Generate method.

 * @param id id

 * @param employeeName employee name

 * @param clientName client name
 */
  public void generate(int id, String employeeName, String clientName) {
    setId(id);
    this.employeeName = employeeName;
    this.clientName = clientName;
    saveMe.save(this);
  }

  //GRASP - Information expert
  // obvious that this class knows the most about info inside getters and setters
  public String getEmployeeName() {
    return employeeName;
  }

  //GRASP - Information expert
  // obvious that this class knows the most about info inside getters and setters
  public String getClientName() {
    return clientName;
  }
}
