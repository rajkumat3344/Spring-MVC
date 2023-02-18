package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.web.models.Club;

public interface ClubRepository extends JpaRepository<Club, Long>{
  Optional<Club> findBytitle(String Url);
}
