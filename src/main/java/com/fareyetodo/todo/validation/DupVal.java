//package com.fareyetodo.todo.validation;
//
//import com.fareyetodo.todo.model.ToDo;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//import static com.fareyetodo.todo.controller.ToDoController.tasks;
//
//public class DupVal implements ConstraintValidator<Duplicates, ToDo> {
//
//    @Override
//    public void initialize(Duplicates dup){
//    }
//
//    @Override
//    public boolean isValid(ToDo todo, ConstraintValidatorContext cxt) {
//        ToDo UserTodos = tasks.get(todo.getUserNumber());
//        int userId = todo.getUserNumber();
//        for(int i=0; i< tasks.size(); i++) {
//            if ((todo.getTitle().equals(tasks.get(i).getTitle())) && userId == tasks.get(i).getUserNumber()) {
//                return false;
//            }
//        }
//        return true;
//    }
//}