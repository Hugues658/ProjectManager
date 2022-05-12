import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  public tasks: any;
  formValue !: FormGroup;

  constructor(private httpClient:HttpClient, private userservice : UserService,private formBuild : FormBuilder) { }

  ngOnInit(): void {
    this.onGetTask()
    console.log(this.tasks);
    
  }

  onGetTask() {
    this.userservice.getTasks()
    .subscribe(data=>{
      this.tasks=data;
    },err=>{
      console.log(err);
    })
  }
  

}
