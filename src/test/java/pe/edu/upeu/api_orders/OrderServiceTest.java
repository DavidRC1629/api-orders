package pe.edu.upeu.api_orders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.edu.upeu.api_orders.model.Order;
import pe.edu.upeu.api_orders.repository.OrderRepository;
import pe.edu.upeu.api_orders.service.OrderService;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    void testConDescuento() {
        when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Order order = new Order(null, "Cliente A", 1200.0);

        Order resultado = orderService.createOrder(order);

        assertEquals(1080.0, resultado.getAmount());
    }

    @Test
    void testSinDescuento() {
        when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Order order = new Order(null, "Cliente B", 500.0);

        Order resultado = orderService.createOrder(order);

        assertEquals(500.0, resultado.getAmount());
    }
}
