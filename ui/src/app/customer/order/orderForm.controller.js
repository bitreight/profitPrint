(function() {
  'use strict';

  angular
    .module('profitPrint')
    .controller('CustomerOrderFormController', CustomerOrderFormController);

  /** @ngInject */
  function CustomerOrderFormController($scope) {
    $scope.popup2 = {
      opened: false
    };

    $scope.open2 = function() {
      $scope.popup2.opened = true;
    };
  }
})();
