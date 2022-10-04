import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VehicleHomeComponent } from './vehicle-home/vehicle-home.component';
import {VehicleRepository} from "../../core/repository/VehicleRepository";
import {SharedModule} from "../../shared/shared.module";
import {MatCardModule} from "@angular/material/card";
import {MatIconModule} from "@angular/material/icon";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatTableModule} from "@angular/material/table";
import {MatListModule} from "@angular/material/list";
import {VehicleRoutingModule} from "./vehicle-routing.module";
import {MatRadioModule} from "@angular/material/radio";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";



@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    VehicleRoutingModule,
    MatCardModule,
    MatIconModule,
    MatFormFieldModule,
    MatAutocompleteModule,
    MatInputModule,
    MatButtonModule,
    MatTableModule,
    MatFormFieldModule,
    MatCardModule,
    MatListModule,
    MatTableModule,
    MatRadioModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  declarations: [
    VehicleHomeComponent
  ],
  providers:[VehicleRepository,   MatDatepickerModule,
    MatNativeDateModule ],
})
export class VehiclesModule { }
