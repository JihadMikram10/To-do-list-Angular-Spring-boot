import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserRoutingModule } from './user-routing.module';
import { SiderBarUserComponent } from '../sider-bar-user/sider-bar-user.component';
import { FormsModule } from '@angular/forms';
import { UserHomeComponent } from '../user-home/user-home.component';
import { RouterModule } from '@angular/router';
import { UserComponent } from './user.component';
import { AddTaskComponent } from '../add-task/add-task.component';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    SiderBarUserComponent,
    UserComponent,
    UserHomeComponent,
    AddTaskComponent,
  ],
  imports: [
    BrowserModule,
    CommonModule,
    UserRoutingModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
  ],
})
export class UserModule {}
