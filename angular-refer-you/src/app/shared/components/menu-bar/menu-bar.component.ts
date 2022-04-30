import {Component, OnDestroy, OnInit} from '@angular/core';
import {UserService} from "../../../core/service/user.service";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-menu-bar',
  templateUrl: './menu-bar.component.html',
  styleUrls: ['./menu-bar.component.scss']
})
export class MenuBarComponent implements OnInit, OnDestroy {

  private isLoggedSubscription: Subscription = new Subscription();
  public isLogged: boolean = false;

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
    this.isLoggedManager()
  }

  private isLoggedManager(): any {
    this.isLogged = this.userService.currentUser !== null;

    this.isLoggedSubscription = this.userService.currentUser$.subscribe(user => {
      this.isLogged = this.userService.currentUser !== null;
    })
  }


  ngOnDestroy() {
    this.isLoggedSubscription.unsubscribe();
  }

  public onCodeButton(): any {
    this.router.navigate(['home', 'code']);
  }


}
