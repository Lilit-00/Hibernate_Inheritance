package strategies;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Product {
    @Id
    private Long id;
    private String name;
    // getters and setters
}

@Entity
class Book extends Product {
    private String author;
    // getters and setters
}

@Entity
class Electronic extends Product {
    private String brand;
    // getters and setters
}

