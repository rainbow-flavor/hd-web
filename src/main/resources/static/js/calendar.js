function scheduleAddFunc(){
    const scheduleForm = document.getElementById("scheduleAdd")
    const startScheduleDate = document.getElementById("startScheduleDate");
    const endScheduleDate = document.getElementById("endScheduleDate");
    const scheduleDetail = document.getElementById("scheduleDetail");

    /*console.log(startScheduleDate.value);
    console.log(endScheduleDate.value);
    console.log(scheduleDetail.value);*/

    scheduleForm.submit();

    $("#exampleModal").modal('hide');
}

/*function actionHandler(e = event){
    const scheduleId = e.target.previousElementSibling.value;
    console.log(scheduleId);
}*/

//해당 날짜를 가져와서 사이드 바에 출력
function tdActionHandler(e = event) {
    if(e.target == e.currentTarget){
        console.log(e);
    }
}