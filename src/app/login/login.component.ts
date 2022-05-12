import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup} from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loginForm! : FormGroup

  constructor( private userservice : UserService,private formBuilder : FormBuilder, private http : HttpClient, private router : Router) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email:[''],
      password:['']
    })
  }
  login(){
    this.userservice.getUsers()
    .subscribe(res=>{
      const user = res.find((a:any)=>{
        return a.email == this.loginForm.value.email && a.password == this.loginForm.value.password
      });
      if(user){
        // alert("Login reussi");
        this.loginForm.reset();
        this.router.navigate(['dashboard'])
      }else{
        alert("Utilisateur non trouve");
      }
    },err=>{
      alert("Une erreur s'est produite!")
    })
  }

}
