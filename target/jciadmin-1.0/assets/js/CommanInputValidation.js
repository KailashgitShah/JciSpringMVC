// common.js

/*function stringValidation (val){
		console.log(val);
	}*/
	
/*	$("input.StringValid").on("input", function () {
    // Access the value of the input field using $(this).val()
    var inputValue = $(this).val();
       
    // Call your function with the input value
    console.log(inputValue);
});*/

$(document).ready(function () {
    $("input.stringValidation").on("input", function () {
        // Access the value of the input field using $(this).val()
        var inputValue = $(this).val();
      
       var refVal = inputValue.replace(/[^a-zA-Z0-9-\s]/g, "");
       $(this).val(refVal);              

    });
    
    $("input.numberValidation").on("input", function () {
        // Access the value of the input field using $(this).val()
         var inputValue = $(this).val();
         
          var sanitizedValue = inputValue.replace(/[^0-9]/g, '');

        $(this).val(sanitizedValue);

    });
});
