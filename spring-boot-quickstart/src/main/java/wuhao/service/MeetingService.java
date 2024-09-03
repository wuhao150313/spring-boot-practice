package wuhao.service;


import org.springframework.stereotype.Service;
import wuhao.entiy.Meeting;

import java.util.ArrayList;
import java.util.List;

@Service

public class MeetingService {
    private final List<Meeting> meetings = new ArrayList<Meeting>();

    public boolean isRoomAvailable(Meeting newmeeting) {
        return meetings.stream()
                .noneMatch(exitingMeeting -> exitingMeeting.isOverlapping(newmeeting));
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }
}
