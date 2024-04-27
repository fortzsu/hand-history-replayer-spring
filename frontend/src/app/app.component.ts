import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

    title: string;
    private usersUrl: string;

    constructor(private http: HttpClient) {
      this.usersUrl = 'http://localhost:8080/api/file/uploadFile';
      this.title = 'Hand History Replayer';
    }

    onChangeFile(event:any) {
      if (event.target.files.length > 0 ) {
        const file = event.target.files[0];
        const formData = new FormData();
        formData.append('file', file);
        this.http.post(this.usersUrl, formData).subscribe();
      }
    }
}
