package com.app.mycalculator;


public class CalculatorCard {
    private String title;
    private int icon;

    public CalculatorCard(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public int getIcon() {
        return icon;
    }
}
