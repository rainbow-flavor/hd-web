import React from 'react'
import FullCalendar from '@fullcalendar/react'
import dayGridPlugin from '@fullcalendar/daygrid'
import interactionPlugin from "@fullcalendar/interaction"; // needed for dayClick
import googlecalendarPlugin from '@fullcalendar/google-calendar';

export default class DemoApp extends React.Component {

    render() {
             return (
            <FullCalendar
                plugins={[dayGridPlugin, interactionPlugin,googlecalendarPlugin]}
                dateClick={this.handleDateClick}
                eventClick={this.handleEventClick}
                height={'93vh'}
                googleCalendarApiKey="AIzaSyA8Xs_pKqsDGL8UX9NEA-BZlHbBo3udH6c"
                eventSources={[
                    {
                        googleCalendarId:'ko.south_korea#holiday@group.v.calendar.google.com',
                        backgroundColor:'red',
                        display:'background',
                    }
                ]}
                locale='ko'
            />
        )
    }

    handleDateClick = (arg) => { // bind with an arrow function
        console.log(arg.date);
    }

    handleEventClick = (e) =>{
        console.log(e.event.title);
    }

}