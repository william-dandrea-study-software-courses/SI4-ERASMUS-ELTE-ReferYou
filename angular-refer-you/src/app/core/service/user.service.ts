import {Injectable} from '@angular/core';
import {User} from "../models/user.model";
import {BehaviorSubject} from "rxjs";
import {USERS} from '../../shared/mocks/codes.mock';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  public currentUser: User | null = null;
  public currentUser$: BehaviorSubject<User | null> = new BehaviorSubject<User | null>(null)

  constructor() {
    // this.setUser();
  }


  public setUser() {
    this.currentUser = USERS[0];
    // this.currentUser = null;
    this.currentUser$.next(this.currentUser);
  }

  public changeUser(id: number, mail: string, password: string, isBan: boolean, token: string): void {
    this.currentUser = {
      user_id: id,
      mail: mail,
      password: password,
      is_ban: isBan,
    };
    this.currentUser$.next(this.currentUser);
  }

  public resetUser(): void {
    this.currentUser = null;
    this.currentUser$.next(this.currentUser);
  }


  public userFromId(id: number): BehaviorSubject<User | undefined> {
    return new BehaviorSubject<User | undefined>(USERS.find(u => u.user_id == +id));
  }
}
