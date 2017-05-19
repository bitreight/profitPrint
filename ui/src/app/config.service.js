(function () {
  'use strict';

  angular
    .module('profitPrint')
    .constant('restConfig', {
      "baseExecutorRestUrl": "http://localhost:9092/api",
      "baseCustomerRestUrl": "http://localhost:5000/api",
      "loginUrl": "http://localhost:9092/auth/login"
    })
})();
