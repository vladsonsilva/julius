import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ContaExistentePage } from './../conta-existente/conta-existente';
import { DescobrirPerfilPage  } from "./../descobrir-perfil/descobrir-perfil";

/**
 * Generated class for the LoginPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  descobrirPerfil() {
    this.navCtrl.push(DescobrirPerfilPage);
  }

  contaExistente() {
    this.navCtrl.push(ContaExistentePage);
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad LoginPage');
  }
}