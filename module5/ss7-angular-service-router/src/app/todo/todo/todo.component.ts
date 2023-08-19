import {Component, OnDestroy, OnInit} from '@angular/core';
import {ITodo} from '../model/itodo';
import {TodoService} from '../service/todo.service';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todoList: ITodo[];
  todoForm: FormGroup;
  constructor(private todoService: TodoService
              ) { }

  ngOnInit(): void {
    this.todoService.getTodos().subscribe(
      next => {this.todoList = next; },
      error => {console.log(error); },
      () => {console.log('complete'); }
    );
    this.todoForm = new FormGroup(
      {
        title: new FormControl('')
      }
    );
  }
  toggleTodo(i) {
    const todo = this.todoList[i];
    const todoToUpdate = {
      ...todo,
      completed: !todo.completed
    };
    this.todoService.updateTodo(todoToUpdate).subscribe(next => this.todoList[i].completed = next.completed);
  }
  deleteTodo(i) {
    const todoToDelete = this.todoList[i];
    this.todoService.deleteTodo(todoToDelete.id).subscribe(
      () => {
        this.todoList = this.todoList.filter(
          remainTodo => remainTodo.id !== todoToDelete.id
        );
      }
    );
  }
  addTodo() {
    const todoToAdd: Partial<ITodo> = {
      title: this.todoForm.get('title').value,
      completed: false
    };
    console.log(todoToAdd);
    this.todoService.newTodo(todoToAdd).subscribe(
      next => {
        this.todoList.unshift(next);
        this.todoForm.setValue({
          title: ''
        });
      }
    );
  }
}
