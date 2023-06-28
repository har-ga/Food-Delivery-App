import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + id));
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {
        Restaurant existingRestaurant = getRestaurantById(id);
        existingRestaurant.setName(restaurant.getName());
        existingRestaurant.setAddress(restaurant.getAddress());
        existingRestaurant.setContactDetails(restaurant.getContactDetails());
        existingRestaurant.setOpeningHours(restaurant.getOpeningHours());
        existingRestaurant.setDeliveryAvailable(restaurant.isDeliveryAvailable());
        return restaurantRepository.save(existingRestaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {
        Restaurant existingRestaurant = getRestaurantById(id);
        restaurantRepository.delete(existingRestaurant);
    }

}
