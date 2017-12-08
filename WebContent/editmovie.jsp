<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

                    <div id="cPage1">  
            <div class="tpl-portlet-components" >
                <div class="portlet-title">
                    <div class="caption font-green bold">
                        <span class="am-icon-code"></span> 表单
                    </div>
                    <div class="tpl-portlet-input tpl-fz-ml">
                        <div class="portlet-input input-small input-inline">
                            <div class="input-icon right">
                                <i class="am-icon-search"></i>
                                <input type="text" class="form-control form-control-solid" placeholder="搜索..."> </div>
                        </div>
                    </div>


                </div>

                <div class="tpl-block">

                    <div class="am-g">
                        <div class="tpl-form-body tpl-form-line">
                            <form class="am-form tpl-form-line-form">
								<!-- 这是一个电影名称开始 -->
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">电影名称<span class="tpl-form-line-small-title">：</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input"  placeholder="请输入电影名称" id="movieName" value="${movie.movieName}">
                                    </div>
                                    </div>
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">电影的图片地址<span class="tpl-form-line-small-title">：</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input"  placeholder="请输入电影的图片地址" id="imageUrl" value="${movie.imagePath }">
                                    </div>
                                    </div>
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">导演<span class="tpl-form-line-small-title">：</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input" placeholder="请输入导演" id="doctor" value="${requestScope.movieDetil.director}">
                                    </div>
                                    </div>
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">电影播放地址<span class="tpl-form-line-small-title">：</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input"  placeholder="请输入电影地址" id="movieUrl" value="${movie.url}">
                                    </div>
                                    </div>
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">评分<span class="tpl-form-line-small-title">：</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="tpl-form-input"  placeholder="请输入电影评分" id="score" value="${movie.score }">
                                    </div>
                                    </div>
								<!-- 这是一个input结束 -->

                              
								
								

                                <div class="am-form-group">
                                    <label class="am-u-sm-3 am-form-label">电影的关键字 <span class="tpl-form-line-small-title">SEO</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" placeholder="输入电影的种类关键字" id="keyWord" value="${movieDetil.keyword}">
                                    </div>
                                </div>
								
								<!--这是一个file控件开始-->
                                <div class="am-form-group">
                                    <label for="user-weibo" class="am-u-sm-3 am-form-label">封面图 <span class="tpl-form-line-small-title">Images</span></label>
                                    <div class="am-u-sm-9">
                                        <div class="am-form-group am-form-file">
                                            <div class="tpl-form-file-img">
                                                <img src="${movie.imagePath }"  alt="" id="imagePath">
                                            </div>
                                            <button type="button" class="am-btn am-btn-danger am-btn-sm">
    <i 												class="am-icon-cloud-upload"></i> 添加封面图片</button>
                                            <input id="doc-form-file" type="file" multiple>
                                        </div>

                                    </div>
                                </div>
								<!--这是一个file控件结束-->

                                <div class="am-form-group">
                                    <label for="user-weibo" class="am-u-sm-3 am-form-label">添加分类 <span class="tpl-form-line-small-title">Type</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" id="movieSort" placeholder="请添加分类用点号隔开" value= "${movieDetil.keyword}">
                                        <div>

                                        </div>
                                    </div>
                                </div>
								
								<!--这是一个单选按钮开始-->
                                <div class="am-form-group">
                                    <label for="user-intro" class="am-u-sm-3 am-form-label">隐藏文章</label>
                                    <div class="am-u-sm-9">
                                        <div class="tpl-switch">
                                            <input type="checkbox" class="ios-switch bigswitch tpl-switch-btn" />
                                            <div class="tpl-switch-btn-view">
                                                <div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
								<!--这是一个单选按钮结束-->

                                <div class="am-form-group">
                                    <label for="user-intro" class="am-u-sm-3 am-form-label">作品简介</label>
                                    <div class="am-u-sm-9">
                                        <textarea class="" rows="10" id="user-intro" placeholder="请输入电影的简介" id="t1">${movieDetil.des}</textarea>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <button type="button" class="am-btn am-btn-primary tpl-btn-bg-color-success " id="updatemoviename">提交</button>
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>


            </div>
<script type="text/javascript">
/* 	document.getElementById("t1").value=${movieDetil.des};
	alert(document.getElementById("t1").value); */

		/* 	<!--提交页面更新的信息的信息  -->
			<!--导演这一栏就不填写  --> */
		$ (function(){
		$("#updatemoviename").click(function(){
			var movieName= $("#movieName").val() ;
			var imagepath=$("#imagePath").val();
			var url=$("#imageUrl").val();
			var score=$("#score").val();
			var keyWord =$("#keyWord").val;
			var sort=$("#movieSort").val
				
				
			$.post(
				"updatemovie.edit",{
					
					movieName1:movieName,
					imagepath1:imagepath,
				/* 	<!-- doctor:doctor, --> */
					play1:play,
					score1:score,
					id:'${movie.id}'
					
					},function(data){
						
						$("#cPage1").html(data);
						
					},"html"
			
			
			);
			
		});
			});
		
	

</script>

</div>



