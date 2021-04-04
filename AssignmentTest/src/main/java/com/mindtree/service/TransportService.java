package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Bus;
import com.mindtree.entity.Passenger;
import com.mindtree.exceptions.ServiceExcptions.TransportServiceException;

public interface TransportService {

	public Passenger addPassenger(Passenger passenger, int busId) throws TransportServiceException;

	public Bus addBus(Bus bus) throws TransportServiceException;

	public List<Passenger> displayPassengerDetails(String busName) throws TransportServiceException;

	public void updatePassengerAge(int passengerAge, int passengerId) throws TransportServiceException;

	public void deletePassenger(int passengerId) throws TransportServiceException;

}
