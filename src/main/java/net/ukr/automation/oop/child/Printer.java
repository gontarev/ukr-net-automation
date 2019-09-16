package net.ukr.automation.oop.child;

import net.ukr.automation.oop.base.PrintDevice;

public abstract class Printer implements PrintDevice {
    private String deviceType;
    private String printerType;
    private String firmwareVersion;
    private Integer cartridgeCount;
    private Integer operatingVoltage;

    @Override
    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getPrinterType() {
        return printerType;
    }

    public void setPrinterType(String printerType) {
        this.printerType = printerType;
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public Integer getCartridgeCount() {
        return cartridgeCount;
    }

    public void setCartridgeCount(Integer cartridgeCount) {
        this.cartridgeCount = cartridgeCount;
    }

    public Integer getOperatingVoltage() {
        return operatingVoltage;
    }

    public void setOperatingVoltage(Integer operatingVoltage) {
        this.operatingVoltage = operatingVoltage;
    }

    @Override
    public void printTestLine() {
        System.out.println("This is the test line");
    }

}
