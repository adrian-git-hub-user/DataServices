var app = angular.module('app', []);

app.controller('MainCtrl', function($scope, $http, $location) {

	  var iconDets = new Array();
	  var icon1 = new Object();
	  icon1.title = "tester1";
	  icon1.wikiUrl = "link to wiki page"
	  icon1.compliance = "IE/FF/Chrome"
	  var icon2 = new Object();
	  icon2.title = "tester1";
	  icon2.wikiUrl = "link to wiki page"
	  icon2.compliance = "IE/FF/Chrome"
	  var icon3 = new Object();
	  icon3.title = "tester1";
	  icon3.wikiUrl = "link to wiki page"
	  icon3.compliance = "IE/FF/Chrome"
	  var icon4 = new Object();
	  icon4.title = "tester1";
	  icon4.wikiUrl = "link to wiki page"
	  icon4.compliance = "IE/FF/Chrome"
	  var icon5 = new Object();
	  icon5.title = "tester1";
	  icon5.wikiUrl = "link to wiki page"
	  icon5.compliance = "IE/FF/Chrome"
	  var icon6 = new Object();
	  icon6.title = "tester1";
	  icon6.wikiUrl = "link to wiki page"
	  icon6.compliance = "IE/FF/Chrome"
	  var icon7 = new Object();
	  icon7.title = "tester1";
	  icon7.wikiUrl = "link to wiki page"
	  icon7.compliance = "IE/FF/Chrome"

	  
	  iconDets.push(icon1);
	  iconDets.push(icon2);
	  iconDets.push(icon3);
	  iconDets.push(icon4);
	  iconDets.push(icon5);
	  iconDets.push(icon6);
	  iconDets.push(icon7);

	var i, j, temparray = [], chunk = 4;
	for (i = 0, j = iconDets.length; i < j; i += chunk) {
		temparray.push(iconDets.slice(i, i + chunk));
	}

	$scope.dets = temparray;
	
	var jsonString = JSON.stringify(iconDets);


});
