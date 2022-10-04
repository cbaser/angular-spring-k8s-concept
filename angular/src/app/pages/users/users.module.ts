import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatCardModule} from "@angular/material/card";
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from "@angular/material/form-field";
import {MatListModule} from "@angular/material/list";
import { UserHomeComponent } from './user-home/user-home.component';
import {MatTableModule} from "@angular/material/table";
import {SharedModule} from "../../shared/shared.module";
import {UsersRoutingModule} from "./users-routing.module";
import {MatButtonModule} from "@angular/material/button";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {MatIconModule} from "@angular/material/icon";
import {UserRepository} from "../../core/repository/UserRepository";


@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    UsersRoutingModule,
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
    MatTableModule
  ],
  providers:[UserRepository],
  declarations: [
    UserHomeComponent
  ],
})
export class UsersModule { }
