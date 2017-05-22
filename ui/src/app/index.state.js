(function() {
  'use strict';

  angular
    .module('profitPrint')
    .config(routeConfig);

  function routeConfig($stateProvider, $urlRouterProvider) {
    $stateProvider
      //customer routes
      .state('customerMain', {
        url: '/',
        templateUrl: 'app/customer/main/main.html',
        controller: 'MainController',
        controllerAs: 'mainCtrl'
      })

      //executor routes
      .state('executorMain', {
        url: '/crm',
        templateUrl: 'app/executor/rootCrm.html',
        abstract: true
      })
      .state('executorLogin', {
        parent: 'executorMain',
        url: '/login',
        templateUrl: 'app/executor/login/loginPage.html'
      })
      .state('executorRegister', {
        parent: 'executorMain',
        url: '/register',
        templateUrl: 'app/executor/register/registerPage.html'
      });

    $urlRouterProvider.otherwise('/');
  }

})();
