package com.learning.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPurchaseWebRequest {

    private int purchaseAmount;

    private String browser;

    private String operatingSystem;

}
