package com.fareyetodo.todo.model;

import com.fareyetodo.todo.validation.Duplicates;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @Duplicates
public class ToDo {
    private LocalDate createdDate, modifiedDate;
    private String body, title, dueDate;
    private Boolean status;
    private int id;
    private int userNumber;

    public LocalDate getCreatedDate() {
        return LocalDate.now();
    }

    public LocalDate getModifiedDate() {
        return LocalDate.now();
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

}
