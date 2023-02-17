import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { User } from 'src/app/shared/interface/user';
import { TaskService } from 'src/app/shared/services/task.service';
import { AddTaskComponent } from '../add-task/add-task.component';
@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css'],
})
export class UserHomeComponent implements OnInit {
  constructor(public dialog: MatDialog, private taskservice: TaskService) {}
  id!: number;
  data!: User;
  user!: User[];
  task: any;
  ngOnInit(): void {
    this.getTasks();
  }
  openFormAdd() {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = false;
    dialogConfig.width = '40%';
    dialogConfig.height = '350px';
    dialogConfig.panelClass = 'add-task-modal';
    this.dialog.open(AddTaskComponent, dialogConfig);
  }
  public getTasks(): void {
    this.taskservice.GetTaskByEmail().subscribe((data: User) => {
      this.task = data.tasks;
    });
  }
  public DeleteTask(id: number) {
    this.taskservice.deleteTask(id).subscribe((data) => {
      this.getTasks();
    });
  }
}
