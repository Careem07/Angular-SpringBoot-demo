import { Component } from '@angular/core';
import {StudentComponent} from "../student/student.component";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent extends StudentComponent{

}
