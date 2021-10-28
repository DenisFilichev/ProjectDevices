/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdevices;
import interfaces.Device;
import interfaces.Ethernet;
import interfaces.Vga;
import annotations.TypeVga;

@TypeVga(type=TypeVga.Transmitter)
public class Pc extends Device implements Ethernet, Vga{
    
    private int speed;
    private Vga connectDeviceVga;
    private Ethernet connectDeviceEthernet;

    public Pc(String serial, int power, int speed){
        super(serial, power);
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String ping() {
        return status ? "OK" : "NO";
    }
    
    @Override
    public void connectDeviceToVga(Vga connectDeviceVga) {
            this.connectDeviceVga = connectDeviceVga;
    }
    
    @Override
    public void connectDeviceToEthernet (Ethernet connectDeviceEthernet){
        this.connectDeviceEthernet = connectDeviceEthernet;
    }

    @Override
    public String toString() {
        return "Computer{" + 
                        "status=" + (status ? "ON" : "OFF") + 
                        ", s/n:" + getSerial() + 
                        ", speed=" + speed + 
                        ", power=" + getPower() + '}';
    }
}
