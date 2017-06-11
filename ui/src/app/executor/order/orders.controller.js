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
        id: '0001',
        date: new Date(),
        count: 5,
        customer: 'Вася Пупкин',
        priority: 'NORMAL',
        state: 'NEW'
      },
      {
        id: '0002',
        date: new Date(),
        count: 3,
        customer: 'Иван Иванов',
        priority: 'LOW',
        state: 'NEW'
      },
      {
        id: '0025',
        date: new Date(),
        count: 1,
        customer: 'Петр Петров',
        priority: 'NORMAL',
        state: 'REJECTED'
      },
      {
        id: '0015',
        date: new Date(),
        count: 2,
        customer: 'Алексей Курчевский',
        priority: 'HIGH',
        state: 'ACCEPTED'
      },
      {
        id: '0026',
        date: new Date(),
        count: 4,
        customer: 'Александр Васильев',
        priority: 'HIGH',
        state: 'COMPLETED'
      }
    ];
  }

})();
