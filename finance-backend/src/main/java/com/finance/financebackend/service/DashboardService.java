package com.finance.financebackend.service;
import com.finance.financebackend.entity.Record;
import com.finance.financebackend.repository.RecordRepository;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    private final RecordRepository repo;

    public DashboardService(RecordRepository repo) {
        this.repo = repo;
    }

    public Map<String, Object> getSummary() {

        List<Record> records = repo.findAll();


        double totalIncome = records.stream()
                .filter(r -> r.getType().equalsIgnoreCase("income"))
                .mapToDouble(Record::getAmount)
                .sum();


        double totalExpense = records.stream()
                .filter(r -> r.getType().equalsIgnoreCase("expense"))
                .mapToDouble(Record::getAmount)
                .sum();


        double balance = totalIncome - totalExpense;


        Map<String, Double> categoryTotals = records.stream()
                .collect(Collectors.groupingBy(
                        Record::getCategory,
                        Collectors.summingDouble(Record::getAmount)
                ));


        List<Record> recent = records.stream()
                .sorted(Comparator.comparing(Record::getDate).reversed())
                .limit(5)
                .toList();


        Map<String, Object> response = new HashMap<>();
        response.put("totalIncome", totalIncome);
        response.put("totalExpense", totalExpense);
        response.put("balance", balance);
        response.put("categoryTotals", categoryTotals);
        response.put("recentTransactions", recent);

        return response;
    }
}