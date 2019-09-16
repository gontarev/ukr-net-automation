package net.ukr.automation.oop.child;

import net.ukr.automation.oop.base.Cloth;

public abstract class Clothes implements Cloth {
    private String clothingType;
    private String fabricType;

    public String getClothingType() {
        return clothingType;
    }

    public void setClothingType(String clothingType) {
        this.clothingType = clothingType;
    }

    public void printClothingType() {
        System.out.println("Clothing type is: " + clothingType + ".");
    }

    @Override
    public void setFabricType(String fabricType) {
        this.fabricType = fabricType;
    }

    @Override
    public String getFabricType() {
        return fabricType;
    }
}
