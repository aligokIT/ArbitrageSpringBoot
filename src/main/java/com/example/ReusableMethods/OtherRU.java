package com.example.ReusableMethods;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import com.amazonaws.*;



public class OtherRU {
    public static Document getHtmlDoc(String url) throws IOException {
        return Jsoup.connect(url).get();
    }
//Method to extract the price and availability of a product from the Adidas website
    public static Map<String, String> getProductDetailsFromAdidas(String url) throws IOException {
        Map<String, String> productDetails = new HashMap<>();
        Document doc = getHtmlDoc(url);
        Element priceElement = doc.selectFirst(".gl-price-item");
        String price = priceElement.text();
        Element availabilityElement = doc.selectFirst(".gl-product-availability");
        String availability = availabilityElement.text();
        productDetails.put("price", price);
        productDetails.put("availability", availability);
        return productDetails;
    }

    //Method to get the current price of a product on Amazon using the Amazon MWS API:
//    public static BigDecimal getCurrentPriceFromAmazon(String asin, String sellerId, String marketplaceId, String accessKeyId, String secretAccessKey) throws PriceNotFoundException {
//        AmazonMarketplaceWebServiceClient client = new AmazonMarketplaceWebServiceClient(
//                accessKeyId,
//                secretAccessKey,
//                "automation",
//                "1.0.0.0"
//        );
//
//        GetCompetitivePricingForASINRequest request = new GetCompetitivePricingForASINRequest();
//        request.setSellerId(sellerId);
//        request.setMarketplaceId(marketplaceId);
//        request.setASINList(new ASINListType().withASIN(asin));
//        GetCompetitivePricingForASINResponse response = client.getCompetitivePricingForASIN(request);
//
//        List<CompetitivePrice> prices = response.getGetCompetitivePricingForASINResult().get(0).getProduct().get(0).getCompetitivePricing().getCompetitivePrices().getCompetitivePrice();
//        for (CompetitivePrice price : prices) {
//            if (price.getCondition().equals("New")) {
//                return price.getListingPrice().getAmount();
//            }
//        }
//        throw new PriceNotFoundException("New price not found for ASIN: " + asin);
//    }
}
