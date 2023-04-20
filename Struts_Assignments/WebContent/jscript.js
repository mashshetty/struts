
	$(document).ready(function() {
		 $('#myTable').DataTable({
		    	
		    	 searching: false,
		    	 paging:false,
		    	
		    });

		var id = "";
		$('#city').prop('disabled', true);
		$('#dropbox').css('display', 'none');
		$('#state').change(function() {
			$.ajax({
				url : 'CityServlet',
				type : 'post',
				data : {
					state : $('#state').val()
				},
				success : function(data) {
					$('#city').prop('disabled', false);
					$('#city').html(data);
				}
			});
		});
		
	
		$('#statex').change(function() {
			$.ajax({
				url : 'CityServlet',
				type : 'post',
				data : {
					state : $('#statex').val()
				},
				success : function(data) {
					$('#cityx').prop('disabled', false);
					$('#cityx').html(data);
				}
			});
		});
		
		$('.del').click(function() {
			$.ajax({
				url : 'DeleteItem',
				type : 'post',
				data : {
					id : id
				},
				success : function(data) {
					alert("Deleted Successfully!!");
					window.location.replace("adduser.do");
				}
			});
		});
		
		

		$('.delete').click(function() {
			 id = $(this).attr('id');
			
			console.log("id is",id);
			$('html, body').animate({
				scrollTop : 0
			}, 'slow');
			$('#dropbox').css('display', 'flex');
		});

		$('.cancel').click(function() {

			$('#dropbox').css('display', 'none');
		});

		$('.del').click(function() {

			
			$('#dropbox').css('display', 'none');
			 
		});
		
		
		$(".editsub").click(function(){
			alert("user updated successfull!!")
		})
		

		$("#myForm").validate({
			rules : {
				fname : "required",
				lname : "required",
				uid : "required",
				email :{ required:true,
						email:true
				},
		
				dob : "required",

			},
			messages : {
				fname : "<br/>Please enter a first name",
				lname : " <br/>Please enter a last name",
				uid : " <br/>Please enter uid",
				email : {required:" <br/>Please enter email",
						email:" <br/>Please enter valid email"
				},
				dob : " <br/>Please enter DOB (yyyy-mm-dd)",
			}
		});

		

	});
	
	
