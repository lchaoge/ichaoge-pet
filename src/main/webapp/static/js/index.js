/*
* v:1.0.0
* author:chaoge
* date:2018/04/12
* dateFormat
*/
	function Apis () {}

	const isLocalHost = window.location.host.toLowerCase() == 'localhost:8080';
	const origin = window.location.origin;
	
	Apis.prototype.urls = {
		'POST_QUERYCOMMONINFO':(isLocalHost?'/apis':origin)+'/wumart/partner/queryCommonInfo',                // 列表-通过门店编号（siteNo）获取业态，小店类型，大区号
		'POST_QUERYSUBJECTTYPE':(isLocalHost?'/apis':origin)+'/wumart/partner/querySubjectType',              // 列表-查询科目
		
		'POST_PARTNER_QUERYSITESHOP':(isLocalHost?'/apis':origin)+'/wumart/partner/querySiteShop',            // 列表-小店维护
		'POST_PARTNER_CREATE':(isLocalHost?'/apis':origin)+'/wumart/partner/create',                          // 新建-小店维护
		'POST_PARTNER_QUERYPARTNERTEAM':(isLocalHost?'/apis':origin)+'/wumart/partner/queryPartnerTeam',      // 列表-合伙人组
		'POST_PARTNER_QUERYSHOPTYPE':(isLocalHost?'/apis':origin)+'/wumart/partner/queryShopType',            // 列表-小店类型
		'POST_PARTNER_UPDATE':(isLocalHost?'/apis':origin)+'/wumart/partner/update',                          // 更新-小店维护
//		'POST_PARTNER_QUERYSHOPTYPEBYERP':(isLocalHost?'/apis':origin)+'/wumart/partner/queryShopTypeByErp',  // 列表-小店类型
		'POST_PARTNER_QUERYSHOP':(isLocalHost?'/apis':origin)+'/wumart/partner/queryShop',                    // 列表-小店列表查询
		
		'POST_AREA_QUERYAREAMAIN':(isLocalHost?'/apis':origin)+'/wumart/partner/area/queryAreaMain',          // 列表-面积查询
		'POST_AREA_QUERYAREAITEM':(isLocalHost?'/apis':origin)+'/wumart/partner/area/queryAreaItem',          // 详细-面积查询
		'POST_AREA_CREATEAREA':(isLocalHost?'/apis':origin)+'/wumart/partner/area/createArea',                // 列表-小店列表查询
		
		'POST_FEE_QUERYFEEMAIN':(isLocalHost?'/apis':origin)+'/wumart/partner/Fee/queryFeeMain',               // 列表-费用录入
		'POST_FEE_QUERYFEEITEM':(isLocalHost?'/apis':origin)+'/wumart/partner/Fee/queryFeeItem',               // 详细-费用录入
		'POST_FEE_CREATEFEE':(isLocalHost?'/apis':origin)+'/wumart/partner/Fee/createFee',                     // 新建-录入费用
		
		'POST_RATE_CREATERATE':(isLocalHost?'/apis':origin)+'/wumart/partner/rate/createRate',                 // 新建-百分比审批
		'POST_RATE_QUERYRATEITEM':(isLocalHost?'/apis':origin)+'/wumart/partner/rate/queryRateItem',           // 详细-费用录入
		'POST_RATE_QUERYRATEMAIN':(isLocalHost?'/apis':origin)+'/wumart/partner/rate/queryRateMain',           // 列表-费用录入
		
		'POST_RATE_QUERYOAAREAITEM':(isLocalHost?'/apis':origin)+'/wumart/partner/area/queryOaAreaItem',           // 详细OA-面积查询
		
		
	}
	
	/*异步获取数据接口*/
	Apis.prototype.ajaxDataFetch = function(param){
		let returnObj = {}
	  if(typeof param.type === 'undefined') param.type = 'GET';
	  if(typeof param.data != 'string') param.data = JSON.stringify(param.data);
	  fetch(param.url,{
	  	method:param.type,
	  	headers:{
				"Content-type":"application/json",
			},
	  	body:JSON.stringify(param.data)
	  })
	  .then(res=>res.json())
	  .then(res=>{
	  	if (typeof res === 'string') {
	      returnObj = JSON.parse(data);
	    } else {
	      returnObj = data;
	    }
	    if (undefined != param.callback) param.callback(returnObj);
	  }).catch(err=>{
	  	this.$message.error(res.message)
	  })
	    
	}

	/*
	*获取日期
	*对Date的扩展，将 Date 转化为指定格式的String
	 * 月(M)、日(d)、小时(h)、分(m)、秒(s)可以用 1-2 个占位符，
	 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
	 *例子：
	 *publicNode.dateFormat("yyyy-MM-dd hh:mm:ss.S","2016-07-02") ==> 2006-07-02 08:09:04.423
	 *publicNode.dateFormat("yyyy-M-d h:m:s.S","2016/07/02")      ==> 2006-7-2 8:9:4.18
	 *publicNode.dateFormat("yyyy-M-d h:m:s.S","2016/7/2")      ==> 2006-7-2 8:9:4.18
	 * times:格式必须为：2016-07-02||2016/07/02
	*/
	Apis.prototype.dateFormat = function(fmt,times){
    if(fmt === "" && fmt === undefined){
        return null;
    }
    var date = new Date();
    if (undefined !== times && times!== "") {
        var timestamp = times;
        if(!(/[0-9]{13}/.test(times))){
            if(/^(\d{4})(-|\/)(\d{1,2})(-|\/)(\d{1,2})$/.test(times)){
                timestamp = new Date((times+"").replace(/(-|年|月)/g,'/').replace(/日/g,"")).getTime();
            }else{
                return null;
            }
        }
        date = new Date(parseInt(timestamp));
    }
    var o = {
        "M+": date.getMonth() + 1, //月份
        "d+": date.getDate(), //日
        "h+": date.getHours(), //小时
        "m+": date.getMinutes(), //分
        "s+": date.getSeconds(), //秒
        "q+": Math.floor((date.getMonth() + 3) / 3), //季度
        "S": date.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
	};
	
	/*获取日期*/
  Apis.prototype.getDateFunc = function(allFlag, times) {
      var date = new Date();
      if (undefined !== times && /^[0-9]*$/.test(times)) {
          date = new Date(times);
      }
      var year = date.getFullYear();
      var month = date.getMonth() + 1;
      month = (month > 9 ? month : '0' + month);
      var day = date.getDate();
      day = (day > 9 ? day : '0' + day);
      var hours = date.getHours();
      hours = (hours > 9 ? hours : '0' + hours);
      var minutes = date.getMinutes();
      minutes = (minutes > 9 ? minutes : '0' + minutes);
      var seconds = date.getSeconds();
      seconds = (seconds > 9 ? seconds : '0' + seconds);
      return allFlag == 'all' ? (year + '-' + month + "-" + day + " " + hours + ':' + minutes + ':' + seconds) : (year + '-' + month + "-" + day);
  }

	Apis.prototype._IE = (function (){
    var v = 3, div = document.createElement('div'), all = div.getElementsByTagName('i');
    while (
        div.innerHTML = '<!--[if gt IE ' + (++v) + ']><i></i><![endif]-->',
            all[0]
        );
    return v > 4 ? v : false;
	}());
	
	
	export	const apis= new Apis();


