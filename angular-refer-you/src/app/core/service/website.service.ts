import { Injectable } from '@angular/core';
import {Code} from "../models/code.model";
import {BehaviorSubject} from "rxjs";
import {Website} from "../models/website.model";
import {CODES, USERS, WEBSITES} from "../../shared/mocks/codes.mock";
import {User} from "../models/user.model";

@Injectable({
  providedIn: 'root'
})
export class WebsiteService {

  public allWebsites: Website[] | null = null;
  public allWebsites$: BehaviorSubject<Website[] | null> = new BehaviorSubject<Website[] | null>(null)

  constructor() {
    this.setWebsites()
  }

  public setWebsites(): any {
    this.allWebsites = WEBSITES;
    this.allWebsites$.next(this.allWebsites);
  }

  public websiteFromId(id: number): BehaviorSubject<Website | undefined> {
    return new BehaviorSubject<Website | undefined>(WEBSITES.find(w => w.website_id === id));
  }


}
