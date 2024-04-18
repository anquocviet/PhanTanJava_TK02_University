package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@Table(name = "departments")
public class Department implements Serializable {
   @Serial
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "department_id")
   private String id;

   @Column(name = "department_name")
   private String name;

   private String location;

   @OneToMany(mappedBy = "department")
   @ToString.Exclude
   private Set<Facility> facilities;

   @OneToOne
   @JoinColumn(name = "manager_id")
   private Person person;

   public Department(String id, String name, String location) {
      this.id = id;
      this.name = name;
      this.location = location;
   }
}