(function () {
  'use strict';

    angular
    .module('profitPrint')
      .directive("scroll", scrollDirective)

      function scrollDirective ($window) {
        return function(scope) {
          angular.element($window).bind("scroll", function() {
            scope.boolChangeClass = this.pageYOffset <= 50;
            scope.$apply();
          });
        }
      }
})();
