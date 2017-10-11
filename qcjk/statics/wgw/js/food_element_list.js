var page = 0;
var cate_id = 0;

listPull(0, 0);

$("#conner").dropload({
    loadUpFn: function (me) {
        listPull(me, 1);
    },
    loadDownFn: function (me) {
        listPull(me, 1);
    }
});

function listPull(me, is_settimmer) {
    page++;
    var mei = me;
    var mydata = {
        "cate_id": cate_id, //分类编号
        "page": page, //获取第几页的数据
        "page_size": "10" //每页的记录数
    };
    $.ajax({
        url: "index.php?m=wgw&c=food_element_list&a=getData",
        type: "get",
        dataType: "json",
        data: {
            "data": JSON.stringify(mydata)
        },
        success: function (result, me) {
            str = "";
            if (cate_id == 0) {
                $.each(result, function (v, o) {
                        /*  str += '<div class="swiper-slide" cate_id=' + o.id + '>' + '<img src=' + o.image + '>' + '<span>' + o.cate_name + '</span>' + '</div>';*/
                    })
                    /*      $(".swiper-wrapper").append(str);*/
                cate_id = result.cate_id;
            }
        }
    })
}