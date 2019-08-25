package com.kundan.railticket.repository;

import com.kundan.railticket.TransportMode.Train;
import com.kundan.railticket.utility.Ticket;

import java.util.Set;

public interface TrainDaoImpl {
    public Set<Train> getAllTrains();
    public Set<Train> searchTrain(String source,String destination);
    public void save(Train train);
    public Train getTrainByTrainNo(int trainNo);
    public int fare(String source,String Destination,Train train);
    public Train getTrainByTicket(Ticket ticket);
}
