import { Task } from './task';

export interface User {
  username: string;
  email: string;
  password: string;
  tasks: Task[];
}
