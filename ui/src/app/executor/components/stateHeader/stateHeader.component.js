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
        vm.current = 'Мой профиль';
        break;
      default:
        vm.current = 'Current state';
    }
  }

})();
