import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardGuard } from 'src/app/shared/auth-guard.guard';
import { AddTaskComponent } from '../add-task/add-task.component';
import { UserHomeComponent } from '../user-home/user-home.component';
import { UserComponent } from './user.component';

const routes: Routes = [
  {
    path: 'user',
    component: UserComponent,
    children: [
      { path: 'home', component: UserHomeComponent },
      { path: 'add-task', component: AddTaskComponent },
    ],
    canActivate: [AuthGuardGuard],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class UserRoutingModule {}
