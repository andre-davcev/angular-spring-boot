import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  standalone: true,
  imports: [CommonModule, RouterModule, ReactiveFormsModule, HttpClientModule],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent implements OnInit {
  public title: string = 'reservations';

  private baseUrl: string = 'http://localhost:8080';
  private reservationUrl: string = `${this.baseUrl}/room/v1/reservation/`

  constructor(private http: HttpClient){}

  public rooms!: Room[];

  public ngOnInit(): void {
    this.rooms = [ new Room("127", "127", "150"),
    new Room("138", "138", "180"),
    new Room("254", "254", "200")
    ];
  }
}

export class Room {
  id: string;
  roomNumber: string;
  price: string;

  constructor(id: string, roomNumber: string, price: string) {
    this.id = id;
    this.roomNumber = roomNumber;
    this.price = price;
  }

}
