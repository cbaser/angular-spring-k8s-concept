import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {AuthenticationService} from "../../../core/services/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnDestroy {
  loading = false;
  submitted = false;
  error=false;
  form: FormGroup = new FormGroup({
    email: new FormControl('',[Validators.required]),
    password: new FormControl('',[Validators.required]),
  });

  constructor(private authenticationService: AuthenticationService,  private router: Router) {
  }


  get f() { return this.form.controls; }


  submit() {
    this.submitted = true;

    if (this.form.invalid) {
      this.error = true;
      return;
    }
    this.loading = true;
    this.authenticationService.login(this.form.get("email")?.value,this.form.get("password")?.value).then(data =>{
      console.log(data);
      localStorage.setItem("currentUser",JSON.stringify(data.user));
      localStorage.setItem("accessToken",data.accessToken);
      localStorage.setItem("refreshToken",data.refreshToken);
      this.router.navigateByUrl('users').then();
    })
  }

  ngOnDestroy(): void {
  }

  ngOnInit(): void {

  }
}
