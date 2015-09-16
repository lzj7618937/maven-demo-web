
$(document).ready(function(){
	initICheckAll();
	initHeaderTripCity();
	
	//$('.email-input').mailAutoComplete();
	
    //qccode
    $("#J_qcCode").click(function () {
        $(this).remove();
    });
    
});

function initICheckAll()
{	
	var input = $(".iCheck");
	
		if( $.isFunction(input.iCheck))
	  	{
			  input.iCheck({
			    	checkboxClass : 'icheckbox_minimal-red',
					radioClass : 'iradio_minimal-red'
			  });
		}

}

function initICheck(obj)
{
	if( $.isFunction(obj.iCheck))
  	{
		  obj.iCheck({
		    	checkboxClass : 'icheckbox_minimal-red',
				radioClass : 'iradio_minimal-red'
		  });
	}
}


//单选框
function radioBtn(obj)
{
	obj = $(obj);
    var sel = obj.data('title');
    var tog = obj.data('toggle');
    $('#'+tog).prop('value', sel);
    
    $('a[data-toggle="'+tog+'"]').not('[data-title="'+sel+'"]').removeClass('active').addClass('notActive');
    $('a[data-toggle="'+tog+'"][data-title="'+sel+'"]').removeClass('notActive').addClass('active');
}

//---------------------------------留言------------------------------------------
//提交留言
//提交留言的表单ID,用于显示每条留言的模版ID,用在显示留言的界面容器节点ID
function submitComment(form, tmplID, ListID)
{
	
	//通过ajax提交留言
	$.ajax({
        cache: true,
        type: "POST",
        url: 'comment/submit',//提交的URL
        data: form.serialize(), // 要提交的表单,必须使用name属性
        async: false,
        success: function (data) {
        	var json = jQuery.parseJSON( data )
         	
        	if(json.length == 0)
        	{
        		$( "#"+ListID ).html("还没有任何留言");
        	}
        	else
        	{
            	$("#"+ListID ).empty()
            	$( "#"+tmplID).tmpl(json).appendTo( "#"+ListID );
        	}

        },
        error: function (request) {
        	$( "#"+ListID ).html("十分抱歉,出现错误。请刷新界面重试。");
           // alert("十分抱歉，现在网络不甚通畅，请重试");
        }
    });
}

//获取留言
//留言类型,留言附属于的主体ID,用于显示每条留言的模版ID,用在显示留言的界面容器节点ID
function getCommentList(type,forID, tmplID, ListID)
{
	
	//已经载入了多少条留言
	var commentNum = $("#"+ListID).children("li").length;
	//载入更多8条
	commentNum = commentNum + 8;
	
	
	$.ajax({
        cache: true,
        type: "POST",
        url: 'comment/list?type='+type+'&for='+forID+'&size='+commentNum,//提交的URL
        async: false,
        success: function (data) {
        	var json = jQuery.parseJSON( data )

        	if(json.length == 0)
        	{
        		$( "#"+ListID ).html("<div style='padding:10px'>还没有任何留言</div>")
        	}
        	else
        	{
            	$("#"+ListID ).empty();
            	$( "#"+tmplID).tmpl(json).appendTo( "#"+ListID );
        	}
        	
        },
        error: function (request) {
        	$( "#"+ListID ).html("十分抱歉,出现错误。请刷新界面重试。");
           // alert("十分抱歉，现在网络不甚通畅，请重试");
        }
    });
}
	
//获取留言数量
//留言类型,留言附属于的主体ID,用于显示留言总数的界面节点ID
function getCommentCount(type,forID,commentCountDivID)
{
		
		$.ajax({
	        cache: true,
	        type: "POST",
	        url: 'comment/count?type='+type+'&for='+forID,//提交的URL
	        async: false,
	        success: function (count) {
	        	return $('#'+commentCountDivID).text(count);
	        },
	        error: function (request) {
	        	$( "#"+ListID ).html("十分抱歉,出现错误。请刷新界面重试。");
	          //  alert("十分抱歉，现在网络不甚通畅，请重试");
	        }
	    });
}

function initHeaderTripCity(){
	//想去的城市
	/*
	$('#trip-place-h').magicSuggest({
		noSuggestionText:"",
		data : 'dest/suggestByName',
		name:'course_dests',
		displayField :'name',
		valueField:'id', 
		toggleOnClick: true,
		hideTrigger: true,
		cls:'search-box-inner',
		editable : true
	});*/
	if($.fn.magicSuggest){
		$('#trip-place-f').magicSuggest({
			noSuggestionText:"",
			data : 'dest/suggestByName',
			name:'course_dests',
			displayField :'name',
			valueField:'id', 
			maxDropHeight: 140,
			toggleOnClick: true,
			editable : true,
		});	
	}
}