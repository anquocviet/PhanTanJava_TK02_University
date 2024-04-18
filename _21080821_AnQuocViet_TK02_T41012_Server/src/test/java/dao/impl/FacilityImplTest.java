package dao.impl;

import dao.FacilityService;
import entities.Facility;
import enums.Status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class FacilityImplTest {
   private FacilityService facilityService = null;
   @BeforeEach
   void setUp() throws RemoteException {
      facilityService = new FacilityImpl();
   }

   @AfterEach
   void tearDown() {
      facilityService = null;
   }

   @Test
   void updateFacility() throws RemoteException {
      Facility facility = new Facility();
      facility.setId("F001");
      facility.setDescription("This is a test facility");
      facility.setPrice(9000);
      facility.setStatus(Status.UNDER_MAINTENANCE);
      facility.setLocation("Hanoi");
      assertEquals(false, facilityService.updateFacility(facility));
   }

   @Test
   void updateFacility1() throws RemoteException {
      Facility facility = new Facility();
      facility.setId("F0000");
      facility.setDescription("This is a test facility");
      facility.setPrice(9000);
      facility.setStatus(Status.UNDER_MAINTENANCE);
      facility.setLocation("Hanoi");
      assertEquals(false, facilityService.updateFacility(facility));
   }

   @Test
   void updateFacility3() throws RemoteException {
      Facility facility = new Facility();
      facility.setId("F001");
      facility.setDescription("This is a test facility");
      facility.setPrice(1000);
      facility.setStatus(Status.UNDER_MAINTENANCE);
      facility.setLocation("Hanoi");
      assertEquals(true, facilityService.updateFacility(facility));
   }
}