import { Component } from '@angular/core';

import { GoalsPage } from '../goals/goals';

@Component({
  selector: 'page-tabs',
  templateUrl: 'tabs.html'
})
export class TabsPage {

  tab1Root = GoalsPage;

  constructor() {

  }
}
