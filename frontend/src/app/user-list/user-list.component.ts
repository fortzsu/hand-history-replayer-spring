import { Component, OnInit } from '@angular/core';
import { HandDataDto } from '../model/hand-data-dto';
import { UserService } from '../service/user-service.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: HandDataDto[] = [];

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.userService.findAll().subscribe((data:any) => {
      this.users = data;
    });
  }

  onSave() {
      this.userService.findAll().subscribe((data:any) => {
        this.users = data;
      });
  }
}
