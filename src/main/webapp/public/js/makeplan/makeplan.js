//定义全局变量
// 删除对话框变量定义
var __dataId = ""; //删除的ID
var __dealType = ""; //删除的类型

/**
 * 对Date的扩展，将 Date 转化为指定格式的String
 * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 * eg:
 * (new Date()).pattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
 * (new Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04
 * (new Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04
 * (new Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04
 * (new Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
 */
Date.prototype.pattern = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, //小时
        "H+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    var week = {
        "0": "/u65e5",
        "1": "/u4e00",
        "2": "/u4e8c",
        "3": "/u4e09",
        "4": "/u56db",
        "5": "/u4e94",
        "6": "/u516d"
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    if (/(E+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f" : "/u5468") : "") + week[this.getDay() + ""]);
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
}

//03月20日&nbsp;星期五 字符串转日期格式，strDate要转为日期格式的字符串
function getDate(strDate) {
    var myDate = new Date();
    var year = myDate.getYear();
    var a = strDate.split("月");
    var month = parseInt(a[0]) - 1;
    var day = a[1].split("日")[0];
    var date = new Date(year, month, day);
    return date;
}

(function (factory) {
    if (typeof define === "function" && define.amd) {

        // AMD. Register as an anonymous module.
        define(["jquery.ui.datepicker"], factory);
    } else {

        // Browser globals
        factory(jQuery.datepicker);
    }
}

(function (datepicker) {
    datepicker.regional['zh-TW'] = {
        closeText: '關閉',
        prevText: '&#x3C;上月',
        nextText: '下月&#x3E;',
        currentText: '今天',
        monthNames: ['一月', '二月', '三月', '四月', '五月', '六月',
            '七月', '八月', '九月', '十月', '十一月', '十二月'
        ],
        monthNamesShort: ['一月', '二月', '三月', '四月', '五月', '六月',
            '七月', '八月', '九月', '十月', '十一月', '十二月'
        ],
        dayNames: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
        dayNamesShort: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
        dayNamesMin: ['日', '一', '二', '三', '四', '五', '六'],
        weekHeader: '周',
        dateFormat: 'mm月dd日 DD',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: true,
        yearSuffix: '年'
    };
    datepicker.setDefaults(datepicker.regional['zh-TW']);

    return datepicker.regional['zh-TW'];

}));

//处理备注字数
function words_deal() {
    var maxNum = 2000;
    var curLength = $("#dlg1 .b_dialog .js_content .e_dialog_ct .textarea_wrapper .text_ct .js_textarea").val().length;
    if (curLength > maxNum) {
        var num = $("#dlg1 .b_dialog .js_content .e_dialog_ct .textarea_wrapper .text_ct .js_textarea").val().substr(0, maxNum);
        $("#dlg1 .b_dialog .js_content .e_dialog_ct .textarea_wrapper .text_ct .js_textarea").val(num);
        alert("超过字数限制，多出的字将被截断！");
    }
    else {
        $("#dlg1 .b_dialog .js_content .e_dialog_ct .textarea_wrapper .font_counter .current").text(maxNum - $("#dlg1 .b_dialog .js_content .e_dialog_ct .textarea_wrapper .text_ct .js_textarea").val().length);
    }
}

//编辑标题
function edit_icon_click() {
    var title = $(".trip_top_box .trip_top_inner .trip_title_box .title_wrap h1").text();
    $(".trip_top_box .trip_top_inner .trip_title_box .title_input_box_wrap .title_input_box .title_input").val(title);
    $(".trip_top_box .trip_top_inner .trip_title_box .title_wrap").css("display", "none");
    $(".trip_top_box .trip_top_inner .trip_title_box .title_input_box_wrap").css("display", "block");
}

//取消编辑标题
function cancel_btn_click() {
    $(".trip_top_box .trip_top_inner .trip_title_box .title_wrap").css("display", "block");
    $(".trip_top_box .trip_top_inner .trip_title_box .title_input_box_wrap").css("display", "none");
}

//确定编辑标题
function confrim_btn_click() {
    var title = $(".trip_top_box .trip_top_inner .trip_title_box .title_input_box_wrap .title_input_box .title_input").val();
    $(".trip_top_box .trip_top_inner .trip_title_box .title_wrap h1").html(title);
    $(".trip_top_box .trip_top_inner .trip_title_box .title_wrap").css("display", "block");
    $(".trip_top_box .trip_top_inner .trip_title_box .title_input_box_wrap").css("display", "none");
}

//显示景点操作按钮
function showDayOp(obj) {
    $(obj).find(".d_text").removeClass("hide");
}

//隐藏景点操作按钮
function hideDayOp(obj) {
    $(obj).find(".d_text").addClass("hide");
}

//左侧天选择鼠标hover事件
function showNodeBox(obj) {
    $(obj).addClass("day_info_hover");
}

//左侧天选择鼠标hover事件
function hideNodeBox(obj) {
    $(obj).removeClass("day_info_hover");
}

function showDayElementNode(obj) {
    $(obj).addClass("day_element_node_hover");
}

function hideDayElementNode(obj) {
    $(obj).removeClass("day_element_node_hover");
}

function showDayMoveList(obj) {
    $(obj).parents(".day_option_box").find(".day_move_list").css("display", "block");
}

function hideDayMoveList(obj) {
    $(obj).css("display", "none");
}

function showDayMemo(obj) {
    $(obj).parents(".day_memo_box").find(".day_memo_ph").css("display", "none");
}

function hideDayMemo(obj) {
    var str = $(obj).val();
    if (str == "")
        $(obj).parents(".day_memo_box").find(".day_memo_ph").css("display", "block");
}

//显示删除对话框
function showDelConfirmDlg(obj) {
    //删除按钮事件
    $("#del_confirm_dlg").css("display", "block");
}

//获得总天数
function getTotalDayCount() {
    return $(".main_day_info").size();
}

//补充移动到第几天的个数
function showDayMoveListInner() {
    $(".day_move_list_inner").each(function (i) {
        var innerHtml = "";
        $(this).html(innerHtml);
        for (var i = 0; i < getTotalDayCount(); i++) {
            innerHtml += "<li class='day_item' data-order='" + i + "'><a href='javascript:;'>第" + (i + 1) + "天</a></li>";
        }
        $(this).html(innerHtml);
    });
}

//显示添加备注背景
function showEleMemo(obj) {
    $(obj).addClass("ele_hover_yellow");
}

//隐藏添加备注背景
function hideEleMemo(obj) {
    $(obj).removeClass("ele_hover_yellow");
}

//显示备注框
function showMemoDlg(obj) {
    var memoText = $(obj).parents(".day_element_node").find(".js_edit_memo").html();
    if (memoText == "点击添加备注") {
        $("#dlg1 .b_dialog .js_content .e_dialog_ct .textarea_wrapper .text_ct .js_textarea").val("");
    } else {
        $("#dlg1 .b_dialog .js_content .e_dialog_ct .textarea_wrapper .text_ct .js_textarea").val(memoText);
    }
    //删除按钮事件
    $("#dlg1").css("display", "block");
}

//更新左边天的顺序
function updateMainDayInfo() {
    $(".main_day_info").each(function (i) {
        var index = i + 1;
        $(this).attr("data-order", i);
        $(this).find(".icon").eq(0).text("D" + index);
    });
}

//更新景点顺序
function updateDayElementNode() {
    $(".day_element_node").each(function (i) {
        var index = i + 1;
        $(this).find(".poi_idx").attr("data-idx", i);
        $(this).find(".poi_idx").text(pad(index, 2));
    });
}

//更新选择天样式
function showSelectDay(obj){
    $("#sch_tree .day_info").each(function(i){
        $(this).removeClass("day_info_selected");
    });
    $(obj).addClass("day_info_selected");
}

/* 质朴长存法 左补0 */
function pad(num, n) {
    var len = num.toString().length;
    while (len < n) {
        num = "0" + num;
        len++;
    }
    return num;
}

//初始化景点事件
function initDayElementNode() {
    showDayMoveListInner();

    //初始化日期选择控件
    $("#datepicker").datepicker({
        showOn: "button",
        buttonImage: "public/images/date.gif",
        buttonImageOnly: true,
        altField: ".date_ct",
        buttonText: "选择日期",
        onSelect: function (dateText, inst) {
            $("#day_order_info_box .day_order_date .date_ct .js_show_calc").html(dateText);
        }
    });

    $("#day_element_list").find(".day_element_node").bind("mouseover", function () {
        //显示操作选择div
        showDayElementNode(this);
    }).bind("mouseout", function () {
        //隐藏操作选择div
        hideDayElementNode(this);
    });

    $("#day_element_list .day_element_node .day_option_box").find(".js_move").bind("mouseenter", function () {
        //显示操作选择div
        showDayMoveList(this);
    });

    //景点删除按钮事件绑定
    $("#day_element_list .day_element_node .day_option_box").find(".js_del").bind("click", function () {
        __dataId = $(this).parents(".day_element_node").attr("data-id");
        __dealType = "day_element_node";
        //显示操作选择div
        showDelConfirmDlg(this);
    });

    //景点编辑按钮事件绑定
    $("#day_element_list .day_element_node .day_option_box").find(".js_edit").bind("click", function () {
        __dataId = $(this).parents(".day_element_node").attr("data-id");
        __dealType = "day_element_node";
        //显示操作选择div
        showMemoDlg(this);
    });

    //景点编辑按钮事件绑定
    $("#day_element_list .day_element_node .element_inner").find(".js_edit_memo").bind("click", function () {
        __dataId = $(this).parents(".day_element_node").attr("data-id");
        __dealType = "day_element_node";
        //显示操作选择div
        showMemoDlg(this);
    }).bind("mouseover", function () {
            showEleMemo(this);
        }
    ).bind("mouseout", function () {
            hideEleMemo(this);
        }
    );

    $("#day_element_list .day_element_node .day_option_box").find(".day_move_list").bind("mouseleave", function () {
        //显示操作选择div
        hideDayMoveList(this);
    });

    $("#day_detail_out_box .day_detail_box").find(".day_memo").bind("click", function () {
        //显示操作选择div
        showDayMemo(this);
    }).bind("mouseout", function () {
        //隐藏操作选择div
        hideDayMemo(this);
    });

    //$(".del_confirm_inner").dialog({
    //    autoOpen: false,
    //    resizable: false,
    //    modal: true,
    //    buttons: {
    //        "确定": function () {
    //            if (__dealType == "day_element_node") {
    //                //可以添加ajax方法，提交到后台
    //                $("#day_element_list .day_element_node[data-id=" + __dataId + "]").remove();
    //            }
    //            $(this).dialog("close");
    //        },
    //        "取消": function () {
    //            $(this).dialog("close");
    //        }
    //    }
    //});

    //拖动早点
    $("#day_element_list").sortable({
        zIndex: 0,
        update: function () {
            updateDayElementNode();
        }
    });
    $("#day_element_list").disableSelection();
}

function addMainDayInfo(obj) {
    var mainDayInfoHtml = "";
    mainDayInfoHtml += "<div class='main_day_info' data-id='299914' data-order='1'>";
    mainDayInfoHtml += "<div class='node_box day_info'>";
    mainDayInfoHtml += "<div class='d_info'>";
    mainDayInfoHtml += "<div class='icon'>D1</div>";
    mainDayInfoHtml += "<div class='d_text'>";
    mainDayInfoHtml += "<div class='city_info'>";
    mainDayInfoHtml += "<em class='city' data-id='299914' data-type='6'>北京</em>";
    mainDayInfoHtml += "</div>";
    mainDayInfoHtml += "<div class='date_info'>";
    mainDayInfoHtml += "<span class='txt'>03月20日&nbsp;星期五</span>";
    mainDayInfoHtml += "</div>";
    mainDayInfoHtml += "</div>";
    mainDayInfoHtml += "<div class='del_icon'></div>";
    mainDayInfoHtml += "</div>";
    mainDayInfoHtml += "</div>";
    mainDayInfoHtml += "<div class='node_box day_op'>";
    mainDayInfoHtml += "<div class='d_info'>";
    mainDayInfoHtml += "<div class='icon'></div>";
    mainDayInfoHtml += "<div class='d_text hide'>添加一天</div>";
    mainDayInfoHtml += "</div>";
    mainDayInfoHtml += "</div>";
    mainDayInfoHtml += "</div>";
    $(obj).parents(".main_day_info").after(mainDayInfoHtml);
}

//初始化左侧操作事件
function initNodeBox() {

    //使用on方法绑定事件，这样未来js创建的元素也同样会绑定

    //绑定插入一天显示
    $(document).on("mouseover", "#sch_tree .day_op", function () {
        //显示操作选择div
        showDayOp(this);
    }).on("mouseout", "#sch_tree .day_op", function () {
        //隐藏操作选择div
        hideDayOp(this);
    }).on("click", "#sch_tree .day_op", function () {
        addMainDayInfo(this);
    });

    //显示选择天
    $(document).on("mouseover", "#sch_tree .day_info", function () {
        //显示操作选择div
        showNodeBox(this);
    }).on("mouseout", "#sch_tree .day_info", function () {
        //隐藏操作选择div
        hideNodeBox(this);
    }).on("click","#sch_tree .day_info",function(){
        //添加选择天样式
        showSelectDay(this)
    });

    //绑定天删除按钮事件绑定
    $(document).on("click", "#sch_tree .day_info .d_info .del_icon", function () {
        __dataId = $(this).parents(".main_day_info").attr("data-id");
        __dealType = "day_info";
        //显示操作选择div
        showDelConfirmDlg(this);
    });

    //拖动天
    $("#sch_tree").sortable({
        zIndex: 0,
        update: function () {
            updateMainDayInfo();
        }
    });
    $("#sch_tree").disableSelection();

}

function initDlg() {
    //删除对话框事件
    //取消按钮
    $("#del_confirm_dlg .del_confirm_inner .buttons .cancel").bind("click", function () {
        //删除按钮事件
        $("#del_confirm_dlg").css("display", "none");
    });
    //确定按钮
    $("#del_confirm_dlg .del_confirm_inner .buttons .confirm").bind("click", function () {
        //删除按钮事件
        if (__dealType == "day_element_node") {
            //可以添加ajax方法，提交到后台
            $("#day_element_list .day_element_node[data-id=" + __dataId + "]").remove();
            updateDayElementNode();
        } else if (__dealType == "day_info") {
            $("#sch_tree .main_day_info[data-id=" + __dataId + "]").remove();
            showDayMoveListInner();
            updateMainDayInfo();
        }
        $("#del_confirm_dlg").css("display", "none");
    });

    //景点备注事件
    //取消按钮
    $("#dlg1 .b_dialog .js_content .e_dialog_ft .js_close").bind("click", function () {
        $("#dlg1").css("display", "none");
    });
    //确定按钮
    $("#dlg1 .b_dialog .js_content .e_dialog_ft .js_save").bind("click", function () {
        var text = $("#dlg1 .b_dialog .js_content .e_dialog_ct .textarea_wrapper .text_ct .js_textarea").val();
        $("#day_element_list .day_element_node[data-id='" + __dataId + "']").find(".js_edit_memo").html(text);
        $("#dlg1").css("display", "none");
    });
}

function init() {
    initDayElementNode();
    initNodeBox();
    initDlg();
}

//绑定各控件的事件
$(function () {
    init();
});
