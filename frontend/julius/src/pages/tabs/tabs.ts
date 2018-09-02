import { Component, ViewChild } from '@angular/core';

import { GoalsPage } from '../goals/goals';
import { RewardsPage } from '../rewards/rewards';

import {Tabs} from 'ionic-angular';
import { ProfilePage } from '../profile/profile';

@Component({
  selector: 'page-tabs',
  templateUrl: 'tabs.html'
})
export class TabsPage {

  @ViewChild("tabs") tabs: Tabs;


  tab1Root = ProfilePage;
  tab2Root = RewardsPage;
  tab3Root = GoalsPage;
  //tab2Root = RewardsPage;
  //tab3Root = GoalsPage;

  constructor() {

  }

  ngAfterViewInit() {
    this.tabs.select(1);
  }
}
