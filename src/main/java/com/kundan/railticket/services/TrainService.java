package com.kundan.railticket.services;


import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kundan.railticket.TransportMode.Train;
import com.kundan.railticket.repository.TrainDao;

@RestController
public class TrainService {

	@GetMapping("/Trains")
	public Set<Train> getAllTrain()
	{
		return TrainDao.getInstance().getAllTrains();
	}
}
