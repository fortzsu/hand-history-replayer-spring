import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-upload-form',
  templateUrl: './upload-form.component.html',
  styleUrl: './upload-form.component.css'
})
export class UploadFormComponent implements OnInit{

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/api/file/uploadFile';
  }

  ngOnInit(): void {
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
