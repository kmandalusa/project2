import { Component, EventEmitter, Input, OnInit } from '@angular/core';
//import { Room } from '../room';
//import { CustomerService } from '../customer.service';
@Component({
  selector: 'app-room-details',
  templateUrl: './room-details.component.html',
  styleUrls: ['./room-details.component.css']
})
export class RoomDetailsComponent implements OnInit {
//customers : Customer[] = [];
  constructor() {
    /*
    @Input() update: EventEmitter<string>;
  constructor(private customerService : CustomerService) {
    this.update= new EventEmitter<string>();
    */
   }

  ngOnInit(): void {
    /*
    if (this.update) {
      // Subscribe to the event emitter to receive an update event
      this.update.subscribe((value: string) => {
          this.getCustomers();
      })
    }
    this.getCustomers();
    */
  }

  /*
  getCustomers() :void {
    console.log("Calling getCustomers");
    this.customerService.getCustomers()
    .subscribe(customers => this.customers = customers);
   }
 */

}
