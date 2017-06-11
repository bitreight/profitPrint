(function () {
  'use strict';

  angular
    .module('profitPrint')
    .filter('orderPriority', orderPriorityFilter);

  /** @ngInject **/
  function orderPriorityFilter() {

    return function (priority) {
      var priorityStr = '';
      switch (priority) {
        case 'LOW':
          priorityStr = 'Низкий';
          break;
        case 'NORMAL':
          priorityStr = 'Обычный';
          break;
        case 'HIGH':
          priorityStr = 'Высокий';
          break;
      }
      return priorityStr;
    }
  }

})();
