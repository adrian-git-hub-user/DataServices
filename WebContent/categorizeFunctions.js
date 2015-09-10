
function fnOpenNormalDialog(text, category) {
	$("#textDialog").html(text);

	// Define the Dialog and its properties.
	$("#textDialog").dialog({
		resizable : false,
		modal : true,
		title : category,
		height : 450,
		width : 1000,
		open : function(event, ui) {
			$('#myDialogId').css('overflow', 'hidden'); // this line does the
														// actual hiding
		},
		buttons : {
			"Ok" : function() {
				$(this).dialog('close');
			}
		}
	})

}

function openPage(text, category) {
	$("#textDialog").html(text);

	// Define the Dialog and its properties.
	$("#textDialog").dialog({
		resizable : false,
		modal : true,
		title : category,
		height : 450,
		width : 1000,
		open : function(event, ui) {
			$('#myDialogId').css('overflow', 'hidden'); // this line does the
														// actual hiding
		},
		buttons : {
			"Ok" : function() {
				$(this).dialog('close');
			}
		}
	})

}

function getParameter( name, url ) {
	 
	  name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
	  var regexS = "[\\?&]"+name+"=([^&#]*)";
	  var regex = new RegExp( regexS );
	  var results = regex.exec( url );
	  return results == null ? null : results[1];
	}


var app = angular.module('categorizer', []);

app.config([
				'$compileProvider',
				function($compileProvider) {
					$compileProvider
							.aHrefSanitizationWhitelist(/^\s*(https?|ftp|mailto|chrome-extension|javascript):/);
				} ]);

app.controller('MainCtrl', function($scope, $http, $location) {

	/*alert(getParameter('category' , $location.absUrl()))
		*/
/*	$http.get('/DataServices-0.0.1-SNAPSHOT/services/crawled/data').success(*/
	
	var category = getParameter('category' , $location.absUrl())
	var afterDate = getParameter('afterDate' , $location.absUrl())
	var minutesInPast = getParameter('minutesInPast' , $location.absUrl())
	
	$http.get('./services/crawled/getItems?category='+category+'&afterDate='+afterDate+'&minutesInPast='+minutesInPast).success(
			function(response) {

				function chunk(arr, size) {
					var newArr = [];
					for (var i = 0; i < arr.length; i += size) {
						newArr.push(arr.slice(i, i + size));
					}
					return newArr;
				}

				response.modules = chunk(response.modules, 4);

				$scope.items = response;

			});

});
