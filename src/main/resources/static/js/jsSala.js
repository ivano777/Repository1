$(document).ready(function () {
	
	var table = $('#Sala').DataTable({
        
		
        "type":'POST',
        "sAjaxSource": "/allSala",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
              { "mData": "id" },
              { "mData": "nomeSala" },
              { "mData": "numeroPosti" },
              {
                  "mData": null,
                  "bSortable": false,
                 "mRender": function (data, type, full) { 
                	 return '<a class="btn btn-info btn-sm" href=/findByIdSala/' + data.id + '>' + 'Visualizza' + '</a>'; }
              }
      
        ]
       
 });
	

    /*("#search-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });*/

});




function fire_ajax_submit() {

    var search = {}
    search["nomeSala"] = $("#nomeSala").val();

    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/searchSala",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            //var json = json

           /* var json = JSON.stringify(data, null, 4);
            $('#feedback').html(json);
            */

           var json = JSON.stringify(data, null, 4);
           $('#feedback').html(json);


            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        //////////////////////////////////////////

    

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });
    
    /*
    $(document).ready( function () {
        var table = $('#Sala').DataTable({
               
               "type":'POST',
               "sAjaxSource": "/allSala",
               "sAjaxDataProp": "",
               "order": [[ 0, "asc" ]],
               "aoColumns": [
                     { "mData": "id" },
                     { "mData": "nomeSala" },
                     { "mData": "numeroPosti" }
               ]
        })
   });*/
 

      
    }
 


