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
               document.getElementById("signup-form").reset();
               document.getElementById("signup-title").innerHTML = "You have successfully registered";
           },
            error: function(xhr,err) {
                if(xhr.status == 400) {
                    document.getElementById("signup-form").reset();
                    alert("Email, password, firstName or lastName is empty. Please enter your details");
s                }
                 else if(xhr.status == 500) {
                    document.getElementById("signup-form").reset();
                    alert("Please try again after some time");
                 }
            }
         });
});