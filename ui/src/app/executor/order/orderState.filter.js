(function () {
  'use strict';

  angular
    .module('profitPrint')
    .filter('orderState', orderStateFilter);

  /** @ngInject **/
  function orderStateFilter() {

    return function (state) {
      var stateStr = '';
      switch (state) {
        case 'NEW':
          stateStr = 'Новый';
          break;
        case 'ACCEPTED':
          stateStr = 'В обработке';
          break;
        case 'COMPLETED':
          stateStr = 'Выполнен';
          break;
        case 'REJECTED':
          stateStr = 'Отклонен';
          break;
      }
      return stateStr;
    }
  }

})();
