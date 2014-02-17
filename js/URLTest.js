
$(function() {

    $('#lolo').click(function() {
        url = 'http://localhost:3000/urls';
        postData = {'url': $("#in1").val()};
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
    s = 'Shortened URL  :    <a href='+response.shorturl+'>'+response.shorturl+'</a>';
    $("#output").html(s);
}