import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-picture',
  templateUrl: './picture.component.html',
  styleUrls: ['./picture.component.css']
})
export class PictureComponent implements OnInit {

  public Data: Object;

  constructor(private http:HttpClient) { }

  ngOnInit() {
    this.getPics().subscribe(data => this.Data = data)
  }

  getPics() {
    return this.http.get('http://localhost:60150/pic')
  }

}
