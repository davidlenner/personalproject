import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-space-x',
  templateUrl: './space-x.component.html',
  styleUrls: ['./space-x.component.css']
})
export class SpaceXComponent implements OnInit {

  spaceXData: Object;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getSpaceXData().subscribe(data => this.spaceXData = data )
  }

  getSpaceXData(){
    return this.http.get("http://localhost:60150/spacex")
  }
}
