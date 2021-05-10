package com.example.NetflixShow.dao;

import com.example.NetflixShow.domain.ShowDetails;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface ShowDetailsRepository extends CrudRepository<ShowDetails, Integer>, JpaSpecificationExecutor<ShowDetails> {

    @Query(value = "SELECT * FROM netflix_titles limit :limit", nativeQuery = true)
    public List<ShowDetails> findTopN(@Param("limit") int limit);

    public List<ShowDetails> findByType(String type);

}
