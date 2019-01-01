/**
 * 
 */
function getBookList(){
	$.get("BookingList",function(data){
		var x = JSON.parse(data);
		//alert(data);
		var array = ["一","二","三","四","五","六","日"];
		if(x.num==0){
			$("#waiting").append("当前没有预约");
			return;
		}else{
			$("#waiting").append("<tr><td>申请人ID</td>" +
					"<td>日期</td><td>时间</td>" +
					"<td>申请理由</td><td></td><td></td></tr>");
			for(var i=0;i<x.num;i++){
				var b = x.booking[i];
				var s = "<tr info='"+JSON.stringify(b)+
					"'>";
				s+="<td>"+b.userid+"</td>";
				s+="<td>第"+b.weekno+"周星期"+array[b.dayno-1]+"</td>";
				s+="<td>第"+b.timeNo+"大节</td>";
				s+="<td>"+b.reason+"</td>";
				s+="<td><button class=\"agree\">同意</button></td>" +
						"<td><button class=\"disagree\">拒绝</button></td></tr>";
				$("#waiting").append(s);
			}
		}
		
	})
}

function se_classroom(){
	$.get("ClassroomId",function(data){
		var x = JSON.parse(data);
		//alert(data);
		
		for(var i=0;i<x.num;i++){
			$("#cr").append("<option>"+x.cr_ids[i]+"</option>");
		}
	})
}
function se_week(){
	for(var i=1;i<=18;i++){
            var s = "<option>第"+i+"周</option>";
            $("#week").append(s);
        }
	//$("#week").append("<option></option>");
    }
function se_day(){
        var array = ["一","二","三","四","五","六","日"];
        for (i in array){
            $("#day").append("<option>"+array[i]+"</option>");
        }
}
function se_time(){
    for(var i=1;i<=6;i++){
        $("#time").append("<option>"+i+"</option>");
    }
}
function agree_booking(){
	$('table').on('click','button.agree',function(){
		//alert("click");
		var dat = JSON.parse($(this).parent().parent().attr('info'));
		dat.bookingtype='借用';
		delete dat.reason;
		dat.timeno = dat.timeNo;
		alert(JSON.stringify(dat));
		$.post("AdminPermit",dat,function(data){
			
		});
	});
}

function refuse_booking(){
	$('table').on('click','button.disagree',function(){
		var dat = JSON.parse($(this).parent().parent().attr('info'));
		dat.timeno = dat.timeNo;
		$.post("AdminRefuse",dat,function(data){
			
		});
	});
}
function GetManageData(){
	var dat = {};
	var array = ["一","二","三","四","五","六","日"];
	dat.crid=$("#cr option:selected").text();
	dat.weekno=Number($("#week option:selected").text()[1]);
	var d=$("#day option:selected").text();
	dat.dayno = array.indexOf(d)+1;
	dat.timeno=Number($("#time option:selected").text());
	dat.userid="2015000000";
	dat.bookingtype="有课";
	
	//alert(JSON.stringify(dat));
	return dat;
}

function GetStateFromScheduleStr(sch,dayno,timeno){
	//alert(sch);
	index = (dayno-1) + (timeno-1)*7;
	return sch[index];
}
function QueryStateClick(){
	$("#query_state").click(function(){
		dat = GetManageData();
		stateArray = ["空闲","有课","借用"];
		$.post("GetSchedule",dat,function(data){
			state = GetStateFromScheduleStr(data,
					dat.dayno,dat.timeno);
			$("#state").text(stateArray[state]);
			$("#update").show();
		});
	});
}

function submit_update(){
	stateArray = ["空闲","有课","借用"];
	$("#update").click(function(){
		var dat = GetManageData();
		method = $("#update_method option:selected").text();
		state = $("#state").text();
		if(method==state){
			alert("您的提交是多余的");
		}
		else{
			//dat JSON 多了2个key：method和now_state,数值String
			dat.method = method;
			dat.now_state = state;
			alert(dat.method);
			$.post("AdminUpdate",dat,function(data){
				alert(data);
			});
			$("#update").hide();
		}
	});
}

$(document).ready(function(){
	$("#update").hide();
    se_week();
    se_day();
    se_time();
    se_classroom();
    getBookList();
    agree_booking();
    refuse_booking();
    QueryStateClick();
    submit_update();
});