import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { Task } from 'src/app/shared/interface/task';
import { TaskService } from 'src/app/shared/services/task.service';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css'],
})
export class AddTaskComponent implements OnInit {
  now = new Date();
  formattedDate = `${this.now.getFullYear()}-${(this.now.getMonth() + 1)
    .toString()
    .padStart(2, '0')}-${this.now.getDate().toString().padStart(2, '0')}`;
  task!: Task[];
  formtask!: FormGroup;
  description!: string;
  date!: string;
  status!: string;
  constructor(
    public dialogRef: MatDialogRef<AddTaskComponent>,
    private fb: FormBuilder,
    private taskservices: TaskService,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.formtask = this.fb.group({
      description: ['', [Validators.required]],
      date: ['', [Validators.required]],
      status: ['Still in Progress', [Validators.required]],
      email: [localStorage.getItem('email'), [Validators.required]],
    });
  }
  public addtask(): void {
    let e = this.formtask.value;
    let eToSave: Task = {
      id: e.task_id,
      description: e.description,
      created_date: e.date,
      status: e.status,
      email: e.email,
    };
    this.taskservices.addTask(eToSave).subscribe(() => {
      this.toastr.success('Task ADDED succesful');
      this.closeDialog();
      window.location.reload();
    });
  }
  closeDialog() {
    this.dialogRef.close();
  }
}
