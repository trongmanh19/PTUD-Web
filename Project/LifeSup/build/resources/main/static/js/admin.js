$(document).ready(function () {
    var dataBangDiem = {};

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#input-select-img-attach").change(function() {
        readURL(this);
        var formData = new FormData();
        NProgress.start();
        formData.append('file', $("#input-select-img-attach")[0].files[0]);
        axios.post("/api/upload/upload-attach", formData).then(function(res){
            NProgress.done();
            if(res.data.success) {
                dataBangDiem = {
                    link: res.data.link
                };
            }
        }, function(err){
            NProgress.done();
        })
    });

    $("#btn-new-bangdiem").on("click", function () {
        dataBangDiem = {};
        $("#input-bangdiem-lophoc").val("1");
        $("#modal-create-bangdiem").modal();
    });

    $(".btn-edit").on("click", function () {
        var bdInfo = $(this).data("bangdiem");
        console.log($(this))
        console.log($(this).data("bangdiem"))

        NProgress.start();
        axios.get("/api/bangdiem/detail/" + bdInfo).then(function(res){
            NProgress.done();
            if(res.data.success) {
                console.log(res.data.data);
                dataBangDiem.id = res.data.data.id;
                dataBangDiem.link = res.data.data.link;
                $("#input-bangdiem-lophoc").val(res.data.data.lopHoc.id);
                $("#modal-create-bangdiem").modal();
            }
        }, function(err){
            NProgress.done();
        })
    });

    $(".btn-save-bangdiem").on("click", function () {
        if(dataBangDiem.link === undefined) {
            swal(
                'Error',
                'You need to fill all values',
                'error'
            );
            return;
        }
        dataBangDiem.idLopHoc = $('#input-bangdiem-lophoc').val();
        console.log(dataBangDiem);
        NProgress.start();

        var linkPost = "/api/bangdiem/create-bangdiem";
        if(dataBangDiem.id) {
            linkPost = "/api/bangdiem/update-bangdiem/" + dataBangDiem.id;
        }

        axios.post(linkPost, dataBangDiem).then(function(res){
            NProgress.done();
            console.log(res.data)
            if(res.data.success) {
                swal(
                    'Good job!',
                    res.data.message,
                    'success'
                ).then(function() {
                    location.reload();
                });
            } else {
                swal(
                    'Error',
                    res.data.message,
                    'error'
                );
            }
        }, function(err){
            NProgress.done();
            swal(
                'Error',
                'Some error when saving bangdiem',
                'error'
            );
        })
    });

    // ----------------------Delete BangDiem-----------------------
    $(".btn-delete").on("click", function () {
        var bdInfo = $(this).data("bangdiem");
        swal({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            type: 'warning',
            showCancelButton: true
        }).then(function(result) {
            if (result.value) {
                NProgress.start();
                axios.post("/api/bangdiem/delete-bangdiem", {
                    idBangDiem : bdInfo
                }).then(function(res){
                    NProgress.done();
                    if(res.data.success) {
                        swal(
                            'Good job!',
                            res.data.message,
                            'success'
                        ).then(function() {
                            location.reload();
                        });
                    } else {
                        swal(
                            'Error',
                            res.data.message,
                            'error'
                        );
                    }
                }, function(err){
                    NProgress.done();
                    swal(
                        'Error',
                        'Some error when saving bangdiem',
                        'error'
                    );
                })
            }
        })
    });

});