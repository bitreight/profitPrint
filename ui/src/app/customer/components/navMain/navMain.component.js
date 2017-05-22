(function () {
  'use strict';

 var app = angular
    .module('profitPrint')
    .component('navMain', {
      templateUrl: 'app/customer/components/navMain/navMain.html',
      controller: (NavMainController)
    });

  /** @ngInject **/
  function NavMainController($uibModal) {
    var vm = this;

    vm.isCollapsed = true;
    vm.openLoginModal = openLoginModal;
    vm.openRegisterModal = openRegisterModal;

    function openLoginModal() {
      $uibModal.open({
        animation: true,
        ariaLabelledBy: 'modal-title',
        ariaDescribedBy: 'modal-body',
        templateUrl: 'app/customer/components/loginForm/loginForm.html',
        controller: 'LoginController',
        controllerAs: '$ctrl'
      });
    }

    function openRegisterModal() {
      $uibModal.open({
        animation: true,
        ariaLabelledBy: 'modal-title',
        ariaDescribedBy: 'modal-body',
        templateUrl: 'app/customer/components/registerForm/registerForm.html',
        controller: 'RegisterController',
        controllerAs: '$ctrl'
      });
    }
  }
})();
