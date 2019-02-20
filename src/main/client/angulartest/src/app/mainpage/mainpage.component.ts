import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {PictureData} from "../models/PictureData";
import {Observable} from "rxjs";

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {

  title = 'angulartest';
  public picturedata : Object;

  constructor(private http:HttpClient) {}

  ngOnInit() {
    this.getPics().subscribe(data => this.picturedata = data);
  }

  getPics() {
    return this.http.get('http://localhost:60150/pic')
  }
}
