
function truncateText(text) {

	var shortText = jQuery.trim(text).substring(0, 20).split(" ").slice(0, -1)
			.join(" ")
			+ "...";

	console.log(shortText);
	return shortText;

}

function fnOpenNormalDialog(text) {
	$("#dialog-confirm").html(text);

	// Define the Dialog and its properties.
	$("#dialog-confirm").dialog({
		resizable : false,
		modal : true,
		title : "Modal",
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
	});

}

var app = angular.module('plunker', []);

app.config([
				'$compileProvider',
				function($compileProvider) {
					$compileProvider
							.aHrefSanitizationWhitelist(/^\s*(https?|ftp|mailto|chrome-extension|javascript):/);
					// Angular before v1.2 uses
					// $compileProvider.urlSanitizationWhitelist(...)
				} ]);

app.controller('MainCtrl', function($scope, $http) {

	$http.get('/DataServices-0.0.1-SNAPSHOT/services/crawled/data').success(
			function(response) {

				function chunk(arr, size) {
					var newArr = [];
					for (var i = 0; i < arr.length; i += size) {
						newArr.push(arr.slice(i, i + size));
					}
					return newArr;
				}

				response.modules = chunk(response.modules, 4);

				$scope.ocw = response;

			});

});
