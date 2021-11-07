import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {
  public notify = new BehaviorSubject<any>('');
  notifyObservable$ = this.notify.asObservable();

  public notifyOther(data: any) {
    if (data) {
      this.notify.next(data);
    }
  }
  submit(cust: Customer) {
    console.log("Form submitted", cust);
    this.customerService.postCustomer(cust);
    this.notifyOther("FormSubmitted");

  }

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
  }

}
