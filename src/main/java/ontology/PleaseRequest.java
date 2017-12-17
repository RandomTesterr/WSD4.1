package ontology;

import jade.content.Concept;

public class PleaseRequest implements Concept {

    java.lang.String PleaseRequestContent;

    public PleaseRequest(){
        this.PleaseRequestContent = "";
    }

    public PleaseRequest(java.lang.String Content){
        this.PleaseRequestContent=Content;
    }

    public void setPRContent (java.lang.String newContent){
        this.PleaseRequestContent = newContent;
    }

    public java.lang.String getPRContent () {
        return this.PleaseRequestContent;
    }
}


