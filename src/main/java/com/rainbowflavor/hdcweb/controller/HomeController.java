package com.rainbowflavor.hdcweb.controller;

import com.rainbowflavor.hdcweb.calendar.DateData;
import com.rainbowflavor.hdcweb.dto.CalendarDto;
import com.rainbowflavor.hdcweb.string.ConstantUrl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.bridge.IMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Slf4j
@Controller
@RequestMapping(value= ConstantUrl.INDEX)
public class HomeController {

    @GetMapping(value = "/login")
    public String loginPage() {
        return "page/login";
    }

    @PostMapping(value = "/schedules")
    public String schedules(@ModelAttribute CalendarDto calendarDto) {
        System.out.println("startScheduleDate = " + calendarDto.getStartScheduleDate());
        System.out.println("startScheduleDate = " + calendarDto.getEndScheduleDate());
        System.out.println("startScheduleDate = " + calendarDto.getScheduleDetail());
        //save
        return "redirect:/index";
    }

    @GetMapping
    public String calendar(Model model, HttpServletRequest req, DateData dateData) {

        Calendar cal = Calendar.getInstance();
        DateData calendarData;
        //검색 날짜
        if(dateData.getDate().equals("")&&dateData.getMonth().equals("")){
            dateData = new DateData(String.valueOf(cal.get(Calendar.YEAR)),String.valueOf(cal.get(Calendar.MONTH)),String.valueOf(cal.get(Calendar.DATE)),null);
        }
        //검색 날짜 end

        Map<String, Integer> today_info =  dateData.todayInfo(dateData);
        List<DateData> dateList = new ArrayList<>();

        //실질적인 달력 데이터 리스트에 데이터 삽입 시작.
        //일단 시작 인덱스까지 아무것도 없는 데이터 삽입
        for(int i=1; i<today_info.get("start"); i++){
            calendarData= new DateData(null, null, null, null);
            dateList.add(calendarData);
        }

        //날짜 삽입
        for (int i = today_info.get("startDay"); i <= today_info.get("endDay"); i++) {
            if(i==today_info.get("today")){
                calendarData= new DateData(String.valueOf(dateData.getYear()), String.valueOf(dateData.getMonth()), String.valueOf(i), "today");
            }else{
                calendarData= new DateData(String.valueOf(dateData.getYear()), String.valueOf(dateData.getMonth()), String.valueOf(i), "normal_date");
            }
            dateList.add(calendarData);
        }

        //달력 빈곳 빈 데이터로 삽입
        int index = 7-dateList.size()%7;

        if(dateList.size()%7!=0){

            for (int i = 0; i < index; i++) {
                calendarData= new DateData(null, null, null, null);
                dateList.add(calendarData);
            }
        }

        //배열에 담음
        model.addAttribute("dateList", dateList);		//날짜 데이터 배열
        model.addAttribute("todayInfo", today_info);
        model.addAttribute("test", "aa");
        return "contents/calendar";

    }
}
