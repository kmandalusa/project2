import { Component } from '@angular/core';
import Hotel from './Hotel';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
hotel: Hotel[] = [
    {
    customer_name: 'Drizzt Urden',
    phonenumber: '1234567890',
    daysbooked: '5 Days',
    bookingstatus: 'Booked'
    },
    {
    customer_name: 'Volothamp Geddarm',
    phonenumber: '0987654321',
    daysbooked: '7 Days',
    bookingstatus: 'Booked'
    },
    {
    customer_name: 'Minsc',
    phonenumber: '5555555555',
    daysbooked: '2 Days',
    bookingstatus: 'Not Booked'
    },
    {
    customer_name: 'Jarlaxle Baenrae',
    phonenumber: '877 CASH NOW',
    daysbooked: '28 Days',
    bookingstatus: 'Booked'
    }
  ];

}
