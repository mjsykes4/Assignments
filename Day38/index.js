angular.module("AppMod", ["ngRoute"])
 	.controller("AppCtrl", ['$http', function($http) {
 		var self = this;
		
		self.changeAbout = function(parm1) {
			self.about = "AngularJS" + parm1;
			
		};
		self.Refresh = function() {
			for ( var student of self.students) {
				student.vis=true;
			}
		}
 
 		$http.get('http://localhost:8080/student')
 			.then(function(resp){
 				self.students = resp.data;
				for (student of self.students) {
				student.vis = true;}
	//			}
 			},function(err) {
 
 			});
 
 	}])
 	.config(['$routeProvider', function($routeProvider) {
 
 		$routeProvider
 		.when('/', {
 			templateUrl: 'views/home.view.html'
 
 		}).when('/student', {
 			templateUrl: 'views/student.view.html',
 			controller: 'AppCtrl',
 			controllerAs: 'ctrl'
 
 		}).when('/about', {
 			templateUrl: 'views/about.view.html'
 
 		})
 		.otherwise({redirectTo: '/'});
		
		
 
 	}]); // end config 