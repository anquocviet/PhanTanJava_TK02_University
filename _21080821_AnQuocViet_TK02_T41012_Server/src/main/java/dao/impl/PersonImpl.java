package dao.impl;

import dao.PersonService;
import entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * @description
 * @author: vie
 * @date: 18/4/24
 */
public class PersonImpl extends UnicastRemoteObject implements PersonService {
   EntityManager em = null;

   public PersonImpl() throws RemoteException {
      em = Persistence.createEntityManagerFactory("MariaDB University").createEntityManager();
   }

   @Override
   public List<Person> getMaintenanceWorkers(String facilityName) throws RemoteException {
      return em.createNamedQuery("Person.findByFacilityName", Person.class)
                   .setParameter("facilityName", "%" + facilityName + "%")
                   .getResultList();
   }
}
