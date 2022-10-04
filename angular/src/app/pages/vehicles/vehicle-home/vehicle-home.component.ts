import {Component, OnInit} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {NGXLogger} from "ngx-logger";
import {NotificationService} from "../../../core/services/notification.service";
import {Title} from "@angular/platform-browser";
import {VehicleRepository} from "../../../core/repository/VehicleRepository";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";


export interface Vehicle {
  id: string;
  licensePlate: string;
  vin: string;
  model: string;
  active: boolean;
  color: string;
  validTill: Date;
}

@Component({
  selector: 'app-vehicle-home',
  templateUrl: './vehicle-home.component.html',
  styleUrls: ['./vehicle-home.component.css']
})
export class VehicleHomeComponent implements OnInit {
  vehicleList: Vehicle[] = [];
  displayedColumns: string[] = ['id', 'licensePlate', 'vin', 'model', 'active', 'color', 'validTill'];
  dataSource = new MatTableDataSource<Vehicle>();
  form!: FormGroup;
  minDate = new Date();
  constructor(private logger: NGXLogger,
              private notificationService: NotificationService,
              private titleService: Title,
              private vehicleRepo: VehicleRepository,
              private formBuilder: FormBuilder) {
  }

  addVehicle(form:FormGroup) {
    let vehicle: Vehicle = {
      active: form.value.active === 'true',
      color: form.value.color,
      id: "",
      licensePlate: form.value.licensePlate,
      model: form.value.model,
      validTill: form.value.validTill,
      vin: form.value.vin
    };

     this.vehicleRepo.addVehicle(vehicle)
       .then(() => this.notificationService.openSnackBar("Vehicle Added"))
       .catch(() => this.notificationService.openSnackBar("Vehicle cannot be added"))

  }


  ngOnInit(): void {
    this.titleService.setTitle('Vehicles');
    this.logger.log('Vehicle List loaded');
    this.notificationService.openSnackBar('Vehicle List loaded');

    this.form = this.formBuilder.group({
      licensePlate: [null, [Validators.required]],
      vin: [null, [Validators.required,Validators.minLength(5)]],
      model: [null, [Validators.required]],
      active: [null, [Validators.required]],
      color: [null, [Validators.required]],
      validTill: [null, [Validators.required]]
    })



    this.vehicleRepo.getVehicles().then((list: Array<Vehicle>) => {
      list.map((data: Vehicle) => {
        this.vehicleList.push({
          id: data.id,
          licensePlate: data.licensePlate,
          vin: data.vin,
          model: data.model,
          active: data.active,
          color: data.color,
          validTill: data.validTill
        })
        this.dataSource = new MatTableDataSource<Vehicle>(this.vehicleList)
      })
    })
  }

}
