/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdevices;

import annotations.TypeVga;
import interfaces.Device;
import interfaces.Ethernet;
import interfaces.Vga;

/**
 *
 * @author denis
 */
public class Main {

public static void main(String[] args) {
        Device[] devices = new Device[3];
        devices[0] = new Pc("pc001", 600, 100);
        devices[0].turnOn();
        devices[1] = new Pc("pc002", 350, 100);
        devices[2] = new Projector("pj001", 300);
        
        for (Device device : devices){
            System.out.println(device.toString());
            if (device instanceof Ethernet){
                System.out.println("Ping = " + ((Ethernet) device).ping());
            }
        }
        
        
        /*
            Проверка совместимости устройств по интерфейсу
            и дополнительному свойству, заданному аннотацией, т.е.
            при условии, что устройства реализуют интерфейс VGA,
            устройство со свойством transmitter может быть подключено
            к устройству со свойством receiver
        */
        if (devices[0] instanceof Vga && devices[2] instanceof Vga){
            Vga dev1 = (Vga)devices[0];
            Vga dev2 = (Vga)devices[2];
            if (dev1.getClass().isAnnotationPresent(TypeVga.class)){ // Проверяем аннотиирован ли класс dev1 классом TypeVga.class, которые является классом аннотацией.
                TypeVga typeVga = dev1.getClass().getAnnotation(TypeVga.class); //Создаем переменную, ссылающуюся на аннотацию
                String typeDev1 = typeVga.type(); // Создаем строковую переменную, ссылающуюся на строковое значение аннотации, заданное нами в определении объекта dev1
                if (dev2.getClass().isAnnotationPresent(TypeVga.class)){// Проверяем аннотиирован ли класс dev2 классом TypeVga.class, которые является классом аннотацией.
                    typeVga = dev2.getClass().getAnnotation(TypeVga.class);//Создаем переменную, ссылающуюся на аннотацию
                    String typeDev2 = typeVga.type();// Создаем строковую переменную, ссылающуюся на строковое значение аннотации, заданное нами в определении объекта dev2
                    if((typeDev1.equals(TypeVga.Receiver) && typeDev2.equals(TypeVga.Transmitter)) || //Проверяем имеет ли первый объект свойство transmitter, второй reseiver
                    (typeDev1.equals(TypeVga.Transmitter) && typeDev2.equals(TypeVga.Receiver))){//Проверяем имеет ли первый объект свойство reseiver, второй transmitter
                        dev1.connectDeviceToVga(dev2);
                        dev2.connectDeviceToVga(dev1);
                        System.out.println("PC и Projector подключены по интерфейсу VGA");
                    } else System.out.println("Устройства несовместимы по интерфейсу VGA");
            }
            }
        }
    }
    
}
