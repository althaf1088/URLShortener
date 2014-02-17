
$(function() {

    $('#lolo').click(function() {
        url = 'http://localhost:8080/tw/api/url';
        postData = {'lu': $("#in1").val()};
//        $.post(url,JSON.stringify(postData),function(response, textStatus, jqXHR){ outputPageContent(response);},'json'
//                ).fail(function(jqXHR, textStatus, errorThrown)
//        {
// alert(errorThrown);
//        });
//    



        $.ajax({
            url: url,
            type: 'POST',
            data: JSON.stringify(postData),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function(res) {
                outputPageContent(res);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert("error= " + errorThrown);
            }
        });

    });

});




function outputPageContent(response) {
    s = 'Shortened URL  :    <a href='+response.su+'>'+response.su+'</a>';
//    $.each(response, function(key, value) {
//        s = s + "<br/>&nbsp&nbsp&nbsp&nbsp" + key + "  :  " + value;
//    });
    $("#output").html(s);
}