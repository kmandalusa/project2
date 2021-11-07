import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Customer } from './customer';
import { catchError, map, tap } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  // static getCustomers() {
  //   throw new Error('Method not implemented.');
  // }

  httpOptions = {
    headers: new HttpHeaders({'Content-type': 'application/json'})
  };

  private baseUrl = "http://localhost:8090";

  constructor( private http: HttpClient,) {  }

  private log(message: string) {
    console.log(`CustomerService: ${message}`);
  }
  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.baseUrl+"/customers")
    .pipe(
      tap(_ => this.log('fetched customers')),
      catchError(this.handleError<Customer[]>('getCustomers', []))
    );
    
  }

  postCustomer(cust: Customer) {
    return this.http.post(this.baseUrl+"/customers", cust)
    .subscribe(status=> console.log(JSON.stringify(status))); 
  }

  
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
