(function () {
  'use strict';

  angular
    .module('profitPrint')
    .controller('RegisterController', RegisterController);

  /** @ngInject */
  function RegisterController($uibModalInstance) {
    var vm = this;

    vm.cancel = function () {
      $uibModalInstance.dismiss('cancel');
    };
  }

})();
