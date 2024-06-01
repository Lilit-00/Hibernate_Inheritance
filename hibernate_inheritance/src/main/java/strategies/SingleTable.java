package strategies;
import javax.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
 abstract class Vehicle {
    @Id
    private Long id;
    private String manufacturer;
    // getters and setters
}

@Entity
@DiscriminatorValue("Car")
 class Car extends Vehicle {
    private int numberOfDoors;
    // getters and setters
}

@Entity
@DiscriminatorValue("Bike")
 class Bike extends Vehicle {
    private boolean hasBasket;
    // getters and setters
}

