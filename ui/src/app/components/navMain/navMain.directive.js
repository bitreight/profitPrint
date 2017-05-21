(function () {
  'use strict';

    angular
    .module('profitPrint')
    .directive("scroll", scrollDirective);

      function scrollDirective ($window) {
      return function(scope) {
        angular.element($window).bind("scroll", function() {
          if (this.pageYOffset > 50) {
            scope.boolChangeClass = false;
          } else {
            scope.boolChangeClass = true;
          }
          scope.$apply();
        });
      }
      }
})();
