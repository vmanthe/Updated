package com.proquest.interview.phonebook;

public class Person
{
  private String name;
  private String phoneNumber;
  private String address;

  public Person(String name, String phoneNumber, String address)
  {
    super();
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }
  

  @Override
  public String toString()
  {
    return "Person [name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
  }
  
  @Override
  public int hashCode()
  {
    int result = 1;
    result =  result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Person other = (Person) obj;
    if (name == null)
    {
      if (other.name != null)
        return false;
    }
    else if (!name.equals(other.name))
      return false;
    return true;
  }


}
