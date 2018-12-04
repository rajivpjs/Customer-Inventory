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
           error: function(data) {
               alert(data);
           }
         });
});