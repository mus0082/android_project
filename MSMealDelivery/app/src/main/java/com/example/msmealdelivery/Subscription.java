package com.example.msmealdelivery;

public class Subscription {
    private String customerName;
    private boolean isYearlySubscription;
    private int deliveryPrice;

    public Subscription(String customerName, boolean isYearlySubscription, int deliveryPrice) {
        this.customerName = customerName;
        this.isYearlySubscription = isYearlySubscription;
        this.deliveryPrice = deliveryPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean isYearlySubscription() {
        return isYearlySubscription;
    }

    public void setYearlySubscription(boolean yearlySubscription) {
        isYearlySubscription = yearlySubscription;
    }

    public int getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(int deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public int calculateTotalCost() {
        int totalCost = 0;

        if (isYearlySubscription) {
            totalCost = calculateYearlyCost();
        } else {
            totalCost = calculateMonthlyCost();
        }

        return totalCost;
    }

    private int calculateMonthlyCost() {
        // Implement your monthly cost calculation logic here
        // Business rules for monthly cost calculation
        int monthlyCost = 0;  // Replace with your logic
        return monthlyCost;
    }

    private int calculateYearlyCost() {
        // Implement your yearly cost calculation logic here
        // Business rules for yearly cost calculation
        int yearlyCost = 0;  // Replace with your logic
        return yearlyCost;
    }
}
