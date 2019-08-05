function searchBook(){
    var search_data = $('#form_search').serialize();
    $.ajax({
        url : '/students/search',
        method : 'POST',
        data : search_data,
        success : function (data) {
            console.log(data);
        }
    });
}

$(document).on('keydown', 'input[pattern]', function(e){
    var input = $(this);
    var oldVal = input.val();
    var regex = new RegExp(input.attr('pattern'), 'g');
    setTimeout(function(){
        var newVal = input.val();
        if(!regex.test(newVal)){
            input.val(oldVal);
        }
    }, 0);
});
