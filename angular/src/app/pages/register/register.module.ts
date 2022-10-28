import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterHomeComponent } from './register-home/register-home.component';
import {MatExpansionModule} from "@angular/material/expansion";
import {DragDropModule} from "@angular/cdk/drag-drop";
import {MatSortModule} from "@angular/material/sort";
import {SharedModule} from "../../shared/shared.module";
import {MatCardModule} from "@angular/material/card";
import {MatIconModule} from "@angular/material/icon";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatTableModule} from "@angular/material/table";
import {MatListModule} from "@angular/material/list";
import {ReactiveFormsModule} from "@angular/forms";
import {RouterOutlet} from "@angular/router";
import {RegisterRoutingModule} from "./register-routing.module";
import {CustomModule} from "../../custom/custom.module";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";



@NgModule({
  declarations: [
    RegisterHomeComponent
  ],
  imports: [
    CommonModule,
    MatExpansionModule, DragDropModule, MatSortModule,
    RegisterRoutingModule,
    SharedModule,
    MatCardModule,
    MatIconModule,
    MatFormFieldModule,
    MatAutocompleteModule,
    MatInputModule,
    MatButtonModule,
    MatTableModule,
    MatCardModule,
    MatListModule,
    MatTableModule,
    ReactiveFormsModule,
    RouterOutlet, CustomModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  providers:[
    MatDatepickerModule, MatNativeDateModule
  ]
})
export class RegisterModule { }
