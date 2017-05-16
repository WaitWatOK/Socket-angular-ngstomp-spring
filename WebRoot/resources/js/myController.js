'use strict';
//angular模块化
var myapp = angular.module('myindex',['myApp.services']).run(['$http','$rootScope', 'ngstomp',function($http,$rootScope,ngstomp){
	
	//创建socket
	$rootScope.client = ngstomp('/SocketDemo/watpoint');
	//socket连接
	$rootScope.client.connect('guest', 'guest',function(frames){
		$rootScope.client.subscribe('/app/firstconn',function(message){
			console.warn(message);
			$rootScope.msgfromServer = message.body;
		});
		$rootScope.client.subscribe('/queue/greetings',function(message){
			console.error(message);
			$rootScope.msgfromServer = message.body;
		});
		$rootScope.client.subscribe('/user/queue/personalgreetings',function(message){
			console.error(message);
			$rootScope.personalmsgfromServer = message.body;
		});
	},function(frames){
		console.error(frames);
	});
	
	$rootScope.sendmsg = function(){
		if($rootScope.message == "") return ;
		$rootScope.client.send('/app/processMsg', {}, $rootScope.message);
		$rootScope.message = "";
	}
	
}]);