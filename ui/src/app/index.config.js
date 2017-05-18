(function() {
  'use strict';

  angular
    .module('profitPrint')
    .config(config);

  /** @ngInject */
  function config($logProvider) {
    // Enable log
    $logProvider.debugEnabled(true);
  }

})();
