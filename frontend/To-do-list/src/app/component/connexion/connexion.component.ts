import { HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { User } from 'src/app/shared/interface/user';
import { TokenStorageService } from 'src/app/shared/services/token-storage.service';
import { UserService } from 'src/app/shared/services/user.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css'],
})
export class ConnexionComponent implements OnInit {
  public user!: User[];
  formUser: any;
  email!: string;
  password!: string;
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  constructor(
    private userService: UserService,
    private fb: FormBuilder,
    private router: Router,
    private toastr: ToastrService,
    private tokenservice: TokenStorageService
  ) {}

  ngOnInit(): void {
    this.formUser = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
    });
  }
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };
  connexion(): void {
    this.userService
      .login(this.formUser.value)

      .subscribe(
        (data: any) => {
          localStorage.setItem('email', this.formUser.value.email);
          this.toastr.success(data['message']);
          this.tokenservice.setToken(data['token']);
          this.router.navigate(['/user/home']);
        },
        (err: HttpErrorResponse) => {
          if (err.status === 409) {
            this.toastr.error(err.error.message);
          }
        }
      );
  }
}
