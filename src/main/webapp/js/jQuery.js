/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {


    var getMembers = function () {
        $.ajax({
            url: "http://localhost:8080/AngularJQuery/api/member/complete",
            type: "GET",
            dataType: "json"
        }).then(function (data) {
            var row;
            row = "<tr>\n\
            <td><h4><b>id</b></h4></td>\n\
            <td><h4><b>age</b></h4></td>\n\
            <td><h4><b>eyeColor</b></h4></td>\n\
            <td><h4><b>name</b></h4></td>\n\
            <td><h4><b>email</b></h4></td>\n\
            <td><h4><b>friends</b></h4></td></tr>";
        
            $('#thead').append(row);

            for (var i = 0; i < data.length; i++) {

                row = "<tr>" +
                        "<td>" + data[i].id + "</td>" +
                        "<td>" + data[i].age + "</td>" +
                        "<td>" + data[i].eyeColor + "</td>" +
                        "<td>" + data[i].name + "</td>" +
                        "<td>" + data[i].email + "</td>" +
                        +"</tr>";

                $('#tbody').append(row);
            }

        });
    };
    getMembers();
});

