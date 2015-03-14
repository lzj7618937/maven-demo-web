$('#goTopBtn').hide();

// 绑定页面滚动事件
$(document).bind('scroll', function() {
	var len = $(this).scrollTop();
	if (len >= 100) {
		// 显示回到顶部按钮
		$('#goTopBtn').show();
	} else {
		// 影藏回到顶部按钮
		$('#goTopBtn').hide();
	}
});

$('#logonButton').on('click', function () {
	alert("fuck");
	$.get("login",function(data,status){
	    alert("Data: " + data + " Status: " + status);
	  });
  });