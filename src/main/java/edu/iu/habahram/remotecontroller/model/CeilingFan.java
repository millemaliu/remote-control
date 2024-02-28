package edu.iu.habahram.remotecontroller.model;

public class CeilingFan {
    String location = "";
    String power = "off";


    public CeilingFan(String location) {
        this.location = location;
    }

    public String setHigh() {
        this.power = "High";
        return "Fan set to " + this.power;
    }

    public String setMedium() {
        this.power = "Medium";
        return "Fan set to " + this.power;
    }

    public String setLow() {
        this.power = "Low";
        return "Fan set to " + this.power;
    }

    public String off() {
        this.power = "off";
        return location + " fan is off";
    }
}
