import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Task } from '../interface/task';
import { User } from '../interface/user';

@Injectable({
  providedIn: 'root',
})
export class TaskService {
  private apiUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) {}

  public addTask(task: Task): Observable<Task> {
    let email = localStorage.getItem('email');

    return this.http.post<Task>(`${this.apiUrl}/${email}/add-task`, task);
  }
  public GetTaskByEmail(): Observable<User> {
    let email = localStorage.getItem('email');
    return this.http.get<User>(`${this.apiUrl}/user/${email}`);
  }
  public deleteTask(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }
}
