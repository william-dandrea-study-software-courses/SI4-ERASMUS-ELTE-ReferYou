import { Injectable } from '@angular/core';
import {Website} from "../models/website.model";
import {BehaviorSubject} from "rxjs";
import {RATINGS, WEBSITES} from "../../shared/mocks/codes.mock";
import {Rating} from "../models/rating.model";

@Injectable({
  providedIn: 'root'
})
export class RatingService {

  public allRatings: Rating[] | null = null;
  public allRatings$: BehaviorSubject<Rating[] | null> = new BehaviorSubject<Rating[] | null>(null)

  constructor() {
    this.setRatings()
  }

  public setRatings(): any {
    this.allRatings = RATINGS;
    this.allRatings$.next(this.allRatings);
  }


  public ratingFromUserIdAndCodeId(userId: number, codeId: number): BehaviorSubject<Rating | undefined> {
    return new BehaviorSubject<Rating | undefined>(RATINGS.find(r => r.user_id === userId && r.code_id === codeId));
  }

  public ratingFromUserId(userId: number): BehaviorSubject<Rating | undefined> {
    return new BehaviorSubject<Rating | undefined>(RATINGS.find(r => r.user_id === userId));
  }

  public ratingFromCodeId(codeId: number): BehaviorSubject<Rating[] | undefined> {
    const ratings: Rating[] = RATINGS.filter(r => r.code_id === codeId);
    console.log(ratings);
    return new BehaviorSubject<Rating[] | undefined>(ratings);
  }




}
