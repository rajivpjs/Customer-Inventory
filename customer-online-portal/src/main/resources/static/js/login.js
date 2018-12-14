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
               document.getElementById("login-form").reset();
               document.getElementById("login-title").innerHTML = "You have successfully logged in";
           },
           error: function(data) {
               alert(data);
           }
         });
});