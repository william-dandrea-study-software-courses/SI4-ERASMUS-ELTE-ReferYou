import {Component, OnDestroy, OnInit} from '@angular/core';
import {UserService} from "../../core/service/user.service";
import {Subscription} from "rxjs";
import {User} from "../../core/models/user.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']
})
export class AuthComponent implements OnInit, OnDestroy {

  private currentUserSubscription: Subscription = new Subscription();
  private currentUser: User | null = null;

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
    this.currentUserSubscription = this.userService.currentUser$.subscribe(user => {
      this.currentUser = user;
    })
  }

  public login(): any {
    this.userService.setUser();
    this.router.navigate(['home']);
  }

  public register(): any {
    this.userService.setUser();
  }

  ngOnDestroy(): void {
    this.currentUserSubscription.unsubscribe();
  }

}
