import { Component, OnInit } from '@angular/core';
import {Todo} from "../Todo";

import {FormControl,FormGroup, Validators} from "@angular/forms";

let _id = 1;
@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todos: Todo[] = [];
  content = new FormControl();
  constructor() { }

  ngOnInit(): void {
    this.todos.push({id:1,content:"Mua rau",complete:false});
    this.todos.push({id:2,content:"Mua thit",complete:true});
    _id=2;
  }

  change(){
    _id++;
    this.todos.push({})
  }
  changeComplete(i: number){
    this.todos[i].complete = !this.todos[i].complete;
  }
  newTodo(){
   let value = this.content.value;
   if (value){
     this.todos.push(
       {
         id: ++_id,
         content:value,
         complete:false
       }
     );
     this.content.reset();
   }
  }
}
