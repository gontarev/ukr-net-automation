package net.ukr.automation.oop.base;

public interface Edition {
    String publisherName = "Publisher";
    String carrierType = "paper";

    String getPublisherName();
    String getCarrierType();
    void setYear(Integer year);
    void printYear();
}
