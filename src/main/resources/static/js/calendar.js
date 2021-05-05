function scheduleAddFunc(){
    const scheduleForm = document.getElementById("scheduleAdd")
    const startScheduleDate = document.getElementById("startScheduleDate");
    const endScheduleDate = document.getElementById("endScheduleDate");
    const scheduleDetail = document.getElementById("scheduleDetail");

    console.log(startScheduleDate.value);
    console.log(endScheduleDate.value);
    console.log(scheduleDetail.value);

    scheduleForm.submit();

    $("#exampleModal").modal('hide');
}

