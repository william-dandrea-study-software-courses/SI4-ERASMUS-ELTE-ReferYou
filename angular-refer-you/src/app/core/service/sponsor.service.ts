import { Injectable } from '@angular/core';
import {Rating} from "../models/rating.model";
import {BehaviorSubject, Observable} from "rxjs";
import {RATINGS, SPONSORS} from "../../shared/mocks/codes.mock";
import {Sponsor} from "../models/sponsor.model";
import {UserService} from "./user.service";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class SponsorService {

  public allSponsors: Sponsor[] | null = null;
  public allSponsors$: BehaviorSubject<Sponsor[] | null> = new BehaviorSubject<Sponsor[] | null>(null)

  constructor(private userService: UserService, ) {
    this.setSponsors()
  }

  public setSponsors(): any {
    this.allSponsors = SPONSORS;
    this.allSponsors$.next(this.allSponsors);
  }


  public sponsorsForCurrentUser(codeId: number): Observable<Sponsor[] | null> {

    return this.allSponsors$.pipe(
      map(sponsors => sponsors!.filter(sponsor => sponsor.code_id == codeId && sponsor.user_id == this.userService.currentUser!.user_id))
    )

  }

  public addSponsor(codeId: number, amount: number) {
    this.allSponsors?.push({
      code_id: codeId,
      user_id: this.userService.currentUser!.user_id,
      amount: amount,
    });
    this.allSponsors$.next(this.allSponsors);
  }

}
