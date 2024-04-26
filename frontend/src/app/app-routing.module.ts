import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { UploadFormComponent } from './upload-form/upload-form.component';

const routes: Routes = [
  { path: 'hands', component: UserListComponent },
  { path: 'upload', component: UploadFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
