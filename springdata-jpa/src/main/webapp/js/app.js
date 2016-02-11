var myApp = angular.module("myApp",[]);

myApp.directive("myTestData",function(){
	return {
	    template: 'test data directive'
	  };
});



myApp.factory("myFactory",function(){
	var name = "test";
	var service = {};
	service.getName = function(){
		return name;
	}
	return service;
});

myApp.service("myService",function(){
	var name = "test12345";
	var service = {};
	this.getName = function(){
		return name;
	}
});


myApp.controller("myController",function($scope,myFactory,myService){
	$scope.msg = "hello world 123";
	$scope.counter = 0;
	$scope.name = myFactory.getName();
	$scope.newName = myService.getName();
	$scope.$watch("name",function(newValue,oldValue){
		console.log("new value : "+newValue);
		console.log("old value : "+oldValue);
		$scope.counter +=1;
	});
});

myApp.controller("testController",function($scope){
	$scope.name = "qwerty";
	$scope.newName = "qwerty 1234";
	$scope.format = 'M/d/yy h:mm:ss a';
});

myApp.directive("myTestDataHtml",function(){
	return {
	    templateUrl: 'html/test.html'
	  };
});

myApp.directive('myCurrentTime', ['$interval', 'dateFilter', function($interval, dateFilter) {

	  function link(scope, element, attrs) {
	    var format,
	        timeoutId;

	    function updateTime() {
	      element.text(dateFilter(new Date(), format));
	    }

	    scope.$watch(attrs.myCurrentTime, function(value) {
	      format = value;
	      updateTime();
	    });

	    element.on('$destroy', function() {
	      $interval.cancel(timeoutId);
	    });

	    // start the UI update process; save the timeoutId for canceling
	    timeoutId = $interval(function() {
	      updateTime(); // update DOM
	    }, 1000);
	  }

	  return {
	    link: link
	  };
	}]);
