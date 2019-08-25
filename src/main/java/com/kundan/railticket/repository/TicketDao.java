package com.kundan.railticket.repository;

import java.util.LinkedHashSet;
import java.util.Set;

import com.kundan.railticket.TransportMode.Train;
import com.kundan.railticket.Users.Passenger;
import com.kundan.railticket.utility.Ticket;
/** this is Singleton class,which is holding all the Tickets in from of Set
 *
 * **/
public class TicketDao implements TicketDaoImpl {
    LinkedHashSet<Ticket> ticketContainer=new LinkedHashSet<Ticket>();
    private static TicketDao SINGLE_INSTANCE=null;
    private TicketDao(){}
    public static TicketDao getInstance()
    {
        if(SINGLE_INSTANCE==null)
            SINGLE_INSTANCE=new TicketDao();
        return SINGLE_INSTANCE;

    }

    @Override
    public void save(Ticket ticket) {
    ticketContainer.add(ticket);
    }

    @Override
    public boolean checkPnrDuplicaton(int pnrNo) {
        for (Ticket ticket:ticketContainer)
        {
           if(pnrNo==ticket.getPnrNo())
               return true;
        }
        return false;
    }

    @Override
    public Set<Integer> getAllPnrNo() {
        LinkedHashSet<Integer> allPnr=new LinkedHashSet<Integer>();
        for (Ticket ticket:ticketContainer)
        {
            allPnr.add(ticket.getPnrNo());
        }
        return allPnr;
    }

    @Override
    public Set<Ticket> getAllTickets() {
        return ticketContainer;
    }


    @Override
    public Set<Ticket> getTicketByTrain(Train train) { //it returns set of all ticket object of specified train.
        LinkedHashSet<Ticket> filterTicketContainer=new LinkedHashSet<Ticket>();
        for(Ticket ticket:ticketContainer)
        {
            if(ticket.getTrain().getTrainNumber()==train.getTrainNumber())
            {
                filterTicketContainer.add(ticket);
            }
        }
        return filterTicketContainer;
    }

    @Override
    public Ticket getTicketByPnr(int pnrNo) { //it return Ticket object if the given pnr is matched with any ticket present in set.
        for(Ticket ticket:ticketContainer)
        {
            if(ticket.getPnrNo()==pnrNo)
            {
                return ticket;
            }
        }
        return null;
    }

    @Override
    public int getCountOfTickets(Train train) { // it returns tottal number of ticket got booked in specified train.
        int count=0;
        for (Ticket ticket:ticketContainer)
        {
            if(ticket.getTrain().getTrainNumber()==train.getTrainNumber())
            {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean removeTicket(Ticket ticket) {
        return ticketContainer.remove(ticket);
    }

    @Override
    public Set<Ticket> getTicketsByPassenger(Passenger passenger) {
        LinkedHashSet<Ticket> filterTicketContainer=new LinkedHashSet<Ticket>();
        for(Ticket ticket :ticketContainer)
        {
            if(ticket.getPassenger().getPassengerId()==passenger.getPassengerId())
            {
                filterTicketContainer.add(ticket);
            }
        }
        return filterTicketContainer;
    }
}
