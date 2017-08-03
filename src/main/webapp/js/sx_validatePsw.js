function validateOldPassword(id){
	$.post('validateOldPassword',
			{oldpassword:$('#oldPassword').val},
			function(data,status){
			    if(data.isPass){
			    	l = 1;
			    	$('#successOldPwd').style.display="block";
			    	$("#inputOldPwd1").style.display="none";
					$("#errorOldPwd2").style.display="none";
			    }else{
			    	l=0;
			    	$('#successOldPwd').style.display="none";
			    	$("#inputOldPwd1").style.display="none";
					$("#errorOldPwd2").style.display="block";
			    }
			});

}