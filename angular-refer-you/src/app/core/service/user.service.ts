import { Injectable } from '@angular/core';
import {User} from "../models/user.model";
import {BehaviorSubject} from "rxjs";
import {CODES, USERS} from '../../shared/mocks/codes.mock';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  public currentUser: User | null = null;
  public currentUser$: BehaviorSubject<User | null> = new BehaviorSubject<User | null>(null)

  constructor() {
    this.setUser();
  }


  setUser() {
    this.currentUser = USERS[0];
    this.currentUser$.next(this.currentUser);
  }
}
