package fit.se;

import dao.FacilityService;
import dao.MaintenanceService;
import dao.PersonService;
import entities.Facility;
import enums.Status;
import lombok.SneakyThrows;

import java.rmi.Naming;
import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   private static final String URL = "rmi://VIE:8080/UniversityService";

   @SneakyThrows
   public static void main(String[] args) {

      FacilityService facilityService = (FacilityService) Naming.lookup(URL + "/facility");
      MaintenanceService maintenanceService = (MaintenanceService) Naming.lookup(URL + "/maintenance");
      PersonService personService = (PersonService) Naming.lookup(URL + "/person");

      Scanner scanner = new Scanner(System.in);

      while (true) {
         System.out.println("1. Liệt kê danh sách những người đã từng bảo trì cơ sở vật chất nào đó: ");
         System.out.println("2. Cập nhật thông tin cơ sở vật chất: ");
         System.out.println("3. Thống kê số lượt bảo trì trên từng cơ sở vật chất: ");
         System.out.println("4. Exit");
         System.out.print("Choose: ");
         int choose = scanner.nextInt();
         switch (choose) {
            case 1:
               facilityService.updateFacility(new Facility("F001", "Facility 1", "Location 1", LocalDate.now(), 100, Status.AVAILABLE, "Location 1"));
               break;
            case 2:
               maintenanceService.countMaintenance().forEach(
                     (k, v) -> {
                        System.out.println("Facility: " + k);
                        System.out.println("Number of maintenance: " + v);
                     }
               );
               break;
            case 3:
               personService.getMaintenanceWorkers("Room").forEach(System.out::println);
               break;
            case 4:
               System.exit(0);
         }
      }

   }
}