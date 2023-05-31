import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core'
import { MarkerService } from './Services/Maker/marker.service';
// import { MdbModalModule } from 'mdb-angular-ui-kit/modal';


import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './Component/home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { ReactiveFormsModule } from '@angular/forms';
import { MatListModule } from '@angular/material/list';
import { HttpClientModule } from '@angular/common/http';
import { AboutComponent } from './Component/about/about.component';
import { ContactComponent } from './Component/contact/contact.component';
import { LoginComponent } from './Component/login/login.component';
import { MapComponent } from './Component/map/map.component';
import { DasboardComponent } from './Component/dasboard/dasboard.component';
import { AdmunicipalComponent } from './Component/admunicipal/admunicipal.component';
import { MunicipalformComponent } from './Component/municipalform/municipalform.component';
import { AddumpsComponent } from './Component/addumps/addumps.component';
import { DumpsformComponent } from './Component/dumpsform/dumpsform.component';
import { MunicipaldashComponent } from './Component/municipaldash/municipaldash.component';


@NgModule({
  declarations: [
    AppComponent,             // nav is used from app
    HomeComponent,
    AboutComponent,
    ContactComponent,
    LoginComponent,
    MapComponent,
    DasboardComponent,
    AdmunicipalComponent,
    MunicipalformComponent,
    AddumpsComponent,
    DumpsformComponent,
    MunicipaldashComponent,
    // Any additional local components
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    HttpClientModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    // MdbModalModule

    // router-outlet imported
  ],
  providers: [
    MarkerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
