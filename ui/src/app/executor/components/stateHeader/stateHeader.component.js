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
    vm.current = $state.current.name;
  }

})();
