(function () {
  'use strict';

  angular
    .module('profitPrint')
    .controller('ExecutorOrdersController', ExecutorOrdersController);

  /** @ngInject **/
  function ExecutorOrdersController() {
    var vm = this;

    vm.orders = [
      {
        id: 1,
        date: new Date(),
        count: 5,
        customer: 'Вася Пупкин',
        priority: 'NORMAL',
        state: 'NEW'
      },
      {
        id: 3,
        date: new Date(),
        count: 3,
        customer: 'Иван Иванов',
        priority: 'LOW',
        state: 'NEW'
      },
      {
        id: 25,
        date: new Date(),
        count: 1,
        customer: 'Петр Петров',
        priority: 'NORMAL',
        state: 'REJECTED'
      },
      {
        id: 15,
        date: new Date(),
        count: 2,
        customer: 'Алексей Курчевский',
        priority: 'HIGH',
        state: 'ACCEPTED'
      },
      {
        id: 26,
        date: new Date(),
        count: 4,
        customer: 'Александр Васильев',
        priority: 'HIGH',
        state: 'COMPLETED'
      }
    ];
  }

})();
