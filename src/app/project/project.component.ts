import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {

  public projects : any;
  formValue !: FormGroup;

  constructor(private httpClient:HttpClient, private userservice : UserService,private formBuild : FormBuilder) { }

  ngOnInit(): void {
    this.onGetProjects()
    console.log(this.projects);
  }
  
onGetProjects() {
  this.userservice.getProjects()
  .subscribe(data=>{
    this.projects=data;
  },err=>{
    console.log(err);
  })
}
}
