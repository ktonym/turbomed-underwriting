package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.Agency;
import ke.co.turbosoft.med.entity.Agent;
import ke.co.turbosoft.med.entity.Broker;

import java.util.List;

/**
 * Created by akipkoech on 12/8/14.
 */
public interface IntermediaryService {
    List<Agent> findAllAgents();
    List<Broker> findAllBrokers();
    List<Agency> findAllAgencies();
    Agent addAgent(Agent agent);
    Broker addBroker(Broker broker);
    Agency addAgency(Agency agency);

    //List<E> findAll<Agent>();
}
