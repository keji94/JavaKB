$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'qrtzfiredtriggers/list',
        datatype: "json",
        colModel: [			
			{ label: 'schedName', name: 'schedName', index: 'SCHED_NAME', width: 50, key: true },
			{ label: '', name: 'entryId', index: 'ENTRY_ID', width: 80 }, 			
			{ label: '', name: 'triggerName', index: 'TRIGGER_NAME', width: 80 }, 			
			{ label: '', name: 'triggerGroup', index: 'TRIGGER_GROUP', width: 80 }, 			
			{ label: '', name: 'instanceName', index: 'INSTANCE_NAME', width: 80 }, 			
			{ label: '', name: 'firedTime', index: 'FIRED_TIME', width: 80 }, 			
			{ label: '', name: 'schedTime', index: 'SCHED_TIME', width: 80 }, 			
			{ label: '', name: 'priority', index: 'PRIORITY', width: 80 }, 			
			{ label: '', name: 'state', index: 'STATE', width: 80 }, 			
			{ label: '', name: 'jobName', index: 'JOB_NAME', width: 80 }, 			
			{ label: '', name: 'jobGroup', index: 'JOB_GROUP', width: 80 }, 			
			{ label: '', name: 'isNonconcurrent', index: 'IS_NONCONCURRENT', width: 80 }, 			
			{ label: '', name: 'requestsRecovery', index: 'REQUESTS_RECOVERY', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		qrtzFiredTriggers: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.qrtzFiredTriggers = {};
		},
		update: function (event) {
			var schedName = getSelectedRow();
			if(schedName == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(schedName)
		},
		saveOrUpdate: function (event) {
			var url = vm.qrtzFiredTriggers.schedName == null ? "qrtzfiredtriggers/save" : "qrtzfiredtriggers/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.qrtzFiredTriggers),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var schedNames = getSelectedRows();
			if(schedNames == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "qrtzfiredtriggers/delete",
				    contentType: "application/json",
				    data: JSON.stringify(schedNames),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(schedName){
			$.get(baseURL + "qrtzfiredtriggers/info/"+schedName, function(r){
                vm.qrtzFiredTriggers = r.qrtzFiredTriggers;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});