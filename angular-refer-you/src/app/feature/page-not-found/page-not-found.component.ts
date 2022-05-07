import { Component, OnInit } from '@angular/core';
import {AuthServiceService} from "../../core/service/auth-service.service";

@Component({
  selector: 'app-page-not-found',
  templateUrl: './page-not-found.component.html',
  styleUrls: ['./page-not-found.component.scss']
})
export class PageNotFoundComponent implements OnInit {

  constructor(private authService: AuthServiceService) {

  }

  ngOnInit(): void {

    this.authService.registerRequest("salut@gmail.com", "william").subscribe(value => {
      console.log('Register :', value);




    });



  }

}
