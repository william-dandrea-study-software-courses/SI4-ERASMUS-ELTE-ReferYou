import {Component, Input, OnInit} from '@angular/core';
import {Code} from "../../../core/models/code.model";
import {Website} from "../../../core/models/website.model";
import {User} from "../../../core/models/user.model";
import {WebsiteService} from "../../../core/service/website.service";
import {UserService} from "../../../core/service/user.service";
import {RatingService} from "../../../core/service/rating.service";
import {Rating} from "../../../core/models/rating.model";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {SponsorService} from "../../../core/service/sponsor.service";
import {Sponsor} from "../../../core/models/sponsor.model";
import {MatSnackBar} from "@angular/material/snack-bar";
import {CodeService} from "../../../core/service/code.service";

@Component({
  selector: 'app-code-list-item',
  templateUrl: './code-list-item.component.html',
  styleUrls: ['./code-list-item.component.scss']
})
export class CodeListItemComponent implements OnInit {

  @Input() public code: Code | null = null;
  public website: Website | undefined = undefined;
  public owner: User | undefined = undefined;
  public positiveRatings: number = 0;
  public negativeRatings: number = 0;

  public panelOpenState: boolean = false;

  public sponsoringForm: FormGroup = this.formBuilder.group({
    amount: ["", [Validators.required]],
  });
  public sponsorships: Sponsor[] | null = []

  constructor(private codeService: CodeService, private snackBar: MatSnackBar, private websiteService: WebsiteService, private userService: UserService, private ratingService: RatingService, private router: Router, private formBuilder: FormBuilder, private sponsorService: SponsorService) {}

  ngOnInit(): void {
    this.websiteFromId();
    this.userFromId();
    this.ratingCode();


    this.sponsorService.sponsorsForCurrentUser(this.code!.code_id).subscribe(sponsors => {
      this.sponsorships = sponsors;
    })

  }

  public websiteFromId(): void {
    this.websiteService.websiteFromId(this.code!.website_id).subscribe(website => {
      this.website = website;
    });
  }

  public userFromId(): void {
    this.userService.userFromId(this.code!.user_id).subscribe(owner => {
      this.owner = owner;
    });
  }

  public ratingCode(): void {
    this.ratingService.ratingFromCodeId(this.code!.code_id).subscribe(ratings => {

      this.positiveRatings = ratings!.numberPositives;
      this.negativeRatings = ratings!.numberNegatives;
    })
  }

  public isAtCurrentUser(): boolean {
    return this.userService && this.userService.currentUser?.user_id === this.code?.user_id
  }

  public onSponsorBtn(): void {
    const formValue = this.sponsoringForm.value;
    this.sponsorService.addSponsor(this.code!.code_id, formValue.amount).subscribe(value => {
      this.sponsorships = value;
      this.snackBar.open('Sponsorhsip added', "Ok");
    });

  }

  public onUpdateBtn(): void {
    this.router.navigate(['home', 'code', 'update', this.code?.code_id]);
  }

  public onDeleteBtn(): void {
    this.codeService.deleteCode(this.code!.code_id).subscribe(value => console.log(value));
  }

  public onLike(): void {
    this.ratingService.addLike(this.code!.code_id).subscribe(value => {
      this.ratingCode();
      this.snackBar.open('Like added', "Ok");
    });

  }

  public onDislike(): void {
    this.ratingService.addDislike(this.code!.code_id).subscribe(value => {
      this.ratingCode();
      this.snackBar.open('Dislike added', "Ok");
    });

  }
}
