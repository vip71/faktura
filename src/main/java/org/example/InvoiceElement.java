package org.example;

/**
 * GRASP - Responsible for managing specific record.
 * GRASP - High Cohesion - between Invoice and Product to lower dependency
 */
public class InvoiceElement {
  private final Commodity commodity;
  private final int amount;

  private final SaveMe saveMe;

  //GRASP - Information expert
  // obvious that this class knows the most about its own
  InvoiceElement(int amount, float unitPrice, String name, SaveMe saveMe) {
    this.commodity = new Commodity(name, unitPrice, saveMe);
    this.amount    = amount;
    this.saveMe = saveMe;
  }

  public void saveElement() {
    saveMe.save(this);
  }

  //GRASP - Information expert
  // to get total price we need unitPrice and quantity,
  // this class knows both of them
  // (e.g. product do not know quantity)
  public float calcElementPrice() {
    return commodity.getUnitPrice() * amount;
  }

  /**
  * Element text.

  * @return returns elements text
  */
  public String elementText() {
    String text = "";

    text += amount + " " + commodity.getName() + " "
        + commodity.getUnitPrice() + " " + calcElementPrice();

    return text;
  }

  //GRASP - Information expert
  // obvious that this class knows the most about info inside getters and setters
  public int getAmount() {
    return amount;
  }

  //GRASP - Information expert
  // obvious that this class knows the most about info inside getters and setters
  public Commodity getCommodity() {
    return commodity;
  }
}
