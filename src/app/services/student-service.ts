import {Injectable} from "@angular/core";
import {Student} from "../student/student";
import {StudentModel} from "../models/student-model";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable(
  {
    providedIn: 'root'
  }
)
export class StudentService {

  constructor(private _http: HttpClient) {
  }

  isStudentExists(students: Student[], studName: string): boolean {
    let found = students.findIndex(stud => stud.firstName === studName)
    if (found !== -1) {
      console.log('Item found at index:', found);
      return true;
    }
    return false;
  }

  getStudentsFromDatabase(): Observable<any[]> {
    return this._http.get<any[]>("http://localhost:8080/findall")
  }

  addStudent(any: any): Observable<any> {
    return this._http.post<any[]>("http://localhost:8080/add", any)
  }

  deleteStudent(id:number):Observable<any>{
    return this._http.delete<any>(`http://localhost:8080/remove?id=${id}`)

  }

  updateStudent(id:number , student:StudentModel):Observable<any>{
    return this._http.put<any>(`http://localhost:8080/user/update/${id}`,student)
  }

  getStudentById(id:number):Observable<any>{
    return this._http.get<any[]>(`http://localhost:8080/userJson/${id}`)
  }
}


