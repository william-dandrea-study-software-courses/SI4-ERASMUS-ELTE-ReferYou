import { Injectable } from '@angular/core';
import {User} from "../models/user.model";
import {BehaviorSubject} from "rxjs";
import {Code} from "../models/code.model";
import {CODES} from "../../shared/mocks/codes.mock";

@Injectable({
  providedIn: 'root'
})
export class CodeService {

  public allCodes: Code[] | null = null;
  public allCodes$: BehaviorSubject<Code[] | null> = new BehaviorSubject<Code[] | null>(null)

  constructor() {
    this.setCodes()
  }

  public setCodes(): any {
    this.allCodes = CODES;
    this.allCodes$.next(this.allCodes);
  }


  public deleteCode(id: number): void {

  }

  public addCode(code: Code): void {

  }

  public editCode(code: Code): void {

  }

}
