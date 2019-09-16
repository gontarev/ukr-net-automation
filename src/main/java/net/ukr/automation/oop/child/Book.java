package net.ukr.automation.oop.child;

import net.ukr.automation.oop.base.Edition;

public abstract class Book implements Edition {
    private int year;

    @Override
    public String getPublisherName() {
        return publisherName;
    }

    @Override
    public String getCarrierType() {
        return carrierType;
    }

    @Override
    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public void printYear() {
        System.out.println("Book year is " + year + ".");
    }
}
