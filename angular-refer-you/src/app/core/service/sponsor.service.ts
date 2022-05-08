import { Injectable } from '@angular/core';
import {Rating} from "../models/rating.model";
import {BehaviorSubject, Observable} from "rxjs";
import {RATINGS, SPONSORS} from "../../shared/mocks/codes.mock";
import {Sponsor} from "../models/sponsor.model";
import {UserService} from "./user.service";
import {map} from "rxjs/operators";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class SponsorService {

  // public allSponsors: Sponsor[] | null = null;
  // public allSponsors$: BehaviorSubject<Sponsor[] | null> = new BehaviorSubject<Sponsor[] | null>(null)

  constructor(private userService: UserService, private http: HttpClient) {
    this.setSponsors()
  }

  public setSponsors(): any {
    // this.allSponsors = SPONSORS;
    // this.allSponsors$.next(this.allSponsors);
  }


  public sponsorsForCurrentUser(codeId: number): Observable<any> {
    // const userId = this.userService.currentUser!.user_id;

    return this.http.get(`http://localhost:8987/promotion/${codeId}`)
    /*return this.allSponsors$.pipe(
      map(sponsors => sponsors!.filter(sponsor => sponsor.code_id == codeId && sponsor.user_id == this.userService.currentUser!.user_id))
    ) */
  }

  public addSponsor(codeId: number, amount: number): Observable<any> {

    return this.http.post(
      `http://localhost:8987/promotion/${codeId}` ,
      JSON.stringify({
        amount: amount,
      }),{
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
        })
      })

    /*this.allSponsors?.push({
      code_id: codeId,
      user_id: this.userService.currentUser!.user_id,
      amount: amount,
    });
    this.allSponsors$.next(this.allSponsors);*/
  }

}
