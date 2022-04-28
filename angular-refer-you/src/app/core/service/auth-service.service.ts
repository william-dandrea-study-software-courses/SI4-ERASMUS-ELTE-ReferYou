import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  private HTTP_OPTIONS = {headers: new HttpHeaders({ 'Content-Type': 'application/json' })};


  constructor(private http: HttpClient) {

  }


}
