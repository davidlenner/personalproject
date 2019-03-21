import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-picture',
  templateUrl: './picture.component.html',
  styleUrls: ['./picture.component.css']
})
export class PictureComponent implements OnInit {

  picData: Object;
  picUrl: Config;

  constructor(private http: HttpClient,private sanitizer: DomSanitizer) {
  }

  ngOnInit() {
    this.sendPicData();
  }

  getPicsTitle() {
    return this.http.get('/pictitle');
  }

  sendPicData() {
    this.getPicsTitle().subscribe(data => this.picData = data);
    this.getPicUrl().subscribe(data => this.picUrl = {
      url: data['url']
    });
  }

  getPicUrl() {
    return this.http.get('/pic');
  }

  photoURL() {
    return this.sanitizer.bypassSecurityTrustResourceUrl(this.picUrl.url);
  }
}

export interface Config {
  url: string;
}
