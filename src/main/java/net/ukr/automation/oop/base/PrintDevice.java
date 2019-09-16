package net.ukr.automation.oop.base;

public interface PrintDevice {
    boolean isElectronic = true;
    String deviceInterface = "COM";

    String getDeviceType();
    void setAddress(String ipAddress);
    String getAddress();
    void printTestLine();
    String getDeviceInterface();
    boolean getIsElectronic();
}
