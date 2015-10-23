package com.proquest.interview.phonebook;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.proquest.interview.util.DatabaseUtil;

public class PhoneBookImplTest 
{
  PhoneBook phoneBook;
  
  @Before
  public void setUp() throws Exception
  {
    DatabaseUtil.initDB();
    phoneBook = new PhoneBookImpl();
  }
  
  @Test
  public void shouldAddFindPerson() throws ClassNotFoundException, SQLException 
  {
    Person test = new Person("test test", "90324214", "some test city");
    phoneBook.addPerson(test);
    
    assertNotNull(phoneBook.findPerson("test", "test"));
    assertTrue(phoneBook.findPerson("test", "test").equals(test));
    
    assertNull(phoneBook.findPerson("notest", "notest"));
  }







}
