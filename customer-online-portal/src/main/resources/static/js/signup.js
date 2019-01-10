$("#submit-signup-form").on('click', function(e) {
    var json = {
            email : $("#email").val(),
            pass  : $("#pass").val(),
            firstName : $("#firstName").val(),
            lastName : $("#lastName").val()
            };

    e.preventDefault();

    $.ajax({
           type: "POST",
           url: "/register/customer",
           data: JSON.stringify(json),
           dataType: "json",
           contentType : "application/json",
           success: function(data)
           {
               $("#signup-form")[0].reset();
               $("#signup-title")[0].innerHTML = "You have successfully registered";
           },
            error: function(xhr,err) {
                if(xhr.status == 400) {
                    $("#signup-form")[0].reset();
                    alert("Email, password, firstName or lastName is empty. Please enter your details");
s                }
                 else if(xhr.status == 500) {
                    $("#signup-form")[0].reset();
                    alert("Please try again after some time");
                 }
            }
         });
});