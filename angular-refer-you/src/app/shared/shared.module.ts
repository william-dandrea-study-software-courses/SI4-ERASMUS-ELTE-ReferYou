import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuBarComponent } from './components/menu-bar/menu-bar.component';
import {MatCardModule} from "@angular/material/card";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatTableModule} from "@angular/material/table";
import {MatListModule} from "@angular/material/list";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatIconModule} from "@angular/material/icon";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatMenuModule} from "@angular/material/menu";
import {MatChipsModule} from "@angular/material/chips";
import {DragDropModule} from "@angular/cdk/drag-drop";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {MatOptionModule} from "@angular/material/core";
import {MatExpansionModule} from "@angular/material/expansion";

const modules = [
  CommonModule,
  ReactiveFormsModule,
  MatCardModule,
  MatFormFieldModule,
  MatInputModule,
  MatButtonModule,
  MatSidenavModule,
  MatListModule,
  MatTableModule,
  MatIconModule,
  MatToolbarModule,
  MatMenuModule,
  MatChipsModule,
  DragDropModule,
  MatAutocompleteModule,
  MatOptionModule,
  MatExpansionModule,
  FormsModule,
]

const components = [
  MenuBarComponent,
]


@NgModule({
    declarations: [
      ...components,
    ],
    exports: [
      ...modules,
      ...components,
    ],
    imports: [
      ...modules
    ]
})
export class SharedModule {
  static forRoot() {
    return {
      ngModule: SharedModule,
      providers: []
    }
  }
}
