import { Injectable } from '@angular/core';
import {Website} from "../models/website.model";
import {BehaviorSubject, Observable} from "rxjs";
import {RATINGS, WEBSITES} from "../../shared/mocks/codes.mock";
import {Rating} from "../models/rating.model";
import {UserService} from "./user.service";
import {map} from "rxjs/operators";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class RatingService {

  // public allRatings: Rating[] | null = null;
  // public allRatings$: BehaviorSubject<Rating[] | null> = new BehaviorSubject<Rating[] | null>(null)

  constructor(private userService: UserService, private http: HttpClient) {
    this.setRatings()
  }

  public setRatings(): any {
    // this.allRatings = RATINGS;
    // this.allRatings$.next(this.allRatings);
  }



  /*
  public ratingFromUserIdAndCodeId(userId: number, codeId: number): BehaviorSubject<Rating | undefined> {
    return new BehaviorSubject<Rating | undefined>(RATINGS.find(r => r.user_id == +userId && r.code_id == +codeId));
  }

  public ratingFromUserId(userId: number): BehaviorSubject<Rating | undefined> {
    return new BehaviorSubject<Rating | undefined>(RATINGS.find(r => r.user_id == +userId));
  } */

  public ratingFromCodeId(codeId: number): Observable<any> {

    return this.http.get(`http://localhost:8987/moderation/code/${codeId}`)

    /*
    return this.allRatings$.pipe(
      map(ratings => ratings!.filter(rating => rating.code_id == codeId))
    ) */
  }


  public addLike(code_id: number): Observable<any> {
    const userId = this.userService.currentUser!.user_id;

    return this.http.post(
      `http://localhost:8987/moderation/code/${code_id}/user/${userId}/like` ,
      {},{
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
        })
      })

    /*this.allRatings?.push({
      code_id: code_id,
      user_id: this.userService.currentUser!.user_id,
      is_negative: false,
      is_positive: true,
    });
    this.allRatings$.next(this.allRatings); */
  }

  public addDislike(code_id: number): Observable<any> {
    const userId = this.userService.currentUser!.user_id;

    return this.http.post(
      `http://localhost:8987/moderation/code/${code_id}/user/${userId}/dislike` ,
      {},{
        headers: new HttpHeaders({
          'Content-Type': 'application/json',
        })
      })
    /*
    this.allRatings?.push({
      code_id: code_id,
      user_id: this.userService.currentUser!.user_id,
      is_negative: true,
      is_positive: false,
    });
    this.allRatings$.next(this.allRatings); */
  }
}
