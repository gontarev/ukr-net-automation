package net.ukr.automation.oop.base;

public interface Cloth {
    String manufacturer = "УкрЕксТканина";

    String getManufacturerName();
    void printManufacturerName();
    void setFabricType(String fabricType);
    String getFabricType();
}
