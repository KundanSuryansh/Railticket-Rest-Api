package com.kundan.railticket.repository;

import java.util.List;
import com.kundan.railticket.Users.Passenger;

public interface PassengerDaoImp {
public List<Passenger> getAllPassengers(); //to list all passengers.
public void save(Passenger passenger); // to save passenger's information.
public boolean checkPassengerIdDuplication(int passengerId);
public Passenger getPassengerById(int passengerId);

}
