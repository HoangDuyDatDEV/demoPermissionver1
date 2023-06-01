import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DanhmucService } from '../danhmuc.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
 
  loginObj:any = { 
   username:'',
   password:'',
  };
  role: any;
  code:any;
  constructor(
    private router:Router,
    private dmService: DanhmucService,
  ) {}
  ngOnInit(): void {
  }

  onLogin(){

    this.dmService.onLogin(this.loginObj).subscribe((res:any)=>{
      this.role = res.role;
      this.code=res.code;
      if(this.code==200){
      console.log('res',res);
      localStorage.setItem('token',res.token);
      if(this.role=='admin')
      {
        this.router.navigate(['/role']);
      }
    }
    })
  }
}


