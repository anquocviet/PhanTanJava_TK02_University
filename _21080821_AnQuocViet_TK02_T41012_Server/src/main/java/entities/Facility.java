package entities;

import enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.checkerframework.checker.fenum.qual.FenumTop;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@Table(name = "facilities")
public class Facility implements Serializable {
   @Serial
   private static final long serialVersionUID = 1L;

   @Id
   @Column(name = "facility_id")
   private String id;

   @Column(name = "facility_name")
   private String name;

   private String description;

   @Column(name = "purchase_date")
   private LocalDate purchaseDate;

   private double price;

   @Enumerated(EnumType.STRING)
   private Status status;

   private String location;

   @ManyToOne
   @JoinColumn(name = "department_id")
   private Department department;

   @OneToMany(mappedBy = "facility")
   private Set<Maintenance> maintenances;

   public Facility(String id, String name, String description, LocalDate purchaseDate, double price, Status status, String location) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.purchaseDate = purchaseDate;
      this.price = price;
      this.status = status;
      this.location = location;
   }
}