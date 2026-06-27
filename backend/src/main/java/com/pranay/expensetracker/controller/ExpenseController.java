package com.pranay.expensetracker.controller;

import com.pranay.expensetracker.entity.Expense;
import com.pranay.expensetracker.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return service.getAllExpenses();
    }

    @PostMapping
    public Expense saveExpense(@RequestBody Expense expense) {
        return service.saveExpense(expense);
    }
}