package coss.api.client;


public interface Constants {
	
	
	String GET = "GET";
	String POST = "POST";
	String DELETE = "DELETE";
	
	 String COSS_API_ENGINE_URL = "https://engine.coss.io/api/v1/" ;
	 String COSS_API_TRADE_URL = "https://trade.coss.io/c/api/v1/" ;
	 String MARKETSUMMARIES_API_URL="https://exchange.coss.io/api/";
	 
	 
     String EXCHANGE_INFO = "exchange-info" ;
     String PING = "ping" ;
     String TIME = "time" ;
     String MARKET_SUMMARIES = "getmarketsummaries";
     String MARKET_DEPTH = "dp";
     String TRADE_HISTORY = "ht";   
     String MARKET_PRICE = "market-price";
     String ACCOUNT_BALANCES = "account/balances" ;
     String ACCOUNT_DETAILS = "account/details";
     String ORDER_ADD = "order/add" ;
     String ORDER_CANCEL = "order/cancel";
     String ORDER_DETAILS = "order/details";
     String ORDER_LIST_ALL = "order/list/all" ;
     String ORDER_LIST_COMPLETED = "order/list/completed" ;
     String ORDER_LIST_OPEN = "order/list/open" ;
     String ORDER_TRADE_DETAIL="order/trade-detail";
     
     
      //Your private key is used to sign the pay load.
     String PUBLIC_API_KEY =  "SmZJM1pnUDB5VFRuVUlxSUdkdFZHay9nQzhXZzYyTGQzRDBwbFdCTzRYd2pYL245MmVCSkFESm5OckplZ1RIUVNZNGtJa2VKZ052dW10Vit3cGFmdjR0aHdPTlZKclllVWFlcWo3WHdQWVk9";

     String PRIVATE_API_KEY = "MSC46rQ1bxtzsUPaF7UykJ37scPnLeyYkQ1SiKS2x8A=";	  
	 
     static String getExchangeInfoURL() {
    	 return new StringBuffer(COSS_API_TRADE_URL).append(EXCHANGE_INFO).toString();
     }
     
     static String getPingURL() {
    	 return new StringBuffer(COSS_API_TRADE_URL).append(PING).toString();
     }
     
     static String getTimeURL() {
    	 return new StringBuffer(COSS_API_TRADE_URL).append(TIME).toString();
     }
     
    
 
     static String getMarketSummariesURL() {
    	 return new StringBuffer(MARKETSUMMARIES_API_URL).append(MARKET_SUMMARIES).toString();
     }
     
     static String getMarketDepthURL() {
    	 return new StringBuffer(COSS_API_ENGINE_URL).append(MARKET_DEPTH).toString();
     }
     
     static String getTradeHistoryURL() {
    	 return new StringBuffer(COSS_API_ENGINE_URL).append(TRADE_HISTORY).toString();
     }
    
    
     static String getMarketPriceURL() {
    	 return new StringBuffer(COSS_API_TRADE_URL).append(MARKET_PRICE).toString();
     }

     static String getAccountBalancesURL() {
    	 return new StringBuffer(COSS_API_TRADE_URL).append(ACCOUNT_BALANCES).toString();
     }
    
     static String getAccountDetailsURLL() {
    	 return new StringBuffer(COSS_API_TRADE_URL).append(ACCOUNT_DETAILS).toString();
     }

     static String getOrderAddURL() {
    	 return new StringBuffer(COSS_API_TRADE_URL).append(ORDER_ADD).toString();
     }

     static String getOrderCancelURL() {
    	 return new StringBuffer(COSS_API_TRADE_URL).append(ORDER_CANCEL).toString();
     }
    
     static String getOrderDetailsURL() {
    	 return new StringBuffer(COSS_API_TRADE_URL).append(ORDER_DETAILS).toString();
     }
         
     
     static String getAllOrdersURL() {
    	 return new StringBuffer(COSS_API_TRADE_URL).append(ORDER_LIST_ALL).toString();
     }

     static String getCompletedOrdersURL() {
    	 return new StringBuffer(COSS_API_TRADE_URL).append(ORDER_LIST_COMPLETED).toString();
     }
    
     static String getOpenOrdersURL() {
    	 return new StringBuffer(COSS_API_TRADE_URL).append(ORDER_LIST_OPEN).toString();
     }
 
     static String getTradeDetailsURL() {
    	 return new StringBuffer(COSS_API_TRADE_URL).append(ORDER_TRADE_DETAIL).toString();
     }
    
    
     
     
 
}
