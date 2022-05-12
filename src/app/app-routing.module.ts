import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompanyComponent } from './company/company.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { ProjectComponent } from './project/project.component';
import { TachesComponent } from './taches/taches.component';
import { TaskComponent } from './task/task.component';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';


const routes: Routes = [
  {path:'', redirectTo:'login', pathMatch:'full'},
  {path:'company',component:CompanyComponent },
  {path:'task',component:TaskComponent},
  {path:'login',component:LoginComponent},
  {path:'project',component:ProjectComponent},
  {path:'dashboard',component:DashboardComponent},
  {path:'utilisateur',component:UtilisateurComponent},
  {path:'taches',component:TachesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
