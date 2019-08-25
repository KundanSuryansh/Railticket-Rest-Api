package com.kundan.railticket.repository;

import java.util.Set;
import com.kundan.railticket.TransportMode.Train;
import com.kundan.railticket.Users.Passenger;
import com.kundan.railticket.utility.Ticket;

public interface TicketDaoImpl {
    public Set<Ticket> getAllTickets();
    public Set<Ticket> getTicketByTrain(Train train);
    public Set<Integer> getAllPnrNo();
    public boolean checkPnrDuplicaton(int pnrNo);
    public void save(Ticket ticket);
    public int getCountOfTickets(Train train);
    public Ticket getTicketByPnr(int pnrNo);
    public boolean removeTicket(Ticket ticket);
    public  Set<Ticket> getTicketsByPassenger(Passenger passenger);
}
