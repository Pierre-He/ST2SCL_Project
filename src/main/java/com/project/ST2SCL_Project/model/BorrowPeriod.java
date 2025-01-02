package com.project.ST2SCL_Project.model;
import java.time.LocalDate;

public class BorrowPeriod {
    private LocalDate begin;
    private LocalDate end;

    public BorrowPeriod(LocalDate begin, LocalDate end) {
        this.begin = begin;
        this.end = end;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "BorrowPeriod{" +
                "begin=" + begin +
                ", end=" + end +
                '}';
    }
}