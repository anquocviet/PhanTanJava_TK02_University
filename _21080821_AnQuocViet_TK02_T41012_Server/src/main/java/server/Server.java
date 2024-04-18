package server;

import dao.FacilityService;
import dao.impl.FacilityImpl;
import dao.impl.MaintenanceImpl;
import dao.impl.PersonImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @description
 * @author: vie
 * @date: 18/4/24
 */
public class Server {
   private static final String URL = "rmi://VIE:8080/UniversityService";

   public static void main(String[] args) throws NamingException, RemoteException {
      Context context = new InitialContext();
      LocateRegistry.createRegistry(8080);

      context.bind(URL + "/facility", new FacilityImpl());
      context.bind(URL + "/maintenance", new MaintenanceImpl());
      context.bind(URL + "/person", new PersonImpl());
      System.out.println("Server is running...");

   }
}
