import { Component } from '@angular/core';
import { HandDataDto } from '../model/hand-data-dto';
import { HandService } from '../service/hand-service.service';

@Component({
  selector: 'app-hand-list',
  templateUrl: './hand-list.component.html'
 })
export class HandListComponent {

  users: HandDataDto[] = [];

  constructor(private handService: HandService) {
      this.onSave();
  }

  onSave() {
      this.handService.findAll().subscribe((data:any) => {
        this.users = data;
      });
  }
}
