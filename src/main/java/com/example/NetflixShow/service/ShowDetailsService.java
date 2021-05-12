package com.example.NetflixShow.service;

import com.example.NetflixShow.dao.ShowDetailsRepository;
import com.example.NetflixShow.domain.ShowDetails;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class ShowDetailsService {

    @Autowired
    private ShowDetailsRepository showDetailsRepository;

    public void insertToDb() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("classpath:netflix_titles.csv"));
        String line = null;
        int count = 0;
        while ((line = reader.readLine()) != null) {
            //Skip the header row
            if (count == 0) {
                count++;
                continue;
            }
            String[] lineContents = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

            ShowDetails showDetails = new ShowDetails();
            showDetails.setShowId(lineContents[0]);
            showDetails.setType(lineContents[1]);
            showDetails.setTitle(lineContents[2]);
            showDetails.setDirector(lineContents[3]);
            showDetails.setCast(lineContents[4]);
            showDetails.setCountry(lineContents[5]);
            showDetails.setDateAdded(lineContents[6]);
            showDetails.setReleaseYear(lineContents[7]);
            showDetails.setRating(lineContents[8]);
            showDetails.setDuration(lineContents[9]);
            showDetails.setListedIn(lineContents[10]);
            showDetails.setDescription(lineContents[11]);

            List<ShowDetails> result = showDetailsRepository.findAll((Specification<ShowDetails>) (root, criteriaQuery, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();

                String showId = showDetails.getShowId();
                Predicate predicateCountry = criteriaBuilder.and(criteriaBuilder.isNotNull(root.get("showId")), criteriaBuilder.equal(root.get("showId"), showId));
                predicates.add(predicateCountry);

                Predicate[] toPredicate = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(toPredicate);

            });
            if (result.size() == 0) {
                count++;
                showDetailsRepository.save(showDetails);
            }
        }

    }

    public ShowDetails postData(ShowDetails showDetails) {
        ShowDetails details = showDetailsRepository.save(showDetails);
        return details;
    }

    public List<ShowDetails> findByInput(Map<String, String> params) {
        List<ShowDetails> result = showDetailsRepository.findAll((Specification<ShowDetails>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (params.get("movieType") != null) {
                String movieType = params.get("movieType");
                Predicate predicateMovieType = criteriaBuilder.and(criteriaBuilder.isNotNull(root.get("listedIn")), criteriaBuilder.like(root.get("listedIn"), "%" + movieType + "%"));

                predicates.add(predicateMovieType);
            }

            if (params.get("country") != null) {
                String country = params.get("country");
                Predicate predicateCountry = criteriaBuilder.and(criteriaBuilder.isNotNull(root.get("country")), criteriaBuilder.equal(root.get("country"), country));
                predicates.add(predicateCountry);
            }
            Predicate[] toPredicate = predicates.toArray(new Predicate[predicates.size()]);
            return criteriaBuilder.and(toPredicate);

        });
        if (params.get("count") != null) {
            result = result.stream().limit(Integer.parseInt(params.get("count"))).collect(Collectors.toList());
        }
        return result;
    }

}
