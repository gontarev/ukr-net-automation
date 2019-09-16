package net.ukr.automation;

import net.ukr.automation.oop.child.Costume;
import net.ukr.automation.oop.child.LaserPrinter;
import net.ukr.automation.oop.child.ReferenceBookAndEncyclopedia;

public class OopUsage {
    public static void main(String[] args) {
        // working with ReferenceBookAndEncyclopedia object
        ReferenceBookAndEncyclopedia book = new ReferenceBookAndEncyclopedia();

        book.setBookName("Birds");
        book.printBookName();
        System.out.println("Carrier type is: " + book.getCarrierType() + ".");
        book.setYear(2012);
        book.printYear();
        System.out.println("\n");

        // working with Costume object
        Costume costume = new Costume();

        costume.printManufacturerName();
        costume.setFabricType("cotton");
        System.out.println("Fabric type is: " + costume.getFabricType() + ".");
        costume.setClothingType("costume");
        costume.printClothingType();
        System.out.println("\n");

        // working with LaserPrinter object
        LaserPrinter laserPrinter = new LaserPrinter();

        if (laserPrinter.getIsElectronic()) System.out.println("Device is electronic.");
        laserPrinter.setDeviceType("printer");
        System.out.println("Device type is: " + laserPrinter.getDeviceType() + ".");
        laserPrinter.setPrinterType("laser printer");
        System.out.println("Printer type is: " + laserPrinter.getPrinterType() + ".");
        laserPrinter.setFirmwareVersion("0.0.97");
        System.out.println("Printer firmware version is: " + laserPrinter.getFirmwareVersion() + ".");
        laserPrinter.printTestLine();
        laserPrinter.setAddress("192.168.0.5");
        System.out.println("Printer IP address is: " + laserPrinter.getAddress() + ".");
        laserPrinter.setCartridgeCount(10);
        System.out.println("Printer cartridge count is: " + laserPrinter.getCartridgeCount() + ".");
    }
}
