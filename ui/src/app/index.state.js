(function() {
  'use strict';

  angular
    .module('profitPrint')
    .config(routeConfig);

  function routeConfig($stateProvider, $urlRouterProvider) {
    var customerPrefix = 'app/customer/';
    var executorPrefix = 'app/executor/';

    $stateProvider
      //customer routes
        .state('customer', {
        url: '/',
        templateUrl: customerPrefix + 'main/main.html',
        controller: 'MainController',
        controllerAs: 'mainCtrl'
      })

      //executor routes
      .state('executor', {
        url: '/crm',
        templateUrl: executorPrefix + 'rootCrm.html',
        redirectTo: 'executorOrders'
      })
      .state('executorLogin', {
        parent: 'executor',
        url: '/login',
        templateUrl: executorPrefix + 'login/loginPage.html'
      })
      .state('executorRegister', {
        parent: 'executor',
        url: '/register',
        templateUrl: executorPrefix + 'register/registerPage.html'
      })
      .state('executorMenu', {
        parent: 'executor',
        abstract: true,
        templateUrl: executorPrefix + 'dashboard/dashboard.html'
      })
      .state('executorProfile', {
        parent: 'executorMenu',
        url: '/profile',
        controller: 'ExecutorProfileController',
        controllerAs: 'ExProfileCtrl',
        templateUrl: executorPrefix + 'profile/profile.html'
      })
      .state('executorOrders', {
        parent: 'executorMenu',
        url: '/order',
        templateUrl: executorPrefix + 'order/orders.html',
        controller: 'ExecutorOrdersController',
        controllerAs: 'exOrdersCtrl'
      })
      .state('executorEditOrder', {
        parent: 'executorMenu',
        url: '/order/:id',
        templateUrl: executorPrefix + 'order/edit/editOrder.html'
      })
     .state('customerPriceList', {
        controller: 'PriceListController',
        controllerAs: 'priceListCtrl',
        url: '/price',
        templateUrl: customerPrefix + 'priceList/priceList.html'
      });

    $urlRouterProvider.otherwise('/');
  }

})();
