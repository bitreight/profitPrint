(function () {
  'use strict';

  angular
    .module('profitPrint')
    .factory('LoginService', LoginService);

  /** @ngInject **/
  function LoginService(restConfig, $resource, $log) {
    return $resource(restConfig.loginUrl, null, {
      'login': { method: 'POST', params: {} }
    });
  }
})();
