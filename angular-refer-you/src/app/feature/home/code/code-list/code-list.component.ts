import { Component, OnInit } from '@angular/core';
import {CodeService} from "../../../../core/service/code.service";
import {Code} from "../../../../core/models/code.model";
import {Website} from "../../../../core/models/website.model";
import {WebsiteService} from "../../../../core/service/website.service";
import {UserService} from "../../../../core/service/user.service";
import {User} from "../../../../core/models/user.model";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-code-list',
  templateUrl: './code-list.component.html',
  styleUrls: ['./code-list.component.scss']
})
export class CodeListComponent implements OnInit {

  public allCodes: Code[] | null = null;

  constructor(private codeService: CodeService, private websiteService: WebsiteService, private userService: UserService, private router: Router, private activatedRoute: ActivatedRoute) {
    this.activatedRoute.params.subscribe(params => {
      this.codeService.allCodes().subscribe(codes => {
        this.allCodes = codes;
        console.log(this.allCodes)
      })
    })
  }

  ngOnInit(): void {

  }

  public isLogged(): boolean {
    return this.userService.currentUser !== null;
  }

  onAddNewCode() {
    this.router.navigate(['home', 'code', 'create']);
  }

  delete(code: Code) {
    this.allCodes = this.allCodes?.filter(c => c != code) ?? []
  }
}
