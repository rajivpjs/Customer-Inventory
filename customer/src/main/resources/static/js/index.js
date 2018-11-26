$('.form').find('input, textarea').on('keyup blur focus', function (e) {
  
  var $this = $(this),
      label = $this.prev('label');

	  if (e.type === 'keyup') {
			if ($this.val() === '') {
          label.removeClass('active highlight');
        } else {
          label.addClass('active highlight');
        }
    } else if (e.type === 'blur') {
    	if( $this.val() === '' ) {
    		label.removeClass('active highlight'); 
			} else {
		    label.removeClass('highlight');   
			}   
    } else if (e.type === 'focus') {
      
      if( $this.val() === '' ) {
    		label.removeClass('highlight'); 
			} 
      else if( $this.val() !== '' ) {
		    label.addClass('highlight');
			}
    }

});

$('.tab a').on('click', function (e) {
  
  e.preventDefault();
  
  $(this).parent().addClass('active');
  $(this).parent().siblings().removeClass('active');
  
  target = $(this).attr('href');

  $('.tab-content > div').not(target).hide();
  
  $(target).fadeIn(600);
  
});

$("#signup-form").submit(function(e) {

//    var email = document.getElementById('email').value;
//    var pass = document.getElementById('pass').value;
//    var firstName = document.getElementById('firstName').value;
//    var lastName = document.getElementById('lastName').value;

    // var json = "{\email\:" + email + ",\pass\:" + pass + ",\firstName\:" + firstName + ",\lastName\:" + lastName + "}";

    // var json = $("#signup-form").serialize();

    $.ajax({
           type: "POST",
           url: "/register/customer",
           data: JSON.stringify({ "email": $('#email').val(), "pass": $('#pass').val(), "firstName": $('#firstName').val(), "lastName": $('lastName').val() }),
           dataType: "json",
           contentType : "application/json;charset=utf-8",
           success: function(data)
           {
               alert("data");
           },
           error: function(data) {
               alert(data);
           }
         });

         e.preventDefault();
});