function search() {
    let searchAll = $("#searchAll").val();
    $.ajax({
       url: "http://localhost:8080/api/v2/blog/search",
       data: {
           searchAll: searchAll,
           page: 1,
           size: 2
       },
        type: "get",
        dataType: "json",
        success: function(data) {
            let resultHtml = '';
            for (let i = 0; i < data.content.length; i++) {
                let blog = data.content[i];
                resultHtml += `
                <div>
                    <div  class="vtimeline-block" style="margin-bottom: 50px">
                                <div class="vtimeline-content">

                                    <br>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor"
                                         class="bi bi-card-heading" viewBox="0 0 16 16">
                                        <path d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h13zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
                                        <path d="M3 8.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0 2a.5.5 0 0 1 .5-.5h6a.5.5 0 0 1 0 1h-6a.5.5 0 0 1-.5-.5zm0-5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5v-1z"/>
                                    </svg>
                                    <h3> ${blog.title} </h3>
                                    <hr>
                                    <ul class="post-meta list-inline">
                                        <li>
                                            <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor"
                                                 class="bi bi-file-font-fill" viewBox="0 0 16 16">
                                                <path d="M12 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zM5.057 4h5.886L11 6h-.5c-.18-1.096-.356-1.192-1.694-1.235l-.298-.01v6.09c0 .47.1.582.903.655v.5H6.59v-.5c.799-.073.898-.184.898-.654V4.755l-.293.01C5.856 4.808 5.68 4.905 5.5 6H5l.057-2z"/>
                                            </svg>
                                            <span> ${blog.content}</span><br>
                                        </li>
                                        <hr>
                                        <li class="list-inline-item">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor"
                                                 class="bi bi-file-code-fill" viewBox="0 0 16 16">
                                                <path d="M12 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zM6.646 5.646a.5.5 0 1 1 .708.708L5.707 8l1.647 1.646a.5.5 0 0 1-.708.708l-2-2a.5.5 0 0 1 0-.708l2-2zm2.708 0 2 2a.5.5 0 0 1 0 .708l-2 2a.5.5 0 0 1-.708-.708L10.293 8 8.646 6.354a.5.5 0 1 1 .708-.708z"/>
                                            </svg>
                                            <span> ${blog.category.categoryName}</span>
                                        </li>
                                        <hr>
                                        <li class="list-inline-item">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                                                 class="bi bi-calendar" viewBox="0 0 16 16">
                                                <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"/>
                                            </svg>
                                            <span> ${blog.time}</span>
                                        </li>
                                               <hr>
                                         <li class="list-inline-item">
                                             <button style="padding: 10px;background: red; margin-right: 10px" type="submit"
                                                     class="btn btn-red">
                                                 <a style="color: white" href="@{/blog/update?id=${blog.id})}">
                                                     <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor"
                                                          class="bi bi-trash" viewBox="0 0 16 16">
                                                         <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
                                                         <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
                                                     </svg>
                                                 </a></button>
                                             <button style="padding: 10px;background: dodgerblue" type="submit" class="btn btn-red"><a
                                                     style="color: white" href="@{/blog/update?id=${blog.id})}">
                                                 <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor"
                                                      class="bi bi-arrow-repeat" viewBox="0 0 16 16">
                                                     <path d="M11.534 7h3.932a.25.25 0 0 1 .192.41l-1.966 2.36a.25.25 0 0 1-.384 0l-1.966-2.36a.25.25 0 0 1 .192-.41zm-11 2h3.932a.25.25 0 0 0 .192-.41L2.692 6.23a.25.25 0 0 0-.384 0L.342 8.59A.25.25 0 0 0 .534 9z"/>
                                                     <path fill-rule="evenodd"
                                                           d="M8 3c-1.552 0-2.94.707-3.857 1.818a.5.5 0 1 1-.771-.636A6.002 6.002 0 0 1 13.917 7H12.9A5.002 5.002 0 0 0 8 3zM3.1 9a5.002 5.002 0 0 0 8.757 2.182.5.5 0 1 1 .771.636A6.002 6.002 0 0 1 2.083 9H3.1z"/>
                                                 </svg>
                                             </a></button>
                                         </li>
                                     </ul>
                                     <a href="#" class="btn btn-outline-secondary btn-sm">Read More</a>
                                 </div>
                             </div>
                    </div>
                </div>`;
            }
            $("#result").html(resultHtml);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log(textStatus, errorThrown);
        }
    });
}
