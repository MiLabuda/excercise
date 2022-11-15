package com.excercise.services;

import com.excercise.model.Campaign;
import com.excercise.model.User;


import java.util.List;

public interface ICampaignService {
    List<Campaign> findAll();
    List<Campaign> getCampaignByUser(User user);
    void save(Campaign campaign, Long productId);
    void edit(Long id, Campaign campaign);
    void delete(Long id);
    Long count();
    Campaign getCampaignById(Long id);
    List<Campaign> getCampaignsByProduct(Long id);
    boolean existCampaignByCampaignId(Long id);
}
