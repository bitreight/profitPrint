(function () {
  'use strict';

  angular
    .module('profitPrint')
    .controller('RegisterExecutorController', RegisterExecutorController);

  /** @ngInject */
  function RegisterExecutorController() {
    var vm = this;

    vm.password = '';
    vm.passwordConfirm = '';
  }

})();
