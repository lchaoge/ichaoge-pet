/**
 * OA面积审批
 * @param {Object} action
 * @param {Object} nodeid
 * @param {Object} psn
 * @param {Object} mind
 * @param {Object} nodelink
 * @param {Object} agent
 * @param {Object} dialog
 */
window.DFlow_Syncal_Submit = function(action, nodeid, psn, mind, nodelink, agent, dialog) {
    OaDimission.InitDocData();
    Flow.Sync = true;
    var $this = $(this);
    var vo = {
  		oneLevelAuditor :$("#oneLevelAuditor").val(), //  第1岗
			twoLevelAuditor :$("#oneLevelAuditor").val(), //  第2岗
			threeLevelAuditor :$("#oneLevelAuditor").val(), //  第3岗
			fourLevelAuditor :$("#oneLevelAuditor").val(), //  第4岗
			fiveLevelAuditor :$("#oneLevelAuditor").val(), //  第5岗
			sixLevelAuditor :$("#oneLevelAuditor").val(), //  第6岗
			action:action,
			nodeid:nodeid,
			psn:psn,
			mind:mind,
			nodelink:nodelink,
			agent:agent, 
			dialog:dialog
    }
    $.ajax({
        url: $(".otherdata").data("save"),
        type: "post",
        async: false,
        dataType: "jsonp",
        data: {"data": JSON.stringify(vo)},
        jsonp: "callback",
        jsonpCallback: "flightHandler",
        contentType: 'application/json;charset=utf-8',
        success: function (json) {
            if (json.success) {
                Flow.submit(action, nodeid, psn, mind, nodelink, agent, dialog);
            } else {
                $.gritter.add({
                    title: '错误',
                    text: json.message,
                    sticky: false,
                    time: 3000,
                    speed: 500,
                    position: 'bottom-right',
                    class_name: 'gritter-warning gritter-center'//gritter-center
                });
            }

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            $.gritter.add({
                title: '错误',
                text: "系统发生严重错误！",
                sticky: false,
                time: 5000,
                speed: 500,
                position: 'bottom-right',
                class_name: 'gritter-error'//gritter-center
            });
        }

    });
}