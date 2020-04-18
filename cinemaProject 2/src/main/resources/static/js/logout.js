$(document).ready(function () {

    $("#bth-logout").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function fire_ajax_submit() {

//    var search = {}
//    search["username"] = $("#username").val();
//    search["password"] = $("#password").val();

    $("#bth-logout").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/logout",
//        data: JSON.stringify(search),
//        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#bth-logout").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#bth-logout").prop("disabled", false);

        }
    });

}