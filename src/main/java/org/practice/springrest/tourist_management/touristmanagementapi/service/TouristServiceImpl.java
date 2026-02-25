package org.practice.springrest.tourist_management.touristmanagementapi.service;

import org.practice.touristmanagementapi.exception.TouristNotFoundException;
import org.practice.touristmanagementapi.model.Tourist;
import org.practice.touristmanagementapi.repo.ITouristRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristServiceImpl implements ITouristService {

    private ITouristRepo repo;

    @Autowired
    public void setRepo(ITouristRepo repo) {
        this.repo = repo;
    }

    @Override
    public String registerTourist(Tourist tourist) {
        Tourist tourist1 = repo.save(tourist);
        return "Tourist ID saved in the DB with ID: " + tourist1.getId();
    }

    @Override
    public Tourist fetchTouristById(Integer id) {
        // Uses the repository to find the tourist or throws the custom exception if not present
        return repo.findById(id)
                .orElseThrow(() -> new TouristNotFoundException("Tourist not found with ID: " + id)); // If you do not use .orElseThrow() (or a similar unwrap method like .get()), the code will not compile because the types do not match.
    }

    @Override
    public List<Tourist> fetchAllTouristInfo() {
        return repo.findAll();
    }

    @Override
    public String updateTourist(Tourist tourist) {
        // findById check ensures we update an existing record rather than creating a new one
        Tourist existing = repo.findById(tourist.getId())
                .orElseThrow(() -> new TouristNotFoundException("Cannot update. Tourist not found with ID: " + tourist.getId()));
        repo.save(tourist);
        return "Tourist details updated successfully for ID: " + tourist.getId();
    }

    @Override
    public String updateTouristBudget(Integer id, Integer budget) {
        Tourist tourist = repo.findById(id)
                .orElseThrow(() -> new TouristNotFoundException("Tourist not found with ID: " + id));
        tourist.setBudget(budget);
        repo.save(tourist);
        return "Tourist budget updated successfully for ID: " + id;
    }
    @Override
    public String deleteTourist(Integer id) {
        // Check if the record exists first to handle the Optional properly
        Tourist tourist = repo.findById(id)
                .orElseThrow(() -> new TouristNotFoundException("Cannot delete. Tourist not found with ID: " + id));

        repo.delete(tourist);
        return "Tourist with ID: " + id + " deleted successfully";
    }
}