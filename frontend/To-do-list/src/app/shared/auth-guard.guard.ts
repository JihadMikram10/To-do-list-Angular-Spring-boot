import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { Observable } from 'rxjs';
import { TokenStorageService } from './services/token-storage.service';

@Injectable({
  providedIn: 'root',
})
export class AuthGuardGuard implements CanActivate {
  constructor(private token: TokenStorageService, private router: Router) {}
  canActivate() {
    if (this.token.isLogggedIn()) {
      return true;
    } else {
      this.router.navigate(['/connexion']);
      return false;
    }
  }
}
