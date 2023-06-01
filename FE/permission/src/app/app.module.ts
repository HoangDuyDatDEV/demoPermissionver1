import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FunctionComponent } from './function/function.component';
import { FormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { MatDialogModule  } from '@angular/material/dialog';
import { RoleComponent } from './role/role.component'
import { HeadersInterceptor } from './headers.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    FunctionComponent,
    RoleComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatDialogModule,
  ],
  providers: [ {provide:HTTP_INTERCEPTORS,useClass:HeadersInterceptor,
    multi: true}],
  bootstrap: [AppComponent],
  exports: [LoginComponent,FunctionComponent]
})

export class AppModule { }
