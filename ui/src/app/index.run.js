(function() {
  'use strict';

  angular
    .module('profitPrint')
    .run(runBlock);

  /** @ngInject */
  function runBlock($log) {

    $log.debug('runBlock end');
  }

})();
