package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@Table(name = "people")
@NamedQueries({
      @NamedQuery(name = "Person.findByFacilityName", query = "SELECT p FROM Person p JOIN p.maintenances m WHERE m.facility.name LIKE :facilityName AND m.cost > 0"),
})
public class Person implements Serializable {
   @Serial
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "person_id")
   private String id;

   @Column(name = "full_name")
   private String name;

   private String position;

   private String email;

   private String phone;

   @OneToMany(mappedBy = "person")
   @ToString.Exclude
   private Set<Maintenance> maintenances;

   public Person(String id, String name, String position, String email, String phone) {
      this.id = id;
      this.name = name;
      this.position = position;
      this.email = email;
      this.phone = phone;
   }
}