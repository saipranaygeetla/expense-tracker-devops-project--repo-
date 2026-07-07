package com.pranay.expensetracker.controller;

import com.pranay.expensetracker.dto.ExpenseRequest;
import com.pranay.expensetracker.entity.Expense;
import com.pranay.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private static final Logger logger =
            LoggerFactory.getLogger(ExpenseController.class);

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Expense> getAllExpenses() {

        logger.info("Fetching all expenses");

        return service.getAllExpenses();
    }

    @PostMapping
    public Expense saveExpense(@Valid @RequestBody ExpenseRequest request) {

        logger.info("Received request to save expense: {}", request.getTitle());

        Expense expense = new Expense();

        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setDescription(request.getDescription());
        expense.setExpenseDate(request.getExpenseDate());

        return service.saveExpense(expense);
    }

}