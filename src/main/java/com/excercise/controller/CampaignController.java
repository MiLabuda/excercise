package com.excercise.controller;

import com.excercise.model.Campaign;
import com.excercise.services.ICampaignService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CampaignController {

    private final ICampaignService campaignService;

    public CampaignController(ICampaignService campaignService) {
        this.campaignService = campaignService;
    }


    @GetMapping("/api/campaigns")
    public ResponseEntity<Object> getCampaigns(){
        return new ResponseEntity<>(campaignService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/product/{productId}/campaigns")
    public ResponseEntity<Object> getCampaignsByProduct(@PathVariable Long productId){
        return new ResponseEntity<>(campaignService.getCampaignsByProduct(productId), HttpStatus.OK);
    }

    @PostMapping("/api/product/{productId}/campaigns")
    public @ResponseBody ResponseEntity<Object> sendNewCampaign(@PathVariable Long productId, @RequestBody @Valid Campaign campaign){
        campaignService.save(campaign, productId);
        return new ResponseEntity<>(campaign, HttpStatus.OK);
    }
    @DeleteMapping("/api/campaign/{id}")
    public ResponseEntity<String> deleteCampaign(@PathVariable Long id){
        try {
            if (this.campaignService.existCampaignByCampaignId(id)) {
                this.campaignService.delete(id);
                return new ResponseEntity<>("Campaign successfully deleted", HttpStatus.OK);
            }
                return new ResponseEntity<>("Campaign not found", HttpStatus.NOT_FOUND);
        }catch(Exception e){
            System.out.println("Failed to delete campaign");
        }
        return new ResponseEntity<>("Failed to delete the Campaign!",HttpStatus.NOT_FOUND);
    }


    @PatchMapping("api/campaign/{id}")
    public ResponseEntity<String> editCampaign(@PathVariable Long id, @RequestBody Campaign campaign){
        try{
            campaignService.edit(id, campaign);
            return new ResponseEntity<>("Campaign has been modified!", HttpStatus.OK);
        }catch (Exception e) {
            System.out.println("The campaign could not be modified");
        }
        return new ResponseEntity<>( "The campaign could not be modified!",
                HttpStatus.NOT_FOUND);
    }

}
