package dao;

import entities.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface PersonService extends Remote {
   public List<Person> getMaintenanceWorkers(String facilityName) throws RemoteException;
}
