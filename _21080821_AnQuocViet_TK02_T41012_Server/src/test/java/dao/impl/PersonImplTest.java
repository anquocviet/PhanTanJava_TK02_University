package dao.impl;

import dao.PersonService;
import entities.Person;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;
import java.util.List;

class PersonImplTest {
   PersonService personService = null;

   @BeforeEach
   void setUp() throws RemoteException {
      personService = new PersonImpl();
   }

   @AfterEach
   void tearDown() {
      personService = null;
   }

   @SneakyThrows
   @Test
   void getMaintenanceWorkers() {
      List<Person> people = personService.getMaintenanceWorkers("Room");
      people.forEach(System.out::println);
      Assertions.assertEquals(2, people.size());

   }
}