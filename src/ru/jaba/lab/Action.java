package ru.jaba.lab;

import java.util.Objects;

public class Action {
    private Named subject;
    private String sentence;
    private ActionType type;

    private String startDetail = "";
    private String midDetail = "";
    private String endDetail = "";
    private Connection connection = Connection.NIHIL;

    private boolean collapsingSubject = false;

    public Action(Named subject, String sentence,ActionType type){
        this.subject = subject;
        this.sentence = sentence;
        this.type = type;
    }

    public Named getSubject(){
        return subject;
    }
    public String getSentence(){
        return sentence;
    }
    public ActionType getType(){
        return type;
    }
    public String getStartDetail(){return startDetail;}
    public String getMidDetail(){return midDetail;}
    public String getEndDetail(){return endDetail;}
    public Connection getConnection(){ return connection;}

    public void setSubject(Named subject){
        this.subject = subject;
    }
    public void setSentence(String sentence){
        this.sentence = sentence;
    }
    public void setType(ActionType type){
        this.type = type;
    }
    public Action specify(String start) {
        startDetail = start;
        return this;
    }
    public Action specify(String start, String middle) {
        startDetail = start;
        midDetail = middle;
        return this;
    }
    public Action specify(String start, String middle, String end) {
        startDetail = start;
        midDetail = middle;
        endDetail = end;
        return this;
    }
    public Action connect(Connection connection) {
        this.connection = connection;
        return this;
    }
    public Action combine(Action action) {
        String secondActor;
        Action combined = new Action(subject,sentence,ActionType.COMBINED);
        if (subject.equals(action.getSubject())) {
            secondActor = action.getSubject().getCollapsedName();
        } else {
            secondActor = action.getSubject().getName();
        }

        combined.setSentence(String.format("%s%s, %s%s%s %s%s",sentence,endDetail,action.getConnection(),action.getStartDetail(),secondActor,action.getMidDetail(),action.getSentence()));
        combined.specify(startDetail,midDetail,action.getEndDetail());
        combined.connect(connection);
        if (collapsingSubject) {
            combined.collapseSubject();
        }
        return combined;
    }
    public Action collapseSubject() {
        collapsingSubject = true;
        return this;
    }
    @Override
    public String toString(){
        String actor;
        if (collapsingSubject) {
            actor = subject.getCollapsedName();
        } else {
            actor = subject.getName();
        }
        String beginning = connection+startDetail+actor+midDetail;
        return String.format("%s%s %s%s. ",Character.toString(beginning.charAt(0)).toUpperCase(),beginning.substring(1),sentence,endDetail);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        Action other = (Action)otherObject;
        return subject.equals(other.subject)&&Objects.equals(sentence,other.sentence)&&(type==other.type);
    }
    @Override
    public int hashCode() {
        return Objects.hash(subject,sentence,type);
    }
}
