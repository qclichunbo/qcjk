var page = 0;
var cate_id = 0;

listPull(0, 0);

$("#main").dropload({
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
        "search": "", //搜索关键词
        "page": page, //获取第几页的数据
        "page_size": "10" //每页的记录数
    };
    $.ajax({
        url: "index.php?m=wgw&c=food_gi&a=getData",
        type: "get",
        dataType: "json",
        data: {
            "data": JSON.stringify(mydata)
        },
        success: function (result, me) {
            html = "";
            str = "";
            if (cate_id == 0) {
                $.each(result.cates, function (v, o) {
                    //console.log(o.image);
                    str += '<div class="swiper-slide" cate_id=' + o.id + '>' + '<img src=' + o.image + '>' + '<span>' + o.cate_name + '</span>' + '</div>';
                })
                $(".swiper-wrapper").append(str);
                $(".swiper-slide").on("click", function () {
                    var idx = $(this).index();
                    $(this).find("span").css({
                            "opacity ": "0"
                        })
                        .parent().siblings().find("span ").css({
                            "opacity ": "1 ",
                            "background ": "rgba(0,0,0,.7)"
                        });
                    cate_id = $(this).attr('cate_id');
                    $(".list").empty();
                    page = 0;
                    listPull(0, 0);
                })
                cate_id = result.cate_id;
            }
            $.each(result.food_gi, function (i, obj) {
                if (obj.food_gi_value < 60) {
                    html += '<li>' + obj.food_gi_name + '<span class="green">' + obj.food_gi_value + '</span>' + '</li>';
                } else
                if (obj.food_gi_value >= 60 && obj.food_gi_value <= 85) {
                    html += '<li>' + obj.food_gi_name + '<span class="blue">' + obj.food_gi_value + '</span>' + '</li>';
                } else {
                    html += '<li>' + obj.food_gi_name + '<span class="red">' + obj.food_gi_value + '</span>' + '</li>';
                }
            })
            if (is_settimmer == 1) {
                setTimeout(function () {
                    $(".list").append(html);
                    mei.reloadDom();
                }, 1000)
            } else {
                $(".list").append(html);
            }
        }
    })
}