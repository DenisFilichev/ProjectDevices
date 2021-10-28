/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdevices;

import interfaces.Device;
import interfaces.Vga;
import annotations.TypeVga;

@TypeVga(type = TypeVga.Receiver)
public class Projector extends Device implements Vga{
    
    private Vga connectDeviceVga;

    public Projector (String serial, int power){
        super(serial, power);
    }
    
    @Override
    public void connectDeviceToVga(Vga connectDeviceVga) {
            this.connectDeviceVga = connectDeviceVga;
    }

    @Override
    public String toString() {
        return "Projector{" + "serial=" + getSerial() + ", power=" + getPower() + '}';
    }
}
