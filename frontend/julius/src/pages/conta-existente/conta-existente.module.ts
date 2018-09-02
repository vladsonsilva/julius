import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ContaExistentePage } from './conta-existente';

@NgModule({
  declarations: [
    ContaExistentePage,
  ],
  imports: [
    IonicPageModule.forChild(ContaExistentePage),
  ],
})
export class ContaExistentePageModule {}
