import { Injectable } from '@angular/core';
import {User} from "../models/user.model";
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  public currentUser: User | null;
  public currentUser$: BehaviorSubject<User | null> = new BehaviorSubject<User | null>(null)

  constructor() {
    this.currentUser = null;
    this.setUser();
  }


  setUser() {
    this.currentUser = {email: "salut@gmail.com"};
    this.currentUser$.next(this.currentUser);
  }
}
