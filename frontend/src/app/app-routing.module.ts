import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HandListComponent } from './hand-list/hand-list.component';

const routes: Routes = [
  { path: 'hands', component: HandListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
