package coss.api.client;

public interface Constants {
	
	
	String GET = "GET";
	String POST = "POST";
	String DELETE = "DELETE";
	
	 String COSS_API_URL = "https://api.coss.io/v1/" ;
	 
	 
     String EXCHANGE_INFO = "exchange-info" ;
     String MARKET_SUMMARIES = "getmarketsummaries";
     String MARKET_DEPTH = "dp";
     String MARKET_PRICE = "market-price";
     String ACCOUNT_BALANCES = "account/balances" ;
     String ACCOUNT_DETAILS = "account/details";
     String ORDER_ADD = "order/add" ;
     String ORDER_CANCEL = "order/cancel";
     String ORDER_DETAILS = "order/details";
     String ORDER_LIST_ALL = "order/list/all" ;
     String ORDER_LIST_COMPLETED = "order/list/completed" ;
     String ORDER_LIST_OPEN = "order/list/open" ;
     
     
      //Your private key is used to sign the pay load.
 	  String PUBLIC_API_KEY =  "Copy your public api key here";
	  String PRIVATE_API_KEY = "Copy your privatte key here";
	  
	 
     static String getExchangeInfoURL() {
    	 return new StringBuffer(COSS_API_URL).append(EXCHANGE_INFO).toString();
     }
 
     static String getMarketSummariesURL() {
    	 return new StringBuffer(COSS_API_URL).append(MARKET_SUMMARIES).toString();
     }
     
     static String getMarketDepthURL() {
    	 return new StringBuffer(COSS_API_URL).append(MARKET_DEPTH).toString();
     }
    
     static String getMarketPriceURL() {
    	 return new StringBuffer(COSS_API_URL).append(MARKET_PRICE).toString();
     }

     static String getAccountBalancesURL() {
    	 return new StringBuffer(COSS_API_URL).append(ACCOUNT_BALANCES).toString();
     }
    
     static String getAccountDetailsURLL() {
    	 return new StringBuffer(COSS_API_URL).append(ACCOUNT_DETAILS).toString();
     }

     static String getOrderAddURL() {
    	 return new StringBuffer(COSS_API_URL).append(ORDER_ADD).toString();
     }

     static String getOrderCancelURL() {
    	 return new StringBuffer(COSS_API_URL).append(ORDER_CANCEL).toString();
     }
    
     static String getOrderDetailsURL() {
    	 return new StringBuffer(COSS_API_URL).append(ORDER_DETAILS).toString();
     }
         
     
     static String getAllOrdersURL() {
    	 return new StringBuffer(COSS_API_URL).append(ORDER_LIST_ALL).toString();
     }

     static String getCompletedOrdersURL() {
    	 return new StringBuffer(COSS_API_URL).append(ORDER_LIST_COMPLETED).toString();
     }
    
     static String getOpenOrdersURL() {
    	 return new StringBuffer(COSS_API_URL).append(ORDER_LIST_OPEN).toString();
     }
    
     
     
 
}
