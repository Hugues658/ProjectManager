import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompanyComponent } from './company/company.component';
import { TaskComponent } from './task/task.component';
import { HttpClientModule} from '@angular/common/http';
import { LoginComponent } from './login/login.component'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProjectComponent } from './project/project.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import { TachesComponent } from './taches/taches.component';

@NgModule({
  declarations: [
    AppComponent,
    CompanyComponent,
    TaskComponent,
    LoginComponent,
    ProjectComponent,
    DashboardComponent,
    UtilisateurComponent,
    TachesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule, 
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
