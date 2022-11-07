package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTest {
    @Test
    public void calcElementPriceTest()
    {
        InvoiceElement invoiceElement =new InvoiceElement(2,2.5f,"Bread",new DataAdapter());
        assertEquals(5,invoiceElement.calcElementPrice());
    }

    @Test
    public void elementTextTest()
    {
        InvoiceElement invoiceElement =new InvoiceElement(2,2.5f,"Bread",new DataAdapter());
        assertEquals("2 Bread 2.5 5.0",invoiceElement.elementText());
    }

    @Test
    public void calcTotalPriceTest()
    {
        Invoice invoice = new Invoice(new DataAdapter());
        invoice.addElement(2,2.5f,"Bread");
        invoice.addElement(3,5f,"Apple");
        assertEquals(20,invoice.calcTotalPrice());
    }

    @Test
    public void allElementTextTest()
    {
        Invoice invoice = new Invoice(new DataAdapter());
        invoice.addElement(2,2.5f,"Bread");
        invoice.addElement(3,5f,"Apple");
        assertEquals("""
                2 Bread 2.5 5.0
                3 Apple 5.0 15.0
                """,invoice.allElementText());
    }

    @Test
    public void invoiceTextTest()
    {
        Invoice invoice = new Invoice(new DataAdapter());
        invoice.setId(12);
        invoice.setClientName("Roman Romanson");
        invoice.setEmployeeName("David Davidek");
        invoice.addElement(2,2.5f,"Bread");
        invoice.addElement(3,5f,"Apple");
        assertEquals("""
                Id: 12
                                
                Employee: David Davidek
                Client: Roman Romanson
                                
                2 Bread 2.5 5.0
                3 Apple 5.0 15.0
                total: 20.0""",invoice.invoiceText());
    }
}