

$("#encryptMessage").on("click", () => {
    $.ajax({
        method: "POST",
        url: "/sha/encr/",
        data: JSON.stringify(sha1Object()),
        contentType: "application/json",
        success: [function (response) {
                $(response.data).each(function (index, info) {
                    $("encryptedMessage").html(info.encryptedMessage);
                })
        }]
    })
})


const sha1Object = () => {
    return {
        initialName: $("#message").val()
    }
}