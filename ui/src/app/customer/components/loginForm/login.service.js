(function () {
  'use strict';

  angular
    .module('profitPrint')
    .factory('LoginService', LoginService);

  /** @ngInject **/
  function LoginService(restApi, $resource, $log) {
    return $resource(restApi.login, null, {
      'login': { method: 'POST', params: {} }
    });
  }
})();
