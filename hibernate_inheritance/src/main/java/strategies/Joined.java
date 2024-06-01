package strategies;
import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
 abstract class Account {
    @Id
    private Long id;
    private String owner;
    // getters and setters
}

@Entity
 class SavingsAccount extends Account {
    private BigDecimal interestRate;
    // getters and setters
}

@Entity
 class CheckingAccount extends Account {
    private BigDecimal overdraftLimit;
    // getters and setters
}

