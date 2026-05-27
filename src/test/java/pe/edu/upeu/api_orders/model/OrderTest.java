package pe.edu.upeu.api_orders.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void shouldCreateAndReadOrderFields() {
        Order order = new Order();
        order.setId(10L);
        order.setCustomer("Cliente X");
        order.setAmount(500.0);

        assertEquals(10L, order.getId());
        assertEquals("Cliente X", order.getCustomer());
        assertEquals(500.0, order.getAmount());
        assertNotNull(order.toString());
    }

    @Test
    void shouldCompareOrders() {
        Order first = new Order(1L, "Cliente A", 100.0);
        Order second = new Order(1L, "Cliente A", 100.0);
        Order different = new Order(2L, "Cliente B", 200.0);

        assertEquals(first, second);
        assertNotEquals(first, different);
        assertEquals(first.hashCode(), second.hashCode());
    }
}
