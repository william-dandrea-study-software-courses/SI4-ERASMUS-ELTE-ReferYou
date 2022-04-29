import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { CodeListComponent } from './code/code-list/code-list.component';
import {SharedModule} from "../../shared/shared.module";
import {MatGridListModule} from "@angular/material/grid-list";
import {MatSortModule} from "@angular/material/sort";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import { CreateUpdateCodeComponent } from './code/create-update-code/create-update-code.component';
import {MatSelectModule} from "@angular/material/select";


@NgModule({
  declarations: [
    CodeListComponent,
    CreateUpdateCodeComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    SharedModule,
    MatGridListModule,
    MatSortModule,
    MatProgressSpinnerModule,
    MatSelectModule
  ]
})
export class HomeModule { }
