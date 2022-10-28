import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";


export interface User{
  firstName: string;
  lastName: string;
  email: string;
  birthday: Date;
  password: string;
}



@Component({
  selector: 'app-register-home',
  templateUrl: './register-home.component.html',
  styleUrls: ['./register-home.component.css']
})
export class RegisterHomeComponent implements OnInit {
  form: FormGroup = new FormGroup({
    email:new FormControl(''),
    password: new FormControl(''),
    password_repeat : new FormControl(''),
    firstname : new FormControl(''),
    lastname : new FormControl(''),
    birthday : new FormControl(new Date())
  });
  minDate: any;
  constructor() {
    this.minDate = new Date();
  }

  submit() {
    if (this.form.valid) {
      this.submitEM.emit(this.form.value);
    }
  }
  @Input() error: string | null | undefined;

  @Output() submitEM = new EventEmitter();

  ngOnInit(): void {
  }

}
