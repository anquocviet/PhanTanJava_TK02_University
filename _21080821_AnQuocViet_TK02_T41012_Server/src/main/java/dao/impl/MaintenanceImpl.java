package dao.impl;

import dao.MaintenanceService;
import entities.Facility;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description
 * @author: vie
 * @date: 18/4/24
 */
public class MaintenanceImpl extends UnicastRemoteObject implements MaintenanceService {
   EntityManager em = null;

   public MaintenanceImpl() throws RemoteException {
      em = Persistence.createEntityManagerFactory("MariaDB University").createEntityManager();
   }

   @Override
   public Map<Facility, Long> countMaintenance() throws RemoteException {
      return em.createNamedQuery("Maintenance.countMaintenance", Object[].class)
                   .getResultList()
                   .stream()
                   .collect(Collectors.toMap(
                         (record) -> (Facility) record[0],
                         (record) -> (Long) record[1],
                         (oldValue, newValue) -> oldValue,
                         LinkedHashMap::new
                   ));
   }
}
