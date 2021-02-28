import React from 'react'
import FullCalendar from '@fullcalendar/react'
import dayGridPlugin from '@fullcalendar/daygrid'
import interactionPlugin from "@fullcalendar/interaction"; // needed for dayClick
import googlecalendarPlugin from '@fullcalendar/google-calendar';

export default class DemoApp extends React.Component {

    state={
        allDayEvents:''
    }

    render() {
             return (
                 <div>
                     
                     <FullCalendar
                         plugins={[dayGridPlugin, interactionPlugin,googlecalendarPlugin]}
                         dateClick={this.handleDateClick}
                         height={'93vh'}
                         googleCalendarApiKey="AIzaSyA8Xs_pKqsDGL8UX9NEA-BZlHbBo3udH6c"
                         eventSources={[
                             {
                                 googleCalendarId:'ko.south_korea#holiday@group.v.calendar.google.com',
                                 backgroundColor:'red',
                                 display:'background',
                             }
                         ]}
                         events={[
                             {
                                 title:'할일1',
                                 date:'2021-03-02'
                             },
                             {
                                 title:'할일2',
                                 date:'2021-03-02'
                             },
                             {
                                 title:'할일3',
                                 date:'2021-03-02'
                             },
                             {
                                 title:'할일4',
                                 date:'2021-03-02'
                             }
                         ]}
                         locale='ko'
                     />
                     <p>{this.state.allDayEvents}</p>
                 </div>
        )
    }

    handleDateClick = (arg) => { // bind with an arrow function
        this.setState({
            allDayEvents: arg.dayEl.innerText,
        })
    }

}