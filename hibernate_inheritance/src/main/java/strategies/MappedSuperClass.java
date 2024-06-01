package strategies;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
 abstract class BaseEntity {
    @Id
    private Long id;
    private LocalDateTime createdAt;
    // getters and setters
}

@Entity
 class Employee extends BaseEntity {
    private String name;
    private String department;
    // getters and setters
}
