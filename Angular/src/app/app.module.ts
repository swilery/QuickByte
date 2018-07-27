import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { MediaPostComponent } from './components/media-post/media-post.component';

import { approutes } from './routing';
import { HomePageComponent } from './components/homepage/homepage.component';
import { LoginPageComponent } from './components/loginpage/loginpage.component';
import { SignupPageComponent } from './components/signuppage/signuppage.component';
import { ErrorPage404Component } from './components/errorpage404/errorpage404.component';

import { APP_BASE_HREF } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    MediaPostComponent,
    HomePageComponent,
    LoginPageComponent,
    SignupPageComponent,
    ErrorPage404Component
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(approutes)
  ],
  providers: [{provide: APP_BASE_HREF, useValue : 'QuickByte'}],
  bootstrap: [AppComponent]
})
export class AppModule { }