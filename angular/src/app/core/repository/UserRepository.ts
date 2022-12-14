import { Injectable } from '@angular/core';
import httpClient from '../services/http-client';
import {Config} from "../../config/config";
@Injectable()
export class UserRepository {

    async getUserByName(name:string) {
      const resp = await httpClient.get(Config.host+Config.port+Config.user+"/"+name, {headers: {"Authorization" : "Bearer " + localStorage.getItem("accessToken")}})
      return resp.data;
    }
    async getUsers() {
    const resp = await httpClient.get(Config.host+Config.port+Config.user,{headers: {"Authorization" : "Bearer " + localStorage.getItem("accessToken")}})
    return resp.data;
    }
}
