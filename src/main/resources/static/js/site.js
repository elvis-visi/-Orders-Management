$(document).ready( function() {
	
	// check the browser console to see status message when page loads.
	console.log("ready");
	
	// hide the entry form by default.
	$("#entry-form").hide();
	
	
		// click handler for the search button
	$("#search-button").click(function(){
		$("#entry-form").hide(500);
		// get the search term from the input text box.
		var searchTerm = $("#searchTerm").val();
		
		console.log("You searched for " + searchTerm);
		
		 $.ajax(
			{
				// REST controller url
				url: "http://localhost:8080/api/v1/orders/search/"+searchTerm, 
	    
	    		// callback function runs after the server responds.
	    		success: function(result)
	    		{
					console.log(result);
					
					// concatenate elements to display.
				var outputHTML = "";
			    for (var x = 0; x < result.length; x++){
					var order = result[x];
			        outputHTML += "<div class='single-order'><ul>";
			        outputHTML += "<li>Id:" + order.id + "</li>";
			        outputHTML += "<li>OrderNumber: " + order.orderNo + "</li>";
			        outputHTML += "<li>ProductName: " + order.productName + "</li>";
			        outputHTML += "<li>Price: " + order.price + "</li>";
			        outputHTML += "<li>Quantity: " + order.quantity + "</li>";
			        outputHTML += "</ul>";
			        outputHTML += "<button class = 'edit-button  btn btn-secondary' value = '" + order.id + "'>Edit</button>";
			        outputHTML += "<button class = 'delete-button btn btn-primary' value = '" + order.id + "'>Delete</button>";
			         outputHTML += "</div>";
			    }
				 // replace the contents of the <div results-box> with the generated results
	    			$("#results-box").html(outputHTML);

					
				}
			});
		});
		
	
});