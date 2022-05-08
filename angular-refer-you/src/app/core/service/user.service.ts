import {Injectable} from '@angular/core';
import {User} from "../models/user.model";
import {BehaviorSubject, Observable} from "rxjs";
import {USERS} from '../../shared/mocks/codes.mock';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  public currentUser: User | null = null;
  public currentUser$: BehaviorSubject<User | null> = new BehaviorSubject<User | null>(null)

  constructor(private http: HttpClient,) {
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


  public userFromId(id: number): Observable<any> {

    return this.http.get(`http://localhost:8987/auth/user/${id}`)
    // return new BehaviorSubject<User | undefined>(USERS.find(u => u.user_id == +id));
  }
}
