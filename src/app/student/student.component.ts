import {Component, OnInit} from '@angular/core';
import {Student} from "./student";
import {HttpClient} from "@angular/common/http";

import {StudentModel} from "../models/student-model";

import {StudentService} from "../services/student-service";

@Component({
  selector: 'app-student',
  templateUrl: 'student.component.html',
  styleUrls: ['./student.component.css'],
})


export class StudentComponent implements OnInit{


  students:StudentModel[]
  constructor(private studentService:StudentService) {
  }


  ngOnInit():void {
    this.studentService.getStudentsFromDatabase().subscribe(
      (response:StudentModel[]) =>{
        this.students = response

        console.log(this.students)
      })

  }

  getStudentCount():number{
    return this.students.length
  }

  add(studentName:string , studentSalary:string , age:number):void {

    let student = new StudentModel(studentName, studentSalary)
    this.studentService.addStudent(student).subscribe(
      (response:StudentModel[]) =>{
        this.students.push(student)
        alert("Student Added")

        console.log(this.students)
   })
  }


  remove(index: number){

    console.log(this.students[index])
    let student = this.students[index]
    // console.log(student.id)
    this.studentService.deleteStudent(student.id)
      .subscribe({
        next:response => {
          if(response.Success)
            this.students.splice(index,1)
          else
            alert(response.Message)
        }
      })
    console.log("remove")

  }
  getSortedStudentsByAge():StudentModel[]{
    return this.students.sort((a,b) => a.id - b.id)
  }

  getStudentsFromAPI():StudentModel[]{
    return this.students
  }

  update(updatedStudent:StudentModel){
    let newStudent:StudentModel
    this.studentService.updateStudent(updatedStudent.id , updatedStudent).subscribe(
      {
        next:response => {
          newStudent = response
          console.log( "new " , newStudent)
        }
      }
    )
    console.log( "old " , updatedStudent)


  }

  protected readonly parseInt = parseInt;
}


