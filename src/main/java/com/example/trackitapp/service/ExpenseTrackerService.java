package com.example.trackitapp.service;

import com.example.trackitapp.models.Budget;
import com.example.trackitapp.models.Expense;
import com.example.trackitapp.models.User;

import java.text.NumberFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;

public class ExpenseTrackerService {
    private final List<Expense> expenses = new ArrayList<>();
    private Budget budget;
    private User currentUser;
    private boolean isAuthenticated = false;

    public void addExpense(String dateIso, String category, String notes, double amount) {
        Expense e = new Expense();
        e.setId(String.valueOf(System.currentTimeMillis()));
        e.setDate(LocalDate.parse(dateIso));
        e.setCategory(category == null ? "Other" : category);
        e.setDescription((notes == null || notes.isEmpty()) ? e.getCategory() + " expense" : notes);
        e.setAmount(amount);
        expenses.add(0, e);
    }

    public void editExpense(String id, String dateIso, String category, String notes, double amount) {
        if (id == null) return;
        for (int i = 0; i < expenses.size(); i++) {
            Expense ex = expenses.get(i);
            if (id.equals(ex.getId())) {
                ex.setDate(LocalDate.parse(dateIso));
                ex.setCategory(category);
                ex.setDescription((notes == null || notes.isEmpty()) ? category + " expense" : notes);
                ex.setAmount(amount);
                expenses.set(i, ex);
                return;
            }
        }
    }

    public void deleteExpense(String id) {
        if (id == null) return;
        expenses.removeIf(e -> e.getId().equals(id));
    }

    public List<Expense> getExpenses() {
        return new ArrayList<>(expenses);
    }

    public List<Expense> filterExpenses(String searchTerm, String categoryFilter, String timeFilter) {
        LocalDate today = LocalDate.now();
        return expenses.stream().filter(expense -> {
            boolean matchesSearch = (searchTerm == null || searchTerm.isEmpty()) ||
                    expense.getDescription().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    expense.getCategory().toLowerCase().contains(searchTerm.toLowerCase());

            boolean matchesCategory = (categoryFilter == null || "all".equalsIgnoreCase(categoryFilter))
                    || expense.getCategory().equalsIgnoreCase(categoryFilter);

            boolean matchesTime = true;
            if (timeFilter != null && !"all".equalsIgnoreCase(timeFilter)) {
                LocalDate d = expense.getDate();
                switch (timeFilter.toLowerCase()) {
                    case "today":
                        matchesTime = d.equals(today);
                        break;
                    case "week":
                        matchesTime = !d.isBefore(today.minusDays(7));
                        break;
                    case "month":
                        matchesTime = d.getMonth() == today.getMonth() && d.getYear() == today.getYear();
                        break;
                    default:
                        matchesTime = true;
                }
            }
            return matchesSearch && matchesCategory && matchesTime;
        }).collect(Collectors.toList());
    }

    public List<String> getUniqueCategories() {
        return expenses.stream().map(Expense::getCategory).distinct().collect(Collectors.toList());
    }

    // Current month
    public List<Expense> getCurrentMonthExpenses() {
        LocalDate t = LocalDate.now();
        return expenses.stream()
                .filter(e -> e.getDate().getMonth() == t.getMonth() && e.getDate().getYear() == t.getYear())
                .collect(Collectors.toList());
    }

    public double calculateTotalSpent(List<Expense> list) {
        return list.stream().mapToDouble(Expense::getAmount).sum();
    }

    public double calculateBudgetPercentage(double totalSpent, double budgetAmount) {
        if (budgetAmount > 0) return (totalSpent / budgetAmount) * 100.0;
        return 0.0;
    }

    public double calculateRemainingBudget(double budgetAmount, double totalSpent) {
        return budgetAmount - totalSpent;
    }

    public double calculateWeeklyTotal() {
        LocalDate now = LocalDate.now();
        LocalDate weekStart = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        return expenses.stream().filter(e -> !e.getDate().isBefore(weekStart)).mapToDouble(Expense::getAmount).sum();
    }

    public double calculateYesterdayTotal() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        return expenses.stream().filter(e -> e.getDate().equals(yesterday)).mapToDouble(Expense::getAmount).sum();
    }

    public Map<String, Double> calculateCategoryTotals(List<Expense> list) {
        Map<String, Double> map = new HashMap<>();
        for (Expense e : list) {
            map.put(e.getCategory(), map.getOrDefault(e.getCategory(), 0.0) + e.getAmount());
        }
        return map;
    }

    public List<Map.Entry<String, Double>> getTopCategories(List<Expense> list, int limit) {
        return calculateCategoryTotals(list).entrySet().stream()
                .sorted((a,b) -> Double.compare(b.getValue(), a.getValue()))
                .limit(limit).collect(Collectors.toList());
    }

    public List<Map.Entry<LocalDate, Double>> getTopSpendingDays(List<Expense> list, int limit) {
        Map<LocalDate, Double> daily = new HashMap<>();
        for (Expense e : list) {
            daily.put(e.getDate(), daily.getOrDefault(e.getDate(), 0.0) + e.getAmount());
        }
        return daily.entrySet().stream()
                .sorted((a,b) -> Double.compare(b.getValue(), a.getValue()))
                .limit(limit)
                .map(e -> new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public double calculateAverageDailySpending(List<Expense> list, LocalDate start, LocalDate end) {
        if (list == null || list.isEmpty()) return 0.0;
        double total = calculateTotalSpent(list);
        long days = java.time.temporal.ChronoUnit.DAYS.between(start, end);
        if (days <= 0) days = 1;
        return total / days;
    }

    public List<Expense> filterExpensesByPeriod(String period) {
        LocalDate now = LocalDate.now();
        LocalDate start;
        switch (period) {
            case "1month": start = now.withDayOfMonth(1); break;
            case "3months": start = now.minusMonths(2).withDayOfMonth(1); break;
            case "6months": start = now.minusMonths(5).withDayOfMonth(1); break;
            case "1year": start = now.minusYears(1).withDayOfMonth(1); break;
            default: start = now.minusMonths(5).withDayOfMonth(1);
        }
        final LocalDate filterDate = start;
        return expenses.stream().filter(e -> !e.getDate().isBefore(filterDate)).collect(Collectors.toList());
    }

    public User signUp(String name, String email, String password) {
        User u = new User(name, email);
        this.currentUser = u;
        this.isAuthenticated = true;
        return u;
    }

    public User login(String email, String password) {
        String[] parts = email != null ? email.split("@") : new String[]{email};
        String uname = parts.length > 0 ? parts[0] : "User";
        uname = uname.length() > 0 ? uname.substring(0,1).toUpperCase() + (uname.length()>1?uname.substring(1):"") : uname;
        User u = new User(uname, email);
        this.currentUser = u;
        this.isAuthenticated = true;
        return u;
    }

    public void logout() {
        this.currentUser = null;
        this.isAuthenticated = false;
    }

    public User getCurrentUser() { return currentUser; }
    public boolean isAuthenticated() { return isAuthenticated; }
    public void setBudget(Budget b) { this.budget = b; }
    public Budget getBudget() { return budget; }

    public String formatCurrency(double amount) {
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        return "₱" + nf.format(amount);
    }

    public String formatDate(LocalDate date) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMM d, yyyy");
        return date.format(f);
    }
}
