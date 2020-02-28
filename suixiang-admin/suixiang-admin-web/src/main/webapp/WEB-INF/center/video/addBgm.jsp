<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- BEGIN PAGE HEADER-->
	<!-- BEGIN PAGE BAR -->
	<div class="page-bar">
	    <ul class="page-breadcrumb">
	        <li>
	            <span>首页</span>
	            <i class="fa fa-circle"></i>
	        </li>
	        <li>
	            <span>bgm管理</span>
	            <i class="fa fa-circle"></i>
	        </li>
	        <li>
	            <span>添加背景音乐</span>
	        </li>
	    </ul>
	</div>
	<!-- END PAGE BAR -->
	<!-- END PAGE HEADER-->
                        
	<div class="row">
    	<div class="col-md-12">
			<br/>
			<!-- 意见反馈 start -->
			<div class="tabbable-line boxless tabbable-reversed">
            	<div class="portlet box green-jungle">
                	<div class="portlet-title">
                    	<div class="caption">
                    		<i class="icon-plus"></i>添加背景音乐
                    	</div>
					</div>
					
					<div class="portlet-body form">
					
	                    <!-- BEGIN FORM-->
	                    <form id="addBgmForm" class="form-horizontal">
		                    <div class="form-body">
		                    
		                    	<div class="form-group">
		                        	<label class="col-md-3 control-label"><span class="field-required"> * </span>歌手名称：</label>
		                            <div class="col-md-4">
		                            	<div id="input-error">
		                            		<input id="author" name="creator" type="text" class="form-control" placeholder="1-8字">
		                            	</div>
									</div>
								</div>
								
								<div class="form-group">
		                        	<label class="col-md-3 control-label"><span class="field-required"> * </span>背景音乐名称：</label>
		                            <div class="col-md-4">
		                            	<div id="input-error">
		                            		<input id="name" name="name" type="text" class="form-control" placeholder="1-10字">
		                            	</div>
									</div>
								</div>
								
								<div class="form-group">
		                        	<label class="col-md-3 control-label"><span class="field-required"> * </span>音乐片段：</label>
		                            <div class="col-md-4">
		                            	<div id="input-error">
		                            	<label>
		                            	    <img src="<%=request.getContextPath() %>/static/pages/img/logos/uploadBgm.jpg" height="50px" width="50px">                          
											<input style="display: none" id="file"  type="file"  name="file" data-url="<%=request.getContextPath() %>/bgm/uploadBgm.action" accept=".mp3"/>				
										</label>
	                            			<input type="hidden" id="path" name="path" class="form-control"/>  
	                            			
											<div id="bgmContent"></div>
	                            		</div>
	                            		
									</div>
								</div>
		                                                  
							</div>
	                                                        
							<div class="form-actions">
			                    <div class="row">
			                        <div class="col-md-offset-3 col-md-9">
			                            <button type="submit" class="btn green-jungle" >提 交</button>
			                            <button type="reset" id="resetBgmForm" class="btn grey-salsa btn-outline">取  消</button>
			                        </div>
			                    </div>
							</div>
						</form>
						<!-- END FORM-->
						
					</div>
				</div>
			</div>
                            
		</div>
	</div>
	
<script type="text/javascript">
    
    $("#file").fileupload({
    	pasteZone: "#bgmContent",
    	dataType: "json",
    	done: function(e, data) {
    		console.log(data);
    		
    		if (data.result.status != '200') {
    			alert("上传失败...");
    		} else {
    			var bgmServer = $("#bgmServer").val();
    			var url = bgmServer + data.result.data;
    			$("#bgmContent").html("<a href='" + url + "' target='_blank'>点击试听</a>");
    			$("#path").attr("value", data.result.data);
    			//$("#file").attr("style", "display:none");
    		}
    		
    	}
    });
    
    var submitBgm = function() {
    	$('#addBgmForm').ajaxSubmit({
    		url: $('#hdnContextPath').val() + '/bgm/addBgm.action',
    		type: 'POST',
    		success: function(data) {
    			
    			if (data.status == 200 && data.msg == 'OK') { 
    				alert('BGM添加成功...');
    				$("#bgmListMenu").click();
    			} else if(data.status == 500){
    				alert(data.msg);
    				$("#addBgmPage").click();
    			}else{
    				alert('BGM添加失败...');
    				$("#addBgmPage").click();
    			}			
    		}
    	});
    }
    
    $('#addBgmForm').validate({
    	errorElement: 'span', //default input error message container
        errorClass: 'help-block', // default input error message class
        focusInvalid: false, // do not focus the last invalid input
        ignore: "", // validate all fields including form hidden input
        rules: {
        	creator: {
                required: true,
                rangelength: [1,8]
            },
            name: {
                required: true,
                rangelength: [1,10]
            },
            path: {
                required: true
            }
        },
        messages: {
        	creator: {
                required: "歌手名字不能为空.",
                rangelength: "歌手名字长度请控制在1-8位."
            },
            name: {
                required: "歌曲名字不能为空.",
                rangelength: "歌曲名字长度请控制在1-10位."
            },
            path: {
                required: "路径不能为空."
            }
        },
        invalidHandler: function(event, validator) { //display error alert on form submit   
            $('.alert-danger', $('#addBgmForm')).show();
        },

        highlight: function(element) { // hightlight error inputs
            $(element).closest('.form-group').addClass('has-error'); // set error class to the control group
        },
        success: function(label) {
            label.closest('.form-group').removeClass('has-error');
            label.remove();
        },
        errorPlacement: function(error, element) {
            error.insertAfter(element.closest('#input-error'));
        },
        submitHandler: function(form) {
        	// FIXME
        	submitBgm();
        }
    });
    
    
</script>
