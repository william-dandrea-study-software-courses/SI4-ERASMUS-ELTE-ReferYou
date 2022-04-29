import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CodeListComponent} from "./code-list/code-list.component";

const routes: Routes = [
  {
    path: "",
    component: CodeListComponent,
    children: [
      {
        path: "",
        component: CodeListComponent,
      },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
