package dao.impl;

import dao.FacilityService;
import entities.Facility;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @description
 * @author: vie
 * @date: 18/4/24
 */
public class FacilityImpl extends UnicastRemoteObject implements FacilityService {
   EntityManager em = null;

   public FacilityImpl() throws RemoteException {
      em = Persistence.createEntityManagerFactory("MariaDB University").createEntityManager();
   }

   @Override
   public boolean updateFacility(Facility newInfoFacility) throws RemoteException {
      EntityTransaction transaction = em.getTransaction();

      try {
         transaction.begin();
         Facility f = em.find(Facility.class, newInfoFacility.getId());
         if (f == null) {
            transaction.rollback();
            return false;
         }
         ;
         if (f.getPrice() <= newInfoFacility.getPrice()) {
            transaction.rollback();
            return false;
         }
         f.setDescription(newInfoFacility.getDescription());
         f.setPrice(newInfoFacility.getPrice());
         f.setStatus(newInfoFacility.getStatus());
         f.setLocation(newInfoFacility.getLocation());
         em.merge(f);
         transaction.commit();
         return true;
      } catch (Exception e) {
         e.printStackTrace();
         transaction.rollback();
         return false;
      }
   }
}
