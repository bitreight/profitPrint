(function() {
  'use strict';

  angular
    .module('profitPrint')
    .config(routeConfig);

  function routeConfig($stateProvider, $urlRouterProvider) {
    $stateProvider
      .state('customerMain', {
        url: '/',
        templateUrl: 'app/customer/main/main.html',
        controller: 'MainController',
        controllerAs: 'mainCtrl'
      })
      .state('executorMain', {
        url: '/crm',
        templateUrl: 'app/executor/root_crm.html',
        abstract: true
      })
      .state('executorLogin', {
        parent: 'executorMain',
        url: '/login',
        templateUrl: 'app/executor/login/login.html'
      })
      .state('executorRegister', {
        parent: 'executorMain',
        url: '/register',
        templateUrl: 'app/executor/register/register.html'
      });

    $urlRouterProvider.otherwise('/');
  }

})();
