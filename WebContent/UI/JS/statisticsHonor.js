/**
 * 绘制荣誉统计图
 */

      $(function(){
    	   // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('honor_bar'));
        var json = $('#json').val();
        var grade = $('#grade').val();
        var jsonList = $('#jsonList').val();
        //校管理员与院管理员text显示不同
        var text = "荣誉总数统计图";          
        //解析json
        json = $.parseJSON( json ); 
        var keyArr = new Array();  //学院名
        var valueArr = new Array();//荣誉数
        var jsonArr = [];
        for(var key in json){
        	       keyArr.push(key); //添加学院名
        	       valueArr.push(json[key])	//添加荣誉数
        	       jsonArr.push({
        	    	   name:key,
        	    	   value:json[key]
        	       })
        	     }
        // 指定图表的配置项和数据
        var bar_option = {
            title: {
                text: text,
            },
            tooltip: {},
            legend: {
                data:['荣誉数']
            },
            xAxis: {
                data: keyArr,
                axisLabel: {  
                	   interval:0,  
                	   rotate:30  
                	}  ,
                	 grid:{//直角坐标系内绘图网格
                         show:true,//是否显示直角坐标系网格。[ default: false ]
                         left:"20%",//grid 组件离容器左侧的距离。
                         right:"30px",
                         borderColor:"#c45455",//网格的边框颜色
                         bottom:"20%" //
                     },
            },
            yAxis: {},
            series: [{
                name: '荣誉数',
                type: 'bar',
                data: valueArr
            }]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(bar_option);
        
        
     // 绘制图表。
  	 //饼图
      var myChart = echarts.init(document.getElementById('honor_pie'));
      var pie_option = {
          title: {
              text: text,
              x: 'center'
          },
          tooltip: {
              trigger: 'item',
              formatter: "{a} <br/>{b} : {c} ({d}%)"
          },
         
          legend: {
              orient: 'vertical',
              left: 'left',
              data: keyArr,
          },
          series: [{
              name: '荣誉数',
              type: 'pie',
              radius: '55%',
              center: ['50%', '60%'],
              data: jsonArr,
              itemStyle: {
                  emphasis: {
                      shadowBlur: 10,
                      shadowOffsetX: 0,
                      shadowColor: 'rgba(0, 0, 0, 0.5)'
                  }
              }
          }]
      };

      myChart.setOption(pie_option);
      
    //折线图
      var keyYearsArr = new Array();  
      var valueYearsArr = new Array();
      var jsonListArr = [];
      var jsonFinlArr = [];
      jsonList = $.parseJSON( jsonList ); 
      for(var i=0; i<5; i++){
    	  for(var key in jsonList[i]){
        	  keyYearsArr.push(key); //50个学院名，即json中所有的学院名
        	  valueYearsArr.push(jsonList[i][key])	//添加专利数
    	       jsonListArr.push({
    	    	   name:key,
    	    	   value:jsonList[i][key]
    	       })
    	     }
    	  for(var key in jsonListArr[i]){
        	  valueYearsArr.push(jsonListArr[i][key])	//添加各个学院及其对应的专利数
    	     }
      }
      
      
      var arr1 = [];
      var arr2 = [];
      var arr3 = [];
      var arr4 = [];
      var arr5 = [];
      var arr6 = [];
      var arr7 = [];
      var arr8 = [];
      var arr9 = [];
      var arr10 = [];
      //获取10个学院5年的数据
      for(var i=0;i<50;i = i + 10){
    	  arr1.push(jsonListArr[i][key])
    	  arr2.push(jsonListArr[i+1][key])
    	  arr3.push(jsonListArr[i+2][key])
    	  arr4.push(jsonListArr[i+3][key])
    	  arr5.push(jsonListArr[i+4][key])
    	  arr6.push(jsonListArr[i+5][key])
    	  arr7.push(jsonListArr[i+6][key])
    	  arr8.push(jsonListArr[i+7][key])
    	  arr9.push(jsonListArr[i+8][key])
    	  arr10.push(jsonListArr[i+9][key])
      }
      var college = new Array();
      for(var i=0;i<10;i++){		//获取所需要的学院名
    	  college.push(keyYearsArr[i]);
      }
      
      
      var myChart = echarts.init(document.getElementById('honor_broken_line'));
      option = {
    		    title: {
    		        text: '折线图堆叠'
    		    },
    		    tooltip: {
    		        trigger: 'axis'
    		    },
    		    legend: {
    		        data:college
    		    },
    		    grid: {
    		        left: '3%',
    		        right: '4%',
    		        bottom: '3%',
    		        containLabel: true
    		    },
    		    toolbox: {
    		        feature: {
    		            saveAsImage: {}
    		        }
    		    },
    		    xAxis: {
    		        type: 'category',
    		        boundaryGap: false,
    		        data: ['2015','2016','2017','2018','2019']
    		    },
    		    
    		    
    		    yAxis: {
    		        type: 'value'
    		    },
    		    series: [
    		        {
    		            name:college[0],
    		            type:'line',
    		            stack: '总量',
    		            data:arr1
    		        },
    		        {
    		            name:college[1],
    		            type:'line',
    		            stack: '总量',
    		            data:arr2
    		        },
    		        {
    		            name:college[2],
    		            type:'line',
    		            stack: '总量',
    		            data:arr3
    		        },
    		        {
    		            name:college[3],
    		            type:'line',
    		            stack: '总量',
    		            data:arr4
    		        },
    		        {
    		            name:college[4],
    		            type:'line',
    		            stack: '总量',
    		            data:arr5
    		        },
    		        {
    		            name:college[5],
    		            type:'line',
    		            stack: '总量',
    		            data:arr6
    		        },
    		        {
    		            name:college[6],
    		            type:'line',
    		            stack: '总量',
    		            data:arr7
    		        },
    		        {
    		            name:college[7],
    		            type:'line',
    		            stack: '总量',
    		            data:arr8
    		        },
    		        {
    		            name:college[8],
    		            type:'line',
    		            stack: '总量',
    		            data:arr9
    		        },
    		        {
    		            name:college[9],
    		            type:'line',
    		            stack: '总量',
    		            data:arr10
    		        }
    		    ]
    		};
      
      myChart.setOption(option);
      })

      
      		