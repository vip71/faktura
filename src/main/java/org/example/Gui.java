package org.example;

import static java.lang.Integer.parseInt;

import javax.swing.*;

/**
 * Gui.
 */
public class Gui extends JFrame {
  Invoice invoice;
  private JTextField idTextField;
  private JLabel id;
  private JTextField clientTextField;
  private JTextField elementTextField;
  private JTextField amountTextField;
  private JTextField empTextField;
  private JTextField unitPriceTextField;
  private JButton addElementButton;
  private JButton generateButton;
  private JPanel mainPanel;
  private JTextPane invoiceText;
  private JButton removeAllElementsButton;

  Gui(Invoice invoice) {
    this.invoice = invoice;
    setContentPane(mainPanel);
    setSize(600, 600);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    addActionListeners(invoice);
  }

  private void addActionListeners(Invoice invoice) {
    addElementButton.addActionListener(
        e -> {
        invoice.addElement(tryParseInt(amountTextField.getText()),
            tryParseFloat(unitPriceTextField.getText()),
            elementTextField.getText());
        invoiceText.setText(invoice.allElementText());
      });
    removeAllElementsButton.addActionListener(
        e -> {
        invoice.clearElements();
        invoiceText.setText(invoice.allElementText());
      });
    generateButton.addActionListener(
        e -> {
        invoice.generate(tryParseInt(idTextField.getText()),
            empTextField.getText(), clientTextField.getText());
        invoiceText.setText(invoice.invoiceText());
      });
  }

  float tryParseFloat(String string) {
    try {
      return Float.parseFloat(string);
    } catch (Exception ignored) {
      return 0;
    }
  }

  int tryParseInt(String string) {
    try {
      return parseInt(string);
    } catch (Exception ignored) {
      return 0;
    }
  }
}

