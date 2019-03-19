import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-mainpage',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  loadedContent = 'picture';

  constructor() {}

  ngOnInit() {
  }

  changeContent(content: string){
    this.loadedContent = content;
  }

}
