package wsd;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;

import java.util.ArrayList;
import java.util.List;

public class CarsMap {
    public static List<AID> getAllOtherCars(Agent thisCar, String agentType) {
        DFAgentDescription template = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        List<AID> agents = new ArrayList<>();
        sd.setType(agentType);
        template.addServices(sd);

        try {
            DFAgentDescription[] result = DFService.search(thisCar, template);
            for (DFAgentDescription res : result) {
                if (!res.getName().equals(thisCar.getAID()))
                    agents.add(res.getName());
            }
        } catch (FIPAException e) {
            e.printStackTrace();
        }

        if(agentType == "emergency_agent")
        {
            String aType = "vehicle_agent";
            sd.setType(aType);
            template.addServices(sd);

            try {
                DFAgentDescription[] result = DFService.search(thisCar, template);
                for (DFAgentDescription res : result) {
                    if (!res.getName().equals(thisCar.getAID()))
                        agents.add(res.getName());
                }
            } catch (FIPAException e) {
                e.printStackTrace();
            }
        }
        else if(agentType == "vehicle_agent")
        {
            String aType = "emergency_agent";
            sd.setType(aType);
            template.addServices(sd);

            try {
                DFAgentDescription[] result = DFService.search(thisCar, template);
                for (DFAgentDescription res : result) {
                    if (!res.getName().equals(thisCar.getAID()))
                        agents.add(res.getName());
                }
            } catch (FIPAException e) {
                e.printStackTrace();
            }
        }

        return agents;
    }

    //nowe
    public static List<AID> getAllAgentsOfOneType(Agent thisAgent, String agentType) {
        DFAgentDescription template = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();
        List<AID> agents = new ArrayList<>();
        sd.setType(agentType);
        template.addServices(sd);

        try {
            DFAgentDescription[] result = DFService.search(thisAgent, template);
            for (DFAgentDescription res : result) {
                    agents.add(res.getName());
            }
        } catch (FIPAException e) {
            e.printStackTrace();
        }

        if(agentType == "emergency_agent")
        {
            String aType = "vehicle_agent";
            sd.setType(aType);
            template.addServices(sd);

            try {
                DFAgentDescription[] result = DFService.search(thisAgent, template);
                for (DFAgentDescription res : result) {
                    if (!res.getName().equals(thisAgent.getAID()))
                        agents.add(res.getName());
                }
            } catch (FIPAException e) {
                e.printStackTrace();
            }
        }
        else if(agentType == "vehicle_agent")
        {
            String aType = "emergency_agent";
            sd.setType(aType);
            template.addServices(sd);

            try {
                DFAgentDescription[] result = DFService.search(thisAgent, template);
                for (DFAgentDescription res : result) {
                    if (!res.getName().equals(thisAgent.getAID()))
                        agents.add(res.getName());
                }
            } catch (FIPAException e) {
                e.printStackTrace();
            }
        }

        return agents;
    }
}
