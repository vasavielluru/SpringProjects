package com.mindtree.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.Repositories.BusRepository;
import com.mindtree.Repositories.PassengerRepository;
import com.mindtree.entity.Bus;
import com.mindtree.entity.Passenger;
import com.mindtree.exceptions.DaoExceptions.RecordNotAddedException;
import com.mindtree.exceptions.DaoExceptions.RecordNotFoundException;
import com.mindtree.exceptions.ServiceExcptions.TransportServiceException;
import com.mindtree.service.TransportService;

@Service
public class TransportServiceImpl implements TransportService{
	
	@Autowired  private BusRepository busRepo;
	@Autowired private PassengerRepository passengerRepo;

	@Override
	public Passenger addPassenger(Passenger passenger, int busId) throws TransportServiceException {
		
		Bus bus = busRepo.findById(busId).orElse(null);

		if (bus == null) {
			throw new RecordNotFoundException("No such Id Found");
		} else {
			passenger.setBus(bus);
			passengerRepo.save(passenger);
			bus.getPassengers().add(passenger);

			busRepo.save(bus);
		}
			return passenger;
	}

	@Override
	public Bus addBus(Bus bus) throws TransportServiceException {

		int id = bus.getBusId();
		Bus object = null;
		object = busRepo.findById(id).orElse(null);
		try {
			if (object == null) {
				busRepo.save(bus);

			} else {
				throw new RecordNotAddedException("Id already exist");
			}
		} catch (RecordNotAddedException e) {
			throw new TransportServiceException(e.getLocalizedMessage());
		}
		return bus;

		}
	

	@Override
	public List<Passenger> displayPassengerDetails(String busName) throws TransportServiceException {


		List<Passenger> passengersList;
		try {
			Bus bus = busRepo.getBusBybusName(busName);
			
			if(bus==null)
			{
				throw new RecordNotFoundException("No team With the name");
			}
			else 
				passengersList = bus.getPassengers();
		} catch (RecordNotFoundException e) {
			throw new RecordNotFoundException(e.getLocalizedMessage());
		}
		return passengersList;
	}

	@Override
	public void updatePassengerAge(int passengerAge, int passengerId) throws TransportServiceException {


		Passenger passenger = passengerRepo.findById(passengerId).orElse(null);
		try {
			if (passenger == null) {
				throw new RecordNotFoundException("No such Passenegr Id found");
			} else {
				
				passenger.setAge(passengerAge);;
				passengerRepo.save(passenger);
			}
		} catch (RecordNotFoundException e) {
			throw new RecordNotAddedException(e.getLocalizedMessage());
		}
		
	}

	@Override
	public void deletePassenger(int passengerId) throws TransportServiceException {
		
		Passenger passenger = passengerRepo.findById(passengerId).orElse(null);
		try {
			if (passenger == null) {
				throw new RecordNotFoundException("No such Passenegr Id found");
			} else {
				
				passengerRepo.delete(passenger);
			}
		} catch (RecordNotFoundException e) {
			throw new RecordNotFoundException(e.getLocalizedMessage());
		}
		
	}

}
