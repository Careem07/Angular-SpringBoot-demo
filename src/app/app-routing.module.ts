import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {StudentComponent} from "./student/student.component";
import {LoginComponent} from "./login/login.component";
import {StudentInfoComponent} from "./student-info/student-info.component";

const routes : Routes =[
  {path:'student',component:StudentComponent},
  {path:'student/info/:id',component:StudentInfoComponent},
  {path:'login' , component:LoginComponent}
]
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
