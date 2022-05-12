import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-utilisateur',
  templateUrl: './utilisateur.component.html',
  styleUrls: ['./utilisateur.component.css']
})
export class UtilisateurComponent implements OnInit {
  public users: any;

  constructor(private userservice : UserService) { }

  ngOnInit(): void {
    this.onGetUser()
    console.log(this.users);
    
  }

  onGetUser() {
    this.userservice.getUsers()
    .subscribe(data=>{
      this.users=data;
    },err=>{
      console.log(err);
    })
  }

}
