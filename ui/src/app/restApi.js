(function () {
  'use strict';

  var baseUrl = {
    service: {
      customer: "http://localhost:5000",
      executor: "http://localhost:9092",
      auth: "http://localhost:9092"
    },
    api: "/api"
  };

  angular
    .module('profitPrint')
    .constant('restApi', {
      login: baseUrl.service.auth + "/auth/login"
    })


})();
