package dao;

import entities.Facility;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FacilityService extends Remote {
   public boolean updateFacility(Facility newInfoFacility) throws RemoteException;
}
