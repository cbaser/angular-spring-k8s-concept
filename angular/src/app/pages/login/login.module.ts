import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {LoginComponent} from "./login-home/login.component";
import {RouterOutlet} from "@angular/router";
import {ReactiveFormsModule} from "@angular/forms";
import {MatCardModule} from "@angular/material/card";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatExpansionModule} from "@angular/material/expansion";
import {DragDropModule} from "@angular/cdk/drag-drop";
import {MatSortModule} from "@angular/material/sort";
import {MatIconModule} from "@angular/material/icon";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatTableModule} from "@angular/material/table";
import {MatListModule} from "@angular/material/list";
import {SharedModule} from "../../shared/shared.module";
import {LoginRoutingModule} from "./login-routing.module";


@NgModule({
  imports: [
    CommonModule,
    MatExpansionModule, DragDropModule, MatSortModule,
    LoginRoutingModule,
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
    RouterOutlet
  ],
  declarations: [
    LoginComponent
  ],
})
export class LoginModule { }
