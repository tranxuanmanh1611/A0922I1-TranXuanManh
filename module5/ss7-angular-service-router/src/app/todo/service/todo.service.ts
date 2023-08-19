import {Injectable, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ITodo} from '../model/itodo';
import {count, map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private readonly API_URL = 'https://jsonplaceholder.typicode.com/todos';
  constructor(private httpService: HttpClient) { }
  getTodos(numberOfTodo = 10) {
    return this.httpService.get<ITodo[]>(this.API_URL).pipe(
      map(data => data.filter((todo, index) => index < numberOfTodo))
    );
  }
  updateTodo(todo: ITodo) {
    return this.httpService.patch<ITodo>(`${this.API_URL}/${todo.id}`, todo);
  }
  deleteTodo(todoId: number) {
   return this.httpService.delete<ITodo>(`${this.API_URL}/${todoId}`);
  }
  newTodo(todoToAdd: Partial<ITodo>) {
    return this.httpService.post<ITodo>(this.API_URL, todoToAdd);
  }
}
