package dao.impl;

import dao.MaintenanceService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;

class MaintenanceImplTest {
   MaintenanceService maintenanceService = null;

   @BeforeEach
   void setUp() throws RemoteException {
      maintenanceService = new MaintenanceImpl();
   }

   @AfterEach
   void tearDown() {
      maintenanceService = null;
   }

   @Test
   void countMaintenance() throws RemoteException {
      maintenanceService.countMaintenance().forEach((facility, count) -> {
         System.out.println(facility.getName() + " " + count);
      });
   }
}