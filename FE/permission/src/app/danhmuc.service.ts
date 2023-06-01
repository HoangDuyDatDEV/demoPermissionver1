import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { HttpClient, HttpHeaders, HttpResponse } from "@angular/common/http";
@Injectable({
  providedIn: 'root'
})
export class DanhmucService {
  public resourceUrl = "https://localhost:8087/";
  
  constructor(private http: HttpClient,
    ) {}
 
   onLogin(obj:any):Observable<any> {
    return this.http.post('http://localhost:8087/api/v1/login', obj);
   }
   getAllRoles():Observable<any> {
    return this.http.get('http://localhost:8087/api/v1/role/getAllRoles')
   }
   getAllFunctionByRole(roleID: any):Observable<any> {
    return this.http.get(`http://localhost:8087/api/v1/function/getFunctionByRoleID?roleID=${roleID}`)
   }
   registerFunction(roleID: any,Data:any):Observable<any> {
    return this.http.post(`http://localhost:8087/api/v1/function/save/?roleID=${roleID}`,Data,{ responseType: 'text' })
   }
   
  deleteFunction(id:any):Observable<any> {
    return this.http.delete('http://localhost:8087/api/v1/function/delete'+ '/' + id,{ responseType: 'text' } );
  }
}
