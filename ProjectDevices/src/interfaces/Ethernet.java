/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author denis
 */
public interface Ethernet {
    
    public String ping ();
    public void connectDeviceToEthernet (Ethernet connectDeviceEthernet);
}
