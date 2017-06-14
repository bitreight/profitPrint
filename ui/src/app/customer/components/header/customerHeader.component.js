(function () {
  'use strict';

  angular
    .module('profitPrint')
    .component('customerHeader', {
      templateUrl: 'app/customer/components/header/customerHeader.html',
      controller: (CustomerHeaderController)
    });

  /** @ngInject **/
  function CustomerHeaderController($state) {
    var vm = this;
    var stateName = $state.current.name;

    switch (stateName) {
      case 'customerNewOrderForm':
        vm.current = 'Новый заказ';
        break;
      default:
        vm.current = 'Current state';
    }
  }
})();
