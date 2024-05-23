$("#ParentMenuID").change(function(){		
	var val=$(this).val();	
	alert(val);
	if(val!="")
	{
		$.ajax({
			type:"POST",
			url:"getFilledProductPosition",
			data:{"id":val},
			success:function(obj){
				alert(obj);
//				if(obj.length>0)				
//				{
//					document.getElementById("child").style.display="block";
//					var buffer="<option value='' selected disabled hidden>Select Expertise</option>";
//					var buff="";
//					for(var i=0;i<obj.length;i++)
//					{				
//						buffer+=("<option value="+obj[i].l2id+">"+obj[i].l2name+"</option>");
//						buff+="<input type='hidden' id='child"+obj[i].l2id+"' value='"+obj[i].l2name+"'>"
//					}			
//					document.getElementById("subExpertId").innerHTML=buffer;			    
//					document.getElementById("hide").innerHTML=buff;			    
//				}
//				else
//				{
//					document.getElementById("child").style.display="none";
//					document.getElementById("selectedArea").value="";
//					//document.getElementById("selectedAreaDiv").style.display="none";
//					alert("No Record Found!");
//				}			
			}			
		});			
	}
});	