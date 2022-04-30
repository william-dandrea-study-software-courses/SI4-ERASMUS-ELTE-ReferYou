import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Subscription} from "rxjs";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Website} from "../../../../core/models/website.model";
import {WebsiteService} from "../../../../core/service/website.service";
import {COMMA, ENTER} from "@angular/cdk/keycodes";
import {MatChipInputEvent} from "@angular/material/chips";
import {CodeService} from "../../../../core/service/code.service";
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-create-update-code',
  templateUrl: './create-update-code.component.html',
  styleUrls: ['./create-update-code.component.scss']
})
export class CreateUpdateCodeComponent implements OnInit, OnDestroy {

  private subscriptionRoute: Subscription = new Subscription();
  private subscriptionParamsRoute: Subscription = new Subscription();

  private codeId: number | null = null;

  public codeForm: FormGroup = this.formBuilder.group({
    website_id: ["", [Validators.required]],
    code_value: ["", [Validators.required]],
    description: ["", [Validators.required]],
    expiration_date: ["", [Validators.required]],
    redirect_url: ["", []],
  });

  public websiteForm: FormGroup = this.formBuilder.group({
    url: ["", [Validators.required]],
    description: ["", [Validators.required]],
  });

  public websites: Website[] | null = null;

  constructor(private route: ActivatedRoute, private router: Router, private formBuilder: FormBuilder, private websiteService: WebsiteService, private codeService: CodeService, private snackBar: MatSnackBar) {}

  ngOnInit(): void {

    this.websiteService.allWebsites$.subscribe(websites => {
      this.websites = websites;
    })

    this.subscriptionRoute = this.route.data.subscribe(data => {
      if (data.status === 'UPDATE') {


        this.subscriptionParamsRoute = this.route.params.subscribe(params => {
          this.codeId = +params['id'];

          this.codeService.codeFromId(params['id']).subscribe(code => {
            this.codeForm.controls['website_id'].setValue(code?.website_id);
            this.codeForm.controls['code_value'].setValue(code?.code_value);
            this.codeForm.controls['description'].setValue(code?.description);
            this.codeForm.controls['expiration_date'].setValue(code?.expiration_date.toISOString().substring(0,10));
            this.codeForm.controls['redirect_url'].setValue(code?.redirect_url);
          })
        })


      } else if (data.status === 'CREATE'){
        console.log("Create")
      }
    })
  }

  ngOnDestroy(): void {
    this.subscriptionRoute.unsubscribe();
    this.subscriptionParamsRoute.unsubscribe();
  }


  public submitCode(): void {
    const formValue = this.codeForm.value;

    if (this.codeId == null) {
      this.codeService.addCode(formValue.code_value, formValue.description, formValue.expiration_date, formValue.redirect_url, formValue.website_id);
    } else {
      this.codeService.updateCode(this.codeId, formValue.code_value, formValue.description, formValue.expiration_date, formValue.redirect_url, formValue.website_id);
    }

    this.router.navigate(['home', 'code',]);
  }

  submitWebsite() {
    this.websiteService.addWebsite(this.websiteForm.value.url, this.websiteForm.value.description);
    this.snackBar.open('Website added', "Ok");

  }
}
