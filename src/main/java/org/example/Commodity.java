package org.example;

/**
 * GRASP - Responsible for managing specific product.
 */
public class Commodity {
  /**
  * Commodity name.
  */
  private final String name;
  /**
  * Unit price.
  */
  private final float unitPrice;

  /**
  * //GRASP - Information expert.
  * // obvious that this class knows the most about its own

  * @param name name
  * @param unitPrice unit price
  */
  Commodity(final String name, final float unitPrice, SaveMe saveMe) {
    this.name = name;
    this.unitPrice = unitPrice;
    saveMe.save(this);
  }

  /**
  * Get unit price.

  * @return unit price
  */
  public float getUnitPrice() {
    return unitPrice;
  }

  /**
  * Get name.

  * @return name
  */
  public String getName() {
    return name;
  }
}
