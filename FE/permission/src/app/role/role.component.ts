import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { DanhmucService } from '../danhmuc.service';
import { BehaviorSubject } from 'rxjs';
import { FunctionComponent } from '../function/function.component';
@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.scss'],
  template: `
    <app-function [roleID]="roleID"></app-function>
  `
})
export class RoleComponent  {
RoleArray: any[]=[];
isResultLoaded = false;
roleID: number=0;
constructor(private http: HttpClient,
  private dmService: DanhmucService) {
  this.getAllRole();
}

viewRoleDetails(roleID: number) {
  this.roleID=roleID;
  console.log('View details of role with ID:', roleID);
  
}
getAllRole() {
  this.dmService
    .getAllRoles()
    .subscribe((resultData: any) => {
      this.isResultLoaded = true;
      console.log(resultData);
      this.RoleArray = resultData;
    });
}


}
