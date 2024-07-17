package com.rocketseat.planer.activity;

import com.rocketseat.planer.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ActivityService {

    @Autowired
    ActivityRepository repository;

    public ActivityResponse registerActivity(ActivityRequestPayload payload, Trip trip) {
        Activity newactivity = new Activity(payload.title(), payload.occurs_at(), trip);

        this.repository.save(newactivity);

        return new ActivityResponse(newactivity.getId());
    }

    public List<ActivityData> getAllActivityFromId(UUID tripId) {
        return this.repository.findByTripId(tripId).stream().map(activity -> new ActivityData(activity.getId(),
                activity.getTitle(), activity.getOccurs_At())).toList();
    }
}
