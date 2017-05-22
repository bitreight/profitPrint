(function () {
  'use strict';

  angular
    .module('profitPrint')
    .controller('LoginController', LoginController);

  /** @ngInject **/
  function LoginController($uibModalInstance, LoginService, $log) {
    var vm = this;

    vm.submit = function () {
      LoginService.login({}).$promise.then(function (result) {
        $log.log(result);
      })
    };

    vm.cancel = function () {
      $uibModalInstance.dismiss('cancel');
    };
  }

})();
