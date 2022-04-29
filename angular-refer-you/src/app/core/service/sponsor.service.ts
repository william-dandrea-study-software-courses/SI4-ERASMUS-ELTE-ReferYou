import { Injectable } from '@angular/core';
import {Rating} from "../models/rating.model";
import {BehaviorSubject} from "rxjs";
import {RATINGS, SPONSORS} from "../../shared/mocks/codes.mock";
import {Sponsor} from "../models/sponsor.model";

@Injectable({
  providedIn: 'root'
})
export class SponsorService {

  public allSponsors: Sponsor[] | null = null;
  public allSponsors$: BehaviorSubject<Sponsor[] | null> = new BehaviorSubject<Sponsor[] | null>(null)

  constructor() {
    this.setSponsors()
  }

  public setSponsors(): any {
    this.allSponsors = SPONSORS;
    this.allSponsors$.next(this.allSponsors);
  }

  public addSponsor(codeId: number) {

  }

}
