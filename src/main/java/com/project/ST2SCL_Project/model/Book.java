package com.project.ST2SCL_Project.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private boolean borrowed;
    private List<BorrowPeriod> borrowPeriods = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public List<BorrowPeriod> getBorrowPeriods() {
        return borrowPeriods;
    }

    public void setBorrowPeriods(List<BorrowPeriod> borrowPeriods) {
        this.borrowPeriods = borrowPeriods;
    }

    public void addBorrowPeriod(BorrowPeriod borrowPeriod) {
        this.borrowPeriods.add(borrowPeriod);
    }
}