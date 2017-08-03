var validateNum;
var keepConfirmPwd;
var a = 0;
var b = 0;
var c = 0;
var d = 0;
var e = 0;
var f = 0;

// 鍒涘缓璇锋眰
var http_request;
function createXMLHttpRequest(){
	http_request=false;
    if(window.XMLHttpRequest){
		http_request=new XMLHttpRequest();  //鍒濆鍖杊ttp_request
		if(http_request.overrideMimeType){
			http_request.overrideMimeType("text/html");
		}
	}else if(window.ActiveXObject){      
		try{
			http_request=new ActiveXObject("Msxml2.XMLHTTP");  //鍦↖E涓垱寤篨MLHttpRequest瀵硅薄,鏂扮増IE
		}catch(e){
			try{
				http_request=new ActiveXObject("Microsoft.XMLHTTP");  //鍦↖E涓垱寤篨MLHttpRequest瀵硅薄鏃х増IE
			}catch(e){}
		}
	}
		
	if(!http_request){
		window.alert("涓嶈兘鍒涘缓XMLHttpRequest瀵硅薄瀹炰緥");
		return false;
	}
}

// 鎻愮ず杈撳叆鐧诲綍鍚�
function onClickShowStyleOfLoginName(){
	// 鐩存帴鏄剧ず鎻愮ず妗�1
	//window.alert("鐩存帴鏄剧ず鎻愮ず妗�1");
	document.getElementById("errorLoginName2").style.display = "none";
	document.getElementById("errorLoginName3").style.display = "none";
	document.getElementById("inputLoginName1").style.display = "block";
	
//	msgBox = document.createElement("div");
//	msgBox.setAttribute("class", "errormt");
//	msgBox.setAttribute("id", "inputLoginName1");
//	msgBox.setAttribute("style", "color:green; background:white; width:auto; height:auto; z-index:9999;");
//	
//	var htmlList = '';
//	htmlList += '<strong>';
//	htmlList += '<span>璇疯緭鍏ラ暱搴︿负6-12浣嶇敱鏁�';
//	htmlList += '<br>瀛楄嫳鏂囧瓧姣嶅強涓嬪垝绾跨粍鎴愮殑';
//	htmlList += '<br>鐧诲綍鍚嶏細濡傦紝ftym_520';
//	htmlList += '</span>';
//	htmlList += '</strong> ';
//	
//	msgBox.innerHTML = htmlList;
	
	//document.getElementById('red_reg_username').appendChild(msgBox);
	//window.alert(msgBox.id);
	//document.body.appendChild(msgBox);
}

// 楠岃瘉鐧诲綍鍚�
function onClickValidateLoginName(id){	
	var login = document.getElementById(id).value;
	
	if(login.length >= 6 && login.length <= 12){
		if(notChinese(login)){				
			validateInfo("validateInfo.action?login.loginName=" + login);			
		}else{
			a = 0;
			document.getElementById("inputLoginName1").style.display = "none";
			//document.getElementById('red_reg_username').removeChild(msgBox);
			document.getElementById("errorLoginName2").style.display = "block";	
		}
	}else{
		a = 0;
		document.getElementById("inputLoginName1").style.display = "none";
		document.getElementById("errorLoginName2").style.display = "block";
	}
}

// 鍒ゆ柇鐢ㄦ埛鍚嶆槸鍚︿负鏁板瓧瀛楁瘝涓嬫粦绾�      
function notChinese(str){ 
	var reg=/[^A-Za-z0-9_]/g; 
    if (reg.test(str)){ 
    	return (false); 
    	}
    else{ 
    	return(true);
    	} 
}

/**  
 * 韬唤璇�15浣嶇紪鐮佽鍒欙細dddddd yymmdd xx p   
 * dddddd锛氬湴鍖虹爜   
 * yymmdd: 鍑虹敓骞存湀鏃�   
 * xx: 椤哄簭绫荤紪鐮侊紝鏃犳硶纭畾   
 * p: 鎬у埆锛屽鏁颁负鐢凤紝鍋舵暟涓哄コ  
 * <p />  
 * 韬唤璇�18浣嶇紪鐮佽鍒欙細dddddd yyyymmdd xxx y   
 * dddddd锛氬湴鍖虹爜   
 * yyyymmdd: 鍑虹敓骞存湀鏃�   
 * xxx:椤哄簭绫荤紪鐮侊紝鏃犳硶纭畾锛屽鏁颁负鐢凤紝鍋舵暟涓哄コ   
 * y: 鏍￠獙鐮侊紝璇ヤ綅鏁板�煎彲閫氳繃鍓�17浣嶈绠楄幏寰�  
 * <p />  
 * 18浣嶅彿鐮佸姞鏉冨洜瀛愪负(浠庡彸鍒板乏) Wi = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2,1 ]  
 * 楠岃瘉浣� Y = [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ]   
 * 鏍￠獙浣嶈绠楀叕寮忥細Y_P = mod( 鈭�(Ai脳Wi),11 )   
 * i涓鸿韩浠借瘉鍙风爜浠庡彸寰�宸︽暟鐨� 2...18 浣�; Y_P涓鸿剼涓牎楠岀爜鎵�鍦ㄦ牎楠岀爜鏁扮粍浣嶇疆  
 *   
 */  
  
var Wi = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 ];// 鍔犳潈鍥犲瓙   
var ValideCode = [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ];// 韬唤璇侀獙璇佷綅鍊�.10浠ｈ〃X   
function IdCardValidate(idCard) {   
    idCard = trim(idCard.replace(/ /g, ""));   
    if (idCard.length == 15) {   
        return isValidityBrithBy15IdCard(idCard);   
    } else if (idCard.length == 18) {   
        var a_idCard = idCard.split("");// 寰楀埌韬唤璇佹暟缁�   
        if(isValidityBrithBy18IdCard(idCard)&&isTrueValidateCodeBy18IdCard(a_idCard)){   
            return true;   
        }else {   
            return false;   
        }   
    } else {   
        return false;   
    }   
}   

/**  
 * 鍒ゆ柇韬唤璇佸彿鐮佷负18浣嶆椂鏈�鍚庣殑楠岃瘉浣嶆槸鍚︽纭�  
 * @param a_idCard 韬唤璇佸彿鐮佹暟缁�  
 * @return  
 */  
function isTrueValidateCodeBy18IdCard(a_idCard) {   
    var sum = 0; // 澹版槑鍔犳潈姹傚拰鍙橀噺   
    if (a_idCard[17].toLowerCase() == 'x') {   
        a_idCard[17] = 10;// 灏嗘渶鍚庝綅涓簒鐨勯獙璇佺爜鏇挎崲涓�10鏂逛究鍚庣画鎿嶄綔   
    }   
    for ( var i = 0; i < 17; i++) {   
        sum += Wi[i] * a_idCard[i];// 鍔犳潈姹傚拰   
    }   
    valCodePosition = sum % 11;// 寰楀埌楠岃瘉鐮佹墍浣嶇疆   
    if (a_idCard[17] == ValideCode[valCodePosition]) {   
        return true;   
    } else {   
        return false;   
    }   
}   
/**  
 * 閫氳繃韬唤璇佸垽鏂槸鐢锋槸濂�  
 * @param idCard 15/18浣嶈韩浠借瘉鍙风爜   
 * @return 'female'-濂炽��'male'-鐢�  
 */  
function maleOrFemalByIdCard(idCard){   
    idCard = trim(idCard.replace(/ /g, ""));// 瀵硅韩浠借瘉鍙风爜鍋氬鐞嗐�傚寘鎷瓧绗﹂棿鏈夌┖鏍笺��   
    if(idCard.length==15){   
        if(idCard.substring(14,15)%2==0){   
            return 'female';   
        }else{   
            return 'male';   
        }   
    }else if(idCard.length ==18){   
        if(idCard.substring(14,17)%2==0){   
            return 'female';   
        }else{   
            return 'male';   
        }   
    }else{   
        return null;   
    }   
   
}   
 /**  
  * 楠岃瘉18浣嶆暟韬唤璇佸彿鐮佷腑鐨勭敓鏃ユ槸鍚︽槸鏈夋晥鐢熸棩  
  * @param idCard 18浣嶄功韬唤璇佸瓧绗︿覆  
  * @return  
  */  
function isValidityBrithBy18IdCard(idCard18){   
    var year =  idCard18.substring(6,10);   
    var month = idCard18.substring(10,12);   
    var day = idCard18.substring(12,14);   
    var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));   
    // 杩欓噷鐢╣etFullYear()鑾峰彇骞翠唤锛岄伩鍏嶅崈骞磋櫕闂   
    if(temp_date.getFullYear()!=parseFloat(year)   
          ||temp_date.getMonth()!=parseFloat(month)-1   
          ||temp_date.getDate()!=parseFloat(day)){   
            return false;   
    }else{   
        return true;   
    }   
}   
  /**  
   * 楠岃瘉15浣嶆暟韬唤璇佸彿鐮佷腑鐨勭敓鏃ユ槸鍚︽槸鏈夋晥鐢熸棩  
   * @param idCard15 15浣嶄功韬唤璇佸瓧绗︿覆  
   * @return  
   */  
  function isValidityBrithBy15IdCard(idCard15){   
      var year =  idCard15.substring(6,8);   
      var month = idCard15.substring(8,10);   
      var day = idCard15.substring(10,12);   
      var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));   
      // 瀵逛簬鑰佽韩浠借瘉涓殑浣犲勾榫勫垯涓嶉渶鑰冭檻鍗冨勾铏棶棰樿�屼娇鐢╣etYear()鏂规硶   
      if(temp_date.getYear()!=parseFloat(year)   
              ||temp_date.getMonth()!=parseFloat(month)-1   
              ||temp_date.getDate()!=parseFloat(day)){   
                return false;   
        }else{   
            return true;   
        }   
  }   
//鍘绘帀瀛楃涓插ご灏剧┖鏍�   
function trim(str) {   
    return str.replace(/(^\s*)|(\s*$)/g, "");   
} 
// 鍒ゆ柇鏄惁涓轰腑鏂囥�佹暟瀛椼�佽嫳鏂囧拰涓嬪垝绾�
function isChinese(str){ 
	var reg=/^[a-zA-Z0-9_\u4e00-\u9fa5]+$/; 
    if (reg.test(str)){ 
    	return (true); 
    	}
    else{ 
    	return(false);
    	} 
}

function validateInfo(url){	
	
	createXMLHttpRequest();
	// 鎸囧畾澶勭悊鍑芥暟 浜嬩欢瑙ｅ彂鍣紒锛侊紒
	http_request.onreadystatechange=processValidateLoginName; 	
	http_request.open("GET",url,true);  
	http_request.send(null); 
}

function processValidateLoginName(){
	if(http_request.readyState==4){ 	
		if(http_request.status==200){
			
			// 閫氳繃request鑾峰彇reponse閲岀殑鍊�
			var isPass = http_request.responseText;
			if( isPass == "true"){
				
				// 鎻愮ず妗�4
				a = 1 ;
				document.getElementById("inputLoginName1").style.display = "none";
				document.getElementById("errorLoginName2").style.display = "none";
				document.getElementById("errorLoginName3").style.display = "none";
				document.getElementById("successLoginName").style.display = "block";
			}else{
				// 鎻愮ず妗�3
				a = 0;
				document.getElementById("inputLoginName1").style.display = "none";
				document.getElementById("errorLoginName2").style.display = "none";
				document.getElementById("errorLoginName3").style.display = "block";
				document.getElementById("successLoginName").style.display = "none";
			}
		}
	}
}

//鎻愮ず杈撳叆瀵嗙爜
function onClickShowStyleOfLoginPassword(){
	document.getElementById("errorPassword2").style.display = "none";
	document.getElementById("inputPassword1").style.display = "block";	
}

function onClickValidateLoginPassword(id){	
	var login = document.getElementById(id).value;
	// 鍔犲叆鐢ㄦ潵鍒ゆ柇纭瀵嗙爜鏄惁涓虹┖鐨勫彉閲�
	var judgeConfirmpwd = document.getElementById('confirmpwd').value;
	
	if(login.length >= 6 && login.length <= 12){
		if(notChinese(login)){	
			b = 1;
			document.getElementById("inputPassword1").style.display = "none";
			document.getElementById("errorPassword2").style.display = "none";
			document.getElementById("successPassword").style.display = "block";
		}
		else{
			b = 0;
			document.getElementById("inputPassword1").style.display = "none";
			document.getElementById("errorPassword2").style.display = "block";
		}
	}else{
		//window.alert("鎻愮ず妗�2");
		//鎻愮ず妗�2
		b = 0;
		document.getElementById("inputPassword1").style.display = "none";
		document.getElementById("errorPassword2").style.display = "block";
	}
	
	if(judgeConfirmpwd.length > 0){
		onClickValidateConfirmPassword('confirmpwd');
	}
}

//鎻愮ず纭瀵嗙爜鐨勮緭鍏�
function onClickShowConfirmPassword(){
	document.getElementById("errorConfirmPassword2").style.display = "none";
	document.getElementById("inputConfirmPassword1").style.display = "block";	
}

function onClickValidateConfirmPassword(id){
	var confirmpassword = document.getElementById(id).value;
	var password1 = document.getElementById('loginPassword').value;
//	window.alert("鎻愮ず妗�2");
	if(confirmpassword.length >0){
		if(confirmpassword == password1){
			c = 1;
			document.getElementById("inputConfirmPassword1").style.display = "none";
			document.getElementById("errorConfirmPassword2").style.display = "none";
			document.getElementById("successConfirmPassword").style.display = "block";
		}
		else{
			c = 0;
			document.getElementById("inputConfirmPassword1").style.display = "none";
			document.getElementById("errorConfirmPassword2").style.display = "block";
		}
	}
	else{
		c = 0;
		document.getElementById("inputConfirmPassword1").style.display = "none";
		document.getElementById("errorConfirmPassword2").style.display = "block";
	}
}

//鎻愮ず鏄电О鐨勮緭鍏�
function onClickShowStyleOfNickName(){
	// 鐩存帴鏄剧ず鎻愮ず妗�1
	//window.alert("鐩存帴鏄剧ず鎻愮ず妗�1");
	document.getElementById("errorNickName2").style.display = "none";
	document.getElementById("errorNickName3").style.display = "none";
	document.getElementById("inputNickName1").style.display = "block";
}

// 楠岃瘉鏄电О
function onClickValidateNickName(id){	
	var login = document.getElementById(id).value;
//	window.alert("鐩存帴鏄剧ず鎻愮ず妗�1");
	if(login.length >= 1 && login.length <= 12){
		if( isChinese(login)){			
			validateNickName("validateNickName.action?userinfo.nickName=" + encodeURI(encodeURI(login)));			
		}else{
			//鎻愮ず妗�2
			d = 0;
			document.getElementById("inputNickName1").style.display = "none";
			document.getElementById("errorNickName2").style.display = "block";	
		}
	}else{
		//window.alert("鎻愮ず妗�2");
		//鎻愮ず妗�2
		d = 0;
		document.getElementById("inputNickName1").style.display = "none";
		document.getElementById("errorNickName2").style.display = "block";
	}
}

function validateNickName(url){	
	
	createXMLHttpRequest();
	// 鎸囧畾澶勭悊鍑芥暟 浜嬩欢瑙ｅ彂鍣紒锛侊紒
	http_request.onreadystatechange=processValidateNickName; 	
	http_request.open("GET",url,true);  
	http_request.send(null); 
}

function processValidateNickName(){
	if(http_request.readyState==4){ 		
		if(http_request.status==200){
			
			// 閫氳繃request鑾峰彇reponse閲岀殑鍊�
			var isPass = http_request.responseText;
			if( isPass == "true"){
				//window.alert("楠岃瘉閫氳繃");
				// 鎻愮ず妗�4
				d = 1;
				document.getElementById("inputNickName1").style.display = "none";
				document.getElementById("errorNickName2").style.display = "none";
				document.getElementById("errorNickName3").style.display = "none";
				document.getElementById("successNickName").style.display = "block";
			}else{
				// 鎻愮ず妗�3
				d = 0;
				document.getElementById("inputNickName1").style.display = "none";
				document.getElementById("errorNickName3").style.display = "block";
			}
		}
	}
}

function createMsgBox(){
	
	//window.alert(msgBox.className);
	//msgBox.setAttribute(id, "inputLoginName1");
	//msgBox.setAttribute(style, "color:green; background:white; height:100px; z-index:9999;");
	return msgBox;
}

//鐪佷唤鍩庡競浜岀骇鑱斿姩
//瀹氫箟浜嗗煄甯傜殑浜岀淮鏁扮粍锛岄噷闈㈢殑椤哄簭璺熺渷浠界殑椤哄簭鏄浉鍚岀殑銆傞�氳繃selectedIndex鑾峰緱鐪佷唤鐨勪笅鏍囧�兼潵寰楀埌鐩稿簲鐨勫煄甯傛暟缁�
var city=[
["鍖椾含","澶╂触","涓婃捣","閲嶅簡","棣欐腐","婢抽棬"],
["鐭冲搴�","鍞愬北","绉︾殗宀�","閭兏","閭㈠彴","淇濆畾","寮犲鍙�","鎵垮痉","娌у窞","寤婂潑","琛℃按"],
["澶師","澶у悓","闃虫硥","闀挎不","鏅嬪煄","鏈斿窞","鏅嬩腑","杩愬煄","蹇诲窞","涓存本","鍚曟"],
["鍛煎拰娴╃壒","鍖呭ご","涔屾捣","璧ゅ嘲","閫氳窘","閯傚皵澶氭柉","鍛间鸡璐濆皵","宸村溅娣栧皵","涔屽叞瀵熷竷","鍏村畨","閿℃灄閮嫆","闃挎媺鍠�"],
["娌堥槼","澶ц繛","闉嶅北","鎶氶『","鏈邯","涓逛笢","閿﹀窞","钀ュ彛","闃滄柊","杈介槼","鐩橀敠","閾佸箔","鏈濋槼","钁姦宀�"],
["闀挎槬","鍚夋灄","鍥涘钩","杈芥簮","閫氬寲","鐧藉北","鏉惧師","鐧藉煄","寤惰竟"],
["鍝堝皵婊�","榻愰綈鍝堝皵","楦¤タ","楣ゅ矖","鍙岄腑灞�","澶у簡","浼婃槬","浣虫湪鏂�","涓冨彴娌�","鐗′腹姹�","榛戞渤","缁ュ寲","澶у叴瀹夊箔"],
["鍗椾含","鑻忓窞","鎵窞","鏃犻敗","寰愬窞","甯稿窞","鍗楅��","杩炰簯娓�","娣畨","鐩愬煄","闀囨睙","娉板窞","瀹胯縼"],
["鏉窞","瀹佹尝","娓╁窞","鍢夊叴","婀栧窞","缁嶅叴","閲戝崕","琛㈠窞","鑸熷北","鍙板窞","涓芥按"],
["鍚堣偉","鑺滄箹","铓屽煚","娣崡","椹瀺灞�","娣寳","閾滈櫟","瀹夊簡","榛勫北","婊佸窞","闃滈槼","瀹垮窞","宸㈡箹","鍏畨","浜冲窞","姹犲窞","瀹ｅ煄"],
["绂忓窞","瀹佸痉","鍗楀钩","鍘﹂棬","鑾嗙敯","涓夋槑","娉夊窞","婕冲窞"],
["鍗楁槍","涓婇ザ","钀嶄埂","涔濇睙","鏅痉闀�","鏂颁綑","楣版江","璧ｅ窞","鍚夊畨","瀹滄槬","鎶氬窞"],
["娴庡崡","闈掑矝","娣勫崥","鏋ｅ簞","涓滆惀","鐑熷彴","娼嶅潑","濞佹捣","娴庡畞","娉板畨","鏃ョ収","鑾辫姕","涓存矀","寰峰窞","鑱婂煄","婊ㄥ窞","鑿忔辰"],
["閮戝窞","寮�灏�","娲涢槼","骞抽《灞�","鐒︿綔","楣ゅ","鏂颁埂","瀹夐槼","婵槼","婕渤","璁告槍","涓夐棬宄�","鍗楅槼","鍟嗕笜","淇￠槼","鍛ㄥ彛","椹婚┈搴�"],
["姝︽眽","鍗佸牥","瑗勬▕","閯傚窞","榛勭煶","鑽嗗窞","瀹滄槍","鑽嗛棬","瀛濇劅","榛勫唸","鍜稿畞","闅忓窞","鎭╂柦"],
["闀挎矙","鏍床","婀樻江","宀抽槼","閭甸槼","甯稿痉","琛￠槼","寮犲鐣�","鐩婇槼","閮村窞","姘稿窞","鎬�鍖�","濞勫簳","婀樿タ"],
["骞垮窞","娓呰繙","娼窞","涓滆帪","鐝犳捣","娣卞湷","姹曞ご","闊跺叧","浣涘北","姹熼棬","婀涙睙","鑼傚悕","鑲囧簡","鎯犲窞","姊呭窞","姹曞熬","闃虫睙","娌虫簮","涓北","鎻槼","浜戞诞"],
["鍗楀畞","鏌冲窞","妗傛灄","姊у窞","鍖楁捣","闃插煄娓�","閽﹀窞","璐垫腐","鐜夋灄","鐧捐壊","璐哄窞","娌虫睜","鏉ュ","宕囧乏"],
["娴峰彛","涓変簹"],
["鎴愰兘","鑷础","鏀�鏋濊姳","娉稿窞","寰烽槼","缁甸槼","骞垮厓","閬傚畞","鍐呮睙","涔愬北","鍗楀厖","瀹滃","骞垮畨","杈惧窞","鐪夊北","闆呭畨","宸翠腑","璧勯槼","闃垮潩","鐢樺瓬","鍑夊北"],
["璐甸槼","鍏洏姘�","閬典箟","瀹夐『","閾滀粊","姣曡妭","榛旇タ鍗�","榛斾笢鍗�","榛斿崡"],
["鏄嗘槑","鏇查潠","鐜夋邯","淇濆北","鏄��","涓芥睙","鏅幢","涓存钵","鏂囧北","绾㈡渤","瑗垮弻鐗堢撼","妤氶泟","澶х悊","寰峰畯","鎬掓睙","杩簡"],
["鎷夎惃","鏄岄兘","灞卞崡","鏃ュ杸鍒�","閭ｆ洸","闃块噷","鏋楄姖"],
["瑗垮畨","閾滃窛","瀹濋浮","鍜搁槼","娓崡","寤跺畨","姹変腑","姒嗘灄","瀹夊悍","鍟嗘礇"],
["鍏板窞","鐧介摱","瀹氳タ","鏁︾厡","鍢夊唱鍏�","閲戞槍","澶╂按","姝﹀▉","寮犳帠","骞冲噳","閰掓硥","搴嗛槼","涓村","闄囧崡","鐢樺崡"],
["瑗垮畞","娴蜂笢","娴峰寳","榛勫崡","娴峰崡","鏋滄礇","鐜夋爲","娴疯タ"],
["閾跺窛","鐭冲槾灞�","鍚村繝","鍥哄師","涓崼"],
["涔岄瞾鏈ㄩ綈","鍏嬫媺鐜涗緷","鍚愰瞾鐣�","鍝堝瘑","鍜岀敯","闃垮厠鑻�","鍠�浠�","鍏嬪瓬鍕掕嫃鏌皵鍏嬪瓬","宸撮煶閮钂欏彜","鏄屽悏","鍗氬皵濉旀媺钂欏彜","浼婄妬鍝堣惃鍏�","闃垮嫆娉�"],
["鍙板寳","楂橀泟","鍩洪殕","鍙颁腑","鍙板崡","鏂扮","鍢変箟"]
];

function getCity(){
    //鑾峰緱鐪佷唤涓嬫媺妗嗙殑瀵硅薄
    var sltProvince=document.forms[0].province;
    //鑾峰緱鍩庡競涓嬫媺妗嗙殑瀵硅薄
    var sltCity=document.forms[0].city;
    
    //寰楀埌瀵瑰簲鐪佷唤鐨勫煄甯傛暟缁�
    var provinceCity=city[sltProvince.selectedIndex];

    //娓呯┖鍩庡競涓嬫媺妗嗭紝浠呯暀鎻愮ず閫夐」
    sltCity.length=1;
    sltCity[0]=new Option(provinceCity[0],provinceCity[0]);

    //灏嗗煄甯傛暟缁勪腑鐨勫�煎～鍏呭埌鍩庡競涓嬫媺妗嗕腑
    for(var i=1;i<provinceCity.length;i++){
        sltCity[i]=new Option(provinceCity[i],provinceCity[i]);
    }
}

//楠岃瘉韬唤璇佸彿姝ｅ垯琛ㄨ揪寮�
function isID(str){ 
	var reg=/[\d{18} | \d{15}]/;
    if (reg.test(str)){ 
    	return (true); 
    	}
    else{ 
    	return(false);
    	} 
}

//鎻愮ず杈撳叆韬唤璇佸彿
function onClickShowStyleOfID(){
	document.getElementById("errorID2").style.display = "none";
	document.getElementById("inputID1").style.display = "block";
}

//楠岃瘉韬唤璇佸彿鐮�
function onClickValidateID(id){
	var login = document.getElementById(id).value;
	if( login.length == 15 || login.length == 18 ){
		if( IdCardValidate(login)){
			e = 1;
			document.getElementById("errorID2").style.display = "none";
			document.getElementById("inputID1").style.display = "none";
			document.getElementById("successID").style.display = "block";
		}
		else{
			e = 0;
			document.getElementById("inputID1").style.display = "none";
			document.getElementById("errorID2").style.display = "block";	
		}
	}
	else{
		document.getElementById("errorID2").style.display = "block";
		document.getElementById("inputID1").style.display = "none";
		document.getElementById("successID").style.display = "none";
	}
}

//鏇存崲楠岃瘉鐮佸浘鐗�
function onClickRefreshCheckCode(){
	var checkCode = document.getElementById('checkCodeImg');
	checkCode.src = "checkCode.action?t="+Math.random();
}

//楠岃瘉杈撳叆楠岃瘉鐮�
function onClickValidateCheckCode(id){
	var checkCodeNumber = document.getElementById(id).value;	
	validateCheckCode("validateCheckcode.action?checkCodeNumber=" + checkCodeNumber);
}
function validateCheckCode(url){	
	
	createXMLHttpRequest();
	http_request.onreadystatechange=processValidateCheckCode; 	
	http_request.open("GET",url,true);  
	http_request.send(null); 
}

function processValidateCheckCode(){
	if(http_request.readyState==4){ 	
		if(http_request.status==200){;				
			
			// 閫氳繃request鑾峰彇reponse閲岀殑鍊�
			var isPass = http_request.responseText;
			if( isPass == "true"){
				f = 1;
				document.getElementById('errorCheckCode2').style.display="none";
				document.getElementById('successCheckCode').style.display="block";	
			}
			else{
				f = 0;
				document.getElementById('errorCheckCode2').style.display="block";
			}
		}
	}
}
