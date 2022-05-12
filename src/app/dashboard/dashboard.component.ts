import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  public taskLogs : any;
  public projectsSize : any;
  public companiesSize : any;
  public tasksSize : any;
  public usersSize : any;
  formValue !: FormGroup;
  constructor(private userservice : UserService,private formBuild : FormBuilder) { }

  ngOnInit(): void {
    this.onGetTaskLog()
    this.onGetProjectSize()
    this.onGetCompaniesSize()
    this.onGetTasksSize()
    this.onGetUsersSize()
    console.log(this.taskLogs);
  }
  onGetTaskLog() {
    this.userservice.getTaskLog()
    .subscribe(data=>{
      this.taskLogs=data;
    },err=>{
      console.log(err);
    })

  };
  onGetProjectSize(){
    this.userservice.getProjectsSize()
    .subscribe(data=>{
      this.projectsSize=data;
    },err=>{
      console.log(err);
    })
  };
  onGetCompaniesSize(){
    this.userservice.getCompaniesSize()
    .subscribe(data=>{
      this.companiesSize=data;
    },err=>{
      console.log(err);
    })
  };
  onGetTasksSize(){
    this.userservice.getTasksSize()
    .subscribe(data=>{
      this.tasksSize=data;
    },err=>{
      console.log(err);
    })
  };
  onGetUsersSize(){
    this.userservice.getUsersSize()
    .subscribe(data=>{
      this.usersSize=data;
    },err=>{
      console.log(err);
    })
  };
}
