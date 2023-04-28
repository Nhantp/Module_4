//function search(){
//    let name= ${"#title"}.val;
//    $.ajax({
//         url: "http://localhost:8080/api/v2/blog/search",
//         data:{
//            title: title;
//         },
//         type: "get",
//         dataType : "json",
//         success: function(data) {
//            let result='';
//            for (let i = 0; i < data.length; i++) {
//                result+=
//                    `
//                    <tr>
//                    <td><input type="text" value="${data[i].id" name="ids" >
//                    <td>${data[i].id}</td>
//                    <td>${data[i].title}</td>
//                    <td>${data[i].content}</td>
//                    <td>${data[i].time}</td>
//                    <td>${data[i].img}</td>
//                    <td>${data[i].category.categoryName}</td>
//                    `
//            }
//              $("#result").html(result);
//         }
//    })
//
//}