import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FunctionComponent } from './function/function.component';
import { LoginComponent } from './login/login.component';
import { RoleComponent } from './role/role.component';

const routes: Routes = [
{path: 'login', component: LoginComponent },
{path: 'function/:id', component: FunctionComponent },
{path: 'role', component: RoleComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
