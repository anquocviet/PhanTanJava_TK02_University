package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * @description
 * @author: vie
 * @date: 18/4/24
 */
public class Main {
   public static void main(String[] args) {

      EntityManagerFactory emf = Persistence.createEntityManagerFactory("MariaDB University");
      EntityManager em = emf.createEntityManager();
   }
}
