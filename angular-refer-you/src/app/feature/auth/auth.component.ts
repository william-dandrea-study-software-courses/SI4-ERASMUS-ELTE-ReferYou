import {Component, OnDestroy, OnInit} from '@angular/core';
import {UserService} from "../../core/service/user.service";
import {Subscription} from "rxjs";
import {User} from "../../core/models/user.model";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthServiceService} from "../../core/service/auth-service.service";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']
})
export class AuthComponent implements OnInit, OnDestroy {

  private currentUserSubscription: Subscription = new Subscription();
  private currentUser: User | null = null;

  public loginForm: FormGroup;
  public registerForm: FormGroup;

  constructor(private userService: UserService, private authService: AuthServiceService, private router: Router, private formBuilder: FormBuilder) {
    this.loginForm = this.formBuilder.group({
      email: ["", [Validators.required, Validators.email]],
      password: ["", [Validators.required]],
    });
    this.registerForm = this.formBuilder.group({
      email: ["", [Validators.required, Validators.email]],
      password: ["", [Validators.required]],
    });
  }

  ngOnInit(): void {
    this.currentUserSubscription = this.userService.currentUser$.subscribe(user => {
      this.currentUser = user;
    });
  }

  public login(): any {
    // this.userService.setUser();
    this.authService.login(this.loginForm.value.email, this.loginForm.value.password).subscribe(value => {
      console.log(value);
      this.router.navigate(['home']);
    });

    // this.router.navigate(['home']);
  }

  public register(): any {
    this.authService.register(this.registerForm.value.email, this.registerForm.value.password).subscribe(value => {
      console.log(value);
      this.router.navigate(['home']);
    });
  }

  ngOnDestroy(): void {
    this.currentUserSubscription.unsubscribe();
  }

}
