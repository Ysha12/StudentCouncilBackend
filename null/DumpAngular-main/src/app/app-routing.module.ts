import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './Component/about/about.component';
import { AddumpsComponent } from './Component/addumps/addumps.component';
import { AdmunicipalComponent } from './Component/admunicipal/admunicipal.component';
import { ContactComponent } from './Component/contact/contact.component';
import { DasboardComponent } from './Component/dasboard/dasboard.component';
import { DumpsformComponent } from './Component/dumpsform/dumpsform.component';
import { HomeComponent } from './Component/home/home.component';
import { LoginComponent } from './Component/login/login.component';
import { MapComponent } from './Component/map/map.component';
import { MunicipaldashComponent } from './Component/municipaldash/municipaldash.component';
import { MunicipalformComponent } from './Component/municipalform/municipalform.component';

const routes: Routes = [
  {path:"",component:HomeComponent,},
  {path:"about",component:AboutComponent},
  {path:"contact",component: ContactComponent},
  {path:"login",component: LoginComponent},
  {path:"map",component: MapComponent },
  {path: "dasboard",component: DasboardComponent},
  {path: "admunicipal",component: AdmunicipalComponent},
  {path: "municipalform", component: MunicipalformComponent},
  {path: "addumps", component: AddumpsComponent},
  {path: "dumpsform", component: DumpsformComponent},
  {path: "municipaldash", component: MunicipaldashComponent}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
