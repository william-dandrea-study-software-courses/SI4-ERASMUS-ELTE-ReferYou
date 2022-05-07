import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpHeaders, HttpRequest} from "@angular/common/http";
import {Code} from "../models/code.model";
import {BehaviorSubject, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  private HTTP_OPTIONS = {headers: new HttpHeaders({ 'Content-Type': 'application/json' })};

  public token: string | null = null;
  public token$: BehaviorSubject<string | null> = new BehaviorSubject<string | null>(null)


  constructor(private http: HttpClient, ) {


  }




  public login(email: string, password: string) {
    return new Observable(observer => {
      this.loginRequest(email, password).subscribe(
        data => {
          this.token = data.token;
          this.token$.next(this.token);
          observer.next(data.token)
        },
        error => {
          observer.error(error)
        })
    })
  }

  public register(email: string, password: string) {
    return new Observable(observer => {
      this.registerRequest(email, password).subscribe(
        data => {
          this.token = data.token;
          this.token$.next(this.token);
          observer.next(data.token)
        },
        error => {
          observer.error(error)
        })
    })
  }

  public verifyToken(token: string): Observable<boolean> {
    return new Observable(observer => {
      this.getTokenRequest(token).subscribe(
        data => {
          observer.next(data)
        },
        error => {
          observer.error(error)
        })
    })
  }


  public loginRequest(email: string, password: string): Observable<any> {
    return this.http.post(
        "http://localhost:8080/auth/login",
        JSON.stringify({
          mail: email,
          password: password
        }),
        this.HTTP_OPTIONS,
      )
  }

  public registerRequest(email: string, password: string): Observable<any> {
    return this.http.post(
        "http://localhost:8080/auth/register",
        JSON.stringify({
          mail: email,
          password: password
        }),{
          headers: new HttpHeaders({
          'Content-Type': 'application/json',
          'Access-Control-Allow-Origin': 'http://localhost/8080',
        })
      })
  }












  public getTokenRequest(token: string): Observable<any> {
    return this.http.post(
      "http://localhost:8080/auth/connected",
      JSON.stringify({
        token: token,
      }),
    );
  }







}
