import { Injectable } from '@angular/core';
import httpClient from '../services/http-client';
import {Config} from "../../config/config";
@Injectable()
export class UserRepository {

    async getUserByName(name:string) {
      const resp = await httpClient.get(Config.host+Config.port+Config.root+Config.version+Config.user+Config.name+"/?name="+name)
      return resp.data;
    }
    async getUsers() {
        const resp = await httpClient.get(Config.host+Config.port+Config.root+Config.version+Config.user)
        return resp.data;
    }
}
