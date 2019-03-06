import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @Output() selected = new EventEmitter<string>();

  constructor() { }

  ngOnInit() {
  }

  OnSelect(selectedItem: string){
    this.selected.emit(selectedItem)

  }

}
