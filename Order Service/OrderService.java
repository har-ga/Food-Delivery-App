public interface OrderService {

    Order createOrder(Order order);
    Order getOrderById(Long id);
    List<Order> getAllOrders();
    List<Order> getOrdersByCustomer(Long customerId);
    Order updateOrderStatus(Long id, OrderStatus status);
    void deleteOrder(Long id);

}
