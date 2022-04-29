import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CodeListComponent} from "./code/code-list/code-list.component";
import {CreateUpdateCodeComponent} from "./code/create-update-code/create-update-code.component";

const routes: Routes = [

  {
    path: 'code/update/:id',
    component: CreateUpdateCodeComponent,
    data: {status: "UPDATE"},
  },
  {
    path: 'code/create',
    component: CreateUpdateCodeComponent,
    data: {status: "CREATE"},
  },
  {
    path: 'code',
    component: CodeListComponent,
  },
  {
    path: '',
    component: CodeListComponent,
  },



];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
