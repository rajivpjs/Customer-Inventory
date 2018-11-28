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
           headers: { "Content-type" : "application/json" },
           data: JSON.stringify(json),
           dataType: "json",
           contentType : "application/json",
           success: function(data)
           {
               // window.location.href = "/loggedin.html";
           },
           error: function(data) {
               alert(data);
           }
         });
});