import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { FormBuilder, FormGroup} from '@angular/forms';
import { CompanyModel } from './company.model';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  public compagnies: any;
  formValue !: FormGroup;
  companyModelObj : CompanyModel = new CompanyModel();

  constructor(private httpClient:HttpClient, private userservice : UserService, private formBuild : FormBuilder) { }

 ngOnInit(): void {
  this.onGetCompany()
  console.log(this.compagnies)
  this.formValue = this.formBuild.group({
    companyName : ['']
  })
 }
 onGetCompany() {
  this.userservice.getCompanies()
  .subscribe(data=>{
    this.compagnies=data;
  },err=>{
    console.log(err);
  });
}
OnDelectCompany(companyName:string){
  let conf = confirm("Etes vous sur ?")
  if (conf) {
    this.userservice.deleteCompanies(companyName)
  .subscribe(data=>{
    this.onGetCompany();
  },err=>{
    console.log(err);
  });
  }
}
 postCompany(){
   this.companyModelObj.companyName = this.formValue.value.companyName;

   this.userservice.getCompanies()
   .subscribe(res=>{
      console.log(res);
      alert("Compagnie ajoutee")
      let ref = document.getElementById('cancel')
      ref?.click();
      this.formValue.reset();
   },
   err=>{
     alert("Une erreur s'est produite")
   })
 }

}
