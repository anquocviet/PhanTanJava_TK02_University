package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@Table(name = "maintenances")
@NamedQueries({
      @NamedQuery(name = "Maintenance.countMaintenance",
            query = "SELECT m.facility, COUNT(m.facility) FROM Maintenance m GROUP BY m.facility ORDER BY m.facility.name"),
})
public class Maintenance {
   @Id
   @Column(name = "start_date")
   private LocalDate startDate;

   @Column(name = "end_date")
   private LocalDate endDate;

   private String description;

   private double cost;

   @ManyToOne
   @JoinColumn(name = "person_id")
   private Person person;

   @ManyToOne
   @JoinColumn(name = "facility_id")
   private Facility facility;

   public Maintenance(LocalDate startDate, LocalDate endDate, String description, double cost) {
      this.startDate = startDate;
      this.endDate = endDate;
      this.description = description;
      this.cost = cost;
   }
}