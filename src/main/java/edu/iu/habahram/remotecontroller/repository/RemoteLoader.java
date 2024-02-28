package edu.iu.habahram.remotecontroller.repository;

import edu.iu.habahram.remotecontroller.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RemoteLoader implements  IRemoteLoader{

    public static RemoteLoader uniqueInstance = new RemoteLoader();
    HashMap<Integer, RemoteControl> remoteControls = new HashMap<>();
    @Override
    public void setup(int id, List<DeviceData> devices) {
        RemoteControl remoteControl = new RemoteControl(devices.size());
        for(DeviceData device : devices) {
            switch (device.type()) {
                case "light":
                    Light light = new Light(device.location());
                    remoteControl.setCommand(device.slot(), light::on, light::off);
                    break;
                case "stereo":
                    Stereo stereo = new Stereo(device.location());
                    Command on = () -> {
                        String o = stereo.on();
                        stereo.setVolume(8);
                        stereo.setCd(true);
                        return o;
                    };
                    remoteControl.setCommand(device.slot(), on, stereo::off);
                case "fan":
                    CeilingFan fan = new CeilingFan(device.location());
                    remoteControl.setCommand(device.slot(), fan::setMedium, fan::off);
            }
        }
        remoteControls.put(id, remoteControl);
        System.out.println(remoteControl.toString());
    }
    
    private RemoteLoader() {}
    
    
    public static RemoteLoader getInstance() {
        return uniqueInstance;
    }

    @Override
    public String onButtonWasPushed(int id, int slot) {
         return remoteControls.get(id).onButtonWasPushed(slot);
    }

    @Override
    public String offButtonWasPushed(int id, int slot) {
        return remoteControls.get(id).offButtonWasPushed(slot);

    }
}
