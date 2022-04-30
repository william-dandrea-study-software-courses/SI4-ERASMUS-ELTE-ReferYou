import { Injectable } from '@angular/core';
import {User} from "../models/user.model";
import {BehaviorSubject} from "rxjs";
import {Code} from "../models/code.model";
import {CODES, WEBSITES} from "../../shared/mocks/codes.mock";
import {Website} from "../models/website.model";
import {UserService} from "./user.service";

@Injectable({
  providedIn: 'root'
})
export class CodeService {

  public allCodes: Code[] | null = null;
  public allCodes$: BehaviorSubject<Code[] | null> = new BehaviorSubject<Code[] | null>(null)

  constructor(private userService: UserService) {
    this.setCodes()
  }

  public setCodes(): any {
    this.allCodes = CODES;
    this.allCodes$.next(this.allCodes);
  }

  public codeFromId(id: number): BehaviorSubject<Code | undefined> {
    return new BehaviorSubject<Code | undefined>(CODES.find(c => c.code_id == +id));
  }

  public deleteCode(id: number): void {
    this.allCodes = this.allCodes!.filter(c => c.code_id != +id);
    this.allCodes$.next(this.allCodes);
  }

  public addCode(code_value: string, description: string, expiration_date: Date, redirect_url: string, website_id: number): void {
    this.allCodes!.push({
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
    this.allCodes$.next(this.allCodes);
  }

  public updateCode(codeId: number, code_value: string, description: string, expiration_date: Date, redirect_url: string, website_id: number): void {
    this.deleteCode(codeId);
    this.addCode(code_value, description, expiration_date, redirect_url, website_id)
  }
}
