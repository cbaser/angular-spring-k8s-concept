import { Injectable } from '@angular/core';
import httpClient from '../services/http-client';
import {Config} from "../../config/config";
import {Vehicle} from "../../pages/vehicles/vehicle-home/vehicle-home.component";
@Injectable()
export class VehicleRepository {
    async getVehicles(){
        const resp = await httpClient.get(Config.host+Config.port+Config.vehicle,{headers: {"Authorization" : "Bearer " + localStorage.getItem("accessToken")}})
        return resp.data;
    }
    async addVehicle(car:Vehicle){
      const resp =  await httpClient.post(Config.host+Config.port+Config.vehicle,car,{headers: {"Authorization" : "Bearer " + localStorage.getItem("accessToken")}})
      return resp.data;
    }
}
