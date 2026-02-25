package org.practice.springrest.tourist_management.touristmanagementapi.service;

import org.practice.springrest.tourist_management.touristmanagementapi.model.*;
import java.util.List;

public interface ITouristService {
    String registerTourist(Tourist tourist);
    Tourist fetchTouristById(Integer id);
    List<Tourist> fetchAllTouristInfo();
    String updateTourist(Tourist tourist); // For PUT
    String updateTouristBudget(Integer id, Integer budget); // For PATCH
    String deleteTourist(Integer id);
}