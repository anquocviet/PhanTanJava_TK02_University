package fit.se;

import dao.FacilityService;
import dao.MaintenanceService;
import dao.PersonService;
import lombok.SneakyThrows;

import java.rmi.Naming;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   private static final String URL = "rmi://VIE:8080/UniversityService";

   @SneakyThrows
   public static void main(String[] args) {

      FacilityService facilityService = (FacilityService) Naming.lookup(URL + "/facility");
      MaintenanceService maintenanceService = (MaintenanceService) Naming.lookup(URL + "/maintenance");
      PersonService personService = (PersonService) Naming.lookup(URL + "/person");


            maintenanceService.countMaintenance().forEach((k, v) -> System.out.println(k.getName() + " " + v));

   }
}