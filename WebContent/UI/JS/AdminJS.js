/**
 * 管理员js
 * 实现前端的一些页面效果；
 * 下拉框二级联动；
 * 根据管理员权限来判断是否具有审核模块；
 */


		$(function() {

			/*左侧导航栏显示隐藏功能*/
			$(".subNav")
					.click(
							function() {
								/*显示*/
								if ($(this).find("span:first-child").attr(
										'class') == "title-icon glyphicon glyphicon-chevron-down") {
									$(this).find("span:first-child")
											.removeClass(
													"glyphicon-chevron-down");
									$(this).find("span:first-child").addClass(
											"glyphicon-chevron-up");
									$(this).removeClass("sublist-down");
									$(this).addClass("sublist-up");
								}
								/*隐藏*/
								else {
									$(this)
											.find("span:first-child")
											.removeClass("glyphicon-chevron-up");
									$(this).find("span:first-child").addClass(
											"glyphicon-chevron-down");
									$(this).removeClass("sublist-up");
									$(this).addClass("sublist-down");
								}
								// 修改数字控制速度， slideUp(500)控制卷起速度
								$(this).next(".navContent").slideToggle(300)
										.siblings(".navContent").slideUp(300);
							})
			/*左侧导航栏缩进功能*/
			$(".left-main .sidebar-fold")
					.click(
							function() {

								if ($(this).parent().attr('class') == "left-main left-full") {
									$(this).parent().removeClass("left-full");
									$(this).parent().addClass("left-off");

									$(this).parent().parent().find(
											".right-product").removeClass(
											"right-full");
									$(this).parent().parent().find(
											".right-product").addClass(
											"right-off");

								} else {
									$(this).parent().removeClass("left-off");
									$(this).parent().addClass("left-full");

									$(this).parent().parent().find(
											".right-product").removeClass(
											"right-off");
									$(this).parent().parent().find(
											".right-product").addClass(
											"right-full");

								}
							})

			/*左侧鼠标移入提示功能*/
			$(".sBox ul li").mouseenter(function() {
				if ($(this).find("span:last-child").css("display") == "none") {
					$(this).find("div").show();
				}
			}).mouseleave(function() {
				$(this).find("div").hide();
			})
		})
		
		function move(){								//实现各院系的两级联动
			//院管理员所属学院
			var college = $('#Cname').val();
			if(college == "null" || college == ""){
				collegeName = $('#college option:selected').val();
			}else{
				collegeName = college;
			}
		    var sdept = document.getElementById("sdept");
		    var add;		
		    //用来存储各学院的专业信息
		    if(collegeName == "马院"){   //对比value值，实现对应的二级专业动态生成
		      add = new Array("请选择所在专业","思想政治教育");
		    }else if(collegeName == "人文学院"){
		      add = new Array("请选择所在专业","汉语言文学","历史学","秘书学","英语","网络与新媒体");
		    }else if(collegeName == "数计学院"){
		      add = new Array("请选择所在专业","网络工程","计算机科学与技术","应用统计学","数学与应用数学");
		    }else if(collegeName == "电气学院"){
		      add = new Array("请选择所在专业","物理学","电子信息工程","电气自动化","电子信息与科学");
		    }else if(collegeName == "化材学院"){
		      add = new Array("请选择所在专业","化学","应用化学","金属材料工程","资源循环科学与工程");
		    }else if(collegeName == "生物学院"){
		      add = new Array("请选择所在专业","园林","制药工程","食品科学与工程","生物科学工程管理","生物技术");
		    }else if(collegeName == "建工学院"){
		      add = new Array("请选择所在专业","地理科学与技术","人文地理与城乡规划","工程管理","土木工程");
		    }else if(collegeName == "经管学院"){
		      add = new Array("请选择所在专业","会计学","信息管理与信护理学息系统","文化产业管理","电子商务","财务管理");
		    }else if(collegeName == "艺术学院"){
		      add = new Array("请选择所在专业","美术学","音乐学","学前教育学");
		    }else if(collegeName == "健康学院"){
		      add = new Array("请选择所在专业","食品卫生与营养","护理学","社会工作","应用心理学");
		    }else if(collegeName == ""){
		    	add = new Array("请选择所在专业");
		    }
		    sdept.length = 0;
		    for(var i =0;i<add.length;i++){     //将对应的专业添加到二级select中
		          var newSdept = new Option();
		          newSdept.text = add[i].split()[0];
		          newSdept.value = add[i].split()[0];
		          sdept.add(newSdept);			//把text值添加到二级select中，显示出来
		        }  	
		}
		
		//根据管理员权限来判断是否具有审核模块
		$(function(){
			var grade = $('#grade').val();
			if(grade == "1"){
				$('.audit').hide();
				$('.permissions').hide();
			}
		})
		
		
		$(function(){
			move();
		})
		
		
		