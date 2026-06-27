package com.pranay.expensetracker.controller;

import com.pranay.expensetracker.dto.ExpenseRequest;
import com.pranay.expensetracker.entity.Expense;
import com.pranay.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
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
    public Expense saveExpense(@Valid @RequestBody ExpenseRequest request) {

        Expense expense = new Expense();

        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setDescription(request.getDescription());
        expense.setExpenseDate(request.getExpenseDate());

        return service.saveExpense(expense);
    }
}