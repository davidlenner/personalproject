import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-joke',
  templateUrl: './joke.component.html',
  styleUrls: ['./joke.component.css']
})
export class JokeComponent implements OnInit {

  constructor(private http:HttpClient) { }

  jokes: Object;

  ngOnInit() {
    this.getJokes().subscribe(data => this.jokes = data)
  }

  getJokes() {
    return this.http.get('/joke')
  }
}
