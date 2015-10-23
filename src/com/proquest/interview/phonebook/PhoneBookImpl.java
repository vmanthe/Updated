package com.proquest.interview.phonebook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.proquest.interview.util.DatabaseUtil;

public class PhoneBookImpl implements PhoneBook {
	public List people;
	
	@Override
	public void addPerson(Person newPerson) throws SQLException, ClassNotFoundException 
	{
	  Connection cn = DatabaseUtil.getConnection();
    PreparedStatement pstmt = cn.prepareStatement("INSERT INTO PHONEBOOK (NAME, PHONENUMBER, ADDRESS) VALUES(?,?, ?)");
    pstmt.setString(1, newPerson.getName());
    pstmt.setString(2, newPerson.getPhoneNumber());
    pstmt.setString(3, newPerson.getAddress());
    
    int rs = pstmt.executeUpdate();
    System.out.println("number of records saved " + rs);
    
    cn.commit();
    cn.close();
    
	}
	
	//@Override
	public Person findPerson() {
	   return null;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DatabaseUtil.initDB();  //You should not remove this line, it creates the in-memory database
		
    PhoneBook phoneBook = new PhoneBookImpl();
    
    Person johnSmith = new Person("John Smith","(248) 123-4567","1234 Sand Hill Dr, Royal Oak, MI");
    phoneBook.addPerson(johnSmith);
    
    Person cynthiaSmith = new Person("Cynthia Smith","(824) 128-8758","875 Main St, Ann Arbor, MI");
    phoneBook.addPerson(cynthiaSmith);


		// TODO: print the phone book out to System.out
    

    // TODO: find Cynthia Smith and print out just her entry
    System.out.println(phoneBook.findPerson("Cynthia", "Smith"));
		
    // TODO: insert the new person objects into the database
    Person newPerson = new Person("Sachin Tendulakr","(339) 123-1234","3767 Dodgers Std, Los Angeles, CA");
    phoneBook.addPerson(newPerson);
    
    //Just to check weather the above object is saved in db or no
    System.out.println(phoneBook.findPerson("Sachin", "Tendulakr"));
    
    
	}

  @Override
  public Person findPerson(String firstName, String lastName) throws ClassNotFoundException, SQLException
  {
    Person person=null;
      Connection cn = DatabaseUtil.getConnection();
      PreparedStatement pstmt = cn.prepareStatement("SELECT NAME, PHONENUMBER, ADDRESS FROM PHONEBOOK WHERE NAME=?");
       pstmt.setString(1, firstName+" "+lastName);
       ResultSet rs = pstmt.executeQuery();
       
       if(rs.next())
       {
         person = new Person(rs.getString("NAME"),rs.getString("PHONENUMBER"),rs.getString("ADDRESS"));
       }
       cn.commit();
       cn.close();
    return person;
  }
}
