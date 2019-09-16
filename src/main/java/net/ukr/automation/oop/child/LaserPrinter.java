package net.ukr.automation.oop.child;

public class LaserPrinter extends Printer {
    private String ipAddress;

    @Override
    public void setAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String getAddress() {
        return ipAddress;
    }

    @Override
    public String getDeviceInterface() {
        return deviceInterface;
    }

    @Override
    public boolean getIsElectronic() {
        return isElectronic;
    }
}
