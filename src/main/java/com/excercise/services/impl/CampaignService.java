package com.excercise.services.impl;

import com.excercise.model.Campaign;
import com.excercise.model.User;
import com.excercise.repository.ICampaignRepository;
import com.excercise.repository.IProductRepository;
import com.excercise.services.ICampaignService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService implements ICampaignService {

    private final ICampaignRepository campaignRepository;
    private final IProductRepository productRepository;

    @Autowired
    public CampaignService(ICampaignRepository campaignRepository, IProductRepository productRepository) {
        this.campaignRepository = campaignRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void save(Campaign campaign, Long productId) {
        campaign.setId();
        campaign.setProduct(productRepository.getReferenceById(productId));
        campaignRepository.save(campaign);
    }

    @Override
    public void edit(Long id, Campaign campaign) {
        Campaign updatedCampaign = campaignRepository.findCampaignById(id);
        updatedCampaign.setName(campaign.getName());
        updatedCampaign.setActiveStatus(campaign.isActiveStatus());
        updatedCampaign.setMinimalBid(campaign.getMinimalBid());
        updatedCampaign.setCampaignFunds(campaign.getCampaignFunds());
        updatedCampaign.setKeywords(campaign.getKeywords());
        updatedCampaign.setTargetTown(campaign.getTargetTown());
        updatedCampaign.setRadiusInKm(campaign.getRadiusInKm());
        campaignRepository.save(updatedCampaign);
    }

    @Override
    public List<Campaign> findAll() {
        return campaignRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        campaignRepository.delete(campaignRepository.findCampaignById(id));
    }

    @Override
    public Long count() {
        return campaignRepository.count();
    }

    @Override
    public Campaign getCampaignById(Long id) {
        return campaignRepository.getReferenceById(id);
    }

    @Override
    public List<Campaign> getCampaignsByProduct(Long id) {
     return campaignRepository.findCampaignsByProduct(productRepository.findProductById(id));
    }

    @Override
    public boolean existCampaignByCampaignId(Long id) {
        return this.campaignRepository.existsCampaignById(id);
    }

    @Override
    public boolean enoughFunds(Long productFunds, Long campaignFunds) {
        return productFunds - campaignFunds > 0;
    }


}
