(function () {
  'use strict';

  angular
    .module('profitPrint')
    .controller('LoginController', LoginController);

  /** @ngInject **/
  function LoginController($uibModalInstance, LoginService, $log) {
    var vm = this;

    vm.submit = function () {
      LoginService.post({}, function (result) {
        $log.log(result);
      });
    };

    vm.cancel = function () {
      $uibModalInstance.dismiss('cancel');
    };
  }

})();
