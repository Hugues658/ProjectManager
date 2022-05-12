import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  public host : string = "http://localhost:8080";

  constructor(
    private http : HttpClient
  ) { }

  getUsers(){
    return this.http.get<any>(this.host + "/users/findUsers")
  }
  getCompanies(){
    return this.http.get(this.host + "/companies/findCompanies")
  }

  getTasks(){
    return this.http.get(this.host + "/tasks/findTasks")
  }

  getTaskLog(){
    return this.http.get(this.host + "/taskLogs/findTaskLogs")
  }

  getProjects(){
    return this.http.get(this.host + "/projects/findProjects")
  }

  getProjectsSize(){
    return this.http.get(this.host + "/projects/projectsSize")
  }

  getCompaniesSize(){
    return this.http.get(this.host + "/users/userSize")
  }

  getTasksSize(){
    return this.http.get(this.host + "/tasks/tasksSize")
  }

  getUsersSize(){
    return this.http.get(this.host + "/users/userSize")
  }

  deleteCompanies(companyName:string){
    return this.http.delete(this.host + "/companies/findCompanies")
  }
}
