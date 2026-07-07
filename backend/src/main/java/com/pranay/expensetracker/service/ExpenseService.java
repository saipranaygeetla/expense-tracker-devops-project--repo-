package com.pranay.expensetracker.service;

import com.pranay.expensetracker.entity.Expense;
import com.pranay.expensetracker.repository.ExpenseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private static final Logger logger =
            LoggerFactory.getLogger(ExpenseService.class);

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public List<Expense> getAllExpenses() {

        logger.info("Fetching expenses from database");

        return repository.findAll();
    }

    public Expense saveExpense(Expense expense) {

        logger.info("Saving expense {}", expense.getTitle());

        Expense savedExpense = repository.save(expense);

        logger.info("Expense saved with id {}", savedExpense.getId());

        return savedExpense;
    }

}