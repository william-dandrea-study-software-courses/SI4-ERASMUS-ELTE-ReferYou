import { Injectable } from '@angular/core';
import {User} from "../models/user.model";
import {BehaviorSubject, Observable} from "rxjs";
import {Code} from "../models/code.model";
import {CODES, WEBSITES} from "../../shared/mocks/codes.mock";
import {Website} from "../models/website.model";
import {UserService} from "./user.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {DatePipe} from "@angular/common";

@Injectable({
  providedIn: 'root'
})
export class CodeService {

  // public allCodes: Code[] | null = null;
  // public allCodes$: BehaviorSubject<Code[] | null> = new BehaviorSubject<Code[] | null>(null)

  constructor(private userService: UserService, private http: HttpClient, private datePipe: DatePipe) {
    // this.setCodes()
  }

  public setCodes(): any {
    // this.allCodes = CODES;
    // this.allCodes$.next(this.allCodes);
  }

  public allCodes(): Observable<any> {
    return this.http.get(`http://localhost:8987/distribution/code/`)
  }

  public codeFromId(id: number): Observable<any> {
    return this.http.get(`http://localhost:8987/distribution/code/by-code/${id}`)
    // return new BehaviorSubject<Code | undefined>(CODES.find(c => c.code_id == +id));
  }

  public deleteCode(id: number): Observable<any> {
    return this.http.delete(`http://localhost:8987/distribution/code/${id}`);

    // this.allCodes = this.allCodes!.filter(c => c.code_id != +id);
    // this.allCodes$.next(this.allCodes);
  }

  public addCode(code_value: string, description: string, expiration_date: Date, redirect_url: string, website_id: number): Observable<any> {

    return this.http.post(
      "http://localhost:8987/distribution/code",
      JSON.stringify({
        user_id: this.userService.currentUser!.user_id,
        website_id: website_id,
        code_value: code_value,
        description: description,
        expiration_date: this.datePipe.transform(expiration_date, 'yyyy-MM-ddTHH:mm:ss'),
        creation_date: this.datePipe.transform(new Date(), 'yyyy-MM-ddTHH:mm:ss'),
        number_of_uses: 0,
        redirect_url: redirect_url,
      }),{
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
        })
      })

    /*this.allCodes!.push({
      code_id: this.allCodes!.length,
      user_id: this.userService.currentUser!.user_id,
      website_id: website_id,
      code_value: code_value,
      description: description,
      expiration_date: expiration_date,
      creation_date: new Date(),
      number_of_uses: 0,
      redirect_url: redirect_url,
    })
    this.allCodes$.next(this.allCodes); */
  }

  public updateCode(codeId: number, code_value: string, description: string, expiration_date: Date, redirect_url: string, website_id: number): Observable<any> {
    return this.http.put(
      `http://localhost:8987/distribution/code/${codeId}`,
      JSON.stringify({
        user_id: this.userService.currentUser!.user_id,
        website_id: website_id,
        code_value: code_value,
        description: description,
        expiration_date: this.datePipe.transform(expiration_date, 'yyyy-MM-ddTHH:mm:ss'),
        creation_date: this.datePipe.transform(new Date(), 'yyyy-MM-ddTHH:mm:ss'),
        number_of_uses: 0,
        redirect_url: redirect_url,
      }),{
        headers: new HttpHeaders({
          'Content-Type': 'application/json'
        })
      })
  }
}
