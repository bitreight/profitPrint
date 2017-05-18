(function () {
  'use strict';

  angular
    .module('profitPrint')
    .component('navMain', {
      templateUrl: 'app/components/navMain/navMain.html',
      controller: NavMainController
    });

  function NavMainController() {
    this.isCollapsed = true;
  }
})();
