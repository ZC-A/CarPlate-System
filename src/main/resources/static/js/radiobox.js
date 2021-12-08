
$(document).ready(function ($){

    //$("input[type='radio']").first().next().css('color','#649723');		//设置默认选项的文字为选中状态
    $(":radio").click(function (){
        $("input[type='radio']").each(function(){
            if(this.checked){
                $(this).next().css('color','#649723');
            }else{
                $(this).next().css('color','#767676');
            }
        });

    });
});
