import { Injectable } from '@angular/core';
import {Code} from "../models/code.model";
import {BehaviorSubject, Observable} from "rxjs";
import {Website} from "../models/website.model";
import {CODES, USERS, WEBSITES} from "../../shared/mocks/codes.mock";
import {User} from "../models/user.model";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class WebsiteService {

  // public allWebsites: Website[] | null = null;
  // public allWebsites$: BehaviorSubject<Website[] | null> = new BehaviorSubject<Website[] | null>(null)

  constructor(private http: HttpClient) {
    this.setWebsites()
  }

  public setWebsites(): any {
    // this.allWebsites = WEBSITES;
    // this.allWebsites$.next(this.allWebsites);
  }

  public allWebsites(): Observable<any> {
    return this.http.get(`http://localhost:8987/distribution/website/`)
  }

  public websiteFromId(id: number): Observable<any> {
    return this.http.get(`http://localhost:8987/distribution/website/${id}`)
  }

  deleteWebsite(website_id: number): Observable<any> {
    return this.http.delete(`http://localhost:8987/distribution/website/${website_id}`)
  }

  addWebsite(url: string, description: string): Observable<any> {

    return this.http.post(
      "http://localhost:8987/distribution/website",
      JSON.stringify({
        url: url,
        description: description
      }),{
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
        })
      })
  }


  updateWebsite(id: number, url: string, description: string): Observable<any> {
    return this.http.put(
      `http://localhost:8987/distribution/website/${id}`,
      JSON.stringify({
        url: url,
        description: description
      }),{
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
        })
      })
  }



}
