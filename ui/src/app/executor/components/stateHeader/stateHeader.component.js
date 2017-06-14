(function () {
  'use strict';

  angular
    .module('profitPrint')
    .component('stateHeader', {
      templateUrl: 'app/executor/components/stateHeader/stateHeader.html',
      controller: StateHeaderController
    });

  /** @ngInject **/
  function StateHeaderController($state) {
    var vm = this;
    var stateName = $state.current.name;

    switch (stateName) {
      case 'executorProfile':
        vm.current = 'Профиль';
        break;
      case 'executorOrders':
        vm.current = 'Список заказов';
        break;
      case 'executorEditOrder':
        vm.current = 'Заказ №' + $state.params.id;
        break;
      case 'executorServices':
        vm.current = 'Услуги';
        break;
      default:
        vm.current = 'Current state';
    }
  }

})();
