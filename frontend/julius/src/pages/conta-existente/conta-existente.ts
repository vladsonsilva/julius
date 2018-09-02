import { ListPage } from './../list/list';
import { GoalsPage } from './../goals/goals';
import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

/**
 * Generated class for the ContaExistentePage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-conta-existente',
  templateUrl: 'conta-existente.html',
})
export class ContaExistentePage {

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  logar(){
    alert("Favor integrar com o Back");

    this.navCtrl.push(GoalsPage);
  }

  esqueciSenha(){
    alert("Favor integrar com o Back");
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ContaExistentePage');
  }

}
