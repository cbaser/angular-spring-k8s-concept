import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {NGXLogger} from "ngx-logger";
import {NotificationService} from "../../../core/services/notification.service";
import {Title} from "@angular/platform-browser";
import {UserRepository} from "../../../core/repository/UserRepository";
export interface User{
  id: string;
  firstName:string;
  lastName:string;
  email:string;
  birthday:string;
}


@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {
  userList: User[] = [];
  searchedUsers: User[] = [];
  displayedColumns: string[] = ['id', 'firstName', 'lastName', 'email','birthday'];
  dataSource = new MatTableDataSource<User>();

  constructor(
    private logger: NGXLogger,
    private notificationService: NotificationService,
    private titleService: Title,
    private userRepo: UserRepository
  ) {
  }
  onSearchUserName(input:string){
    this.userRepo.getUserByName(input).then(users=>{
      if(Array.isArray(users))
      users.map((user:User)=>{
        this.searchedUsers.push(user)
      })
      else this.searchedUsers.push(users);
    })
  }

  ngOnInit(): void {
    this.titleService.setTitle('Users');
    this.logger.log('User List loaded');
    this.notificationService.openSnackBar('User List loaded');
    this.userRepo.getUsers().then((list: Array<User>)=>{
      list.map((data: User) => {
        this.userList.push({birthday: data.birthday, email: data.email, firstName: data.firstName, lastName: data.lastName, id: data.id})
        this.dataSource = new MatTableDataSource<User>(this.userList)
      })
    })
  }

}
