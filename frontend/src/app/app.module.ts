import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { HandListComponent } from './hand-list/hand-list.component';
import { HandService } from './service/hand-service.service';

@NgModule({
  declarations: [
    AppComponent,
    HandListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [HandService],
  bootstrap: [AppComponent]
})
export class AppModule { }
