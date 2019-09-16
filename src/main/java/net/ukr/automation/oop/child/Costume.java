package net.ukr.automation.oop.child;

public class Costume extends Clothes {
    @Override
    public String getManufacturerName() {
        return manufacturer;
    }

    @Override
    public void printManufacturerName() {
        System.out.println("Manufacturer name is: " + manufacturer + ".");
    }


}
