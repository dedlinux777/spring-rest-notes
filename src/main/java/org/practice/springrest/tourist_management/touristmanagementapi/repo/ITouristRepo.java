package org.practice.springrest.tourist_management.touristmanagementapi.repo;

import org.practice.touristmanagementapi.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITouristRepo extends JpaRepository<Tourist, Integer> {
}
