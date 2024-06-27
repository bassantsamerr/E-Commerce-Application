package com.example.wallet_service.controller;

import com.example.wallet_service.service.WalletProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletProviderController {
    @Autowired
    WalletProviderServiceImpl walletProviderService;
    public WalletProviderController() {

    }
    public WalletProviderController(WalletProviderServiceImpl walletProviderService) {
        this.walletProviderService = walletProviderService;
    }
    @GetMapping("/checkWallet")
    public Integer checkWallet(@RequestParam String mobileNumber, @RequestParam String nationalID) {
        return walletProviderService.checkWalletExist(mobileNumber, nationalID);
    }
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        return "plain-login";
    }

}
