(function($){
     var longPolling = function(url, callback) {
         $.ajax({
             url: url,
             async: true,
             cache: false,
             global: false,
             timeout: 30 * 1000,
             dataType : "json",
             success: function (data, status, request) {
                 callback(data);
                 data = null;
                 status = null;
                 request = null;
                 setTimeout(
                     function () {
                         longPolling(url, callback);
                     },
                     10
                 );
             },
             error: function (xmlHR, textStatus, errorThrown) {
                 xmlHR = null;
                 textStatus = null;
                 errorThrown = null;

                 setTimeout(
                     function () {
                         longPolling(url, callback);
                     },
                     30 * 1000
                 );
             }
         });
     };
	
     var startPolling=function(){
 		
 	    var pollingUrl = "admin/polling";
 		longPolling(pollingUrl, function(data) {
             if(data) {
             	console.dir(data);
                 if(data.unreadMessageCount) {
                     //message.update(data.unreadMessageCount);
                 }
                 if(data.notifications) {
                     //notification.update(data.notifications);
                 }
             }
         });
 	 };
	
		var initTripCity = function(){
			//想去的城市
			$('#trip-place').magicSuggest({
				noSuggestionText:"",
				data : 'dest/suggestByName',
				name:'course_dests',
				displayField :'name',
				valueField:'id', 
				editable : true,
			});
			
			
			$('#trip-place-m').magicSuggest({
				noSuggestionText:"",
				data : 'dest/suggestByName',
				name:'course_dests',
				displayField :'name',
				valueField:'id', 
				editable : true,
			});
		};
		
 	 
	$(function(){
		initTripCity();
	});
})(jQuery);