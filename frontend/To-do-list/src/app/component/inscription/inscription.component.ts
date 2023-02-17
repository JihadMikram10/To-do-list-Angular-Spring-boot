import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { User } from 'src/app/shared/interface/user';
import { UserService } from 'src/app/shared/services/user.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
  animations: [],
})
export class InscriptionComponent implements OnInit {
  public user!: User[];
  formUser!: FormGroup;
  username!: string;
  email!: string;
  password!: string;
  constructor(
    private userService: UserService,
    private fb: FormBuilder,
    private router: Router,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.formUser = this.fb.group({
      id: ['', []],
      username: ['', [Validators.required, Validators.minLength(6)]],
      email: ['', [Validators.required, Validators.email]],
      password: [
        '',
        [
          Validators.required,
          Validators.minLength(6),
          Validators.pattern('^[A-Z][a-zA-Z0-9]*'),
        ],
      ],
    });
  }

  public addUser(): void {
    let e = this.formUser.value;
    let eToSave: User = {
      username: e.username,
      email: e.email,
      password: e.password,
      tasks: e.task,
    };
    this.userService.addUser(eToSave).subscribe(
      () => {},
      (err: HttpErrorResponse) => {
        if (err.status === 200) {
          this.toastr.success('Register passed succesful');
          this.formUser.reset();
          setTimeout(() => {
            this.router.navigate(['/connexion']);
          }, 1300);
        } else if (err.status === 409) {
          this.toastr.error(err.error);
        }
      }
    );
  }
}
