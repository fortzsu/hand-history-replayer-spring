import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HandDataDto } from '../model/hand-data-dto';
import { Observable } from 'rxjs/';
import { HttpClientModule } from '@angular/common/http';


@Injectable()
export class HandService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/api/file/getData';
  }

  public findAll(): Observable<HandDataDto[]> {
    return this.http.get<HandDataDto[]>(this.usersUrl);
  }

}
