import { Component, OnInit } from '@angular/core';
import { HandDataDto } from '../model/hand-data-dto';
import { HandService } from '../service/hand-service.service';

@Component({
  selector: 'app-hand-list',
  templateUrl: './hand-list.component.html'
 })
export class HandListComponent implements OnInit {

  users: HandDataDto[] = [];

  constructor(private handService: HandService) {
  }

  ngOnInit() {
    this.handService.findAll().subscribe((data:any) => {
      this.users = data;
    });
  }

  onSave() {
      this.handService.findAll().subscribe((data:any) => {
        this.users = data;
      });
  }
}
