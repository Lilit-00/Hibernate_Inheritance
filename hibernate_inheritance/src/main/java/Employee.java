
//import jakarta.persistence.*;
import javax.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Set;

@Entity
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(
                name = "get_by_id",
                query = "select p from Employee p where employeeId = :id"
        )

})
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(name = "employee_name", nullable = false)
    private String name;



    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @PrePersist
    protected void prePersist() {
        System.out.println("PrePersist: About to add an Employee with ID: " + employeeId);
    }

    @PostPersist
    protected void postPersist() {
        System.out.println("PostPersist: Added an Employee with ID: " + employeeId);
    }

    @PreUpdate
    protected void preUpdate() {
        System.out.println("PreUpdate: About to update Employee with ID: " + employeeId);
    }

    @PostUpdate
    protected void postUpdate() {
        System.out.println("PostUpdate: Updated Employee with ID: " + employeeId);
    }

    @PreRemove
    protected void preRemove() {
        System.out.println("PreRemove: About to remove Employee with ID: " + employeeId);
    }

    @PostRemove
    protected void postRemove() {
        System.out.println("PostRemove: Removed Employee with ID: " + employeeId);
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", name=" + name + "]";
    }

}