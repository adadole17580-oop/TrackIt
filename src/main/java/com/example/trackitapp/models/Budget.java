package com.example.trackitapp.models;

import java.util.HashMap;
import java.util.Map;

public class Budget {
    private double amount;
    private String period;
    private Map<String, Double> categoryBudgets = new HashMap<>();

    public Budget() {}

    public Budget(double amount, String period) {
        this.amount = amount;
        this.period = period;
    }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getPeriod() { return period; }
    public void setPeriod(String period) { this.period = period; }

    public Map<String, Double> getCategoryBudgets() { return categoryBudgets; }
    public void setCategoryBudgets(Map<String, Double> categoryBudgets) {
        this.categoryBudgets = categoryBudgets;
    }
}
