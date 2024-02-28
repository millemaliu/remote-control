package edu.iu.habahram.remotecontroller.model;

public class Stereo {
    String location = "";
    Integer volume = 100;
    Boolean dvd = false;
    Boolean radio = false;
    Boolean cd = false;


    public Stereo(String location) {
        this.location = location;
    }

    public String on() {
        return location + " stereo is on";
    }

    public String setDvd(boolean now) {
        this.dvd = now;
        return "Dvd? " + this.dvd;
    }

    public String setCd(boolean now) {
        this.cd = now;
        return "CD? " + this.cd;
    }

    public String setRadio(boolean now) {
        this.radio = now;
        return "Radio? " + this.radio;
    }

    public String setVolume(int new_vol) {
        this.volume = new_vol;
        return "Volume set to " + this.volume;
    }

    public String off() {
        return location + " stereo is off";
    }
}
