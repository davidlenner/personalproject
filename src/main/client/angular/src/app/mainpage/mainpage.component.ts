import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {

  loadedContent = 'picture';

  constructor() {}

  ngOnInit() {
  }

  changeContent(content: string){
    this.loadedContent = content
  }

}
