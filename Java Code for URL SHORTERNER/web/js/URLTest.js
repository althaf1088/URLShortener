
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
 
 
    $('#lolo2').click(function() {
        url = 'http://localhost:8080/tw/api/url/stat';
        postData = {'su': $("#in1").val()};
 
 
        $.ajax({
            url: url,
            type: 'POST',
            data: JSON.stringify(postData),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function(res) {
                showTable(res);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert("error= " + errorThrown);
            }
        });
 
    });
 
});
 
 
 
function showTable(response) {
 
    $("#output").html('<br/><br/><br/><br/> Request origin and respective hits<br/><br/>');
    var $table = $('<table/>');
        $.each(response, function(key, value) {
        $table.append('<tr><td>' + 'ip : <a  href="" >' + value.ipUrlPK.ipla +'</a></td><td>'+ ' &nbsp &nbsp hits : <b>'+ value.count+ '</b></td></tr>');
    });
//    for (var i = 0; i < 3; i++) {
//        $table.append('<tr><td>' + 'result' + i + '</td></tr>');
//    }
    $('#output').append($table);
}
 
 
 
function outputPageContent(response) {
    s = 'Shortened URL  :    <a href=' + response.su + '>' + response.su + '</a>';
//    $.each(response, function(key, value) {
//        s = s + "<br/>&nbsp&nbsp&nbsp&nbsp" + key + "  :  " + value;
//    });
    $("#output").html(s);
}




function outputPageContent(response) {
    s = 'Shortened URL  :    <a href='+response.su+'>'+response.su+'</a>';
//    $.each(response, function(key, value) {
//        s = s + "<br/>&nbsp&nbsp&nbsp&nbsp" + key + "  :  " + value;
//    });
    $("#output").html(s);
}