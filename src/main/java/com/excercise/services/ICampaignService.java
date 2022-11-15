package com.excercise.services;

import com.excercise.model.Campaign;


import java.util.List;

public interface ICampaignService {
    List<Campaign> findAll();
    void save(Campaign campaign, Long productId);
    void edit(Long id, Campaign campaign);
    void delete(Long id);
    Long count();
    Campaign getCampaignById(Long id);
    List<Campaign> getCampaignsByProduct(Long id);
    boolean existCampaignByCampaignId(Long id);
    boolean enoughFunds(Long productFunds, Long campaignFunds);

}
