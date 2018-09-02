import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { HttpModule } from '@angular/http';

import { ContaExistentePage } from '../pages/conta-existente/conta-existente';
import { DescobrirPerfilPage } from './../pages/descobrir-perfil/descobrir-perfil';
import { GoalsPage } from '../pages/goals/goals';
import { ListPage } from './../pages/list/list';
import { LoginPage} from '../pages/login/login';
import { MyApp } from './app.component';
import { TabsPage } from '../pages/tabs/tabs';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { ProfilePage } from '../pages/profile/profile';
import { RewardsPage } from '../pages/rewards/rewards';

@NgModule({
  declarations: [
    ContaExistentePage,
    DescobrirPerfilPage,
    GoalsPage,
    TabsPage,
    RewardsPage,
    ProfilePage
    ListPage,
    LoginPage,
    MyApp,
    TabsPage
  ],
  imports: [
    BrowserModule,
    HttpModule,
    IonicModule.forRoot(MyApp, { mode: 'ios' }),
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    ContaExistentePage,
    DescobrirPerfilPage,
    GoalsPage,
    TabsPage,
    RewardsPage,
    ProfilePage
    LoginPage,
    ListPage,
    MyApp,
    TabsPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    { provide: ErrorHandler, useClass: IonicErrorHandler }
  ]
})
export class AppModule { }