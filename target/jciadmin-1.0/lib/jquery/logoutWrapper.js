$(document).ready(function(){	
	  var val= $("#sessionValTochk").val();
	 if(val == 'null'){
		  $.ajax({
				type:"GET",
				url:"logout.obj",
				data:{"id":val},
				success:function(result){				 
	 				window.location.assign("index.obj");
				}			
			});			  
	  }
});	