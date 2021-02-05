import React from 'react'
import FullCalendar from '@fullcalendar/react'
import dayGridPlugin from '@fullcalendar/daygrid'
import interactionPlugin from "@fullcalendar/interaction"; // needed for dayClick

export default class DemoApp extends React.Component {

    render() {
        return (
            <FullCalendar
                plugins={[dayGridPlugin, interactionPlugin]}
                dateClick={this.handleDateClick}
                height={'93vh'}
            />
        )
    }

    handleDateClick = (arg) => { // bind with an arrow function
        alert(arg.dateStr)
    }

}