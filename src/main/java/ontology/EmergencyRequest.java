package ontology;

import jade.content.Concept;


public class EmergencyRequest implements Concept {

    java.lang.String RequestContent;

    public EmergencyRequest(){
        this.RequestContent = "";
    }

    public EmergencyRequest(java.lang.String Content){
        this.RequestContent=Content;
    }

    public void setERContent (java.lang.String newContent){
        this.RequestContent = newContent;
    }

    public java.lang.String getERContent () {
        return this.RequestContent;
    }
}
