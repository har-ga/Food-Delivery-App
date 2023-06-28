@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String contactDetails;
    private String openingHours;
    private boolean deliveryAvailable;

    // Constructors, getters, and setters

}
