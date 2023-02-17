import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../interface/user';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private apiUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) {}

  public addUser(user: User): Observable<User> {
    return this.http.post<User>(`${this.apiUrl}/add-user`, user);
  }
  login(data: User) {
    return this.http.post<User>(`${this.apiUrl}/signin`, data);
  }
}
