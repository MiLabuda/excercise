package com.excercise.repository;

import com.excercise.model.Campaign;
import com.excercise.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ICampaignRepository extends JpaRepository<Campaign, Long>{
    Campaign findCampaignById(Long productId);
    Campaign findCampaignByName(String name);
    boolean  existsCampaignById(Long id);
    List<Campaign> findCampaignsByProduct(Product product);
}
