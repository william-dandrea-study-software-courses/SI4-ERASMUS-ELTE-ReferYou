import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Subscription} from "rxjs";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Website} from "../../../../core/models/website.model";
import {WebsiteService} from "../../../../core/service/website.service";
import {COMMA, ENTER} from "@angular/cdk/keycodes";
import {MatChipInputEvent} from "@angular/material/chips";

@Component({
  selector: 'app-create-update-code',
  templateUrl: './create-update-code.component.html',
  styleUrls: ['./create-update-code.component.scss']
})
export class CreateUpdateCodeComponent implements OnInit, OnDestroy {

  /**
   * website_id: number,
     code_value: string,
     description: string,
     expiration_date: any,
     redirect_url: string,
   * @private
   */

  readonly separatorKeysCodes = [ENTER, COMMA] as const;
  private subscriptionRoute: Subscription = new Subscription();

  public codeForm: FormGroup = this.formBuilder.group({
    website_id: ["", [Validators.required]],
    code_value: ["", [Validators.required]],
    description: ["", [Validators.required]],
    expiration_date: ["", [Validators.required]],
    redirect_url: ["", [Validators.required]],
  });

  public websiteForm: FormGroup = this.formBuilder.group({
    url: ["", [Validators.required]],
    description: ["", [Validators.required]],
  });

  public websites: Website[] | null = null;

  constructor(private route: ActivatedRoute, private formBuilder: FormBuilder, private websiteService: WebsiteService) {}

  ngOnInit(): void {

    this.websiteService.allWebsites$.subscribe(websites => {
      this.websites = websites;
    })

    this.subscriptionRoute = this.route.data.subscribe(data => {

      if (data.status === 'UPDATE') {
        console.log("Update");
      } else if (data.status === 'CREATE'){
        console.log("Create")
      }


    })
  }

  ngOnDestroy(): void {
    this.subscriptionRoute.unsubscribe();
  }


  public submitCode(): void {
    console.log(this.codeForm)
  }

  public deleteWebsite(website_id: number): void {
    this.websites = this.websites!.filter(website => website.website_id != website_id);
  }


  submitWebsite() {
    console.log(this.websiteForm)
  }
}
