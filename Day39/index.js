angular.module("AppMod", ["ngRoute"])
	.controller("AppCtrl", ['$http','$routeParams', function($http, $routeParams) {
 		var self = this;
		
		self.id = $routeParams.studentID;

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

 			},function(err) {
 
 			});
			
		$http.get('http://localhost:8080/student/'+ self.id)
		.then(function(resp) {
			self.student = resp.data;
		},function(err) {
			
		});
 
 	}])
 	.config(['$routeProvider', function($routeProvider) {
 
 		$routeProvider
 		.when('/', {
 			templateUrl: 'views/home.view.html'
			
		}).when('/student/:studentID', {
 			templateUrl: 'views/detail.view.html',
 			controller: 'AppCtrl',
 			controllerAs: 'ctrl'

 		}).when('/student', {
 			templateUrl: 'views/student.view.html',
 			controller: 'AppCtrl',
 			controllerAs: 'ctrl'
 
 		}).when('/about', {
 			templateUrl: 'views/about.view.html'
 
 		})
 		.otherwise({redirectTo: '/'});
		
		
 
 	}]); 