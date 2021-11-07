import { Component, EventEmitter, Input, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
   customers : Customer[] = [];
   @Input() update: EventEmitter<string>;
  constructor(private customerService : CustomerService) {
    this.update= new EventEmitter<string>();
   }

  ngOnInit(): void {
    if (this.update) {
      // Subscribe to the event emitter to receive an update event
      this.update.subscribe((value: string) => {
          this.getCustomers();
      })
    }
    this.getCustomers();
  }
 
  getCustomers() :void {
    console.log("Calling getCustomers");
    this.customerService.getCustomers()
    .subscribe(customers => this.customers = customers);
   }
  
}
