import {Component, Input, OnInit} from '@angular/core';
import {Code} from "../../../core/models/code.model";
import {Website} from "../../../core/models/website.model";
import {User} from "../../../core/models/user.model";
import {WebsiteService} from "../../../core/service/website.service";
import {UserService} from "../../../core/service/user.service";
import {RatingService} from "../../../core/service/rating.service";
import {Rating} from "../../../core/models/rating.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-code-list-item',
  templateUrl: './code-list-item.component.html',
  styleUrls: ['./code-list-item.component.scss']
})
export class CodeListItemComponent implements OnInit {

  @Input() public code: Code | null = null;
  public website: Website | undefined = undefined;
  public owner: User | undefined = undefined;
  public positiveRatings: Rating[] | undefined = undefined;
  public negativeRatings: Rating[] | undefined = undefined;

  public panelOpenState: boolean = false;

  constructor(private websiteService: WebsiteService, private userService: UserService, private ratingService: RatingService, private router: Router) {}

  ngOnInit(): void {
    this.websiteFromId();
    this.userFromId();
    this.ratingCode();

  }

  public websiteFromId(): void {
    this.websiteService.websiteFromId(this.code!.website_id).subscribe(website => this.website = website);
  }

  public userFromId(): void {
    this.userService.userFromId(this.code!.user_id).subscribe(owner => this.owner = owner);
  }

  public ratingCode(): void {
    this.ratingService.ratingFromCodeId(this.code!.code_id).subscribe(ratings=> {
      this.positiveRatings = ratings!.filter(r => r.is_positive);
      this.negativeRatings = ratings!.filter(r => r.is_negative);
    })
  }

  public isAtCurrentUser(): boolean {
    return this.userService && this.userService.currentUser?.user_id === this.code?.user_id
  }

  public onSponsorBtn(): void {

  }

  public onUpdateBtn(): void {
    this.router.navigate(['home', 'code', 'update', this.code?.code_id]);
  }

  public onDeleteBtn(): void {

  }
}
