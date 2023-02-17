import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/shared/interface/user';
import { TaskService } from 'src/app/shared/services/task.service';

@Component({
  selector: 'app-sider-bar-user',
  templateUrl: './sider-bar-user.component.html',
  styleUrls: ['./sider-bar-user.component.css'],
})
export class SiderBarUserComponent implements OnInit {
  userName!: string;
  constructor(private router: Router, private taskservice: TaskService) {}
  data!: User;
  user!: User[];
  ngOnInit(): void {
    this.getTasks();
  }

  signOut(): void {
    window.localStorage.clear();
    this.router.navigate(['/connexion']);
  }
  public getTasks(): void {
    this.taskservice.GetTaskByEmail().subscribe((data: User) => {
      this.userName = data.username;
    });
  }
}
