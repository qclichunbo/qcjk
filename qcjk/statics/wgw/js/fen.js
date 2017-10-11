;
(function ($) {
    $.ajax({
        url: "index.php?m=wgw&c=food_element_cate&a=getData",
        type: "get",
        dataType: "json",
        success: function (data) {
            html = '';
            $.each(data, function (v, i) {
                html += '<li>' + '<a href = " index.php?m=wgw&c=food_element_list&cate_id=' + i.id + '">' + '<img src=' + i.image + '>' + '</a><span>' + i.cate_name + '</span>' + '</li>';
            })
            $(".list").html(html);
        }
    })
   ;
    
})(Zepto);