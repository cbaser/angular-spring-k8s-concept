import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {Config} from "../../config/config";
import httpClient from "./http-client";

@Injectable({providedIn: 'root'})
export class AuthenticationService {
  private currentUserSubject: BehaviorSubject<any>;
  public currentUser: Observable<any>;

  constructor() {
    // @ts-ignore
    this.currentUserSubject = new BehaviorSubject<any>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue() {
    return this.currentUserSubject.value;
  }

  async login(email: string, password: string) {
    const resp = await httpClient.post(Config.host + Config.port + Config.auth + Config.login, {
      email: email,
      password: password
    }, {headers: {"Content-Type": "application/json"}})
    return resp.data;
  }

  async register(email: string, username: string, password: string, firstName: string, lastName: string) {
    const resp = await httpClient.post(Config.host + Config.port + Config.auth + Config.login, {
      username: username,
      password: password,
      firstName: firstName,
      lastName: lastName
    }, {headers: {"Content-Type": "application/json"}})
    return resp.data;
  }


  logout() {
    // remove user from local storage and set current user to null
    localStorage.removeItem('currentUser');
    localStorage.removeItem("accessToken");
    localStorage.removeItem("refreshToken");
    this.currentUserSubject.next(null);
  }
}
