(function () {
  'use strict';

  angular
    .module('profitPrint')
    .component('leftMenu', {
      templateUrl: 'app/customer/components/leftMenu/leftMenu.html',
      controller: (LeftMenuController)
    });

  /** @ngInject **/
  function LeftMenuController() {}
})();
