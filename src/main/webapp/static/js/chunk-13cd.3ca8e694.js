(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-13cd"],{"6H4E":function(n,t,e){"use strict";var i=e("EqWV");e.n(i).a},EqWV:function(n,t,e){},Yfch:function(n,t,e){"use strict";function i(n){return["admin","editor"].indexOf(n.trim())>=0}function o(n){return/^(https?|ftp):\/\/([a-zA-Z0-9.-]+(:[a-zA-Z0-9.&%$-]+)*@)*((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9][0-9]?)(\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])){3}|([a-zA-Z0-9-]+\.)*[a-zA-Z0-9-]+\.(com|edu|gov|int|mil|net|org|biz|arpa|info|name|pro|aero|coop|museum|[a-zA-Z]{2}))(:[0-9]+)*(\/($|[a-zA-Z0-9.,?'\\+&%$#=~_-]+))*$/.test(n)}e.d(t,"a",function(){return i}),e.d(t,"b",function(){return o})},c11S:function(n,t,e){"use strict";var i=e("gTgX");e.n(i).a},"d/5p":function(n,t,e){"use strict";var i=e("i6g7");e.n(i).a},gTgX:function(n,t,e){},i6g7:function(n,t,e){},ntYl:function(n,t,e){"use strict";e.r(t);var i=e("Yfch"),o=e("ETGp");function s(n,t,e,i){var o=void 0!==window.screenLeft?window.screenLeft:screen.left,s=void 0!==window.screenTop?window.screenTop:screen.top,a=(window.innerWidth?window.innerWidth:document.documentElement.clientWidth?document.documentElement.clientWidth:screen.width)/2-e/2+o,r=(window.innerHeight?window.innerHeight:document.documentElement.clientHeight?document.documentElement.clientHeight:screen.height)/2-i/2+s,c=window.open(n,t,"toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=yes, copyhistory=no, width="+e+", height="+i+", top="+r+", left="+a);window.focus&&c.focus()}var a={name:"SocialSignin",methods:{wechatHandleClick:function(n){this.$store.commit("SET_AUTH_TYPE",n);s("https://open.weixin.qq.com/connect/qrconnect?appid=xxxxx&redirect_uri="+encodeURIComponent("xxx/redirect?redirect="+window.location.origin+"/authredirect")+"&response_type=code&scope=snsapi_login#wechat_redirect",n,540,540)},tencentHandleClick:function(n){this.$store.commit("SET_AUTH_TYPE",n);s("https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=xxxxx&redirect_uri="+encodeURIComponent("xxx/redirect?redirect="+window.location.origin+"/authredirect"),n,540,540)}}},r=(e("6H4E"),e("KHd+")),c=Object(r.a)(a,function(){var n=this,t=n.$createElement,e=n._self._c||t;return e("div",{staticClass:"social-signup-container"},[e("div",{staticClass:"sign-btn",on:{click:function(t){n.wechatHandleClick("wechat")}}},[e("span",{staticClass:"wx-svg-container"},[e("svg-icon",{staticClass:"icon",attrs:{"icon-class":"wechat"}})],1),n._v(" 微信\n  ")]),n._v(" "),e("div",{staticClass:"sign-btn",on:{click:function(t){n.tencentHandleClick("tencent")}}},[e("span",{staticClass:"qq-svg-container"},[e("svg-icon",{staticClass:"icon",attrs:{"icon-class":"qq"}})],1),n._v(" QQ\n  ")])])},[],!1,null,"2de45e6f",null);c.options.__file="socialsignin.vue";var l=c.exports,d={name:"Login",components:{LangSelect:o.a,SocialSign:l},data:function(){return{loginForm:{username:"admin",password:"1111111"},loginRules:{username:[{required:!0,trigger:"blur",validator:function(n,t,e){Object(i.a)(t)?e():e(new Error("Please enter the correct user name"))}}],password:[{required:!0,trigger:"blur",validator:function(n,t,e){t.length<6?e(new Error("The password can not be less than 6 digits")):e()}}]},passwordType:"password",loading:!1,showDialog:!1}},created:function(){},destroyed:function(){},methods:{showPwd:function(){"password"===this.passwordType?this.passwordType="":this.passwordType="password"},handleLogin:function(){var n=this;this.$refs.loginForm.validate(function(t){if(!t)return console.log("error submit!!"),!1;n.loading=!0,n.$store.dispatch("LoginByUsername",n.loginForm).then(function(){n.loading=!1,n.$router.push({path:"/"})}).catch(function(){n.loading=!1})})},afterQRScan:function(){}}},u=(e("c11S"),e("d/5p"),Object(r.a)(d,function(){var n=this,t=n.$createElement,e=n._self._c||t;return e("div",{staticClass:"login-container"},[e("el-form",{ref:"loginForm",staticClass:"login-form",attrs:{model:n.loginForm,rules:n.loginRules,"auto-complete":"on","label-position":"left"}},[e("div",{staticClass:"title-container"},[e("h3",{staticClass:"title"},[n._v(n._s(n.$t("login.title")))]),n._v(" "),e("lang-select",{staticClass:"set-language"})],1),n._v(" "),e("el-form-item",{attrs:{prop:"username"}},[e("span",{staticClass:"svg-container svg-container_login"},[e("svg-icon",{attrs:{"icon-class":"user"}})],1),n._v(" "),e("el-input",{attrs:{placeholder:n.$t("login.username"),name:"username",type:"text","auto-complete":"on"},model:{value:n.loginForm.username,callback:function(t){n.$set(n.loginForm,"username",t)},expression:"loginForm.username"}})],1),n._v(" "),e("el-form-item",{attrs:{prop:"password"}},[e("span",{staticClass:"svg-container"},[e("svg-icon",{attrs:{"icon-class":"password"}})],1),n._v(" "),e("el-input",{attrs:{type:n.passwordType,placeholder:n.$t("login.password"),name:"password","auto-complete":"on"},nativeOn:{keyup:function(t){return"button"in t||!n._k(t.keyCode,"enter",13,t.key,"Enter")?n.handleLogin(t):null}},model:{value:n.loginForm.password,callback:function(t){n.$set(n.loginForm,"password",t)},expression:"loginForm.password"}}),n._v(" "),e("span",{staticClass:"show-pwd",on:{click:n.showPwd}},[e("svg-icon",{attrs:{"icon-class":"eye"}})],1)],1),n._v(" "),e("el-button",{staticStyle:{width:"100%","margin-bottom":"30px"},attrs:{loading:n.loading,type:"primary"},nativeOn:{click:function(t){return t.preventDefault(),n.handleLogin(t)}}},[n._v(n._s(n.$t("login.logIn")))]),n._v(" "),e("div",{staticClass:"tips"},[e("span",[n._v(n._s(n.$t("login.username"))+" : admin")]),n._v(" "),e("span",[n._v(n._s(n.$t("login.password"))+" : "+n._s(n.$t("login.any")))])]),n._v(" "),e("div",{staticClass:"tips"},[e("span",{staticStyle:{"margin-right":"18px"}},[n._v(n._s(n.$t("login.username"))+" : editor")]),n._v(" "),e("span",[n._v(n._s(n.$t("login.password"))+" : "+n._s(n.$t("login.any")))])]),n._v(" "),e("el-button",{staticClass:"thirdparty-button",attrs:{type:"primary"},on:{click:function(t){n.showDialog=!0}}},[n._v(n._s(n.$t("login.thirdparty")))])],1),n._v(" "),e("el-dialog",{attrs:{title:n.$t("login.thirdparty"),visible:n.showDialog,"append-to-body":""},on:{"update:visible":function(t){n.showDialog=t}}},[n._v("\n    "+n._s(n.$t("login.thirdpartyTips"))+"\n    "),e("br"),n._v(" "),e("br"),n._v(" "),e("br"),n._v(" "),e("social-sign")],1)],1)},[],!1,null,"16b7c22a",null));u.options.__file="index.vue";t.default=u.exports}}]);