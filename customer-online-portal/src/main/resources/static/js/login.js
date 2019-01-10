$("#submit-login-form").on('click', function(e) {
    var json = {
            email : $("#login-email").val(),
            pass  : $("#login-pass").val()
            };

    e.preventDefault();

    $.ajax({
           type: "POST",
           url: "/login/customer",
           data: JSON.stringify(json),
           dataType: "json",
           contentType : "application/json",
           success: function(data)
           {
               $("#login-form")[0].reset();
               $("#login-form")[0].innerHTML = "You have successfully logged in";
           },
           error: function(xhr,err) {
               if(xhr.status == 400) {
                   $("#login-form")[0].reset();
                   alert("Email or password is empty. Please enter your details");
               }
               else if(xhr.status == 401) {
                   $("#login-form")[0].reset();
                   alert("Please try again or if you don't remember your username or password please click Forgot password");
               }
               else if(xhr.status == 500) {
                   $("#login-form")[0].reset();
                   alert("Please try again after some time");
               }
           }
         });
});