package dao;

import entities.Facility;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

/**
 * @description
 * @author: vie
 * @date: 18/4/24
 */
public interface MaintenanceService extends Remote {
   public Map<Facility, Long> countMaintenance() throws RemoteException;
}
