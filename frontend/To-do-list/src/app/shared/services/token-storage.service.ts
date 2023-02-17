import { Injectable } from '@angular/core';
import { User } from '../interface/user';

@Injectable({
  providedIn: 'root',
})
export class TokenStorageService {
  constructor() {}
  setToken(token: string) {
    localStorage.setItem('token', token);
  }
  signOut(): void {
    window.localStorage.clear();
  }
  isLogggedIn() {
    return localStorage.getItem('token');
  }
}
