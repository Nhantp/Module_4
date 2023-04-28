function search() {
    let searchAll = $("#searchAll").val();
    $.ajax({
       url: "http://localhost:8080/api/v2/blog/search",
       data: {
           searchAll:searchAll,
           page: 1,
           size: 4
       },
        type: "get",
        dataType: "json",
        success: function(data) {
        let resultHtml = '';
            // hiển thị kết quả tìm kiếm trên trang web
            for (let i = 0; i < data.length; i++) {
                resultHtml +=
                `
                <li>
//                resultHtml += "<a><img src=\"/getImg/" + blog.image + "\" ></a>";
                 <span> + ${data[i].title} + "/span>
                 <span> + ${data[i].content} + </span>
                 <span> + ${data[i].category.categoryName} + </span>
                 <span> + ${data[i].time} + </span>
                 </li>
                `
            }
            $("#result").html(resultHtml);
        }
    });
}
