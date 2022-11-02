package com.fareyetodo.todo.model;

import com.fareyetodo.todo.validation.Duplicates;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter @Setter @NoArgsConstructor @Duplicates
@Entity
@Table(name = "todo")
public class ToDo {
//    private LocalDate createdDate, modifiedDate;
    private String body;

    private String title;
    //    private String dueDate;
//    private Boolean status;
    @Id
    private int id;
    private int userNumber;



    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public LocalDate getCreatedDate() {
//        return LocalDate.now();
//    }

//    public LocalDate getModifiedDate() {
//        return LocalDate.now();
//    }

//    public void setCreatedDate(LocalDate createdDate) {
//        this.createdDate = createdDate;
//    }

}
