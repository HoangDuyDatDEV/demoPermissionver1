import { Component, Input, OnInit } from '@angular/core';
import { DanhmucService } from '../danhmuc.service';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'app-function',
  templateUrl: './function.component.html',
  styleUrls: ['./function.component.scss'],
  template: `
    <p>ID from parent: {{ roleID }}</p>
  `
})
export class FunctionComponent implements OnInit {
  FunctionArray: any[] = [];
  roles: any[] = [];
  isResultLoaded = false;

  name: string='';
  code: Number=0;
  url: string='';
  currentFunctionID='';
  role: any
  // selectedRoleId: any;

  constructor(private http: HttpClient,
    private dmService: DanhmucService,
    private route: ActivatedRoute
    ) {
   
  }
  
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.role = params
      this.getAllFunction(this.role.id)
    });
    // this.loadRoles();
  }
//   loadRoles() {
//     this.dmService.getAllRoles()
//         .subscribe((data: any) => {
//             this.roles = data;
//         });
//   }
//   public getRoleIdFromSelection() {
//     const selectedRole = this.roles.find(r => r.id === this.selectedRoleId);
//     return selectedRole ? selectedRole.id : null;
//  }

  getAllFunction(roleID:number) {
    this.dmService
      .getAllFunctionByRole(roleID)
      .subscribe((resultData: any) => {
        this.isResultLoaded = true;
        console.log(resultData);
        this.FunctionArray = resultData;
      });
  }
  register() {
    let bodyData = {
      name: this.name,
      code: this.code,
      url: this.url,
    };
    this.dmService
      .registerFunction(this.role.id,bodyData)
      .subscribe((resultData: any) => {
        console.log(resultData);
        alert('Add Function Successfully');
        this.getAllFunction(this.role.id);

        this.name = '';
        this.code = 0;
        this.url = '';
      });
  }
 
  save() {
      this.register();  
  }
  setDelete(data: any) {
    this.dmService
      .deleteFunction(
        data.id
      )
      .subscribe((resultData: any) => {
        console.log(resultData);
        alert('Function Deletedddd');
        this.getAllFunction(this.role.id);

        this.name = '';
        this.code = 0;
        this.url = '';
      });
  }

}
