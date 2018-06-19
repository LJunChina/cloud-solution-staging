function serverAjaxData(url,method,fnCallback,paramData) {
    $.ajax({
        "dataType" : 'json',
        "contentType": "application/json; charset=utf-8",
        "type" : method,
        "url" : url,
        "data" :paramData,
        "success" : function(resp){
            if(resp.code === '0000'){
                fnCallback({
                    "recordsTotal":resp.data.pages,
                    "recordsFiltered":resp.data.total,
                    "data":resp.data.list
                });
            }else if (resp.code === '7000' || resp.code === '8001' || resp.code === '9104'){
                $.info(resp.message,function (e) {
                   if(e){
                       self.location.reload(true);
                   }
                });
            }else {
                $.error(resp.message,null);
            }
        },
        "error":function () {
            self.location = "login.html";
        }
    });
}

/**
 * 创建数据表格
 * @param returnData 服务器请求回调
 * @param aoColumns 列定义
 * @param aoColumnDefs 列格式
 * @param fnInitComplete 表格加载完成回调
 * @param dom 标签
 */
function createDataTable(returnData,aoColumns,aoColumnDefs,fnInitComplete,dom) {
    var option = {
        "pagingType": "full_numbers_icon",
        "serverSide": true,
        "ordering": false,
        "fnServerData":returnData,
        "searching": false,
        "oLanguage": { //国际化配置
            "sProcessing": "<span style='color:#ff0000;'><img height='30' width='30' src='../assets/images/loading.gif'></span>",
            "sLengthMenu": "显示 _MENU_ 条",
            "sZeroRecords": "没有您要搜索的内容",
            "sInfo": "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
            "sInfoEmpty": "记录数为0",
            "sInfoFiltered": "(总页数 _MAX_ 页)",
            "sInfoPostFix": "",
            "sSearch": "搜索",
            "sUrl": "",
            "oPaginate": {
                "sFirst": "第一页",
                "sPrevious": "上一页",
                "sNext": "下一页",
                "sLast": "最后一页"
            }
        },
        "bProcessing" : true, //DataTables载入数据时，是否显示‘进度’提示
        "destroy" : true,//重载表格清空
        "aoColumns" : aoColumns,
        "aoColumnDefs":aoColumnDefs,
        "fnInitComplete":fnInitComplete
    };
    $(dom).html("");
    $(dom).DataTable(option);
}

function getPageIndex(aDataSet) {
    var pageSize,pageIndex = 1;
    $.each(aDataSet,function () {
        if(this.name && this.name === 'length'){
            pageSize = this.value;
        }
    });
    $.each(aDataSet,function () {
        if(this.name && this.name === 'start'){
            var start = this.value;
            if(start === 0){
                pageIndex = 1;
            }else {
                if(pageSize){
                    pageIndex = start/pageSize + 1;
                }
            }
        }
    });
    return pageIndex;
}
function getPageSize(aDataSet) {
    var pageSize = 10;
    $.each(aDataSet,function () {
        if(this.name && this.name === 'length'){
            pageSize = this.value;
        }
    });
    return pageSize;
}