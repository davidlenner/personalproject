import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainPageComponent } from './mainpage/main-page.component';
import { HeaderComponent } from './header/header.component';
import { PictureComponent } from './picture/picture.component';
import { JokeComponent } from './joke/joke.component';
import { SpaceXComponent } from './space-x/space-x.component';

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    HeaderComponent,
    PictureComponent,
    JokeComponent,
    SpaceXComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
