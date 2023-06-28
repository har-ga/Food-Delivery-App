@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    private final NotificationService notificationService;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentService paymentService, NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }

    @Override
    public Order createOrder(Order order) {
        // Perform order creation logic
        // Calculate total price, validate items, etc.
        // Process payment through paymentService
        // Send order confirmation notification through notificationService
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByCustomer(Long customerId) {
        // Retrieve orders based on customer ID
        // Implement logic to fetch orders for a specific customer
        return orderRepository.findOrdersByCustomerId(customerId);
    }

    @Override
    public Order updateOrderStatus(Long id, OrderStatus status) {
        Order order = getOrderById(id);
        order.setStatus(status);
        // Update order status in the repository
        return orderRepository.save(order);
    }

    @Override
