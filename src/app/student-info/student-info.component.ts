import {Component, OnInit} from '@angular/core';
import {StudentComponent} from "../student/student.component";
import {ActivatedRoute} from "@angular/router";
import {StudentService} from "../services/student-service";
import {StudentModel} from "../models/student-model";

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent implements OnInit{
    student:StudentModel
  constructor(private activatedRoute:ActivatedRoute , private studentServices:StudentService) {

  }
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe( parm =>{
     let id = parm.get('id')
      if (typeof id === "string") {
        this.studentServices.getStudentById(parseInt(id)).subscribe(
          {
            next:(response:StudentModel) => {
              this.student=response


            }
          }
        )
      }
    })
  }

}
