package com.proquest.interview.phonebook;

import java.sql.SQLException;

public interface PhoneBook {
	public Person findPerson(String firstName, String lastName) throws ClassNotFoundException, SQLException;
	public void addPerson(Person newPerson) throws SQLException, ClassNotFoundException;
}
